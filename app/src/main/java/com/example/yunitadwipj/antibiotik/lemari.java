package com.example.yunitadwipj.antibiotik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class lemari extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lemari);
        getSupportActionBar().setTitle("Lemari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
