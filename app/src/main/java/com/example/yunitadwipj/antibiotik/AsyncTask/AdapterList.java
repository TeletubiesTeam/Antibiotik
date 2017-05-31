package com.example.misbahul.antiobiotik.AsyncTask;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.misbahul.antiobiotik.DetailTips;
import com.example.misbahul.antiobiotik.DetailTips;
import com.example.misbahul.antiobiotik.ListTips;
import com.example.misbahul.antiobiotik.ListTips;
import com.example.misbahul.antiobiotik.R;

import java.util.ArrayList;
import java.util.HashMap;


public class AdapterList extends RecyclerView.Adapter<BeritaHolder>  {

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterList(ListTips listBerita, ArrayList<HashMap<String, String>> list_data) {
        this.context = listBerita;
        this.list_data = list_data;
    }

    @Override
    public BeritaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new BeritaHolder(view);

    }

    @Override
    public void onBindViewHolder(BeritaHolder holder, final int position) {

        Glide.with(context)
                .load(list_data.get(position).get("gambar"))
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.gambar);
        holder.txtjudul.setText(list_data.get(position).get("judul"));
        holder.txtdeskripsi.setText(list_data.get(position).get("deskripsi"));
        holder.txtwaktu.setText(list_data.get(position).get("waktu"));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), DetailTips.class);
                intent.putExtra("Link", list_data.get(position).get("link"));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }
}