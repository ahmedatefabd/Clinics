package com.example.ragab.clinics.newRequest;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import Util.Utils;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ragab.clinics.R;
import com.google.android.material.chip.Chip;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class newRequestFragment extends Fragment {

    private TextView dateOfBirthTV;
    int year, month, day;
    private LinearLayout DateBooking;
    public static Toolbar toolbar;
    public static TextView toolbar_title;
    private Chip chip_1;
    private Chip chip_2;
    private Chip chip_3;
    private Chip chip_4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_request, container, false);
        controlToolbar(view);
        chip_1 = view.findViewById(R.id.chip1);
        chip_2 = view.findViewById(R.id.chip2);
        chip_3 = view.findViewById(R.id.chip3);
        chip_4 = view.findViewById(R.id.chip4);
        DateBooking = view.findViewById(R.id.DateBooking);
        viewTime(DateBooking);
        dateOfBirthTV = view.findViewById(R.id.dateobooking);
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
                new DatePickerDialog(getActivity(), date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        return view;
    }

    private void controlToolbar(View view) {
        toolbar = view.findViewById(R.id.Booking_Toolbar);
        toolbar_title = view.findViewById(R.id.toolbar_booking);
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
            Utils.slide_up(getActivity(), DateBooking);
            DateBooking.setVisibility(View.GONE);
        } else {
            DateBooking.setVisibility(View.VISIBLE);
            Utils.slide_down(getActivity(), DateBooking);
        }
    }

    private void updateLabel(Calendar ca) {
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateOfBirthTV.setText(format1.format(ca.getTime()));
    }

}
