package com.example.ragab.clinics.Home;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import Util.RoundedTransformation;
import adapterViewPager.Slider_Pager_Adapter_Home;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.newRequest.newRequestActivity;
import com.example.ragab.clinics.oldRequest.oldRequestActivity;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment_Work extends Fragment {

    private RelativeLayout oldReq, newReq;
    private ImageView doctor2, doctor3;
    Slider_Pager_Adapter_Home sliderPagerAdapter;
    ArrayList<Integer> slider_image_list = new ArrayList<>();
    int page_position = 0;
    private ViewPager images_slider;
    private LinearLayout pages_dots;
    Timer timer;
    private TextView[] dots;
    public HomeFragment_Work() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_work, container, false);
        images_slider = view.findViewById(R.id.image_page_slider_home);
        pages_dots = view.findViewById(R.id.image_page_dots_home);
        timer = new Timer();
        initSlider();
        scheduleSlider();
        oldReq = view.findViewById(R.id.oldReq);
        newReq = view.findViewById(R.id.newReq);
        doctor2 = view.findViewById(R.id.doctor2);
        doctor3 = view.findViewById(R.id.doctor3);


        newReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), newRequestActivity.class));
//                startActivity(new Intent(getActivity(), medicalPrescreptionActivity.class));
            }
        });

        oldReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), oldRequestActivity.class));
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

    private void initSlider() {
        addBottomDots(0);

        slider_image_list = new ArrayList<>();

        slider_image_list.add(R.drawable.slider1);
        slider_image_list.add(R.drawable.slider2);
        slider_image_list.add(R.drawable.slider3);
        slider_image_list.add(R.drawable.slider4);

        sliderPagerAdapter = new Slider_Pager_Adapter_Home(getActivity(),slider_image_list);
        images_slider.setAdapter(sliderPagerAdapter);
        images_slider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void scheduleSlider() {
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == slider_image_list.size()) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                images_slider.setCurrentItem(page_position, true);
            }
        };
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 1000, 3000);
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[slider_image_list.size()];
        pages_dots.removeAllViews();
        pages_dots.setPadding(0, 0, 0, 20);
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getActivity());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#9f9f9f"));
            pages_dots.addView(dots[i]);
        }
        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#ffffff"));
    }

    @Override
    public void onPause() {
        timer.cancel();
        super.onPause();
    }

}
