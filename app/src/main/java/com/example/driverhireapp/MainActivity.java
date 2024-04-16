package com.example.driverhireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    private Button bookDriver,driverBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        bookDriver.setOnClickListener(view -> {

            startActivity(
                    new Intent(this, UserLogin.class)
            );

        });

        driverBtn.setOnClickListener(view -> {
            startActivity(new Intent(this, DriverLogin.class));
        });




    }

    private void init(){
        bookDriver = findViewById(R.id.bookDriver);
        driverBtn = findViewById(R.id.driver_btn);
    }
}