package com.example.ragab.clinics.sheet_Treatment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import APIClient.ApiInterface;
import APIClient.ServicesConnection;
import Model.ResponseBookingItem;
import Model.Response_Labs;
import Model.Response_Sheet_Treatment;
import Model.Response_XRay;
import Model.Sheet_Treatment;
import Util.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sheet_TreatmentImp implements sheet_TreatmentPresenter, ApiInterface {

    sheet_TreatmentView sheetTreatmentView;

    @Override
    public void setView(sheet_TreatmentView sheetTreatmentView) {
        this.sheetTreatmentView = sheetTreatmentView;
    }

    @Override
    public void getSheetTreatment() {

        Map<String,String> map = new HashMap<>();
        map.put(Constant.Api.TOKEN_NAME_GENERAL , Constant.Api.TOKEN_VALUE_GENERAL);
        getSheetTreatment(map);

    }

    @Override
    public Call<String> login(String body, String content_type) {
        return null;
    }

    @Override
    public Call<ResponseBookingItem> getBookingHistory(Map<String, String> queryParameters) {
        return null;
    }

    @Override
    public Call<Response_Sheet_Treatment> getSheetTreatment(Map<String, String> queryParameters) {

        Call<Response_Sheet_Treatment> QueryCall = ServicesConnection.GetService().getSheetTreatment(queryParameters);

        QueryCall.enqueue(new Callback<Response_Sheet_Treatment>() {
            @Override
            public void onResponse(Call<Response_Sheet_Treatment> call, Response<Response_Sheet_Treatment> response) {
                List<Sheet_Treatment> sheetTreatmentList = response.body().getSheet_treatmentList();
                if (response.isSuccessful()) {
//                    roomDataBase.oper().deleteBookingItems();
//                    for (int i = 0; i < bookingAll_items.size(); i++) {
//                        //SingleTon
//                        BookingAll_ItemsDB bookingAllItemsDB =
//                                BookingAll_ItemsDB.getInstance(bookingAll_items.get(i).getId()
//                                        , bookingAll_items.get(i).getBranchId()
//                                        ,bookingAll_items.get(i).getAppointmentDate()
//                                        ,bookingAll_items.get(i).getCost()
//                                        ,bookingAll_items.get(i).getStatusId()
//                                        ,bookingAll_items.get(i).getTypeId());
//
//                        bookingAllItemsDB.setId(bookingAll_items.get(i).getId());
//                        bookingAllItemsDB.setBranchId(bookingAll_items.get(i).getBranchId());
//                        bookingAllItemsDB.setAppointmentDate(bookingAll_items.get(i).getAppointmentDate());
//                        bookingAllItemsDB.setCost(bookingAll_items.get(i).getCost());
//                        bookingAllItemsDB.setStatusId(bookingAll_items.get(i).getStatusId());
//                        bookingAllItemsDB.setTypeId(bookingAll_items.get(i).getTypeId());
//
//                        roomDataBase.oper().addBookingItems(bookingAllItemsDB);
//                    }
                    sheet_TreatmentActivity.shimmerRecyclerView.hideShimmerAdapter();
                    sheetTreatmentView.setSheet_treatmentList(sheetTreatmentList);
                }
            }
            @Override
            public void onFailure(Call<Response_Sheet_Treatment> call, Throwable t) {
                System.out.print(toString());
            }
        });

        return null;
    }

    @Override
    public Call<Response_XRay> getSheetX_Ray(Map<String, String> queryParameters) {
        return null;
    }

    @Override
    public Call<Response_Labs> getSheetLabs(Map<String, String> queryParameters) {
        return null;
    }
}