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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class StudentLogin extends AppCompatActivity {
EditText loginemail;
Button btnlogin;

        //String URL="http://192.168.1.4/logincheck.php";
    String URL="http://192.168.43.8/checkloginnew.jsp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);



        loginemail=findViewById(R.id.loginemail);
        btnlogin=findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               final String em=loginemail.getText().toString().trim();
                Toast.makeText(StudentLogin.this, "email is"+em, Toast.LENGTH_SHORT).show();
                StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        try {

                            Toast.makeText(StudentLogin.this, "res"+response, Toast.LENGTH_SHORT).show();
                           // JSONArray jsonArray=new JSONArray(response);
                            //JSONObject jsonObject=jsonArray.getJSONObject(0);
                           JSONObject jsonObject=new JSONObject("{response}");

                            String msg=jsonObject.getString("code");
                            String mail=jsonObject.getString("email");

                            Toast.makeText(StudentLogin.this, "from response"+mail, Toast.LENGTH_SHORT).show();
                            if(msg.equals("loginfailed"))

                            {

                                Toast.makeText(StudentLogin.this, "Login error", Toast.LENGTH_SHORT).show();
                            }


                            else


                            {

                                Intent intent=new Intent(StudentLogin.this,StudentHome.class);
                                Bundle bundle=new Bundle();
                                bundle.putString("em",jsonObject.getString("email"));
                                intent.putExtras(bundle);
                                startActivity(intent);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error){

            Toast.makeText(StudentLogin.this, "error", Toast.LENGTH_SHORT).show();
                          error.printStackTrace();


                            }

                        }
                )

                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {


                        Map<String,String>params=new HashMap<>();
                        params.put("email",em);
                        return  params;

                    }

                    /*@Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("Content-Type","application/x-www-form-urlencoded");
                        return params;
                    }*/


                }



                    ;
                MySingleton.getInstance(StudentLogin.this).addToRequestQueue(stringRequest);

            }
        });
    }
}
