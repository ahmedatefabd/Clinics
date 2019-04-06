package com.example.ragab.clinics.Labs;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import APIClient.ApiInterface;
import APIClient.ServicesConnection;
import Model.ResponseBookingItem;
import Model.Response_Labs;
import Model.Response_Sheet_Treatment;
import Model.Response_XRay;
import Model.Sheet_Labs;
import Util.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LabsPresenterImp implements LabsPresenter, ApiInterface {

    LabsView lLabsView;

    @Override
    public void setView(LabsView labsView) {
        this.lLabsView = labsView;
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
        return null;
    }

    @Override
    public Call<Response_XRay> getSheetX_Ray(Map<String, String> queryParameters) {
        return null;
    }

    @Override
    public void getSheetLabs() {
        Map<String,String> map = new HashMap<>();
        map.put(Constant.Api.TOKEN_NAME_GENERAL , Constant.Api.TOKEN_VALUE_GENERAL);
        getSheetLabs(map);
    }

    @Override
    public Call<Response_Labs> getSheetLabs(Map<String, String> queryParameters) {

        Call<Response_Labs> QueryCall = ServicesConnection.GetService().getSheetLabs(queryParameters);

        QueryCall.enqueue(new Callback<Response_Labs>() {
            @Override
            public void onResponse(Call<Response_Labs> call, Response<Response_Labs> response) {
                List<Sheet_Labs> sheetLabs = response.body().getSheet_labsList();
                if (response.isSuccessful()){
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

                    LabsActivity.shimmerRecyclerView.hideShimmerAdapter();
                    lLabsView.setSheet_labs(sheetLabs);
                }
            }

            @Override
            public void onFailure(Call<Response_Labs> call, Throwable t) {
                System.out.print(toString());
            }
        });

        return null;
    }

}