package com.example.ragab.clinics.oldRequest;
import java.util.List;
import Model.BookingAll_Items;
import ModelDB.BookingAll_ItemsDB;

public interface oldRequestView {
    void setBookingRequestsHistoryList(List<BookingAll_Items> bookingAll_items);
    void recyclerOfflineRoom(List<BookingAll_ItemsDB> bookingAllItemsDBS);
    void LoadDataOfflineRoom();
    void LoadData();
    void error();
    void controlToolbar();
    void Local();
    void ShimmerRecycler();
    void errorMessage();
    void control();
}
