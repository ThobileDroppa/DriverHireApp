package com.example.driverhireapp;

import static androidx.constraintlayout.widget.Constraints.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.driverhireapp.model.Driver;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DriverLogin extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText email,password;

    private Button loginBtn;

    private TextView signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);

        init();

        signUp.setOnClickListener(view -> {
            startActivity(new Intent(this, DriverRegistration.class));
        });

        loginBtn.setOnClickListener(v -> {

            String user = email.getText().toString().trim();
            String pwd = password.getText().toString().trim();

            signInUser(user,pwd);

        });



    }

    private void init(){
        mAuth = FirebaseAuth.getInstance();
        signUp = findViewById(R.id.signUp_text);
        password = findViewById(R.id.pwd_login);
        email = findViewById(R.id.email_login);
        loginBtn = findViewById(R.id.login_btn);
    }

    private void signInUser(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Log.e("","qqqqqqqq - SUCCESS LOGIN " + mAuth.getUid());

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

                    databaseReference.child("Drivers").child(mAuth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {

                            if(task.isSuccessful()){
                                //Driver driver = task.getResult().getValue();
                               // Log.d(" ","0000000000000 " + task.getResult().getValue().toString());

                                if(task.getResult().getValue()!=null){
                                     Log.d(" ","0000000000000 " + task.getResult().getValue().toString());
                                     Driver driver = (Driver) task.getResult().getValue();
                                     Intent intent = new Intent(DriverLogin.this, MakeHire.class);
                                     intent.putExtra("driver",driver);
                                     startActivity(intent);
                                }
                            }

                        }
                    });

                }else {
                    Log.w(TAG, "------------------  signInWithEmail:failure - ", task.getException());
                    Toast.makeText(DriverLogin.this, "Invalid Email or Password.",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}