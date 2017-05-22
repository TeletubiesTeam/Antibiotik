package com.example.yunitadwipj.antibiotik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Homepagi extends AppCompatActivity {
ImageButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Antibiotik Online");
        setContentView(R.layout.activity_homepagi);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        btn = (ImageButton) findViewById(R.id.pagi);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepagi.this,Homepagi.class);
                startActivity(intent);

            }
        });
        btn = (ImageButton) findViewById(R.id.siang);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepagi.this,Homesiang.class);
                startActivity(intent);

            }
        });
        btn = (ImageButton) findViewById(R.id.sore);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepagi.this,Homesore.class);
                startActivity(intent);

            }
        });
        btn = (ImageButton) findViewById(R.id.malam);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepagi.this,Homemalam.class);
                startActivity(intent);

            }
        });


        btn = (ImageButton) findViewById(R.id.lonceng);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepagi.this,alarm.class);
                startActivity(intent);

            }
        });

        btn = (ImageButton) findViewById(R.id.tips);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepagi.this,tips.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.status);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepagi.this,status.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.lemari);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepagi.this,lemari.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.dokterku);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepagi.this,dokterku.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.darurat);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepagi.this,darurat.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.bantuan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepagi.this,bantuan.class);
                startActivity(intent);
            }
        });
    }
}