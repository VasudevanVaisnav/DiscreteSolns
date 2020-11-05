package com.example.discretesolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class display_a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_a);
        TextView txtvv = (TextView) findViewById(R.id.textIDCP);
        Bundle arg = getIntent().getExtras();
        String id = arg.get("id").toString();
        txtvv.setText(id);
    }
}