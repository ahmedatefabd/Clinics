package com.example.ragab.clinics.Home;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ragab.clinics.Labs.LabsActivity;
import com.example.ragab.clinics.Login.LoginActivity;
import com.example.ragab.clinics.contact.ContactActivity;
import com.example.ragab.clinics.sheet_Treatment.sheet_TreatmentActivity;
import com.example.ragab.clinics.newRequest.newRequestActivity;
import com.example.ragab.clinics.oldRequest.oldRequestActivity;
import com.example.ragab.clinics.x_Rays.X_RaysActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import com.example.ragab.clinics.ProfileFragment;
import com.example.ragab.clinics.R;
import java.util.Locale;
import Util.Utils;
import cn.pedant.SweetAlert.SweetAlertDialog;
import ru.whalemare.sheetmenu.SheetMenu;
import static android.os.Build.VERSION_CODES.M;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, HomeView {
    public static Toolbar toolbar;
    public static TextView toolbar_title;
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;
    public static SharedPreferences sharedPreferences ;
    public static SharedPreferences.Editor editor;
    public static final String PREF_NAME = "prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        Local();
        controlToolbar();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        loadingFragment(new HomeFragment_Work());
        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        if (Build.VERSION.SDK_INT >= M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.booking));
        }
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private void Local() {
        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        String en = Locale.getDefault().getDisplayLanguage();
        Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLayoutDirection(locale);
        }
    }

    private void controlToolbar() {
        toolbar = findViewById(R.id.Home_Toolbar);
        toolbar_title = findViewById(R.id.toolbar_title);
        toolbar.setBackgroundColor(getResources().getColor(R.color.booking));
        toolbar_title.setText("العيادة");
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
            Utils.makeToast(getApplicationContext(), "للخروج من التطبيق اضغط مرة  أخرى ", 3000);
        }
        back_pressed = System.currentTimeMillis();
    }

    @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        final Fragment[] fragment = {new Fragment()};
            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    toolbar_title.setText("العيادة");
//                    fragment[0] = new HomeFragment_Work();
//                    loadingFragment(fragment[0]);
//                    Animatoo.animateZoom(HomeActivity.this);
//                    return true;
                case R.id.navigation_profile:
                    toolbar_title.setText("الشخصية");
                    fragment[0] = new ProfileFragment();
                    loadingFragment(fragment[0]);
                    return true;
                case R.id.navigation_logout:
                    logoutMessage();
                    return true;
                case R.id.navigation_menu:
                    toolbar_title.setText("العيادة");
                    fragment[0] = new HomeFragment_Work();
                    loadingFragment(fragment[0]);
                    Animatoo.animateZoom(HomeActivity.this);
                    SheetMenu.with(this)
                            .setMenu(R.menu.menu)
                            .setAutoCancel(true)
                            .setClick(new MenuItem.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem item) {
                                    switch (item.getItemId()) {
                                        case R.id.home:
                                            fragment[0] = new HomeFragment_Work();
                                            loadingFragment(fragment[0]);
                                            break;
                                        case R.id.reportMenu:
                                            startActivity(new Intent(HomeActivity.this, sheet_TreatmentActivity.class));
                                            Animatoo.animateZoom(HomeActivity.this);
                                            break;
                                        case R.id.xRayMenu:
                                            startActivity(new Intent(HomeActivity.this, X_RaysActivity.class));
                                            Animatoo.animateZoom(HomeActivity.this);
                                            break;
                                        case R.id.labsMenu:
                                            startActivity(new Intent(HomeActivity.this, LabsActivity.class));
                                            Animatoo.animateZoom(HomeActivity.this);
                                            break;
                                        case R.id.contactmenu:
                                            startActivity(new Intent(HomeActivity.this, ContactActivity.class));
                                            Animatoo.animateZoom(HomeActivity.this);
                                            break;
                                        case R.id.newReqMenu:
                                            startActivity(new Intent(HomeActivity.this, newRequestActivity.class));
                                            Animatoo.animateZoom(HomeActivity.this);
                                            break;
                                        case R.id.oldReqMenu:
                                            startActivity(new Intent(HomeActivity.this, oldRequestActivity.class));
                                            Animatoo.animateZoom(HomeActivity.this);
                                            break;
                                        case R.id.logout:
                                            logoutMessage();
                                            break;
                                    }
                                    return true;
                                }
                            }).show();
            } 
            return true;
        }

    private void logoutMessage() {
        new SweetAlertDialog(HomeActivity.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("هل أنت متأكد؟")
                .setContentText("أنك تريد تسجيل الخروج؟")
                .setConfirmText("خروج")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismiss();
                        editor.remove("username");
                        editor.apply();
                        editor.remove("password");
                        editor.apply();
                        editor.remove("id");
                        editor.apply();
//                        Utils.RemoveUserID(HomeActivity.this);
                        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                        finish();
                    }
                })
                .setCancelText("لا")
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }

    private void Message() {
        new SweetAlertDialog(HomeActivity.this, SweetAlertDialog.BUTTON_CONFIRM)
                .setContentText("هل أنت متأكدأنك تريد تسجيل الخروج؟")
                .setConfirmText("خروج")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismiss();
                        editor.remove("username");
                        editor.apply();
                        editor.remove("password");
                        editor.apply();
                        editor.remove("id");
                        editor.apply();
                        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                        finish();
                    }
                })
                .show();
    }
    
    private void loadingFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.message, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        RefreshHome();
    }

    public void RefreshHome() {
        Utils.makeAlertToast(getApplicationContext(), ("\uD83D\uDC49") + "  " + "   " + "  " + "يمكنك تغيير الخدمة من هنا", 3000);
    }
}