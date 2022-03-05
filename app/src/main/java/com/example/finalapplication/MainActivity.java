package com.example.finalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    NestedScrollView nScroll;
    Button addUser;
    int page = 0, limit = 2;
    ArrayList list;
    ShowUserList adapter;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        nScroll = findViewById(R.id.nScroll);
        addUser = findViewById(R.id.adduser);
        list = new ArrayList();


     addUser.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i = new Intent(MainActivity.this,AddUser.class);
             startActivity(i);
         }
     });



    listingdata(page, limit);
    nScroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
        @Override
        public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                if(page < 2) {
                    page++;
                }
                listingdata(page, limit);
            }
        }
    });


    }

    private void listingdata(int page, int limit) {
        Call<GetData> call = RetrofitClient.getInstance().getMyApi().getUserList(page);
        call.enqueue(new Callback<GetData>() {
            @Override
            public void onResponse(Call<GetData> call, Response<GetData> response) {

                if(page==0) {
                    list = response.body().getData();
                    adapter = new ShowUserList(list, MainActivity.this);
                    recycler.setHasFixedSize(true);
                    recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recycler.setAdapter(adapter);
                }else {

                    list.addAll(response.body().getData());

                    adapter = new ShowUserList(list, MainActivity.this);
                    recycler.setHasFixedSize(true);
                    recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recycler.setAdapter(adapter);

                }


            }

            @Override
            public void onFailure(Call<GetData> call, Throwable t) {

            }
        });
    }

}