package com.example.emp_loyee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FrontPageActivity extends AppCompatActivity {


    Button ml,entry,display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        ml=(Button) findViewById(R.id.ml);
        entry=(Button) findViewById(R.id.entry);
        display=(Button) findViewById(R.id.display);

        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(FrontPageActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        ml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FrontPageActivity.this, ManagerLoginActivity.class);
                startActivity(intent);
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FrontPageActivity.this, DisplayAllEmployees.class);
                startActivity(intent);
            }
        });
    }
}