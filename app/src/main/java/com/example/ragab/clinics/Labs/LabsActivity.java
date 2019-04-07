package com.example.ragab.clinics.Labs;
import Adapters.SheetLabsAdapter;
import Model.Sheet_Labs;
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
import com.example.ragab.clinics.labs_Details.Labs_Details_Activity;

import java.util.List;
import java.util.Locale;
import static android.os.Build.VERSION_CODES.M;

public class LabsActivity extends AppCompatActivity implements LabsView{
    public static Toolbar toolbar;
    public static ShimmerRecyclerView shimmerRecyclerView;
    private SheetLabsAdapter adapter;
    private LabsPresenter labsPresenter;
    private ImageView imgbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_labs);
        labsPresenter = new LabsPresenterImp();
        labsPresenter.setView(this);
        ShimmerRecycler();

        Local();
        controlToolbar();
        if (Build.VERSION.SDK_INT >= M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.booking));
        }
//        recycler();
        if(NetworkChangeReceiver.isNetworkAvailable(this)) {
//            LoadData();
            labsPresenter.getSheetLabs();
        }else {
            errorMessage();
            LoadDataOfflineRoom();
        }
    }


    private void LoadData() {
        labsPresenter.getSheetLabs();
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

        shimmerRecyclerView = findViewById(R.id.recyclerLabsDown);
        shimmerRecyclerView.showShimmerAdapter();
        shimmerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        shimmerRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void controlToolbar() {
        toolbar = findViewById(R.id.labsDown_Toolbar);
        imgbar = findViewById(R.id.imgbar_labsDown);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.booking));
        getSupportActionBar().setTitle("");

        imgbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabsActivity.this, HomeActivity.class));
                Animatoo.animateSlideUp(LabsActivity.this);
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
        startActivity(new Intent(LabsActivity.this, HomeActivity.class));
        Animatoo.animateSlideDown(LabsActivity.this);
        finish();
    }

    @Override
    public void setSheet_labs(List<Sheet_Labs> sheet_labs) {

        adapter = new SheetLabsAdapter (this,  sheet_labs);
        if (sheet_labs.size() > 0) {
            shimmerRecyclerView.setAdapter(adapter);
        } else {
            error();
        }

    }

    @Override
    public void error() {
        try {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("عفواًً")
                    .setContentText("لا توجد أى تحاليل سابقة")
                    .setConfirmText("تم")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            Toast.makeText(this, "لا توجد أى تحاليل سابقة ..", Toast.LENGTH_SHORT).show();
        }
    }
}