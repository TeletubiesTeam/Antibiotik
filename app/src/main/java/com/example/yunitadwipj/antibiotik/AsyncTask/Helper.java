package com.example.yunitadwipj.antiobiotik.AsyncTask;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Helper extends AppCompatActivity {
    public Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    /*alamat utama, silahkan disesuaikan dgn ip sobat dan nama folder sobat*/
    public static String BASE_URL = "http://192.168.43.89/antibiotikwebsite";

    /*fungsi cek kesamaan text*/
    public static boolean isCompare(EditText et1, EditText et2){
        String a = et1.getText().toString();
        String b = et2.getText().toString();
        /*jika a sama dengan b*/
        if (a.equals(b)){
            return false;
        }else{
            return true;
        }
    }

    /*fungsi untuk menampilkan pesan*/
    public static void pesan (Context c, String msg){
        Toast.makeText(c,msg,Toast.LENGTH_LONG).show();
    }

    /*fungsi untuk mengecek apakah isian kosong*/
    public static boolean isEmpty(EditText editText){
        /*jika banyak huruf lebih dari 0*/
        if (editText.getText().toString().trim().length() > 0){
            /*tidak dikembalikan*/
            return false;
        }else {
            /*kembalikan*/
            return true;
        }
    }

}
