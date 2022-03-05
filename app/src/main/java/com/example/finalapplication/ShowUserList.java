package com.example.finalapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ShowUserList extends RecyclerView.Adapter<ShowUserList.ViewHolder> {

    ArrayList<UserData> data;
    Context context;

    public ShowUserList(ArrayList<UserData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ShowUserList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.user_list_ui, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShowUserList.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.fname.setText(data.get(position).getFirst_name());
        holder.lname.setText(data.get(position).getLast_name());
        holder.email.setText(data.get(position).getEmail());
        Picasso.with(context).load(data.get(position).getAvatar()).fit().into(holder.imageView);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), UserShowDetails.class);
                intent.putExtra("fname",data.get(position).getFirst_name());
                intent.putExtra("lname",data.get(position).getLast_name());
                intent.putExtra("email",data.get(position).getEmail());
                intent.putExtra("img",data.get(position).getAvatar());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView fname,lname,email;
        ImageView imageView;
        Button btn;
        public ViewHolder(View itemView) {
            super(itemView);
            fname=itemView.findViewById(R.id.fname);
            lname=itemView.findViewById(R.id.lname);
            email=itemView.findViewById(R.id.email);
            imageView=itemView.findViewById(R.id.img);
            btn=itemView.findViewById(R.id.showbtn);
        }
    }
}
