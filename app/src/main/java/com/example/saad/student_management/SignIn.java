package com.example.saad.student_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {
    EditText email,password;
    String email1,pass;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        b = (Button)findViewById(R.id.sign_in);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.pass);


    }

    public void onClick(View v){
        email1 = email.getText().toString();
        pass = password.getText().toString();

        if(email1.equals("Admin@gmail.com") && pass.equals("12345")){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
