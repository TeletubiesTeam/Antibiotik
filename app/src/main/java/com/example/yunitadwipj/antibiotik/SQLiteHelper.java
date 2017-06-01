package com.example.yunitadwipj.antibiotik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yunitadwipj on 26/05/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "db_antibiotik";
    public static final String TABLE_ALARM = "tbl_alarm";
    public static final String ID_ALARM = "id_alarm";
    public static final String NAMA_OBAT = "nama_obat";
    public static final String WAKTU = "waktu";
    public static final String KETERANGAN = "keterangan";

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_ALARM + "(" + ID_ALARM + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NAMA_OBAT + " TEXT, " + WAKTU + " TIME, " + KETERANGAN + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertAlarm (String nama_obat, String waktu, String keterangan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAMA_OBAT, nama_obat);
        contentValues.put(WAKTU, waktu);
        contentValues.put(KETERANGAN, keterangan);
        long result = db.insert(TABLE_ALARM, null, contentValues);

        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getData(String query) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery(query, null );
        return res;
    }
}
