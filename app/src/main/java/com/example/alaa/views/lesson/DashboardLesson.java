package com.example.alaa.views.lesson;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.ViewPager;

import com.example.alaa.R;
import com.example.alaa.views.dashboard.BookmarkFragment;
import com.example.alaa.views.dashboard.TabAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.tabs.TabLayout;


public class DashboardLesson extends BottomSheetDialogFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapter adapter;
    private View view;
    private AppCompatImageView cancel;


    public static final String TAG = "===>" ;

    public DashboardLesson() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.dashboard_lesson, container, false);

       // init();

        return view;
    }


    private void init() {

        cancel = view.findViewById(R.id.cancel_dashboard);

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        adapter = new TabAdapter(getChildFragmentManager());
        adapter.addFragment(new BookmarkFragment(), "ویدیو های مرتبط");

        viewPager.setAdapter(adapter);


        tabLayout.setupWithViewPager(viewPager);


        tabLayout.getTabAt(0).setIcon(R.drawable.ic_video_play);

        tabLayout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.alaa1) , PorterDuff.Mode.MULTIPLY);


        viewPager.setCurrentItem(1);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onStop();
            }
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {

                    case 0:
                        tabLayout.getTabAt(tab.getPosition()).setIcon(R.drawable.ic_video_play);
                        tabLayout.getTabAt(tab.getPosition()).getIcon().setColorFilter(getResources().getColor(R.color.alaa1) , PorterDuff.Mode.MULTIPLY);
                        break;


                    default:
                        //TODO:// default ?
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                switch (tab.getPosition()) {

                    case 0:
                        tabLayout.getTabAt(tab.getPosition()).setIcon(R.drawable.ic_cart);
                       // tabLayout.getTabAt(tab.getPosition()).getIcon().setColorFilter(getResources().getColor(R.color.alaa0) , PorterDuff.Mode.MULTIPLY);

                        break;

                    case 1:
                        tabLayout.getTabAt(tab.getPosition()).setIcon(R.drawable.ic_personal_info_black);
                        break;

                    default:
                        //TODO:// default ?
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

}