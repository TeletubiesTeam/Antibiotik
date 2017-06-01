package com.example.yunitadwipj.antibiotik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class hubungidokter extends AppCompatActivity {
    private ListView lvItem;
    private String[] bahasapemrograman = new String[]{
            "Ramadhanny"};

    ImageButton btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubungidokter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btn = (ImageButton) findViewById(R.id.imageButton11);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hubungidokter.this,tambahdokter.class);
                startActivity(intent);
            }
        });





                getSupportActionBar().setTitle("Hubungi Dokter"); //tampil title
      //  getSupportActionBar().setSubtitle("Telletubis"); //tampil subtitle


        lvItem = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(hubungidokter.this, android.R.layout.simple_list_item_1, android.R.id.text1, bahasapemrograman);


        lvItem.setAdapter(adapter);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i =new Intent(getApplicationContext(),profildokter.class);
                startActivity(i);
            }
        });
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
