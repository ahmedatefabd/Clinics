package com.example.ragab.clinics.oldRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import APIClient.ApiInterface;
import APIClient.ServicesConnection;
import Model.BookingAll_Items;
import Model.ResponseBookingItem;
import ModelDB.BookingAll_ItemsDB;
import Util.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.ragab.clinics.oldRequest.oldRequestActivity.roomDataBase;

public class oldRequestPresentImp implements oldRequestPresenter, ApiInterface {
    oldRequestView oldRequestView;
    List<BookingAll_Items> bookingAll_items = new ArrayList<>();

    @Override
    public Call<String> login(String body, String content_type) {
        return null;
    }

    @Override
    public Call<ResponseBookingItem> getBookingHistory(Map<String, String> queryParameters) {
        Call<ResponseBookingItem> QueryCall = ServicesConnection.GetService().getBookingHistory(queryParameters);
        QueryCall.enqueue(new Callback<ResponseBookingItem>() {
            @Override
            public void onResponse(Call<ResponseBookingItem> call, Response<ResponseBookingItem> response) {
                List<BookingAll_Items> bookingAll_items = response.body().getItems();
                if (response.isSuccessful()) {
                    roomDataBase.oper().deleteBookingItems();
                    for (int i = 0; i < bookingAll_items.size(); i++) {
                        //SingleTon
                        BookingAll_ItemsDB bookingAllItemsDB =
                                BookingAll_ItemsDB.getInstance(bookingAll_items.get(i).getId()
                                        , bookingAll_items.get(i).getBranchId()
                                        ,bookingAll_items.get(i).getAppointmentDate()
                                        ,bookingAll_items.get(i).getCost()
                                        ,bookingAll_items.get(i).getStatusId()
                                        ,bookingAll_items.get(i).getTypeId());

                        bookingAllItemsDB.setId(bookingAll_items.get(i).getId());
                        bookingAllItemsDB.setBranchId(bookingAll_items.get(i).getBranchId());
                        bookingAllItemsDB.setAppointmentDate(bookingAll_items.get(i).getAppointmentDate());
                        bookingAllItemsDB.setCost(bookingAll_items.get(i).getCost());
                        bookingAllItemsDB.setStatusId(bookingAll_items.get(i).getStatusId());
                        bookingAllItemsDB.setTypeId(bookingAll_items.get(i).getTypeId());

                        roomDataBase.oper().addBookingItems(bookingAllItemsDB);
                    }
                    oldRequestActivity.shimmerRecyclerView.hideShimmerAdapter();
                    oldRequestView.setBookingRequestsHistoryList(bookingAll_items);
                }
            }
            @Override
            public void onFailure(Call<ResponseBookingItem> call, Throwable t) {
                System.out.print(toString());
            }
        });
        return null;
    }

    @Override
    public void setView(oldRequestView oldRequestView) {
        this.oldRequestView = oldRequestView;
    }

    @Override
    public void getBookingHistory() {
        Map<String,String> map = new HashMap<>();
        map.put(Constant.Api.TOKEN_NAME , Constant.Api.TOKEN_VALUE);
        getBookingHistory(map);
    }
}
