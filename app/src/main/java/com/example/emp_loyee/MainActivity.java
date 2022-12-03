package com.example.emp_loyee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatActivity context;

    EditText name, id, sal, add, ph, doj;
    Button regbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.name);
        id=(EditText) findViewById(R.id.id);
        sal=(EditText) findViewById(R.id.sal);
        add=(EditText) findViewById(R.id.add);
        ph=(EditText) findViewById(R.id.ph);
        doj=(EditText) findViewById(R.id.doj);
        regbtn=(Button) findViewById(R.id.regbtn);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String n1 = id.getText().toString();
                String n2 = sal.getText().toString();
                String n3 = add.getText().toString();
                String n4 = ph.getText().toString();
                String n5 = doj.getText().toString();

                Employee emp = new Employee();
                emp.setName(n);
                emp.setId(n1);
                emp.setSalary(n2);
                emp.setAddress(n3);
                emp.setPhone(n4);
                emp.setDatejoined(n5);

                DatabaseHandler databaseHandler = new DatabaseHandler(MainActivity.this);

                long res = databaseHandler.addNewEmployee(emp);
                name.setText("");
                id.setText("");
                sal.setText("");
                add.setText("");
                ph.setText("");
                doj.setText("");
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,FrontPageActivity.class);
                startActivity(intent);

            }
        });
    }
}