package com.example.driverhireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button bookDriver,driverBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        bookDriver.setOnClickListener(view -> {

        });




    }

    private void init(){
        bookDriver = findViewById(R.id.bookDriver);
        driverBtn = findViewById(R.id.driver_btn);
    }
}