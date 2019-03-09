package com.example.ragab.clinics.Login;

public interface LoginPresenter {
    void setView(LoginActivity loginView);
    int RequestLogin(String UserName, String Password);
}
