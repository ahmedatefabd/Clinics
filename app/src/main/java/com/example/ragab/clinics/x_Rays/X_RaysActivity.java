package com.example.ragab.clinics.x_Rays;
import Adapters.SheetXRayAdapter;
import Model.Sheet_XRays;
import Util.NetworkChangeReceiver;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.pedant.SweetAlert.SweetAlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.ragab.clinics.Home.HomeActivity;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.x_Rays_Details.X_Rays_Details_Activity;

import java.util.List;
import java.util.Locale;
import static android.os.Build.VERSION_CODES.M;

public class X_RaysActivity extends AppCompatActivity implements X_RayView {
    public static Toolbar toolbar;
    public static ShimmerRecyclerView shimmerRecyclerView;
    private SheetXRayAdapter adapter;
    private X_RayPresenter xRayPresenter;
    private ImageView imgbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_x__rays);
        xRayPresenter = new X_RayImp();
        xRayPresenter.setView(this);
        ShimmerRecycler();

        Local();
        controlToolbar();
        if (Build.VERSION.SDK_INT >= M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.booking));
        }
//        recycler();

        if(NetworkChangeReceiver.isNetworkAvailable(this)) {
//            LoadData();
            xRayPresenter.getSheetXRays();
        }else {
            errorMessage();
            LoadDataOfflineRoom();
        }
    }

    private void LoadData() {
        xRayPresenter.getSheetXRays();
    }

    private void errorMessage() {
        try {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("عفواًً")
                    .setContentText("لا يــوجد أى اتصال بالانترنت")
                    .setConfirmText("تم")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            Toast.makeText(this, "لا يــوجد أى اتصال بالانترنت ..", Toast.LENGTH_SHORT).show();
        }
    }

    private void LoadDataOfflineRoom() {
    }

    private void ShimmerRecycler() {
        shimmerRecyclerView = findViewById(R.id.recyclerXrayDown);
        shimmerRecyclerView.showShimmerAdapter();
        shimmerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        shimmerRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    private void controlToolbar() {
        toolbar = findViewById(R.id.XRayDown_Toolbar);
        imgbar = findViewById(R.id.imgbar_xray);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.booking));
        getSupportActionBar().setTitle("");

        imgbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(X_RaysActivity.this, HomeActivity.class));
                Animatoo.animateSlideDown(X_RaysActivity.this);
                finish();
            }
        });
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

    @Override
    public void onBackPressed() {
        startActivity(new Intent(X_RaysActivity.this, HomeActivity.class));
        Animatoo.animateSlideDown(X_RaysActivity.this);
        finish();
    }

    @Override
    public void error() {
        try {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("عفواًً")
                    .setContentText("لا توجد أى اشاعات سابقة")
                    .setConfirmText("تم")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            Toast.makeText(this, "لا توجد أى اشاعات سابقة ..", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setSheet_XRays(List<Sheet_XRays> sheetXRays) {

        adapter = new SheetXRayAdapter(this,  sheetXRays);
        if (sheetXRays.size() > 0) {
            shimmerRecyclerView.setAdapter(adapter);
        } else {
            error();
        }
    }
}