package com.example.salesmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import android.widget.TextView;
import android.os.AsyncTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asyncタスククラスのインスタンスを作成し、実行する
        TaskDbConnect task = new TaskDbConnect(MainActivity.this);
        task.execute();
    }
}