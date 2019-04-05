package com.aljouharji.obdachlosenhilfe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Anmeldung extends AppCompatActivity {

    private EditText Name, Password;
    private TextView Info;
    private Button login;
    private int counter = 3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anmeldung);

        Name=(EditText)findViewById(R.id.txtorgan);
        Password=(EditText)findViewById(R.id.txtpass);
        Info=(TextView) findViewById(R.id.tvinfo);
       login = (Button)findViewById(R.id.btnanmeldung);

        Info.setText("Hallo! Du hast maximal 3 Versuchen");


       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               valiadate(Name.getText().toString(),Password.getText().toString());
           }
       });



       //);

    }
    private void valiadate (String userName, String userPassword){

        if ( (userName .equals("Admin") ) &&(userPassword.equals("Admin")) ){
            Intent intent = new Intent (Anmeldung.this,Main2Activity.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText("Du hast " + String.valueOf(counter) + " Versuchen");

            if(counter==0){
                Toast.makeText( Anmeldung.this, "Das Program wurde gesperrt", Toast.LENGTH_LONG  ).show ();
                login.setEnabled(false);
            }
        }




    }





}
