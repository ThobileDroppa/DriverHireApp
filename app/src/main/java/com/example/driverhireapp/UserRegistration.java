package com.example.driverhireapp;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.driverhireapp.model.Driver;
import com.example.driverhireapp.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserRegistration extends AppCompatActivity {

    private Button loginBtn;

    private EditText name,surname,email,pwd;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        init();

        loginBtn.setOnClickListener(view -> {
            String emailT = email.getText().toString().trim();
            String passT = pwd.getText().toString().trim();
            createUser(emailT,passT);
        });



    }

    private void init(){
        firebaseAuth = FirebaseAuth.getInstance();
        loginBtn = findViewById(R.id.login_btn_user);
        name = findViewById(R.id.name_user);
        surname = findViewById(R.id.surname_user);
        email = findViewById(R.id.email_user);
        pwd = findViewById(R.id.pwd_user);
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
                                String emails = emailOne;
                                String role = "user";


                                User user1 = new User(user.getUid(),names,surnames,emails,role);
                                Log.d("","///////////////////////////////// "+ user.getUid());


                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference myRef = database.getReference();
                                myRef.child("Users").child(user.getUid()).setValue(user1);

                                //startActivity();

                                myRef.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        User newValue = snapshot.getValue(User.class);

                                        Log.d("","NEW VALUE ------------------------ "+newValue.toString());

                                        startActivity(new Intent(UserRegistration.this, MakeHire.class));
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                                // updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(UserRegistration.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }
                        }
                    });

        } else {
            Toast.makeText(this, "Email and password fields are invalid", Toast.LENGTH_SHORT).show();
        }
    }
}