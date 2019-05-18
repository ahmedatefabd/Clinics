package com.example.ragab.clinics.x_Rays_Details;
import Adapters.X_RaysDetailsAdapter;
import Model.Sheet_Treatment;
import Model.Sheet_XRays;
import Model.Xrays;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.pedant.SweetAlert.SweetAlertDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ragab.clinics.Labs.LabsActivity;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.labs_Details.Labs_Details_Activity;
import com.example.ragab.clinics.x_Rays.X_RaysActivity;

import java.util.ArrayList;

public class X_Rays_Details_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private X_RaysDetailsAdapter adapter;
    private TextView name_XRayDetails;
    private TextView date_XRayDetails;
    private Sheet_XRays sheet_xRays;
    private Toolbar toolbar;
    private ImageView imgbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_x__rays__details_);
        recyclerView = findViewById(R.id.recyclerXrayDedails);
        name_XRayDetails = findViewById(R.id.Name_XRayDetails);
        date_XRayDetails = findViewById(R.id.Date_XRayDetails);

        Bundle bundle = getIntent().getExtras();
        Sheet_XRays sHheetXRays = bundle.getParcelable("modelXRay");
        sheet_xRays = sHheetXRays;
        ArrayList<Xrays> xraysArrayList =bundle.getParcelableArrayList("listXray");

        if (xraysArrayList == null){
            Toast.makeText(this, "null", Toast.LENGTH_LONG).show();
        }else if (xraysArrayList.size() == 0){
            new SweetAlertDialog(X_Rays_Details_Activity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                    .setTitleText("البيانات")
                    .setContentText("لا توجد أى بيانات")
                    .setConfirmText("تم")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    })
                    .show();
        } else {
            adapter = new X_RaysDetailsAdapter(X_Rays_Details_Activity.this, xraysArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }

        name_XRayDetails.setText("الاسم:- " + sheet_xRays.getSheetName());
        date_XRayDetails.setText(sheet_xRays.getCreatedWhen());
        if (sheet_xRays.getCreatedWhen() == null){
            date_XRayDetails.setText("--/--/----");
        }else {
            date_XRayDetails.setText(sheet_xRays.getCreatedWhen());
        }

        toolbar = findViewById(R.id.XRay_Details_Toolbar);
        imgbar = findViewById(R.id.imgbar_XRay_Details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        imgbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(X_Rays_Details_Activity.this, X_RaysActivity.class));
                Animatoo.animateSlideRight(X_Rays_Details_Activity.this);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(X_Rays_Details_Activity.this, X_RaysActivity.class));
        Animatoo.animateSlideRight(X_Rays_Details_Activity.this);
        finish();
    }
}
