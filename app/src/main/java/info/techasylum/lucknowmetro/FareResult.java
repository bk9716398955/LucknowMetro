package info.techasylum.lucknowmetro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FareResult extends AppCompatActivity {

    int st, ch,f=0;

    TextView fr, st1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare_result);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        fr = (TextView)findViewById(R.id.fareRusult);


        st = (Integer)getIntent().getIntExtra("STATION",0);
        int s=st-1;
        ch = (Integer)getIntent().getIntExtra("CHANGE",0);
        if(s==1)f=10;

        if(s==2)f=15;

        if(s>2&&s<=6)f=20;

        if(s>=7&&s<=9)f=30;

        if(s>=10&&s<=13)f=40;

        if(s>=14&&s<=17)f=50;

        if(s>=18)f=60;

        fr.setText("₹"+f);


    }
}
