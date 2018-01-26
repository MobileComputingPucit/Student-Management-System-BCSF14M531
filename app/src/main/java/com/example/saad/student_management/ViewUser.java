package com.example.saad.student_management;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ViewUser extends AppCompatActivity {

    EditText rollno,name,marks,phone;
    String roll, name1, marks1, phone1;
    DBHelper dbHelper;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);

        rollno = (EditText) findViewById(R.id.V_RollNo);
        name = (EditText)findViewById(R.id.V_Name);
        marks = (EditText)findViewById(R.id.V_Marks);
        phone = (EditText)findViewById(R.id.V_Phone);

        b = (Button)findViewById(R.id.ViewUser);
    }

    public void GetData(View view){
        roll = rollno.getText().toString();
        Cursor r  = dbHelper.getData(roll);
        Toast.makeText(this,"r is " +r, Toast.LENGTH_LONG).show();
        if(r != null){
            if(r.getCount() > 0){
                name1 = r.getString(r.getColumnIndex("NAME"));
                marks1 = r.getString(r.getColumnIndex("MARKS"));
                phone1 = r.getString(r.getColumnIndex("PHONE"));

                name.setText(name1);
                marks.setText(marks1);
                phone.setText(phone1);
            }
        }

        else
        {
            Toast.makeText(this,"User not exist " +r, Toast.LENGTH_LONG).show();
        }
    }
}

