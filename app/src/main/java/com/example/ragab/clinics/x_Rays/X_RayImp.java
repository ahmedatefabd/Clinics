package com.example.ragab.clinics.x_Rays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import APIClient.ApiInterface;
import APIClient.ServicesConnection;
import Model.ResponseBookingItem;
import Model.Response_Labs;
import Model.Response_Sheet_Treatment;
import Model.Response_XRay;
import Model.Sheet_XRays;
import Util.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class X_RayImp implements X_RayPresenter, ApiInterface {
    X_RayView xX_rayView;

    @Override
    public void setView(X_RayView x_rayView) {
       this.xX_rayView = x_rayView;
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
    public void getSheetXRays() {
        Map<String,String> map = new HashMap<>();
        map.put(Constant.Api.TOKEN_NAME_GENERAL , Constant.Api.TOKEN_VALUE_GENERAL);
        getSheetX_Ray(map);
    }

    @Override
    public Call<Response_XRay> getSheetX_Ray(Map<String, String> queryParameters) {
        Call<Response_XRay> QueryCall = ServicesConnection.GetService().getSheetX_Ray(queryParameters);
        QueryCall.enqueue(new Callback<Response_XRay>() {
            @Override
            public void onResponse(Call<Response_XRay> call, Response<Response_XRay> response) {

                List<Sheet_XRays> sheet_xRays = response.body().getSheet_xRaysList();
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

                    X_RaysActivity.shimmerRecyclerView.hideShimmerAdapter();
                    xX_rayView.setSheet_XRays(sheet_xRays);
                }
            }

            @Override
            public void onFailure(Call<Response_XRay> call, Throwable t) {
                System.out.print(toString());
            }
        });

        return null;
    }

    @Override
    public Call<Response_Labs> getSheetLabs(Map<String, String> queryParameters) {
        return null;
    }

}
