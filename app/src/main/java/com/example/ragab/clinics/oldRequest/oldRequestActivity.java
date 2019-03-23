package com.example.ragab.clinics.oldRequest;
import Adapters.OldRequestAdapter;
import Model.BookingAll_Items;
import Util.RoundedTransformation;
import Util.Utils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.pedant.SweetAlert.SweetAlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.ragab.clinics.Home.HomeActivity;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.medical_Prescreption.medicalPrescreptionActivity;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;
import static android.os.Build.VERSION_CODES.M;

public class oldRequestActivity extends AppCompatActivity implements oldRequestView{
    public static Toolbar toolbar;
    public static ShimmerRecyclerView shimmerRecyclerView;
    private RecyclerView recyclerView;
    private ImageView oldReqImg;
    private OldRequestAdapter adapter;
    oldRequestPresenter oldRequestPresenter;
    private ImageView imgbarOldRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_old_request);
        recyclerView = findViewById(R.id.recyclerOldRequest);
        oldReqImg = findViewById(R.id.oldReqImg);
        imgbarOldRequest = findViewById(R.id.imgbarOldRequest);

        imgbarOldRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(oldRequestActivity.this, HomeActivity.class));
                Animatoo.animateSlideUp(oldRequestActivity.this);
                finish();
            }
        });

        Picasso.get()
                .load(R.drawable.book5)
                .transform(new RoundedTransformation())
                .resize(500, 500)
                .into(oldReqImg);
        Local();
        controlToolbar();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (Build.VERSION.SDK_INT >= M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.booking));
        }
        oldRequestPresenter = new oldRequestPresentImp();
        oldRequestPresenter.setView(this);
        ShimmerRecycler();
        if(Utils.isInternetOn(this)) {
            oldRequestPresenter.getBookingHistory();
        }else {
            errorMessage();
        }
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

    private void ShimmerRecycler() {
        shimmerRecyclerView = findViewById(R.id.recyclerOldRequest);
        shimmerRecyclerView.showShimmerAdapter();
        shimmerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        shimmerRecyclerView.setItemAnimator(new DefaultItemAnimator());
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
        toolbar = findViewById(R.id.oldreq_Toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.booking));
        getSupportActionBar().setTitle("");
    }

    @Override
    public void setBookingRequestsHistoryList(List<BookingAll_Items> bookingAll_items) {
        adapter = new OldRequestAdapter(this,  bookingAll_items);
        if (bookingAll_items.size() > 0) {
            shimmerRecyclerView.setAdapter(adapter);
        } else {
            error();
        }
    }

    private void error() {
        shimmerRecyclerView.hideShimmerAdapter();
        try {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("عفواًً")
                    .setContentText("لا توجد أى طلبات سابقة")
                    .setConfirmText("تم")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            Toast.makeText(this, "لا توجد أى طلبات سابقة ..", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(oldRequestActivity.this, HomeActivity.class));
        Animatoo.animateSlideUp(oldRequestActivity.this);
        finish();
    }
}