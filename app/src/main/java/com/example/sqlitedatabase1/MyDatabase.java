package com.example.sqlitedatabase1;

import android.annotation.SuppressLint;
import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
@SuppressLint("Range")
public class MyDatabase extends SQLiteAssetHelper {
    public static final String DB_NAME = "cars.db";
    public static final int DB_VERSION = 1;
    public static final String CAR_TB_NAME = "car";
    public static final String CAR_CLN_ID = "id";
    public static final String CAR_CLN_MODEL = "model";
    public static final String CAR_CLN_COLOR = "color";
    public static final String CAR_CLN_DPL = "distancePerLetter";
    public MyDatabase(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

    /*
    @Override
   public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + CAR_TB_NAME + " (" + CAR_CLN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            CAR_CLN_MODEL + " TEXT ," + CAR_CLN_COLOR + " TEXT," + CAR_CLN_DPL + " REAL)");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + CAR_TB_NAME);
        onCreate(db);
    }
    */


}
