package com.aljouharji.obdachlosenhilfe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
EditText txtname, txtstrasse, txtstadt, txtplz,txttelefon, txttermin,txtmahl;
Button buttonschincken;
DatabaseReference reff;
Member member;
long maxid=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText( MainActivity.this, "Du kannst deine Informationen hier eingeben", Toast.LENGTH_LONG  ).show ();

        txtname= (EditText) findViewById(R.id.txtname) ;
        txtstrasse= (EditText) findViewById(R.id.txtstrasse) ;
        txtstadt= (EditText) findViewById(R.id.txtstadt) ;
        txtplz= (EditText) findViewById(R.id.txtplz) ;
        txttelefon= (EditText) findViewById(R.id.txttelefon) ;
        txttermin= (EditText) findViewById(R.id.txttermin) ;
        txtmahl= (EditText) findViewById(R.id.txtmahl) ;
        buttonschincken = (Button) findViewById(R.id.buttonschicken);

        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        buttonschincken.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick (View view) {
                int tlf = Integer.parseInt(txttelefon.getText().toString().trim());
                int mahl= Integer.parseInt(txtmahl.getText().toString().trim());
                member.setName(txtname.getText().toString().trim());
                member.setStrasse(txtstrasse.getText().toString().trim());
                member.setStadt(txtstadt.getText().toString().trim());
                member.setPlz(txtplz.getText().toString().trim());
                member.setTelefon(tlf);
                member.setMahl(mahl);
                member.setTermin(txttermin.getText().toString().trim());


                reff.child(String.valueOf(maxid+1)).setValue(member);
                Toast.makeText( MainActivity.this, "Deine Informationen wurden hochgeladen", Toast.LENGTH_LONG  ).show ();

                Intent i = new Intent(MainActivity.this,End.class );
                startActivity(i);


            }



        });

    }
}
