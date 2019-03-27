package com.example.ragab.clinics.Login;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.ragab.clinics.Home.HomeActivity;
import com.example.ragab.clinics.R;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.taishi.flipprogressdialog.FlipProgressDialog;
import java.util.Locale;
import Util.Utils;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class LoginActivity extends AppCompatActivity implements LoginView{
    private Button LogBtn;
    public static EditText usernameET, passwordET;
    LoginPresenterImp loginPresenter;
    FlipProgressDialog progressDialog;
    private String email, password;
    public static SharedPreferences sharedPreferences ;
    public static SharedPreferences.Editor editor;
    public static final String PREF_NAME = "prefs";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASS = "password";
    private static long back_pressed;
    private static final int TIME_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameET = findViewById(R.id.username);
        passwordET = findViewById(R.id.paasword);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final Locale locale = new Locale("en");
        final Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLayoutDirection(locale);
        }
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Skip_Login();
        LogBtn = findViewById(R.id.LogBtn);
        loginPresenter = new LoginPresenterImp();
        loginPresenter.setView(this);
        progressDialog = new FlipProgressDialog();
        
        LogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress();
                email = usernameET.getText().toString().trim();
                password = passwordET.getText().toString().trim();
                if (!edEmail().isEmpty() && !edPassword().isEmpty()) {
                    editor.putString(KEY_USERNAME, edEmail());
                    editor.putString(KEY_PASS, edPassword());
                    editor.apply();
                }
                if (CheckEmpty(email, password)) {
                    CheckInternetConnection();
                } else {
                    Toast.makeText(LoginActivity.this, "تأكد من كتابة البيانات بطريقة صحيحة", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Skip_Login() {
        String userN = sharedPreferences.getString(KEY_USERNAME, "");
        String pass = sharedPreferences.getString(KEY_PASS, "");
        if ((!userN.isEmpty() && !pass.isEmpty())) {
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }
    }

    public boolean CheckEmpty(String email, String password) {
        if (email.isEmpty()) {
            usernameET.setError("الإيميل لا يمكن أن يكون فارغاً");
            return false;
        }else if (password.isEmpty()) {
            passwordET.setError("كلمة  المرور لا يمكن أن تكون فارغاً");
            return false;
        }else {
            return true;
        }
    }

    private void CheckInternetConnection() {
        if (Utils.isInternetOn(LoginActivity.this)) {
            try {
                loginPresenter.RequestLogin(email, password);
            } catch (NumberFormatException e) {
                Log.w("NumberException", e.getMessage());
                passwordET.setError("تأكد من ادخال القيمة بطريقة صحيحةً");
            }
        } else {
            showErrorMessage("من فضلك تأكد من الإتصال بالإنترنت");
        }
    }

    private void showErrorMessage(String message) {
        try {
            new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("خطأ")
                    .setContentText(message)
                    .setConfirmText("تم")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void progress(){
        KProgressHUD.create(LoginActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();
    }

    @Override
    public void showUserNameError(int resId) {
        usernameET.setError(getString(resId));
    }

    @Override
    public void showPasswordError(int resId) {
        passwordET.setError(getString(resId));
    }

    @Override
    public void showLoader() {
    }
    @Override
    public String edEmail() {
        return usernameET.getText().toString();
    }

    @Override
    public String edPassword() {
        return passwordET.getText().toString();
    }

    @Override
    public void showalert(String Message) {
        try {
            new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("خطأ")
                    .setContentText(Message)
                    .setConfirmText("تم")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            Toast.makeText(this, Message , Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void RefreshHome() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        finish();
        Utils.makeAlertToast(getApplicationContext(), ("\uD83D\uDC49") + "  " + "   " + "  " + "يمكنك تغيير الخدمة من هنا", 3000);
    }

    @Override
    public void onBackPressed() {
        if(back_pressed + TIME_DELAY > System.currentTimeMillis()){
            Intent exit = new Intent(Intent.ACTION_MAIN);
            exit.addCategory(Intent.CATEGORY_HOME);
            exit.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(exit);
            finish();
            System.exit(0);
        }else {
            Utils.makeToast(getApplicationContext(), "للخروج من التطبيق اضغط مرة أخرى ", 3000);
        }
        back_pressed = System.currentTimeMillis();
    }
}
