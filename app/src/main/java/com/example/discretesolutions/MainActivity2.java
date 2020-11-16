package com.example.discretesolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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
                if (!pass.equals(cpass)) {
                    status.setText("Password doesnt match");
                } else if (pno.length() != 10) {
                    status.setText("Incorrect phone number");
                } else {
                    register(name, eid, pno, cname, pass);
                    status.setText("Successfully Signed Up");
                    startActivity(new Intent(MainActivity2.this, Home_Screen.class));
                }
            }
        });
    }

    public void register(String name, String eid, String pno, String cname, String pass) {
        JSONObject signupJSON = new JSONObject();
        try {
            signupJSON.put("clientName", name);
            signupJSON.put("emailId", eid);
            signupJSON.put("phoneNo", pno);
            signupJSON.put("organisationName", cname);
            signupJSON.put("password", pass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestQueue signupq = Volley.newRequestQueue(MainActivity2.this);
        JsonObjectRequest signupreq = new JsonObjectRequest(
                Request.Method.POST,
                "http://192.168.0.104:3060/client/register",
                signupJSON,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error);
                    }
                });
        signupreq.setRetryPolicy(new DefaultRetryPolicy(120000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        signupq.add(signupreq);
        System.out.println("Done");
    }
}