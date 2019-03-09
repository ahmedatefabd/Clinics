package com.example.ragab.clinics.Splash;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ragab.clinics.Home.HomeActivity;
import com.example.ragab.clinics.Login.LoginActivity;
import com.example.ragab.clinics.R;
import java.util.Locale;

import Util.Utils;

public class SplashActivity extends Activity {
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    public static final String PREF_NAME = "prefs";

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Local();
        StartAnimations();
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

    private void StartAnimations() {

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l = findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        anim.reset();
        ImageView iv = findViewById(R.id.logo);
        iv.clearAnimation();
        iv.startAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        try {
                            Intent i;
                            if (Utils.checkLogin(SplashActivity.this) == false){
                                i = new Intent(SplashActivity.this, LoginActivity.class);
                                finish();
                            } else {
                                i = new Intent(SplashActivity.this, HomeActivity.class);
                                finish();
                            }
                            startActivity(i);
                            finish();
                            startActivity(i);
                            finish();
                        } catch (Exception e) {
                        }
                    }
                }, 2000);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}
