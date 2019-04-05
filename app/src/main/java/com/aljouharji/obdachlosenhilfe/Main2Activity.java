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

public class Main2Activity extends AppCompatActivity {
TextView m1,p1,m2,m3,m4,p2,p3,p4;
Button a,in1,in2,in3,in4;

DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        m1=(TextView)findViewById(R.id.mahl1);
        m2=(TextView)findViewById(R.id.mahl2);
        m3=(TextView)findViewById(R.id.mahl3);
        m4=(TextView)findViewById(R.id.mahl4);

        p1=(TextView)findViewById(R.id.plz1);
        p2=(TextView)findViewById(R.id.plz2);
        p3=(TextView)findViewById(R.id.plz3);
        p4=(TextView)findViewById(R.id.plz4);

        a=(Button)findViewById(R.id.aktuell);
        in1=(Button)findViewById(R.id.info1);
        in2=(Button)findViewById(R.id.info2);
        in3=(Button)findViewById(R.id.info3);
        in4=(Button)findViewById(R.id.info4);



        in1.setEnabled(false);
        in2.setEnabled(false);
        in3.setEnabled(false);
        in4.setEnabled(false);






        in1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Main2Activity.this,M1.class );
                startActivity(i);

            }
        });

        in2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Main2Activity.this,M2.class );
                startActivity(i);

            }
        });


        in3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Main2Activity.this,M3.class );
                startActivity(i);

            }
        });



        in4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Main2Activity.this,M4.class );
                startActivity(i);

            }
        });


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                in1.setEnabled(true);
                in2.setEnabled(true);
                in3.setEnabled(true);
                in4.setEnabled(true);




                reff=FirebaseDatabase.getInstance().getReference().child("Member").child("1");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String plz1s1= dataSnapshot.child("plz").getValue().toString();
                        String mahl1s1=dataSnapshot.child("mahl").getValue().toString();

                        m1.setText(mahl1s1);
                        p1.setText(plz1s1);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                /////////////////////////////////////////////
                reff=FirebaseDatabase.getInstance().getReference().child("Member").child("2");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String plz1s2= dataSnapshot.child("plz").getValue().toString();
                        String mahl1s2=dataSnapshot.child("mahl").getValue().toString();

                        m2.setText(mahl1s2);
                        p2.setText(plz1s2);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                /////////////////////////////////////////////
                reff=FirebaseDatabase.getInstance().getReference().child("Member").child("3");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String plz1s3= dataSnapshot.child("plz").getValue().toString();
                        String mahl1s3=dataSnapshot.child("mahl").getValue().toString();

                        m3.setText(mahl1s3);
                        p3.setText(plz1s3);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                /////////////////////////////////////////////
                reff=FirebaseDatabase.getInstance().getReference().child("Member").child("4");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String plz1s4= dataSnapshot.child("plz").getValue().toString();
                        String mahl1s4=dataSnapshot.child("mahl").getValue().toString();

                        m4.setText(mahl1s4);
                        p4.setText(plz1s4);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                //////////


            }




        });



    }
}
