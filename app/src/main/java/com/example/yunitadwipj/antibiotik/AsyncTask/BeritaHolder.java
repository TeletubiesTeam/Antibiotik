package com.example.misbahul.antiobiotik.AsyncTask;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.misbahul.antiobiotik.R;

import java.util.ArrayList;
import java.util.HashMap;

public class BeritaHolder extends RecyclerView.ViewHolder{
    public TextView txtjudul, txtwaktu, txtlink, txtdeskripsi;
    public ImageView gambar;
    public CardView cardView;

    ArrayList<HashMap<String, String>> list_data;



    public BeritaHolder(final View itemView) {
        super(itemView);
        //itemView.setOnClickListener(this);

        /*mangenalkan objek*/
        txtjudul = (TextView) itemView.findViewById(R.id.judul);
        txtdeskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
        txtwaktu = (TextView) itemView.findViewById(R.id.waktu);
        txtlink = (TextView) itemView.findViewById(R.id.link);
        gambar = (ImageView) itemView.findViewById(R.id.gambar);
        cardView = (CardView) itemView.findViewById(R.id.cardView);


    }
}