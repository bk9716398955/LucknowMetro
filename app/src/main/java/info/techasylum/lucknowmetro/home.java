package info.techasylum.lucknowmetro;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;

import com.sdsmdg.harjot.rotatingtext.RotatingTextWrapper;
import com.sdsmdg.harjot.rotatingtext.models.Rotatable;

public class home extends AppCompatActivity {
 private ImageButton b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_home);
      b1=(ImageButton) findViewById(R.id.n1);
        b2=(ImageButton) findViewById(R.id.n2);
        b3=(ImageButton) findViewById(R.id.n3);
        b4=(ImageButton) findViewById(R.id.n4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent io = new Intent(home.this, MainActivity.class);
                startActivity(io);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent io = new Intent(home.this, FareStats.class);
                startActivity(io);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent io = new Intent(home.this, MapsActivity.class);
                startActivity(io);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent io = new Intent(home.this, about.class);
                startActivity(io);

            }
        });
    }
}
