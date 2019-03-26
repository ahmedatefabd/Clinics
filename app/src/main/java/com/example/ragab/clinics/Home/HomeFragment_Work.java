package com.example.ragab.clinics.Home;
import android.content.Intent;
import android.os.Bundle;
import Util.RoundedTransformation;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.newRequest.newRequestActivity;
import com.example.ragab.clinics.oldRequest.oldRequestActivity;
import com.squareup.picasso.Picasso;

public class HomeFragment_Work extends Fragment {

    private RelativeLayout oldReq, newReq;
    private ImageView doctor2, doctor3 ,doc;

    public HomeFragment_Work() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_work, container, false);
        oldReq = view.findViewById(R.id.oldReq);
        newReq = view.findViewById(R.id.newReq);
        doctor2 = view.findViewById(R.id.doctor2);
        doctor3 = view.findViewById(R.id.doctor3);
        doc = view.findViewById(R.id.doc);

        newReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), newRequestActivity.class));
//                startActivity(new Intent(getActivity(), AboutDoctorActivity.class));
                Animatoo.animateZoom(getActivity());
            }
        });

        oldReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), oldRequestActivity.class));
                Animatoo.animateZoom(getActivity());
            }
        });

        Picasso.get()
                .load(R.drawable.doc3)
                .transform(new RoundedTransformation())
                .resize(1000, 1000)
                .into(doctor2);

        Picasso.get()
                .load(R.drawable.report1)
                .transform(new RoundedTransformation())
                .resize(1000, 1000)
                .into(doctor3);
        Picasso.get()
                .load(R.drawable.doc2)
                .transform(new RoundedTransformation())
                .resize(500, 500)
                .into(doc);
        return view;
    }
}
