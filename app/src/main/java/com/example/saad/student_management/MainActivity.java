package com.example.saad.student_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog.Builder;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button add, view, delete, show1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.addbtn);
        delete = (Button) findViewById(R.id.deletedtn);
        view = (Button) findViewById(R.id.viewbtn);
        show1 = (Button) findViewById(R.id.showbtn);


        show1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "This app is made by Saad", Toast.LENGTH_SHORT).show();

                ShowMessage("Student Management system", "Develepod by saad ");
            }
        });

    }

    public void ShowMessage(String title, String Message) {

        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

    public void onClick(View view){
        if(view.getId() == R.id.addbtn)
        {
            Intent i = new Intent(this,Add.class);
            startActivity(i);
        }

        else if(view.getId() == R.id.deletedtn){
            Intent del = new Intent(this,Delete.class);
            startActivity(del);
        }

        else if(view.getId() == R.id.viewbtn){
            Intent viewi = new Intent(this,ViewUser.class);
            startActivity(viewi);
        }

    }

}

