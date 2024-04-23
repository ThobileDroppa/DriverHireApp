package com.example.driverhireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class DriverLogin extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText email,password;

    private TextView signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);

        init();

        signUp.setOnClickListener(view -> {
            startActivity(new Intent(this, DriverRegistration.class));
        });




    }

    private void init(){
        mAuth = FirebaseAuth.getInstance();
        signUp = findViewById(R.id.signUp_text);
    }
}