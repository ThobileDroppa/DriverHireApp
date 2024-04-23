package com.example.driverhireapp;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DriverRegistration extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button signUpBtn;

    private EditText name, surname, email, password, number, location, yearsDriving;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    //FirebaseStorage storage = FirebaseStorage.getInstance();
    //StorageReference storageRef = storage.getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_registration);

        init();

        signUpBtn.setOnClickListener(view -> {
            String emailT = email.getText().toString().trim();
            String passT = password.getText().toString().trim();
            //createUser(emailT,passT);
        });


    }

    private void init() {
        firebaseAuth = FirebaseAuth.getInstance();
        signUpBtn = findViewById(R.id.driver_signUp_Btn);

        email = findViewById(R.id.email_driver);
        password = findViewById(R.id.password_driver);
        name = findViewById(R.id.name_driver);
        surname = findViewById(R.id.surname_driver);
        location = findViewById(R.id.location_driver);
        yearsDriving = findViewById(R.id.yearsExprience_driver);
        number = findViewById(R.id.number_driver);

      //   db = FirebaseFirestore.getInstance();

    }

    private void createUser(String emailOne, String password) {

        if (email.length() > 6 && password.length() > 5) {


            firebaseAuth.createUserWithEmailAndPassword(emailOne, password).
                    addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = firebaseAuth.getCurrentUser();

                              String  names = name.getText().toString().trim();
                              String  surnames = surname.getText().toString().trim();
                              String numbers = number.getText().toString().trim();
                              String emails = emailOne;
                              String yearsOfExperience = yearsDriving.getText().toString().trim();
                              String locations = location.getText().toString().trim();
                              String role = "driver";


                                Driver driver = new Driver(user.getUid(),names,surnames,numbers,emails,Integer.parseInt(yearsOfExperience),locations,role);
                                Log.d("","///////////////////////////////// "+ user.getUid());

                                myRef.setValue(driver);
                                // updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(DriverRegistration.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }
                        }
                    });

        } else {
            Toast.makeText(this, "Email and password", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            // reload();
        }
    }
}