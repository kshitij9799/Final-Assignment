package com.example.finalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserShowDetails extends AppCompatActivity {
    private String email;
    private TextView semail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_show_details);

        email = getIntent().getStringExtra("email");
        semail = findViewById(R.id.email);
    }
}