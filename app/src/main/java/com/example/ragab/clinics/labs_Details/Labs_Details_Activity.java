package com.example.ragab.clinics.labs_Details;
import Adapters.LabsDetailsAdapter;
import Model.Labs;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.ragab.clinics.R;
import java.util.ArrayList;

public class Labs_Details_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LabsDetailsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labs__details_);

        recyclerView = findViewById(R.id.recyclerLabsDedails);
        adapter = new LabsDetailsAdapter(Labs_Details_Activity.this, new ArrayList<Labs>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
