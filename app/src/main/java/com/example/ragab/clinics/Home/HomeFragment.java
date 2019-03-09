package com.example.ragab.clinics.Home;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.ragab.clinics.BaseFragment;
import com.example.ragab.clinics.R;
import java.util.ArrayList;
import Adapters.DoctorsAdapter;
import Model.Doctors;
import Model.SampleSearchModel;
import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;

public class HomeFragment extends BaseFragment {
    private RecyclerView recycler;
    private RecyclerView.LayoutManager mLayoutManager;
    private DoctorsAdapter adapter;
    private LinearLayout linearLayout;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recycler = view.findViewById(R.id.recycler);
        linearLayout = view.findViewById(R.id.search_home_fragment);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(mLayoutManager);
        adapter = new DoctorsAdapter(getActivity(), new ArrayList<Doctors>());
        recycler.setAdapter(adapter);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SimpleSearchDialogCompat(getActivity(), "ابحث...", "عن ما تبحث...؟", null, createSampleData(),
                        new SearchResultListener<SampleSearchModel>() {
                            @Override
                            public void onSelected(BaseSearchDialogCompat dialog, SampleSearchModel item, int position) {
                                Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }).show();
            }
        });
        return view;
    }

    private ArrayList<SampleSearchModel> createSampleData() {
        ArrayList<SampleSearchModel> items = new ArrayList<>();
        items.add(new SampleSearchModel("First item"));
        items.add(new SampleSearchModel("Second item"));
        items.add(new SampleSearchModel("Third item"));
        items.add(new SampleSearchModel("The ultimate item"));
        items.add(new SampleSearchModel("Last item"));
        items.add(new SampleSearchModel("Lorem ipsum"));
        items.add(new SampleSearchModel("Dolor sit"));
        items.add(new SampleSearchModel("Some random word"));
        items.add(new SampleSearchModel("guess who's back"));
        return items;
    }
}
