package com.example.emp_loyee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class DisplayAllEmployees extends AppCompatActivity {

    TextView displayemployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_employees);

        displayemployees = (TextView) findViewById(R.id.displayemployees);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);

        List<Employee> allEmployees = databaseHandler.showAllEmployee();

        String str = "";

        for(int i=0; i<allEmployees.size(); i++)
        {
            str = str + "ID: "+ allEmployees.get(i).getId() + "\n";
            str = str + "Name: "+ allEmployees.get(i).getName() + "\n";
            str = str + "Phone: "+ allEmployees.get(i).getPhone() + "\n";
            str = str + "Address: "+ allEmployees.get(i).getAddress() + "\n";
            str = str + "Salary: "+ allEmployees.get(i).getSalary() + "\n";
            str = str + "Date Joined: "+ allEmployees.get(i).getDatejoined() + "\n";

            str = str + "\n";
        }

        displayemployees.setText(str);
    }
}