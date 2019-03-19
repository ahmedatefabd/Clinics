package com.example.ragab.clinics;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.ragab.clinics.Home.HomeActivity.sharedPreferences;
import static com.example.ragab.clinics.Login.LoginActivity.KEY_USERNAME;

public class ProfileFragment extends BaseFragment {

    private TextView edit_firstname;
    private TextView edit_email;
    private TextView edit_mobilenumber;
    String userN;

    public ProfileFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        userN = sharedPreferences.getString(KEY_USERNAME, "");
        edit_firstname = view.findViewById(R.id.edit_firstname);
        edit_email = view.findViewById(R.id.edit_email);
        edit_mobilenumber = view.findViewById(R.id.edit_mobilenumber);
        edit_firstname.setText(userN);
        edit_email.setText("hesham0755@gmail.com");
        edit_mobilenumber.setText("01032400149");
        return view;
    }

}
