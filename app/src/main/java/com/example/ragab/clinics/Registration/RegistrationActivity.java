package com.example.ragab.clinics.Registration;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.ragab.clinics.R;

public class RegistrationActivity extends AppCompatActivity implements RegistrationView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }
}
