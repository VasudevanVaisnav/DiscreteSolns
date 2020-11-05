package com.example.discretesolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_b);
        TextView txtvv = (TextView) findViewById(R.id.textIDAP);
        Bundle arg = getIntent().getExtras();
        String id = arg.get("id").toString();
        txtvv.setText(id);
    }
}