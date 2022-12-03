package com.example.emp_loyee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ManagerLoginActivity extends AppCompatActivity {


    Button login;
    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_login);

        login=(Button) findViewById(R.id.login);
        user=(EditText) findViewById(R.id.user);
        pass=(EditText) findViewById(R.id.pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u=user.getText().toString();
                String p=pass.getText().toString();

                if (u.equalsIgnoreCase("Roach") && p.equals("Android123"))
                {
                    Toast.makeText(ManagerLoginActivity.this, "Login Success.", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(ManagerLoginActivity.this,ManagerActivity.class);
                    startActivity(intent);
                }
                else
                {
                    user.setText("");
                    pass.setText("");
                    Toast.makeText(ManagerLoginActivity.this, "Incorrect details!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}