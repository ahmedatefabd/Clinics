package com.example.ragab.clinics.x_Rays_Details;

import Adapters.X_RaysDetailsAdapter;
import Model.Xrays;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ragab.clinics.R;

import java.util.ArrayList;

public class X_Rays_Details_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private X_RaysDetailsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x__rays__details_);

        recyclerView = findViewById(R.id.recyclerXrayDedails);

        adapter = new X_RaysDetailsAdapter(X_Rays_Details_Activity.this, new ArrayList<Xrays>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
