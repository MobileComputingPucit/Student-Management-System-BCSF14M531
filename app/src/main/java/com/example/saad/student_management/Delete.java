package com.example.saad.student_management;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Delete extends AppCompatActivity {

    EditText rollno;
    String roll;
    DBHelper dbHelper;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        dbHelper = new DBHelper(this);

        rollno = (EditText)findViewById(R.id.D_RollNo);


        b = (Button)findViewById(R.id.Delete);
    }


    public void onClick(View view){

        roll = rollno.getText().toString();
        boolean r = dbHelper.delete(roll);

        if(r){
            Toast.makeText(this,"User deleted Successfully", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

        else
        {
            Toast.makeText(this,"User Doesn't exist", Toast.LENGTH_LONG).show();
        }
    }
}