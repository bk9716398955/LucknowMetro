package info.techasylum.lucknowmetro;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView actvSource;
    AutoCompleteTextView actvDestination;
    ArrayList<String> list = new ArrayList<String>();
    Button Click;

    int station=0,change=0;
    int r1=0, r2=0, b1=0, b2=0, r1index=0, r2index=0, b1index=0, b2index=0;

    String[] red1 ={
            "CHAUDHARY CHARAN SINGH INTERNATIONAL AIRPORT", "AMAUSI", "TRANSPORT NAGAR", "KRISHNA NAGAR", "SHRINGAR NAGAR",
            "ALAMBAGH", "ALAMBAGH ISBT BUS INTERCHANGE", "MAWAIYA", "DURGAPURI", "CHARBAGH RAILWAY STATION", "HUSSAINGANJ",
            "SACHIVALAYA", "HAZRATGANJ", "KD SINGH BABU STADIUM", "LUCKNOW UNIVERSITY", "IT CHAURAHA",
            "MAHANAGAR", "BADSHAH NAGAR", "LEKHRAJ MARKET", "RAMSAGAR MISHRA NAGAR", "INDIRA NAGAR", "MUNSHI PULIA"
    };
    String[] blue1 ={
            "CHARBAGH RAILWAY STATION", "GAUTAM BUDDHA MARG", "AMINABAD", "PANDEY GANJ", "CITY RAILWAY STATION",
            "MEDICAL COLLEGE CROSSING", "NAWAZ GANJ", "THAKUR GANJ", "BALA GANJ", "SARFARAZ GANJ", "MUSA BAGH", "VASANT KUNJ"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actvSource = (AutoCompleteTextView)findViewById(R.id.actv1);
        actvDestination = (AutoCompleteTextView)findViewById(R.id.actv2);
        Click = (Button)findViewById(R.id.btn);
        String[] stations = getResources().getStringArray(R.array.station_array);
        actvSource.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,stations));
        actvDestination.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,stations));


        Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FareCalculator();
                SendData();
            }
        });
    }
    public void FareCalculator(){
        String s = actvSource.getText().toString().trim();
        String d = actvDestination.getText().toString().trim();
        if(s.length()==0&&d.length()==0||s.length()==0||d.length()==0){
            Toast.makeText(MainActivity.this, "Please Fill Required Field", Toast.LENGTH_LONG).show();
        }
        else if(s.equals(d)) {
            Toast.makeText(MainActivity.this, "Both Are Same Stations", Toast.LENGTH_LONG).show();
        }
        else{
            /*====================checking source and destination station present in same line ======================*/
            for(int i=0; i<red1.length; i++){
                if(s.equals(red1[i])){
                    r1++;
                    r1index=i;
                }
                if(d.equals(red1[i])){
                    r2++;
                    r2index=i;

                }
            }
            for(int j=0; j<blue1.length; j++){
                if(s.equals(blue1[j])){
                    b1++;
                    b1index=j;

                }
                if(d.equals(blue1[j])){
                    b2++;
                    b2index=j;
                }
            }
            /*====================end checking source and destination station present in same line ======================*/
            /*====================Printing data if both value is available ======================*/
            if(r1>0&&r2>0){
                if(r1index<r2index){
                    for(int i=r1index; i<=r2index; i++){
                        list.add(red1[i]);
                        station++;
                    }
                }
                else{
                    for (int i=r1index; i>=r2index; i--){
                        list.add(red1[i]);
                        station++;
                    }
                }
            }
            else if(b1>0&&b2>0){
                if(b1index<b2index){
                    for (int i=b1index; i<=b2index; i++){
                        list.add(blue1[i]);
                        station++;
                    }
                }
                else{
                    for (int i=b1index; i>=b2index; i--){
                        list.add(blue1[i]);
                        station++;
                    }
                }
            }
            /* ========================================== coded by pankaj sharma================================================*/
            else{
                if(b1>0&&b2==0){
                    change++;
                    for (int i=b1index; i>=0; i--){
                        list.add(blue1[i]);
                        station++;
                    }

                    if(r2>0&&r2index<10){

                        for (int i=8; i>=r2index; i--){
                            list.add(red1[i]);
                            station++;
                        }
                    }
                    if(r2>0&&r2index>9){

                        for(int i=10; i<=r2index; i++){
                            list.add(red1[i]);
                            station++;
                        }
                    }
                }
                if(r1>0&&r2==0){
                    change++;
                    if(r1index>10){
                        for (int i=r1index; i>=9; i--){
                            list.add(red1[i]);
                            station++;
                        }

                        for(int i=1; i<=b2index; i++){
                            list.add(blue1[i]);
                            station++;
                        }
                    }
                    if(r1<10){
                        for(int i=r1index; i<=9; i++){
                            list.add(red1[i]);
                            station++;
                        }
                        for(int i=1; i<=b2index; i++){
                            list.add(blue1[i]);
                            station++;
                        }
                    }
                }
            }
        }

    }
    public void SendData(){
        if(list.size()!=0){
            Intent intent =new Intent(this,FareListActivity.class);
            intent.putExtra("ARRAYLIST", list);
            intent.putExtra("STATION", station);
            intent.putExtra("CHANGE", change);
            startActivity(intent);
        }
        else{
            Toast.makeText(MainActivity.this, "Note getting any data:", Toast.LENGTH_LONG).show();
        }
        list.clear();
        station=0;
        change=0;
    }
}
