package com.example.discretesolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView status = (TextView) findViewById(R.id.supstatus);
        status.setText("");
        EditText namef = (EditText) findViewById(R.id.nameipfield);
        EditText cnamef = (EditText) findViewById(R.id.cnameipfield);
        EditText pnof = (EditText) findViewById(R.id.pnoipfield);
        EditText eidf = (EditText) findViewById(R.id.emailipfield);
        EditText passf = (EditText) findViewById(R.id.passipfield);
        EditText confpassf = (EditText) findViewById(R.id.cpassipfield);
        Button sbtn = (Button) findViewById(R.id.signupbtn);
        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = namef.getText().toString();
                String cname = cnamef.getText().toString();
                String pno = pnof.getText().toString();
                String eid = eidf.getText().toString();
                String pass = passf.getText().toString();
                String cpass = confpassf.getText().toString();
                if (!pass.equals(cpass)) {
                    status.setText("Password doesnt match");
                } else if (pno.length() != 10) {
                    status.setText("Incorrect phone number");
                } else {
                    register(name, eid, pno, cname, pass, cpass);
                    status.setText("Successfully Signed Up");
                }
            }
        });
    }

    public void register(String name, String eid, String pno, String cname, String pass, String cpass) {
        System.out.println("Done");
    }
}