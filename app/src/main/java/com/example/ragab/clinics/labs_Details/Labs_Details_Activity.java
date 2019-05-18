package com.example.ragab.clinics.labs_Details;
import Adapters.LabsDetailsAdapter;
import Model.Labs;
import Model.Sheet_Labs;
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

import java.util.ArrayList;

public class Labs_Details_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LabsDetailsAdapter adapter;
    private TextView name_LabsDetails;
    private TextView date_LabsDetails;
    private Toolbar toolbar;
    private ImageView imgbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labs__details_);

        recyclerView = findViewById(R.id.recyclerLabsDedails);
        name_LabsDetails = findViewById(R.id.Name_LabsDetails);
        date_LabsDetails = findViewById(R.id.Date_LabsDetails);

        Bundle bundle = getIntent().getExtras();
        Sheet_Labs SHheet_Labs = bundle.getParcelable("modelLabs");
        ArrayList<Labs> labsArrayList =bundle.getParcelableArrayList("listLabs");

        if (labsArrayList == null){
            Toast.makeText(this, "null", Toast.LENGTH_LONG).show();
        }else if (labsArrayList.size() == 0){
            new SweetAlertDialog(Labs_Details_Activity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
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
        }else {
            adapter = new LabsDetailsAdapter(Labs_Details_Activity.this, labsArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }

        name_LabsDetails.setText("الاسم:- " + SHheet_Labs.getSheetName());
        date_LabsDetails.setText(SHheet_Labs.getCreatedWhen());

        if (SHheet_Labs.getCreatedWhen() == null){
            date_LabsDetails.setText("--/--/----");
        }else {
            date_LabsDetails.setText(SHheet_Labs.getCreatedWhen());
        }


        Toolbarr();

        imgbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Labs_Details_Activity.this, LabsActivity.class));
                Animatoo.animateSlideRight(Labs_Details_Activity.this);
                finish();
            }
        });
    }

    private void Toolbarr() {
        toolbar = findViewById(R.id.Labs_Details_Toolbar);
        imgbar = findViewById(R.id.imgbar_Labs_Details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Labs_Details_Activity.this, LabsActivity.class));
        Animatoo.animateSlideRight(Labs_Details_Activity.this);
        finish();
    }
}