package com.example.dell.vollytutorialone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StudentHome extends AppCompatActivity {

    TextView nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
       Intent intent=getIntent();
         /*   Bundle bundle=intent.getExtras();
           String email=    bundle.getString("em");

        nm=findViewById(R.id.nm);
        nm.setText("hello user your email is"+email);*/
    }
}
