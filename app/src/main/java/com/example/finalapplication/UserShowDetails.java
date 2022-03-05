package com.example.finalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class UserShowDetails extends AppCompatActivity {
    private String email,fname,lname,img;
    private TextView semail,sfname,slname;
    private ImageView imageView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_show_details);

        fname = getIntent().getStringExtra("fname");
        lname = getIntent().getStringExtra("lname");
        email = getIntent().getStringExtra("email");
        img = getIntent().getStringExtra("img");
        sfname = findViewById(R.id.fname);
        slname = findViewById(R.id.lname);
        semail = findViewById(R.id.email);
        imageView = findViewById(R.id.img);
        Picasso.with(context).load(img).fit().into(imageView);
        sfname.setText(fname);
        slname.setText(lname);
        semail.setText(email);
    }
}