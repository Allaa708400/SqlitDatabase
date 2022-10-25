package com.example.sqlitedatabase1;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
@SuppressLint("Range")
public class DatabaseAccess {

    private SQLiteDatabase database;
    private SQLiteOpenHelper openHelper;
    private static DatabaseAccess instance;
    private DatabaseAccess(Context context){

        this.openHelper = new MyDatabase(context);

    }
    public static DatabaseAccess getInstance(Context context){
        if (instance==null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.database = this.openHelper.getWritableDatabase();

    }
    public void close(){
        if (this.database!=null){
            this.database.close();
        }

    }


    public boolean insertCar(Car car) {

        ContentValues values = new ContentValues();
        values.put(MyDatabase.CAR_CLN_MODEL, car.getModel());
        values.put(MyDatabase.CAR_CLN_COLOR, car.getColor());
        values.put(MyDatabase.CAR_CLN_DPL, car.getDbl());
        long result = database.insert(MyDatabase.CAR_TB_NAME, null, values);
        return result != -1;
    }

    public boolean updateCar(Car car) {

        ContentValues values = new ContentValues();
        values.put(MyDatabase.CAR_CLN_MODEL, car.getModel());
        values.put(MyDatabase.CAR_CLN_COLOR, car.getColor());
        values.put(MyDatabase.CAR_CLN_DPL, car.getDbl());
        String args[] = {String.valueOf(car.getId())};
        int result = database.update(MyDatabase.CAR_TB_NAME, values, "id=?", args);
        return result > 0;
    }


    public long getCarsCount(){

        return DatabaseUtils.queryNumEntries(database, MyDatabase.CAR_TB_NAME);
    }
    public boolean deleteCar(Car car) {


        String args[] = {String.valueOf(car.getId())};
        int result =database.delete(MyDatabase.CAR_TB_NAME,"id=?", args);
        return result > 0;
    }
    public ArrayList<Car> getAllCars(){

        ArrayList<Car> cars = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM "+MyDatabase.CAR_TB_NAME, null);
        if (cursor != null && cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MyDatabase.CAR_CLN_ID));
                String model = cursor.getString(cursor.getColumnIndex(MyDatabase.CAR_CLN_MODEL));
                String color = cursor.getString(cursor.getColumnIndex(MyDatabase.CAR_CLN_COLOR));
                double dbl = cursor.getDouble(cursor.getColumnIndex(MyDatabase.CAR_CLN_DPL));
                Car c = new Car(id,model,color,dbl);
                cars.add(c);
            }while (cursor.moveToNext());
            cursor.close();
        }
        return cars;
    }
    public ArrayList<Car> getCars(String modelSearch){

        ArrayList<Car> cars = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM "+MyDatabase.CAR_TB_NAME +" WHERE "+MyDatabase.CAR_CLN_MODEL+" LIKE ?"
                ,new String[]{modelSearch+"%"});
        if (cursor != null && cursor.moveToFirst()){
            do {
                 int id = cursor.getInt(cursor.getColumnIndex(MyDatabase.CAR_CLN_ID));
                String model = cursor.getString(cursor.getColumnIndex(MyDatabase.CAR_CLN_MODEL));
                String color = cursor.getString(cursor.getColumnIndex(MyDatabase.CAR_CLN_COLOR));
                double dbl = cursor.getDouble(cursor.getColumnIndex(MyDatabase.CAR_CLN_DPL));
                Car c = new Car(id,model,color,dbl);
                cars.add(c);
            }while (cursor.moveToNext());
            cursor.close();
        }
        return cars;
    }


}
