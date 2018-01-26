package com.example.saad.student_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends AppCompatActivity {

    EditText rollno,name,marks,phone;
    String roll,name1,marks1,phone1;
    DBHelper dbHelper;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dbHelper = new DBHelper(this);

        rollno = (EditText)findViewById(R.id.RollNo);
        name = (EditText)findViewById(R.id.Name);
        marks = (EditText)findViewById(R.id.Marks);
        phone = (EditText)findViewById(R.id.Phone);

        b = (Button)findViewById(R.id.Add);
    }

    public void onClick(View view){
        roll = rollno.getText().toString();
        name1 = name.getText().toString();
        marks1 = marks.getText().toString();
        phone1 = phone.getText().toString();

        long r = dbHelper.insert(roll,name1,marks1,phone1);

        Toast.makeText(this,"rid is " +r, Toast.LENGTH_LONG).show();

        if(r != -1){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
