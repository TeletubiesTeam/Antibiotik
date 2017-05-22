package com.example.yunitadwipj.antibiotik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Homesore extends AppCompatActivity {
    ImageButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Antibiotik Online");
        setContentView(R.layout.activity_homesore);

        btn = (ImageButton) findViewById(R.id.pagi);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homesore.this,Homepagi.class);
                startActivity(intent);

            }
        });
        btn = (ImageButton) findViewById(R.id.siang);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homesore.this,Homesiang.class);
                startActivity(intent);

            }
        });
        btn = (ImageButton) findViewById(R.id.sore);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homesore.this,Homesore.class);
                startActivity(intent);

            }
        });
        btn = (ImageButton) findViewById(R.id.malam);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homesore.this,Homemalam.class);
                startActivity(intent);

            }
        });


        btn = (ImageButton) findViewById(R.id.lonceng);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homesore.this,alarm.class);
                startActivity(intent);

            }
        });

        btn = (ImageButton) findViewById(R.id.tips);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homesore.this,tips.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.status);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homesore.this,status.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.lemari);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homesore.this,lemari.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.dokterku);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homesore.this,dokterku.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.darurat);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homesore.this,darurat.class);
                startActivity(intent);
            }
        });

        btn = (ImageButton) findViewById(R.id.bantuan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homesore.this,bantuan.class);
                startActivity(intent);
            }
        });
    }
}
