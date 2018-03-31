package com.example.dell.vollytutorialone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StudentLogin_New extends AppCompatActivity {

    String URL="http://192.168.1.4/mylogin.php";
    EditText ed_mail;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login__new);
        ed_mail=findViewById(R.id.ed_mail);
        btnlogin=findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nm = ed_mail.getText().toString().trim();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                            {


                            Toast.makeText(StudentLogin_New.this, ""+response, Toast.LENGTH_SHORT).show();
                                    if(response.equals("valid"))
                                    {
                                        Toast.makeText(StudentLogin_New.this, "valid", Toast.LENGTH_SHORT).show();
                                    }

                              }


                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(StudentLogin_New.this, "error", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }


                ) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("name", nm);

                        return params;
                    }
                };
                MySingleton.getInstance(StudentLogin_New.this).addToRequestQueue(stringRequest);
            }

        });
    }
}
