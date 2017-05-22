package com.example.yunitadwipj.antibiotik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Homemalam extends AppCompatActivity {
    ImageButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Antibiotik Online");
        setContentView(R.layout.activity_homemalam);

        btn = (ImageButton) findViewById(R.id.pagi);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homemalam.this,Homepagi.class);
                startActivity(intent);

            }
        });
        btn = (ImageButton) findViewById(R.id.siang);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homemalam.this,Homesiang.class);
                startActivity(intent);

            }
        });
        btn = (ImageButton) findViewById(R.id.sore);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homemalam.this,Homesore.class);
                startActivity(intent);

            }
        });
        btn = (ImageButton) findViewById(R.id.malam);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homemalam.this,Homemalam.class);
                startActivity(intent);

            }
        });


        btn = (ImageButton) findViewById(R.id.lonceng);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homemalam.this,alarm.class);
                startActivity(intent);

            }
        });

        btn = (ImageButton) findViewById(R.id.tips);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homemalam.this,tips.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.status);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homemalam.this,status.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.lemari);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homemalam.this,lemari.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.dokterku);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homemalam.this,dokterku.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.darurat);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homemalam.this,darurat.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.bantuan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homemalam.this,bantuan.class);
                startActivity(intent);
            }
        });
    }
}