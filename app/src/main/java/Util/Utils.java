package Util;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.CountDownTimer;
import android.os.NetworkOnMainThreadException;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.ragab.clinics.Login.LoginActivity;
import com.example.ragab.clinics.R;

import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.Context.MODE_PRIVATE;

public class Utils {
    private static final int SHORT_TOAST_DURATION = 3000;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private final String PREF_NAME = "prefs";
    Context context;

    public Utils(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static void makeToast(Context context, String text, long durationInMillis) {
        final Toast t = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        t.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 10);
        View view = t.getView();
        view.setBackgroundColor(Color.WHITE);
        new CountDownTimer(Math.max(durationInMillis - SHORT_TOAST_DURATION, 1000), 1000) {
            @Override
            public void onFinish() {
                t.show();
            }
            @Override
            public void onTick(long millisUntilFinished) {
                t.show();
            }
        }.start();
    }

    public static void makeAlertToast(Context context, String text, long durationInMillis) {
        final Toast t = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        t.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 10);
        View view = t.getView();
        view.setBackgroundColor(Color.WHITE);
        new CountDownTimer(Math.max(durationInMillis - SHORT_TOAST_DURATION, 2000), 2000) {
            @Override
            public void onFinish() {
                t.show();
            }
            @Override
            public void onTick(long millisUntilFinished) {
                t.show();
            }
        }.start();
    }
    public static void makeAlertToastEmotions(Context context, String text, long durationInMillis) {
        final Toast t = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        t.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 10);
        View view = t.getView();
        view.setBackgroundColor(Color.BLACK);
        new CountDownTimer(Math.max(durationInMillis - SHORT_TOAST_DURATION, 1000), 1000) {
            @Override
            public void onFinish() {
                t.show();
            }
            @Override
            public void onTick(long millisUntilFinished) {
                t.show();
            }
        }.start();
    }

    public static void slide_down(Context ctx, View v) {
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
        if (a != null) {
            a.reset();
            if (v != null) {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    public static void slide_up(Context ctx, View v) {
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_up);
        if (a != null) {
            a.reset();
            if (v != null) {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    public static final boolean isInternetOn(Context context) {
            final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
            return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
        }

    public static boolean checkLogin(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(LoginActivity.PREF_NAME, MODE_PRIVATE);
        String name = prefs.getString("username", "");
        String pass = prefs.getString("password", "");
        return ((!name.isEmpty() || !pass.isEmpty()));
    }
    public static int getID(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(LoginActivity.PREF_NAME, MODE_PRIVATE);
        int id = -1;
        int restored_id = prefs.getInt("id", 0);
        if (restored_id != -1) {
            return restored_id;
        } else
            return id;
    }

    public static void RemoveUserID(Context context) {
        editor.remove("username");
        editor.apply();
        editor.remove("password");
        editor.apply();
        editor.remove("id");
        editor.apply();
    }
}


