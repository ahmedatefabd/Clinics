package com.example.ragab.clinics.booking;
import Util.Utils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.ragab.clinics.R;
import com.google.android.material.chip.Chip;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BookingActivity extends AppCompatActivity {
   private TextView dateOfBirthTV;
    int year, month, day;
    private LinearLayout otherAccountLy;
    private LinearLayout DateBooking;
    CheckBox radiotheraccount;
    RadioGroup AccountTypeRadio;
    private Boolean BookForMeFlage = true;
    public static Toolbar toolbar;
    public static TextView toolbar_title;
    private Chip chip_1;
    private Chip chip_2;
    private Chip chip_3;
    private Chip chip_4;
    private Chip chip_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_booking);
        controlToolbar();
//        chip_1 = findViewById(R.id.chip1);
//        chip_2 = findViewById(R.id.chip2);
//        chip_3 = findViewById(R.id.chip3);
//        chip_4 = findViewById(R.id.chip4);
        AccountTypeRadio = findViewById(R.id.radioBookingType);
        radiotheraccount = findViewById(R.id.radiotheraccount);
        otherAccountLy = findViewById(R.id.otheraccountLy);
        DateBooking = findViewById(R.id.DateBooking);
        toggle_contents(otherAccountLy);
        viewTime(DateBooking);
        dateOfBirthTV = findViewById(R.id.dateobooking);
        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        AccountTypeRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radiotheraccount) {
                    BookForMeFlage = false;
                    ShowOtherAccountLy(otherAccountLy);
                }
            }
        });
        radiotheraccount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (radiotheraccount.isChecked()) {
                    BookForMeFlage = false;
                    ShowOtherAccountLy(otherAccountLy);
                } else {
                    BookForMeFlage = true;
                    ShowOtherAccountLy(otherAccountLy);
                }
            }
        });
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
                new DatePickerDialog(BookingActivity.this, date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void controlToolbar() {
        toolbar = findViewById(R.id.Booking_Toolbar);
        toolbar_title = findViewById(R.id.toolbar_booking);
        toolbar.setBackgroundColor(getResources().getColor(R.color.booking));
        toolbar_title.setText("عيادة الحجز المباشر");
    }

    public void toggle_contents(View v) {
        otherAccountLy.setVisibility(otherAccountLy.isShown()
                ? View.VISIBLE
                : View.GONE);
    }
    public void viewTime(View v) {
        DateBooking.setVisibility(DateBooking.isShown()
                ? View.VISIBLE
                : View.GONE);
    }
    public void ShowOtherAccountLy(View v) {
        if (otherAccountLy.isShown()) {
            Utils.slide_up(this, otherAccountLy);
            otherAccountLy.setVisibility(View.GONE);
        } else {
            otherAccountLy.setVisibility(View.VISIBLE);
            Utils.slide_down(this, otherAccountLy);
        }
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
}