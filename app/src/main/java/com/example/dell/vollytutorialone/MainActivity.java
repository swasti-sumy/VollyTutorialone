package com.example.dell.vollytutorialone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button btnshow;
    TextView txtdata;
    String serverurl="http://192.168.1.4/demo.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnshow=findViewById(R.id.btnshow);
        txtdata=findViewById(R.id.txtdata);
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "clickhere", Toast.LENGTH_SHORT).show();
                final RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);

                Toast.makeText(MainActivity.this, "after request", Toast.LENGTH_SHORT).show();


                StringRequest stringRequest=new StringRequest(Request.Method.POST, serverurl,


                        new Response.Listener<String>()
                        {

                            @Override
                            public void onResponse(String response)
                            {

                                Log.e("res",response);
                                Toast.makeText(MainActivity.this, "in response", Toast.LENGTH_SHORT).show();
                                txtdata.setText(response);
                                requestQueue.stop();
                            }
                        }


                        ,
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                txtdata.setText("error");
                                error.printStackTrace();;
                                requestQueue.stop();

                            }
                        });
                requestQueue.add(stringRequest);
            }
        });
    }
}
