package com.example.yunitadwipj.antibiotik;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class setalarm extends AppCompatActivity {

    TimePicker myTimePicker;
    Button buttonstartSetDialog, btnSimpan;
    TextView textAlarmPrompt;
    private EditText edtAdd;
    private RadioButton rdPagi, rdSiang, rdSore, rdMalam;
    private AnalogClock jam;
    private SQLiteHelper db;
    private String keterangan = null;

    TimePickerDialog timePickerDialog;

    final static int RQS_1 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setalarm);
        getSupportActionBar().setTitle("Set Alarm");
        textAlarmPrompt = (TextView)
                findViewById(R.id.alarmprompt);
        edtAdd = (EditText)findViewById(R.id.addnama);
        buttonstartSetDialog = (Button)
                findViewById(R.id.startSetDialog);
        rdPagi = (RadioButton)findViewById(R.id.pg);
        rdSiang = (RadioButton)findViewById(R.id.sg);
        rdSore = (RadioButton)findViewById(R.id.sr);
        rdMalam = (RadioButton)findViewById(R.id.ml);

        btnSimpan = (Button)findViewById(R.id.simpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtAdd.getText().equals("") || textAlarmPrompt.getText().equals("") || keterangan == null){
                    Toast.makeText(getApplicationContext(), "Field masih kosong", Toast.LENGTH_SHORT).show();
                }else {
                    //Toast.makeText(getApplicationContext(), keterangan, Toast.LENGTH_SHORT).show();
                    boolean isInserted = db.insertAlarm(edtAdd.getText().toString(),
                            textAlarmPrompt.getText().toString(), keterangan);
                    if (isInserted == true){
                        Toast.makeText(getApplicationContext(), "Alarm berhasil disimpan", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), alarm.class);
                        startActivity(i);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "Alarm gagal disimpan", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        buttonstartSetDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textAlarmPrompt.setText("");
                openTimePickerDialog(false);
            }
        });

        db = new SQLiteHelper(this);

        rdPagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keterangan = "Pagi";
            }
        });
        rdSiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keterangan = "Siang";
            }
        });
        rdSore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keterangan = "Sore";
            }
        });
        rdMalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keterangan = "Malam";
            }
        });

    }
    private void openTimePickerDialog(boolean is24r){
        Calendar calendar = Calendar.getInstance();

        timePickerDialog=new
                TimePickerDialog(setalarm.this,
                onTimeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true);
        timePickerDialog.setTitle("Set Alarm Time");
        timePickerDialog.show();
    }

    TimePickerDialog.OnTimeSetListener onTimeSetListener = new
            TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    Calendar calNow = Calendar.getInstance();
                    Calendar calSet = (Calendar)
                            calNow.clone();
                    calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calSet.set(Calendar.MINUTE, minute);
                    calSet.set(Calendar.SECOND, 0);
                    calSet.set(Calendar.MILLISECOND, 0);

                    if (calSet.compareTo(calNow) <= 0) {
                        calSet.add(Calendar.DATE, 1);
                        Log.i("hasil", "=<0");
                    } else if (calSet.compareTo(calNow) > 0) {
                        Log.i("hasil", ">0");
                    } else {
                        Log.i("hasil", "else");
                    }

                    setAlarm(calSet);
                }
            };

    private void setAlarm(Calendar targetCal){
        //textAlarmPrompt.setText("***\n" + "Alarm set on " + targetCal.getTime()+"***");
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String formatted = format.format(targetCal.getTime());
        textAlarmPrompt.setText(formatted);
        Intent intent = new
                Intent(getBaseContext(),alarmreceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(),RQS_1,intent,0);
        AlarmManager alarmManager = (AlarmManager)
                getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,
                targetCal.getTimeInMillis(),pendingIntent);
    }
}