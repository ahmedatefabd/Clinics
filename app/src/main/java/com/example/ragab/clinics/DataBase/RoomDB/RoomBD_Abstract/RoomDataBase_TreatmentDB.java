package com.example.ragab.clinics.DataBase.RoomDB.RoomBD_Abstract;
import android.content.Context;
import com.example.ragab.clinics.DataBase.RoomDB.DAO.DAO_Treatment;

import ModelDB.TreatmentDB;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TreatmentDB.class}, version = 1, exportSchema = false)
public abstract class RoomDataBase_TreatmentDB extends RoomDatabase {

    private static RoomDatabase instance;
    public abstract DAO_Treatment operation();

    public RoomDataBase_TreatmentDB() {
    }

    //Single ton
    public static RoomDatabase getInstance(Context context) {

        if (instance == null) {
            synchronized (RoomDataBase_TreatmentDB.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDataBase_TreatmentDB.class,
                            "product_database")
                            .build();

                }
            }
        }
        return instance;
    }

}
