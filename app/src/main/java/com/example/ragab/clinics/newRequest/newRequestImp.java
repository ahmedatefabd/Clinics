package com.example.ragab.clinics.newRequest;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ragab.clinics.Home.HomeActivity;
import com.kaopiz.kprogresshud.KProgressHUD;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.Map;
import APIClient.ApiInterface;
import APIClient.ServicesConnection;
import Model.ResponseBookingItem;
import Model.Response_Labs;
import Model.Response_Sheet_Treatment;
import Model.Response_XRay;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import static com.example.ragab.clinics.newRequest.newRequestActivity.PatientName;
import static com.example.ragab.clinics.newRequest.newRequestActivity.patientDetails;
import static com.example.ragab.clinics.newRequest.newRequestActivity.progressBar;

public class newRequestImp implements newRequestPresenter, ApiInterface {
    newRequestActivity newRequestActivity1;
    int ResponseCode = -1;

    @Override
    public void setView(newRequestActivity newRequestView) {
        this.newRequestActivity1 = newRequestView;
    }

    @Override
//    public int RequestBooking(String p_branch_name, String p_patient_id, String p_appointment_date, String p_complaint_type, String p_clinic_id) {
    public int RequestBooking(String p_patient_id, String p_appointment_date, String p_complaint_type, String p_clinic_id) {

        String RegRequestBody = "{";


//        if (p_branch_name.equals("")) {
//            RegRequestBody += "\"P_BRANCH_NAME\":null ,";
//        } else
//            RegRequestBody += "\"P_BRANCH_NAME\":\"" + p_branch_name + "\" ,";


        if (p_patient_id.equals("")) {
            RegRequestBody += "\"p_patient_id\":null ,";
        } else
            RegRequestBody += "\"p_patient_id\":\"" + p_patient_id + "\" ,";


        if (p_appointment_date.equals("")) {
            RegRequestBody += "\"p_appointment_date\":null ,";
        } else
            RegRequestBody += "\"p_appointment_date\":\"" + p_appointment_date + "\" ,";


        if (p_complaint_type.equals("")) {
            RegRequestBody += "\"p_complaint_type\":null ,";
        } else
            RegRequestBody += "\"p_complaint_type\":\"" + p_complaint_type + "\" ,";


        if (p_clinic_id.equals("")) {
            RegRequestBody += "\"p_clinic_id\":null ,";
        } else
            RegRequestBody += "\"p_clinic_id\":\"" + p_clinic_id + "\"";


        RegRequestBody += "}";

        Log.w("Booking", RegRequestBody);
        Booking( RegRequestBody, ServicesConnection.CONTENT_TYPE);
        return 0;
    }

    @Override
    public Call<String> Booking(String body, String content_type) {
        Call<String> QueryCall = ServicesConnection.GetService().Booking(body.toString(), ServicesConnection.CONTENT_TYPE);
        Log.w("content", ServicesConnection.CONTENT_TYPE);
        QueryCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String Body = response.body();
                Log.w("response", Body + "");
                if (response.isSuccessful()) {
                    try {
                        JSONObject responCodeObj = new JSONObject(Body);
                        ResponseCode = responCodeObj.getInt("RESULT");
                        if (ResponseCode < 0) {
                            if (ResponseCode < 0) {
                                newRequestActivity1.progressBar.setVisibility(View.GONE);
                                new SweetAlertDialog(newRequestActivity1, SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("خطأ")
                                        .setContentText("فشلت العملية")
                                        .setConfirmText("تم")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sDialog) {
                                                sDialog.dismiss();
                                                newRequestActivity1.progressBar.setVisibility(View.GONE);
                                            }
                                        }).show();
                            }
                        } else {
                            newRequestActivity1.progressBar.setVisibility(View.GONE);
                            new SweetAlertDialog(newRequestActivity1, SweetAlertDialog.SUCCESS_TYPE)
                                    .setTitleText("شكراًً")
                                    .setContentText("تم تلقى طلبكم وسيتم التواصل معكم قريبا")
                                    .setConfirmText("تم")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            sDialog.dismiss();
                                            newRequestActivity1.progressBar.setVisibility(View.GONE);
                                            patientDetails.setText(null);
                                            newRequestActivity1.startActivity(new Intent(newRequestActivity1, HomeActivity.class));
                                            Animatoo.animateSlideDown(newRequestActivity1);
                                            newRequestActivity1.finish();
                                        }
                                    })
                                    .show();

                        }
                    } catch (JSONException e) {
                        newRequestActivity1.showalert("حدث خطأ في الاتصال , من فضلك أعد المحاولة");
                        newRequestActivity1.progressBar.setVisibility(View.GONE);
                    }
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.print(toString());
                newRequestActivity1.showalert("حدث خطأ في الاتصال , من فضلك أعد المحاولة وتأكد من الاتصال بالانترنت");
                newRequestActivity1.progressBar.setVisibility(View.GONE);
            }
        });
        return null;
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
    public Call<Response_Labs> getSheetLabs(Map<String, String> queryParameters) {
        return null;
    }
}
