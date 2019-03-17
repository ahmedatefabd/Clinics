package com.example.ragab.clinics.medical_Prescreption;
import Adapters.medical_PrescreptionAdapter;
import Model.medical_Prescreption;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import com.example.ragab.clinics.R;
import java.util.ArrayList;
import java.util.Locale;
import static android.os.Build.VERSION_CODES.M;

public class medicalPrescreptionActivity extends AppCompatActivity {

    private medical_PrescreptionAdapter adapter;
    private RecyclerView recyclerView;
    public static Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_medical_prescreption);
        Local();
        controlToolbar();
        recyclerView = findViewById(R.id.recyclerViewmedical_Prescreption_Toolbar);
        if (Build.VERSION.SDK_INT >= M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.booking));
        }
        recycler();
    }

    private void controlToolbar() {
        toolbar = findViewById(R.id.medical_Prescreption_Toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.booking));
        getSupportActionBar().setTitle("");
    }

    private void recycler() {
        adapter = new medical_PrescreptionAdapter(medicalPrescreptionActivity.this, new ArrayList<medical_Prescreption>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
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
}
