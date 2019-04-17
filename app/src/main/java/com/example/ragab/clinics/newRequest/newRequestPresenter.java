package com.example.ragab.clinics.newRequest;

public interface newRequestPresenter {
    void setView(newRequestActivity newRequestView);
    int RequestBooking(String p_branch_name, String p_patient_id, String p_appointment_date, String p_complaint_type, String p_clinic_id);
}
