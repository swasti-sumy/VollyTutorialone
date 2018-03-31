package com.example.dell.vollytutorialone;

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

import java.util.HashMap;
import java.util.Map;

public class StudentRegistration extends AppCompatActivity {

    EditText stname,stemail;
    Button btnregister;
    String URL="http://192.168.1.4/studentinsert.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);

        stname=findViewById(R.id.stname);
        stemail=findViewById(R.id.stemail);
        btnregister=findViewById(R.id.btnregister);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            final String sname=stname.getText().toString().trim();

           final String semail=stemail.getText().toString().trim();
             Toast.makeText(StudentRegistration.this, ""+sname+semail, Toast.LENGTH_SHORT).show();
                StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                      Toast.makeText(StudentRegistration.this, "studentRegistersuccesssfully", Toast.LENGTH_SHORT).show();
                        stname.setText("");
                        stemail.setText("");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(StudentRegistration.this, "error", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                })
                {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError
                    {

                        Map<String, String> params = new HashMap<>();
                        params.put("name", sname);
                        params.put("email", semail);

                        return params;

                    }
                }

                        ;
     MySingleton.getInstance(StudentRegistration.this).addToRequestQueue(stringRequest);
          }
        });

    }
}
