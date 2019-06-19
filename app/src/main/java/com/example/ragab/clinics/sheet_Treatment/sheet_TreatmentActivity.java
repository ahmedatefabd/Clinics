package com.example.ragab.clinics.sheet_Treatment;
import Adapters.SheetTreatmentAdapter;
import Model.Sheet_Treatment;
import Util.NetworkChangeReceiver;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
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
import com.example.ragab.clinics.DataBase.RoomDB.RoomBD_Abstract.RoomDataBase_TreatmentDB;
import com.example.ragab.clinics.Home.HomeActivity;
import com.example.ragab.clinics.R;
import java.util.List;
import java.util.Locale;
import static android.os.Build.VERSION_CODES.M;

public class sheet_TreatmentActivity extends AppCompatActivity implements sheet_TreatmentView {
    private SheetTreatmentAdapter adapter;
    private RecyclerView recyclerView;
    public static ShimmerRecyclerView shimmerRecyclerView;
    public static Toolbar toolbar;
    public sheet_TreatmentPresenter sheet_treatmentPresenter;
    private ImageView imgbarPrescreption;
    public static RoomDataBase_TreatmentDB roomDataBaseSheet_Treatment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_medical_prescreption);
        imgbarPrescreption = findViewById(R.id.imgbarPrescreption);
        sheet_treatmentPresenter = new sheet_TreatmentImp();
        sheet_treatmentPresenter.setView(this);
        ShimmerRecycler();
        roomDataBaseSheet_Treatment = Room.databaseBuilder(getApplicationContext(), RoomDataBase_TreatmentDB.class, "postsdb").allowMainThreadQueries().build();
        Local();
        controlToolbar();
        if (Build.VERSION.SDK_INT >= M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.booking));
        }
        if(NetworkChangeReceiver.isNetworkAvailable(this)) {
            sheet_treatmentPresenter.getSheetTreatment();
        }else {
            errorMessage();
            LoadDataOfflineRoom();
        }

        imgbarPrescreption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sheet_TreatmentActivity.this, HomeActivity.class));
                Animatoo.animateSlideUp(sheet_TreatmentActivity.this);
                finish();
            }
        });
    }

    private void LoadData() {
        sheet_treatmentPresenter.getSheetTreatment();
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
        shimmerRecyclerView = findViewById(R.id.shimmerRecyclerSheetTreatment);
        shimmerRecyclerView.showShimmerAdapter();
        shimmerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        shimmerRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void controlToolbar() {
        toolbar = findViewById(R.id.sheetTreatment_Toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.booking));
        getSupportActionBar().setTitle("");
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
        startActivity(new Intent(sheet_TreatmentActivity.this, HomeActivity.class));
        Animatoo.animateSlideDown(sheet_TreatmentActivity.this);
        finish();
    }

    @Override
    public void error() {
        try {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("عفواًً")
                    .setContentText("لا توجد أى روشتات سابقة")
                    .setConfirmText("تم")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            Toast.makeText(this, "لا توجد أى روشتات سابقة ..", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setSheet_treatmentList(List<Sheet_Treatment> sheet_treatmentList) {

        adapter = new SheetTreatmentAdapter (this,  sheet_treatmentList, roomDataBaseSheet_Treatment);
        if (sheet_treatmentList.size() > 0) {
            shimmerRecyclerView.setAdapter(adapter);
        } else {
            error();
        }
    }
}