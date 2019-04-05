package com.aljouharji.obdachlosenhilfe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class M3 extends AppCompatActivity {

    TextView na,str,sta,plz,tlf,ter,ma;
    Button zu,fe;

    DatabaseReference reff;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3);

        na=(TextView)findViewById(R.id.tvname);
        str=(TextView)findViewById(R.id.tvstrasse);
        sta=(TextView)findViewById(R.id.tvstadt);
        plz=(TextView)findViewById(R.id.tvplz);
        tlf=(TextView)findViewById(R.id.tvtlf);
        ter=(TextView)findViewById(R.id.tvtermin);
        ma=(TextView)findViewById(R.id.tvmahl);

        zu =(Button)findViewById(R.id.btnkonsole);
        fe=(Button)findViewById(R.id.btnfertig);


        reff= FirebaseDatabase.getInstance().getReference().child("Member").child("3");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String names1= dataSnapshot.child("name").getValue().toString();
                String strasses1=dataSnapshot.child("strasse").getValue().toString();
                String stadts1= dataSnapshot.child("stadt").getValue().toString();
                String tlfs1=dataSnapshot.child("telefon").getValue().toString();
                String plz1s1= dataSnapshot.child("plz").getValue().toString();
                String mahl1s1=dataSnapshot.child("mahl").getValue().toString();
                String termins1= dataSnapshot.child("termin").getValue().toString();
                //na,str,sta,plz,tlf,ter,ma

                ma.setText(mahl1s1);
                plz.setText(plz1s1);
                na.setText(names1);
                str.setText(strasses1);
                sta.setText(stadts1);
                tlf.setText(tlfs1);
                ter.setText(termins1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        zu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(M3.this,Main2Activity.class );
                startActivity(i);

            }
        });


        fe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(M3.this,End.class );
                startActivity(i);

            }
        });




    }
}