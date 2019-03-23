package com.example.ragab.clinics.medical_PrescreptionDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ragab.clinics.Home.HomeActivity;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.medical_Prescreption.medicalPrescreptionActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.hzn.lib.EasyTransition;

public class medical_PrescreptionDetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imgbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical__prescreption_details);
        toolbar = findViewById(R.id.message_Toolbar);
        imgbar = findViewById(R.id.imgbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        imgbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(medical_PrescreptionDetailsActivity.this, medicalPrescreptionActivity.class));
                Animatoo.animateSlideUp(medical_PrescreptionDetailsActivity.this);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(medical_PrescreptionDetailsActivity.this, medicalPrescreptionActivity.class));
        Animatoo.animateSlideUp(medical_PrescreptionDetailsActivity.this);
        finish();
    }
}
