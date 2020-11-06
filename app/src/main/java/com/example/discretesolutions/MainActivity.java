package com.example.discretesolutions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button login_btn;
    TextView sup;
    EditText eid, pass;
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sup = (TextView) findViewById(R.id.noaccbt);

        login_btn = findViewById(R.id.lgnbtn);
        eid = findViewById(R.id.unipfield);
        pass = findViewById(R.id.pwipfield);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mUser = mAuth.getCurrentUser();
                if (mUser != null) {
                    Toast.makeText(MainActivity.this, "LOGGED IN SUCCESSFULLY !!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, Home_Screen.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "PLEASE LOG IN", Toast.LENGTH_SHORT).show();
                }

            }
        };

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = eid.getText().toString();
                String pwd = pass.getText().toString();

                if (email.isEmpty()) {
                    eid.setError("Please enter email id");
                    eid.requestFocus();
                } else if (pwd.isEmpty()) {
                    pass.setError("Please enter your password");
                    pass.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "LOGIN FAILED....TRY AGAIN !!", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent i = new Intent(MainActivity.this, Home_Screen.class);
                                startActivity(i);
                            }
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "ERROR OCCURRED !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Listening to SignUp TextView
        sup.setOnClickListener(new View.OnClickListener() {
            @Override

            //Going from one Activity to Another
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

        /*
        //Listening to Login Button
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Home_Screen.class));
            }
        });

         */

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
}

