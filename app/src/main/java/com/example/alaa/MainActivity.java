package com.example.alaa;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.asksira.loopingviewpager.LoopingViewPager;
import com.example.alaa.Dashboard.DashboardFragment;
import com.example.alaa.ViewPager.ImageSlider;
import com.example.alaa.ViewPager.PagerAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.ItemClickListener{


    public static final String TAG = "===>";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:

                    return true;

                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);

        setAdapters();

        initViewPager();


    }

    private void initViewPager() {


        PagerAdapter pagerAdapter = new PagerAdapter(this, getImageList());
        LoopingViewPager loopingViewPager = findViewById(R.id.viewpager);

       // loopingViewPager.setClipToPadding(false);
        //loopingViewPager.setPadding(50 , 0 , 50 , 0);
       // loopingViewPager.setPageMargin(-50);

        DotsIndicator dotsIndicator = findViewById(R.id.dots_indicator);


        loopingViewPager.setAdapter(pagerAdapter);

        loopingViewPager.resumeAutoScroll();
       // dotsIndicator.setViewPager(loopingViewPager);


        try {
            Field mScroller;
            mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller(loopingViewPager.getContext(), new DecelerateInterpolator());
            // scroller.setFixedDuration(5000);
            mScroller.set(loopingViewPager, scroller);
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        }



    }

    private void setAdapters() {

        final Adapter adapter = new Adapter(this , R.layout.content_recycler);

        RecyclerView recyclerView01 = findViewById(R.id.recycler01);
        RecyclerView recyclerView02 = findViewById(R.id.recycler02);
        RecyclerView recyclerView03 = findViewById(R.id.recycler03);
        RecyclerView recyclerView04 = findViewById(R.id.recycler04);

        recyclerView01.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        recyclerView02.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        recyclerView03.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        recyclerView04.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        recyclerView01.setAdapter(adapter);
        recyclerView02.setAdapter(adapter);
        recyclerView03.setAdapter(adapter);
        recyclerView04.setAdapter(adapter);

        adapter.setClickListener(this);


    }

    private List<ImageSlider> getImageList() {
        List<ImageSlider> imageList = new ArrayList<>();
        imageList.add(new ImageSlider("ad_00", R.drawable.ad_0));
        imageList.add(new ImageSlider("ad_01", R.drawable.ad_01));
        imageList.add(new ImageSlider("ad_02", R.drawable.ad__02));
        return imageList;
    }

    public void Onclick_dashboard(View view) {
        DashboardFragment dashboardFragment = new DashboardFragment();
        dashboardFragment.show(getSupportFragmentManager(), dashboardFragment.getTag());


    }

    @Override
    public void onItemClick(View view, int position) {

        Intent intent  = new Intent(this , VideoPage.class);
        startActivity(intent);
    }

    public class FixedSpeedScroller extends Scroller {

        private int mDuration = 500;

        public FixedSpeedScroller(Context context) {
            super(context);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator, boolean flywheel) {
            super(context, interpolator, flywheel);
        }


        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            // Ignore received duration, use fixed one instead
            super.startScroll(startX, startY, dx, dy, mDuration);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy) {
            // Ignore received duration, use fixed one instead
            super.startScroll(startX, startY, dx, dy, mDuration);
        }
    }


}
