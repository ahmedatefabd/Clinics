package com.example.ragab.clinics.detailsClinic;
import Util.RoundedTransformation;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.newRequest.newRequestActivity;
import com.example.ragab.clinics.oldRequest.oldRequestActivity;
import com.squareup.picasso.Picasso;

public class DetailsClinicActivity extends AppCompatActivity {

    private RelativeLayout oldReq, newReq;
    private ImageView doctor2, doctor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_clinic);

        oldReq = findViewById(R.id.oldReq);
        newReq = findViewById(R.id.newReq);
        doctor2 = findViewById(R.id.doctor2);
        doctor3 = findViewById(R.id.doctor3);


        newReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsClinicActivity.this, newRequestActivity.class));
            }
        });

        oldReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsClinicActivity.this, oldRequestActivity.class));
            }
        });

        Picasso.get()
                .load(R.drawable.doctor2)
                .transform(new RoundedTransformation())
                .resize(150, 150)
                .into(doctor2);

        Picasso.get()
                .load(R.drawable.doctor3)
                .transform(new RoundedTransformation())
                .resize(150, 150)
                .into(doctor3);
    }
}