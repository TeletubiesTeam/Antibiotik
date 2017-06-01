package com.example.yunitadwipj.antibiotik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class dokterku extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokterku);
        getSupportActionBar().setTitle("Dokterku");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void onclick(View view)
    {
        Intent simpan = new Intent(this,hubungidokter.class);
        startActivity(simpan);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
