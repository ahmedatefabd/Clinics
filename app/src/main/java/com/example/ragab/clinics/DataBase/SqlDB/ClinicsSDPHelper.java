package com.example.ragab.clinics.DataBase.SqlDB;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClinicsSDPHelper extends SQLiteOpenHelper {
    public static final String DATA_BASE_NAME = "";
    public static final String TABLE_ = "";

    public ClinicsSDPHelper(Context context) {
        super(context, DATA_BASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}