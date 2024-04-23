package com.example.driverhireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserLogin extends AppCompatActivity {


    private TextView signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        init();

        signUp.setOnClickListener(v -> {
            startActivity(new Intent(UserLogin.this,UserRegistration.class));
        });
    }

    private void init(){
        signUp = findViewById(R.id.create_acc);
    }
}