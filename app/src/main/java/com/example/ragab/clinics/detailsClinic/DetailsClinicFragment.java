package com.example.ragab.clinics.detailsClinic;
import android.content.Intent;
import android.os.Bundle;

import Util.RoundedTransformation;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.ragab.clinics.R;
import com.example.ragab.clinics.newRequest.newRequestActivity;
import com.squareup.picasso.Picasso;

public class DetailsClinicFragment extends Fragment {

    private RelativeLayout oldReq, newReq;
    private ImageView doctor2, doctor3;

    public DetailsClinicFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details_clinic, container, false);
        oldReq = view.findViewById(R.id.oldReq);
        newReq = view.findViewById(R.id.newReq);
        doctor2 = view.findViewById(R.id.doctor2);
        doctor3 = view.findViewById(R.id.doctor3);


        newReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), newRequestActivity.class));
            }
        });

        oldReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), newRequestActivity.class));
            }
        });

        Picasso.get()
                .load(R.drawable.doctor2)
                .transform(new RoundedTransformation())
                .resize(150, 150)
                .into(doctor2);

        Picasso.get()
                .load(R.drawable.doctor3)
                .transform(new RoundedTransformation())
                .resize(150, 150)
                .into(doctor3);
        return view;
    }

}
