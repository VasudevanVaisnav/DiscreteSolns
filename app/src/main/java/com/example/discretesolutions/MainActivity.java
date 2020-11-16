package com.example.discretesolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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
                TextView eidip = (TextView) findViewById(R.id.unipfield);
                TextView passip = (TextView) findViewById(R.id.pwipfield);
                String eid = eidip.getText().toString();
                String pass = passip.getText().toString();
                check_auth(eid, pass);
            }
        });
    }

    public void check_auth(String eid, String pass) {
        System.out.println(eid);
        System.out.println(pass);
        String sts = "";
        RequestQueue loginq = Volley.newRequestQueue(MainActivity.this);
        JSONObject credJSON = new JSONObject();
        try {
            credJSON.put("emailId", eid);
            credJSON.put("password", pass);
            System.out.println(credJSON);
        } catch (JSONException e) {
            System.out.println("e10");
        }
        JsonObjectRequest loginreq = new JsonObjectRequest(
                Request.Method.POST,
                "http://192.168.0.104:3060/client/login",
                credJSON,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String status = response.get("msg").toString();
                            System.out.println(status);
                            if (status.equalsIgnoreCase("success")) {
                                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(MainActivity.this, Home_Screen.class));
                            } else {
                                System.out.println("asdf");
                                Toast.makeText(getApplicationContext(), "Login Failure", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {

                            System.out.println(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error);
                    }
                });
        loginreq.setRetryPolicy(new DefaultRetryPolicy(120000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        loginq.add(loginreq);
    }
}