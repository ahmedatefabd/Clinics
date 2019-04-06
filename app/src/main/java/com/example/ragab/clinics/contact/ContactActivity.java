package com.example.ragab.clinics.contact;
import Adapters.PrivateChatAdapter;
import Model.ChatMessage;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ragab.clinics.Home.HomeActivity;
import com.example.ragab.clinics.R;
import java.util.ArrayList;
import java.util.Locale;
import static android.os.Build.VERSION_CODES.M;

public class ContactActivity extends AppCompatActivity {
    private PrivateChatAdapter adapter;
    private RecyclerView recyclerView;
    public static Toolbar toolbar;
    private ImageView imgbarMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contact);
        imgbarMessage = findViewById(R.id.imgbarMessage);

        Local();
        controlToolbar();

        recyclerView = findViewById(R.id.recyclerViewContact);
        if (Build.VERSION.SDK_INT >= M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.booking));
        }

        recycler();

        imgbarMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactActivity.this, HomeActivity.class));
                Animatoo.animateSlideUp(ContactActivity.this);
                finish();
            }
        });
    }

    private void controlToolbar() {
        toolbar = findViewById(R.id.message_Toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.booking));
        getSupportActionBar().setTitle("");
    }

    private void recycler() {
        adapter = new PrivateChatAdapter(ContactActivity.this, new ArrayList<ChatMessage>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void Local() {
        Locale locale = new Locale("en");
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
        startActivity(new Intent(ContactActivity.this, HomeActivity.class));
        Animatoo.animateSlideDown(ContactActivity.this);
        finish();
    }
}