package com.example.ragab.clinics.newRequest;
import Util.Utils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import cn.pedant.SweetAlert.SweetAlertDialog;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ragab.clinics.Home.HomeActivity;
import com.example.ragab.clinics.Login.LoginActivity;
import com.example.ragab.clinics.R;
import com.google.android.material.chip.Chip;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class newRequestActivity extends AppCompatActivity implements newRequestView{
    private TextView dateOfBirthTV, check;
    int year, month, day;
    public static ProgressBar progressBar;
//    private LinearLayout DateBooking;
    public static Toolbar toolbar;
    public static TextView toolbar_title;
//    public static EditText PatientName, patientDetails;
    public static EditText patientDetails;
    private AppCompatButton Sendbooking ;
    public static SharedPreferences sharedPreferences_newRequestActivity ;
    public static SharedPreferences.Editor editor_newRequestActivity;
    public static final String PREF_NAME = "prefs";
    private newRequestImp nNewRequestImp;
//    private Chip chip_1;
//    private Chip chip_2;
//    private Chip chip_3;
//    private Chip chip_4;
    private String P_Branch_Name, P_Patient_Id, P_Appointment_Date, P_Complaint_Type, P_Clinic_Id;
    private ImageView imgbarBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_request);
        controlToolbar();
        imgbarBooking = findViewById(R.id.imgbarBooking);
//        PatientName = findViewById(R.id.patientName);
        patientDetails = findViewById(R.id.patientDetails);
        patientDetails = findViewById(R.id.patientDetails);
        Sendbooking = findViewById(R.id.sendbooking);
        progressBar = findViewById(R.id.progressBar);

        sharedPreferences_newRequestActivity = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor_newRequestActivity = sharedPreferences_newRequestActivity.edit();
        nNewRequestImp = new newRequestImp();
        nNewRequestImp.setView(this);

        imgbarBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(newRequestActivity.this, HomeActivity.class));
                Animatoo.animateSlideRight(newRequestActivity.this);
                finish();
            }
        });

        Sendbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                progress();
                progressBar.setVisibility(View.VISIBLE);
//                P_Branch_Name = PatientName.getText().toString().trim();
                P_Complaint_Type = patientDetails.getText().toString().trim();
                P_Appointment_Date = dateOfBirthTV.getText().toString().trim();

//                if (CheckEmpty(P_Branch_Name, P_Complaint_Type, P_Appointment_Date)) {
                if (CheckEmpty(P_Complaint_Type, P_Appointment_Date)) {
                    CheckInternetConnection();
                } else {
                    Toast.makeText(newRequestActivity.this, "تأكد من كتابة البيانات بطريقة صحيحة", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        chip_1 = findViewById(R.id.chip1);
//        chip_2 = findViewById(R.id.chip2);
//        chip_3 = findViewById(R.id.chip3);
//        chip_4 = findViewById(R.id.chip4);
//        check = findViewById(R.id.check);

//        DateBooking = findViewById(R.id.DateBooking);
//        viewTime(DateBooking);
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
//                        visibleTime(DateBooking);
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

//        chip_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                check.setText("10.30 to 11.30");
//            }
//        });
//        chip_2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                check.setText("11.30 to 12.30");
//            }
//        });
//        chip_3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                check.setText("12.30 to 01.30");
//            }
//        });
//        chip_4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                check.setText("01.30 to 02.30");
//            }
//        });
    }

    private void progress(){
        KProgressHUD.create(newRequestActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();
    }

//    private boolean CheckEmpty(String p_branch_name, String p_complaint_type, String P_Appointment_Date) {
    private boolean CheckEmpty(String p_complaint_type, String P_Appointment_Date) {
//        if (p_branch_name.isEmpty()) {
//            PatientName.setError("الاسم لا يمكن أن يكون فارغاً");
//            return false;
//        }else

        if (p_complaint_type.isEmpty()) {
            patientDetails.setError("الحاله المرضيه لا يمكن أن تكون فارغاً");
            progressBar.setVisibility(View.GONE);
            return false;

        } else if (P_Appointment_Date.isEmpty()) {
            dateOfBirthTV.setError("من فضلك أدخل التاريخ");
            progressBar.setVisibility(View.GONE);
            return false;

        } else {
            return true;
        }
    }


    private void CheckInternetConnection() {
        P_Patient_Id = String.valueOf(Utils.getID(newRequestActivity.this));
        P_Clinic_Id = "0";

        if (Utils.isInternetOn(newRequestActivity.this)) {
//                nNewRequestImp.RequestBooking(P_Branch_Name, P_Patient_Id, P_Appointment_Date, P_Complaint_Type, P_Clinic_Id);
                nNewRequestImp.RequestBooking(P_Patient_Id, P_Appointment_Date, P_Complaint_Type, P_Clinic_Id);
        } else {
            showErrorMessage("من فضلك تأكد من الإتصال بالإنترنت");
            progressBar.setVisibility(View.GONE);
        }
    }

    private void showErrorMessage(String message) {
        try {
            new SweetAlertDialog(newRequestActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("خطأ")
                    .setContentText(message)
                    .setConfirmText("تم")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void controlToolbar() {
        toolbar = findViewById(R.id.Booking_Toolbar);
        toolbar_title = findViewById(R.id.toolbar_booking);
        toolbar.setBackgroundColor(getResources().getColor(R.color.booking));
        toolbar_title.setText("عيادة الحجز المباشر");
    }

    public void viewTime(View v) {
//        DateBooking.setVisibility(DateBooking.isShown()
//                ? View.VISIBLE
//                : View.GONE);
    }

    public void visibleTime(View v) {
//        if (DateBooking.isShown()) {
//            Utils.slide_up(this, DateBooking);
//            DateBooking.setVisibility(View.GONE);
//        } else {
//            DateBooking.setVisibility(View.VISIBLE);
//            Utils.slide_down(this, DateBooking);
//        }
    }

    private void updateLabel(Calendar ca) {
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateOfBirthTV.setText(format1.format(ca.getTime()));
    }

    @Override
    public void onBackPressed() {
            startActivity(new Intent(newRequestActivity.this, HomeActivity.class));
        Animatoo.animateSlideRight(newRequestActivity.this);
            finish();
        }

    @Override
    public void showalert(String Message) {
        try {
            new SweetAlertDialog(newRequestActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("خطأ")
                    .setContentText(Message)
                    .setConfirmText("تم")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            Toast.makeText(this, Message , Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}