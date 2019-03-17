package com.example.ragab.clinics.Login;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.example.ragab.clinics.Home.HomeActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Map;
import APIClient.ApiInterface;
import APIClient.ServicesConnection;
import Model.ResponseBookingItem;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenterImp implements LoginPresenter, ApiInterface {

    LoginActivity loginView;
    int ResponseCode = -1;

    @Override
    public int RequestLogin(String UserName, String Password) {
        loginView.showLoader();
        String RegRequestBody = "{";
        if (UserName.equals("")) {
            RegRequestBody += "\"P_USERNAME\":null ,";
        } else
            RegRequestBody += "\"P_USERNAME\":\"" + UserName + "\" ,";
        if (Password.equals("")) {
            RegRequestBody += "\"P_PASSWORD\":null ,";
        } else
            RegRequestBody += "\"P_PASSWORD\":\"" + Password + "\"";
        RegRequestBody += "}";
        Log.w("Login", RegRequestBody);
        login( RegRequestBody, ServicesConnection.CONTENT_TYPE);
        return 0;
    }

    @Override
    public Call<String> login(String body, String content_type) {
        Call<String> QueryCall = ServicesConnection.GetService().login(body.toString(), ServicesConnection.CONTENT_TYPE);
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
                        LoginActivity.editor.putInt("id", ResponseCode);
                        LoginActivity.editor.apply();
                        if (ResponseCode < 0) {
                            if (ResponseCode < 0) {
                                new SweetAlertDialog(loginView, SweetAlertDialog.ERROR_TYPE)
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
                            Toast.makeText(loginView, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();
                            loginView.startActivity(new Intent(loginView, HomeActivity.class));
                        }
                    } catch (JSONException e) {
                        loginView.showalert("حدث خطأ في الاتصال , من فضلك أعد المحاولة");
                    }
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.print(toString());
                loginView.showalert("حدث خطأ في الاتصال , من فضلك أعد المحاولة وتأكد من الاتصال بالانترنت");
            }
        });
        return null;
    }

    @Override
    public Call<ResponseBookingItem> getBookingHistory(Map<String, String> queryParameters) {
        return null;
    }

    @Override
    public void setView(LoginActivity loginView) {
        this.loginView = loginView;
    }
}
