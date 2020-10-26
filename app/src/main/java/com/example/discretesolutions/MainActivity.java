package com.example.discretesolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button login_btn;
    TextView sup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sup = (TextView) findViewById(R.id.noaccbt);
        login_btn = findViewById(R.id.lgnbtn);

        //Listening to SignUp TextView
        sup.setOnClickListener(new View.OnClickListener() {
            @Override

            //Going from one Activity to Another
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

        //Listening to Login Button
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Home_Screen.class));
            }
        });

    }
}