package com.example.ragab.clinics.DataBase.RoomDB.RoomBD_Abstract;
import android.content.Context;

import com.example.ragab.clinics.DataBase.RoomDB.DAO.DAO;

import ModelDB.BookingAll_ItemsDB;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {BookingAll_ItemsDB.class}, version = 1, exportSchema = false)
public abstract class RoomDataBase extends RoomDatabase {

    private static RoomDatabase instance;
    public abstract DAO oper();

    public RoomDataBase() {
    }

    //Single ton
    public static RoomDatabase getInstance(Context context) {

        if (instance == null) {
            synchronized (RoomDataBase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDataBase.class,
                            "product_database")
                            .build();

                }
            }
        }
        return instance;
    }

}
