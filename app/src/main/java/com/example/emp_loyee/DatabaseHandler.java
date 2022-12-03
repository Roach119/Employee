package com.example.emp_loyee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "employeedb1";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "employee";
    private static final String COL_ID = "employeeid";
    private static final String COL_NAME = "name";
    private static final String COL_ADDRESS = "address";
    private static final String COL_SALARY = "salary";
    private static final String COL_PHONE = "phone";
    private static final String COL_DATEJOINED = "datejoined";


    Context context;

    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create your table

        String sql = "CREATE TABLE "+TABLE_NAME+" ("+COL_ID+ " TEXT PRIMARY KEY, "+COL_NAME+" TEXT, "+COL_ADDRESS+" TEXT, "+COL_PHONE+ " TEXT, "+COL_SALARY+" TEXT, "+COL_DATEJOINED+" TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //update table by deleting then creating

        String sql = "DROP TABLE IF EXISTS "+TABLE_NAME;
        sqLiteDatabase.execSQL(sql);

        onCreate(sqLiteDatabase);
    }


    long addNewEmployee(Employee s)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_ID, s.getId());
        values.put(COL_NAME, s.getName());
        values.put(COL_ADDRESS, s.getAddress());
        values.put(COL_PHONE, s.getPhone());
        values.put(COL_SALARY, s.getSalary());
        values.put(COL_DATEJOINED, s.getDatejoined());

        long res = sqLiteDatabase.insert(TABLE_NAME, null, values);

        sqLiteDatabase.close();

        return res;
    }

    long updateEmployee(Employee s)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_ID, s.getId());
        values.put(COL_NAME, s.getName());
        values.put(COL_ADDRESS, s.getAddress());
        values.put(COL_PHONE, s.getPhone());
        values.put(COL_SALARY, s.getSalary());

        long res = sqLiteDatabase.update(TABLE_NAME,  values, COL_ID + " = ?", new String[]{s.getId()});

        sqLiteDatabase.close();

        return res;
    }

    long deleteEmployee(Employee s)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();


        long res = sqLiteDatabase.delete(TABLE_NAME,   COL_ID + " = ?", new String[]{s.getId()});

        sqLiteDatabase.close();

        return res;
    }

    //Display All Records
    List<Employee> showAllEmployee()
    {
        List<Employee> allEmployee = new ArrayList<>();

        String sql = "SELECT *FROM "+TABLE_NAME;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        while(cursor.moveToNext())
        {
            Employee s = new Employee();
            s.setId(cursor.getString(0));
            s.setName(cursor.getString(1));
            s.setAddress(cursor.getString(2));
            s.setPhone(cursor.getString(3));
            s.setSalary(cursor.getString(4));
            s.setDatejoined(cursor.getString(5));

            allEmployee.add(s);
        }

        return  allEmployee;
    }


}