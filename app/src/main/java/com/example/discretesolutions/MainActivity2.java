package com.example.discretesolutions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {


    EditText namef, cnamef, pnof, eidf, passf, confpassf;
    Button sdtn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView status = (TextView) findViewById(R.id.supstatus);
        status.setText("");
        namef = (EditText) findViewById(R.id.nameipfield);
        cnamef = (EditText) findViewById(R.id.cnameipfield);
        pnof = (EditText) findViewById(R.id.pnoipfield);
        eidf = (EditText) findViewById(R.id.emailipfield);
        passf = (EditText) findViewById(R.id.passipfield);
        confpassf = (EditText) findViewById(R.id.cpassipfield);
        Button sbtn = (Button) findViewById(R.id.signupbtn);


        mAuth = FirebaseAuth.getInstance();

        //Listening to SignIn button
        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = namef.getText().toString();
                String cname = cnamef.getText().toString();
                String pno = pnof.getText().toString();
                String eid = eidf.getText().toString();
                String pass = passf.getText().toString();
                String cpass = confpassf.getText().toString();
                if (name.isEmpty()) {
                    namef.setError("Name cannot be empty");
                    namef.requestFocus();
                } else if (eid.isEmpty()) {
                    eidf.setError("Email cannot be empty");
                    eidf.requestFocus();
                } else if (pno.isEmpty()) {
                    pnof.setError("Enter Phone Number");
                    pnof.requestFocus();
                } else if (cname.isEmpty()) {
                    cnamef.setError("Mention Organisation Name");
                    cnamef.requestFocus();
                } else if (pass.isEmpty()) {
                    passf.setError("Set Password");
                    passf.requestFocus();
                } else if (pno.length() != 10) {
                    pnof.setError("Incorrect Phone Number");
                    pnof.requestFocus();
                } else if (cpass.isEmpty()) {
                    confpassf.setError("Confirm Password");
                    confpassf.requestFocus();
                } else if (!pass.equals(cpass)) {
                    status.setText("Password doesnot match");
                } else if (pass.length() < 6) {
                    passf.setError("Password must contain atleast 6 characters");
                    passf.requestFocus();
                } else if (!(eid.isEmpty() && pass.isEmpty())) {
                    mAuth.createUserWithEmailAndPassword(eid, pass).addOnCompleteListener(MainActivity2.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {

                                Toast.makeText(MainActivity2.this, "SignUp Unsuccessful", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(MainActivity2.this, Home_Screen.class));
                            }
                        }
                    });
                    //register(name, eid, pno, cname, pass, cpass);
                    //startActivity(new Intent(MainActivity2.this, Home_Screen.class));
                    //register(name, eid, pno, cname, pass, cpass);
                    //status.setText("Successfully Signed Up");
                } else {
                    Toast.makeText(MainActivity2.this, "ERROR OCCURRED !!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    /*
    public void register(String name, String eid, String pno, String cname, String pass, String cpass) {
        System.out.println("Done");
    }

     */


}