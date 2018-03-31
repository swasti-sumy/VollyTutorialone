package com.example.dell.vollytutorialone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.toolbox.*;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;




public class Name_Email extends AppCompatActivity {

    TextView txtname,txtemail;
    Button btnshow;
    String URL="http://192.168.1.4/studentfetch.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name__email);

        txtemail=findViewById(R.id.txtemail);
        txtname=findViewById(R.id.txtname);
        btnshow=findViewById(R.id.btnshow);
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                /*JsonObjectRequest jsonObjectRequest=new JsonObjectRequest
                        (Request.Method.POST, URL, (String) null,
                                new Response.Listener<JSONObject>()
                                {
                    @Override
                    public void onResponse(JSONObject response)
                    {

                    }
                }, new Response.ErrorListener()
                        {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
*/
            }
        });

    }
}
