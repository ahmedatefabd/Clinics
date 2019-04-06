package com.example.ragab.clinics.sheet_TreatmentDetails;
import Adapters.SheetTreatmentDetailsAdapter;
import Model.Sheet_Treatment;
import Model.Treatment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.sheet_Treatment.sheet_TreatmentActivity;
import java.util.ArrayList;
import java.util.List;

public class sheet_TreatmentDetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imgbar;
    private Sheet_Treatment sHeetTreatment;
    private TextView treatmentName;
    private TextView treatmentDate;
    private SheetTreatmentDetailsAdapter adapter;
    public static ShimmerRecyclerView shimmerRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_medical__prescreption_details);

        treatmentName = findViewById(R.id.Name_SheetTreatmentDetails);
        treatmentDate = findViewById(R.id.Date_SheetTreatmentDetails);

//        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        Sheet_Treatment sheet_treatment = bundle.getParcelable("model");
        sHeetTreatment = sheet_treatment;
       ArrayList<Treatment> treatmentList1 =bundle.getParcelableArrayList("sheet");
//        List<TreatmentDB> treatmentList1 = roomDataBaseSheet_Treatment.operation().getAllTreatmentItems();

//        Gson gson = new Gson();
//        String gGson = getIntent().getStringExtra("sheet");
//        Type type = new TypeToken<List<Treatment>>() {
//        }.getType();
//        List<Treatment> treatmentList1 = gson.fromJson(gGson, type);

        treatmentDate.setText("التاريخ:- " + sHeetTreatment.getCreatedWhen());
        treatmentName.setText("الاسم:- " + sHeetTreatment.getSheetName());

       // List<Treatment> treatmentList1 = new ArrayList<>();

        ShimmerRecycler(treatmentList1);

        toolbar = findViewById(R.id.message_Toolbar);
        imgbar = findViewById(R.id.imgbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        imgbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sheet_TreatmentDetailsActivity.this, sheet_TreatmentActivity.class));
                Animatoo.animateSlideUp(sheet_TreatmentDetailsActivity.this);
                finish();
            }
        });
    }

    private void ShimmerRecycler(List<Treatment> treatmentList) {

        shimmerRecyclerView = findViewById(R.id.ShimmerRecyclerTreatmentDetails);
        shimmerRecyclerView.showShimmerAdapter();
        shimmerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        shimmerRecyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new SheetTreatmentDetailsAdapter (this, treatmentList);
            shimmerRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(sheet_TreatmentDetailsActivity.this, sheet_TreatmentActivity.class));
        Animatoo.animateSlideUp(sheet_TreatmentDetailsActivity.this);
        finish();
    }
}