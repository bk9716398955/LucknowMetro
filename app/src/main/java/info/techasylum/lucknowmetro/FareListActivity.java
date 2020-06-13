package info.techasylum.lucknowmetro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FareListActivity extends AppCompatActivity {

    int st, ch,f=0;
    ArrayAdapter<String> adapter;
    ListView lst;
    TextView fr, ch1, st1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare_list);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        fr = (TextView)findViewById(R.id.fare);
        ch1 = (TextView)findViewById(R.id.change);
        st1 = (TextView)findViewById(R.id.stations);

        lst = (ListView)findViewById(R.id.listroute);
        ArrayList<String> list = (ArrayList<String>) getIntent().getSerializableExtra("ARRAYLIST");
        adapter=new ArrayAdapter<String>(FareListActivity.this,R.layout.row,R.id.tt,list);
        lst.setAdapter(adapter);

        st = (Integer)getIntent().getIntExtra("STATION",0);
        ch = (Integer)getIntent().getIntExtra("CHANGE",0);
        int stn=st-1;
        if(stn==1)f=10;

        if(stn==2)f=15;

        if(stn>2&&stn<=6)f=20;

        if(stn>=7&&stn<=9)f=30;

        if(stn>=10&&stn<=13)f=40;

        if(stn>=14&&stn<=17)f=50;

        if(stn>=18)f=60;

        fr.setText(""+f);

        st1.setText(""+stn);

        ch1.setText(""+ch);
    }
}
