package com.example.ragab.clinics.sheet_TreatmentDetails;
import Adapters.SheetTreatmentDetailsAdapter;
import Model.Sheet_Treatment;
import Model.Treatment;
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
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.sheet_Treatment.sheet_TreatmentActivity;
import java.util.ArrayList;

public class sheet_TreatmentDetailsActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView imgbar;
    private Sheet_Treatment sHeetTreatment;
    private TextView treatmentName;
    private TextView treatmentDate;
    private SheetTreatmentDetailsAdapter adapter;
    public  RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sheet_treatment_details);
        treatmentName = findViewById(R.id.Name_SheetTreatmentDetails);
        treatmentDate = findViewById(R.id.Date_SheetTreatmentDetails);

        Bundle bundle = getIntent().getExtras();
        Sheet_Treatment sheet_treatment = bundle.getParcelable("model");
        sHeetTreatment = sheet_treatment;
       ArrayList<Treatment> treatmentList1 =bundle.getParcelableArrayList("listSheet");

        if (treatmentList1 == null) {
            Toast.makeText(this, "null", Toast.LENGTH_LONG).show();
        }else if (treatmentList1.size() == 0){
            new SweetAlertDialog(sheet_TreatmentDetailsActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
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
//            Toast.makeText(this, "List", Toast.LENGTH_LONG).show();
            recycler(treatmentList1);
        }

        if (sHeetTreatment.getCreatedWhen() == null){
            treatmentDate.setText("--/--/----");
        }else {
            treatmentDate.setText(sHeetTreatment.getCreatedWhen());
        }
        treatmentName.setText("الاسم :- " + sHeetTreatment.getSheetName());

       toolbarr();

        imgbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sheet_TreatmentDetailsActivity.this, sheet_TreatmentActivity.class));
                Animatoo.animateSlideRight(sheet_TreatmentDetailsActivity.this);
                finish();
            }
        });
    }

    private void toolbarr() {
        toolbar = findViewById(R.id.Sheet_Treatment_Details_Toolbar);
        imgbar = findViewById(R.id.imgbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    private void recycler(ArrayList<Treatment> treatmentList1) {
        recyclerView = findViewById(R.id.RecyclerXraysDetails);
        adapter = new SheetTreatmentDetailsAdapter(this, treatmentList1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(sheet_TreatmentDetailsActivity.this, sheet_TreatmentActivity.class));
        Animatoo.animateSlideRight(sheet_TreatmentDetailsActivity.this);
        finish();
    }
}