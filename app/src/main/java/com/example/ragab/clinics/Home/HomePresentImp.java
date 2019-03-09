package com.example.ragab.clinics.Home;
import java.util.Map;

import APIClient.ApiInterface;
import Model.ResponseBookingItem;
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
}
