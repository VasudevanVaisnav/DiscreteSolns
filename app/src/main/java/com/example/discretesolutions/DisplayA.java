package com.example.discretesolutions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayA extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_a);

        TextView txtvv = (TextView) findViewById(R.id.textID);


        int id = getIntent().getIntExtra("ID", 9);
        txtvv.setText(String.valueOf(id));


    }
}
