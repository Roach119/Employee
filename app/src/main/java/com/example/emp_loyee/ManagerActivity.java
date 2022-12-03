package com.example.emp_loyee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ManagerActivity extends AppCompatActivity {


    Button del, edit,dis;
    TextView distxt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        del=(Button) findViewById(R.id.del);
        edit=(Button) findViewById(R.id.edit);
        dis=(Button) findViewById(R.id.dis);
        distxt=(TextView) findViewById(R.id.distxt);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(ManagerActivity.this);
                builder.setTitle("Edit Employee");
                builder.setCancelable(false);

                final View customLayout = getLayoutInflater().inflate(R.layout.edit_layout,null);
                builder.setView(customLayout);



                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        EditText ename=(EditText) customLayout.findViewById(R.id.ename);
                        EditText eid=(EditText) customLayout.findViewById(R.id.eid);
                        EditText esal=(EditText) customLayout.findViewById(R.id.esal);
                        EditText eadd=(EditText) customLayout.findViewById(R.id.eadd);
                        EditText eph=(EditText) customLayout.findViewById(R.id.eph);

                        String n = ename.getText().toString();
                        String n1 = eid.getText().toString();
                        String n2 = esal.getText().toString();
                        String n3 = eadd.getText().toString();
                        String n4 = eph.getText().toString();

                        Employee emp = new Employee();
                        emp.setName(n);
                        emp.setId(n1);
                        emp.setSalary(n2);
                        emp.setAddress(n3);
                        emp.setPhone(n4);

                        DatabaseHandler databaseHandler = new DatabaseHandler(ManagerActivity.this);
                        long res = databaseHandler.updateEmployee(emp);

                        Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                    }

                });
                builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,int which)
                    {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(ManagerActivity.this);
                builder.setTitle("Delete Employee");
                builder.setCancelable(false);

                final View customLayout = getLayoutInflater().inflate(R.layout.delete_layout,null);
                builder.setView(customLayout);

                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        EditText edid=(EditText) customLayout.findViewById(R.id.edid);
                        String n1 = edid.getText().toString();

                        Employee emp = new Employee();
                        emp.setId(n1);
                        DatabaseHandler databaseHandler = new DatabaseHandler(ManagerActivity.this);
                        long res = databaseHandler.deleteEmployee(emp);
                        Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,int which)
                    {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ManagerActivity.this, DisplayAllEmployees.class);
                startActivity(intent);
            }
        });
    }
}