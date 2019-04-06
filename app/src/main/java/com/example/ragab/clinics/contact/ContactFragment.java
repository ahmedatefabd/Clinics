package com.example.ragab.clinics.contact;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ragab.clinics.R;
import java.util.ArrayList;
import java.util.Locale;
import Adapters.PrivateChatAdapter;
import Model.ChatMessage;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ContactFragment extends Fragment {
    private PrivateChatAdapter adapter;
    private RecyclerView recyclerView;
    public static Toolbar toolbar;

    public ContactFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        Local();
        recyclerView = view.findViewById(R.id.recyclerView);
        recycler();
        return view;
    }

    private void recycler() {
        adapter = new PrivateChatAdapter(getActivity(), new ArrayList<ChatMessage>());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private void Local() {
        Locale locale = new Locale("en");
        Locale.setDefault(locale);
        String en = Locale.getDefault().getDisplayLanguage();
        Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLayoutDirection(locale);
        }
    }
}