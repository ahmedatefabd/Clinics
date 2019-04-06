package com.example.ragab.clinics.newRequest;
import Util.Utils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ragab.clinics.Home.HomeActivity;
import com.example.ragab.clinics.R;
import com.google.android.material.chip.Chip;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class newRequestActivity extends AppCompatActivity {
    private TextView dateOfBirthTV, check;
    int year, month, day;
    private LinearLayout DateBooking;
    public static Toolbar toolbar;
    public static TextView toolbar_title;
    private Chip chip_1;
    private Chip chip_2;
    private Chip chip_3;
    private Chip chip_4;

    private ImageView imgbarBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_request);
        controlToolbar();
        imgbarBooking = findViewById(R.id.imgbarBooking);

        imgbarBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(newRequestActivity.this, HomeActivity.class));
                Animatoo.animateSlideUp(newRequestActivity.this);
                finish();
            }
        });

        chip_1 = findViewById(R.id.chip1);
        chip_2 = findViewById(R.id.chip2);
        chip_3 = findViewById(R.id.chip3);
        chip_4 = findViewById(R.id.chip4);
        check = findViewById(R.id.check);

        DateBooking = findViewById(R.id.DateBooking);
        viewTime(DateBooking);
        dateOfBirthTV = findViewById(R.id.dateobooking);
        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog.OnDateSetListener date =
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateLabel(calendar);
                        visibleTime(DateBooking);
                    }
                };
        dateOfBirthTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(newRequestActivity.this, date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        chip_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check.setText("10.30 to 11.30");
            }
        });
        chip_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check.setText("11.30 to 12.30");
            }
        });
        chip_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check.setText("12.30 to 01.30");
            }
        });
        chip_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check.setText("01.30 to 02.30");
            }
        });
    }
    private void controlToolbar() {
        toolbar = findViewById(R.id.Booking_Toolbar);
        toolbar_title = findViewById(R.id.toolbar_booking);
        toolbar.setBackgroundColor(getResources().getColor(R.color.booking));
        toolbar_title.setText("عيادة الحجز المباشر");
    }

    public void viewTime(View v) {
        DateBooking.setVisibility(DateBooking.isShown()
                ? View.VISIBLE
                : View.GONE);
    }

    public void visibleTime(View v) {
        if (DateBooking.isShown()) {
            Utils.slide_up(this, DateBooking);
            DateBooking.setVisibility(View.GONE);
        } else {
            DateBooking.setVisibility(View.VISIBLE);
            Utils.slide_down(this, DateBooking);
        }
    }

    private void updateLabel(Calendar ca) {
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateOfBirthTV.setText(format1.format(ca.getTime()));
    }

    @Override
    public void onBackPressed() {
            startActivity(new Intent(newRequestActivity.this, HomeActivity.class));
        Animatoo.animateSlideDown(newRequestActivity.this);
            finish();
        }
}