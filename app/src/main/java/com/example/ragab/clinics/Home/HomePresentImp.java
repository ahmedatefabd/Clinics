package com.example.ragab.clinics.Home;
import java.util.Map;
import APIClient.ApiInterface;
import Model.ResponseBookingItem;
import Model.Response_Labs;
import Model.Response_Sheet_Treatment;
import Model.Response_XRay;
import retrofit2.Call;

public class HomePresentImp implements HomePresenter, ApiInterface {
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
    public Call<Response_Labs> getSheetLabs(Map<String, String> queryParameters) {
        return null;
    }

    @Override
    public Call<String> Booking(String body, String content_type) {
        return null;
    }


}
