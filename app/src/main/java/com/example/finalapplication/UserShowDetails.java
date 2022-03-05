package com.example.finalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserShowDetails extends AppCompatActivity {
    private String email,fname,lname;
    private TextView semail,sfname,slname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_show_details);

        fname = getIntent().getStringExtra("fname");
        lname = getIntent().getStringExtra("lname");
        email = getIntent().getStringExtra("email");
        sfname = findViewById(R.id.fname);
        slname = findViewById(R.id.lname);
        semail = findViewById(R.id.email);
        sfname.setText(fname);
        slname.setText(lname);
        semail.setText(email);
    }
}