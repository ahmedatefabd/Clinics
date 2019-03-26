package com.example.ragab.clinics.DataBase.RoomDB;
import java.util.List;
import ModelDB.BookingAll_ItemsDB;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DAO {

    @SuppressWarnings("unchecked")
    @Insert
     void addBookingItems(BookingAll_ItemsDB bookingAllItemsDB);

    @SuppressWarnings("unchecked")
    @Query("DELETE FROM BookingItems")
     void deleteBookingItems();

    @SuppressWarnings("unchecked")
    @Query("select * from BookingItems")
    List<BookingAll_ItemsDB> getAllBookingItems();


    @SuppressWarnings("unchecked")
    @Delete
     void deleteBookingItems(BookingAll_ItemsDB postModel_room);
}
