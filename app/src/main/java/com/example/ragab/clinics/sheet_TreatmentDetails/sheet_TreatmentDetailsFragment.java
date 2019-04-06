package com.example.ragab.clinics.sheet_TreatmentDetails;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ragab.clinics.R;

public class sheet_TreatmentDetailsFragment extends Fragment {

    public sheet_TreatmentDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_medical__prescreption_details, container, false);
    }

}
