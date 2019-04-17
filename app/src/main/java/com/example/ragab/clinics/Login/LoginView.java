package com.example.ragab.clinics.Login;

public interface LoginView {
    void showUserNameError(int resId);
    void showPasswordError(int resId);
    void showLoader();
    String edEmail();
    String edPassword();
    void showalert(String Message);
    void RefreshHome();
}
