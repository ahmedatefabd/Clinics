package com.example.ragab.clinics.newRequest;
import android.util.Log;
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
import static com.example.ragab.clinics.newRequest.newRequestActivity.PatientName;
import static com.example.ragab.clinics.newRequest.newRequestActivity.patientDetails;

public class newRequestImp implements newRequestPresenter, ApiInterface {

    newRequestActivity newRequestActivity1;
    int ResponseCode = -1;

    @Override
    public void setView(newRequestActivity newRequestView) {
        this.newRequestActivity1 = newRequestView;
    }

    @Override
    public int RequestBooking(String p_branch_name, String p_patient_id, String p_appointment_date, String p_complaint_type, String p_clinic_id) {

        String RegRequestBody = "{";


        if (p_branch_name.equals("")) {
            RegRequestBody += "\"P_BRANCH_NAME\":null ,";
        } else
            RegRequestBody += "\"P_BRANCH_NAME\":\"" + p_branch_name + "\" ,";


        if (p_patient_id.equals("")) {
            RegRequestBody += "\"P_PATIENT_ID\":null ,";
        } else
            RegRequestBody += "\"P_PATIENT_ID\":\"" + p_patient_id + "\" ,";


        if (p_appointment_date.equals("")) {
            RegRequestBody += "\"P_aPPOINTMENT\":null ,";
        } else
            RegRequestBody += "\"P_aPPOINTMENT\":\"" + p_appointment_date + "\" ,";


        if (p_complaint_type.equals("")) {
            RegRequestBody += "\"P_COMPLAINT_TYPE\":null ,";
        } else
            RegRequestBody += "\"P_COMPLAINT_TYPE\":\"" + p_complaint_type + "\" ,";


        if (p_clinic_id.equals("")) {
            RegRequestBody += "\"P_CLINIC_ID\":null ,";
        } else
            RegRequestBody += "\"P_CLINIC_ID\":\"" + p_clinic_id + "\"";


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
                                new SweetAlertDialog(newRequestActivity1, SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("خطأ")
                                        .setContentText("فشلت العملية")
                                        .setConfirmText("تم")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sDialog) {
                                                sDialog.dismiss();
                                            }
                                        }).show();
                            }
                        } else {
                            new SweetAlertDialog(newRequestActivity1, SweetAlertDialog.SUCCESS_TYPE)
                                    .setTitleText("شكراًً")
                                    .setContentText("تم تلقى طلبكم وسيتم التواصل معكم قريبا")
                                    .setConfirmText("تم")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            sDialog.dismiss();
                                            PatientName.setText(null);
                                            patientDetails.setText(null);
                                        }
                                    })
                                    .show();
                        }
                    } catch (JSONException e) {
                        newRequestActivity1.showalert("حدث خطأ في الاتصال , من فضلك أعد المحاولة");
                    }
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.print(toString());
                newRequestActivity1.showalert("حدث خطأ في الاتصال , من فضلك أعد المحاولة وتأكد من الاتصال بالانترنت");
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
