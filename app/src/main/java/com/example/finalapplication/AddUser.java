package com.example.finalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddUser extends AppCompatActivity {
    private EditText name,job;
    private Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        name=findViewById(R.id.name);
        job=findViewById(R.id.job);
        submitBtn=findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty() && job.getText().toString().isEmpty()) {
                    Toast.makeText(AddUser.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }
                submit(name.getText().toString(), job.getText().toString());
            }
        });


    }
    private void submit(String name, String job)
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);
        FormData modal = new FormData(name, job);
        Call<FormData> call = api.createPost(modal);
        call.enqueue(new Callback<FormData>() {
            @Override
            public void onResponse(Call<FormData> call, Response<FormData> response) {
                Toast.makeText(AddUser.this, "Data added to API", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<FormData> call, Throwable t) {
                Toast.makeText(AddUser.this, "Invalid Data", Toast.LENGTH_SHORT).show();
            }
        });

    }
}