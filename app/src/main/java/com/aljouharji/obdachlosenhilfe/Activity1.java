package com.aljouharji.obdachlosenhilfe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {
    Button buttonspenden, buttonorga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        buttonspenden = (Button) findViewById(R.id.buttonspenden);
        buttonspenden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Activity1.this,MainActivity.class );
                startActivity(i);

            }
        });


        buttonorga = (Button) findViewById(R.id.buttonorga);
        buttonorga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent z = new Intent(Activity1.this,Anmeldung.class );
                startActivity(z);

            }
        });


    }
}
