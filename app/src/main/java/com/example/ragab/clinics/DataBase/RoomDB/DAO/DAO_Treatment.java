package com.example.ragab.clinics.DataBase.RoomDB.DAO;
import java.util.List;
import ModelDB.TreatmentDB;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DAO_Treatment {

    @SuppressWarnings("unchecked")
    @Insert
    void addTreatmentItems(TreatmentDB treatmentDB);

    @SuppressWarnings("unchecked")
    @Query("DELETE FROM TreatmentDB")
    void deleteTreatmentItems();

    @SuppressWarnings("unchecked")
    @Query("select * from TreatmentDB")
    List<TreatmentDB> getAllTreatmentItems();


    @SuppressWarnings("unchecked")
    @Delete
    void deleteTreatmentItems(TreatmentDB treatmentDB1);
}
