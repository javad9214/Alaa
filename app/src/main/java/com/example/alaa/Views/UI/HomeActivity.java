package com.example.alaa.Views.UI;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.asksira.loopingviewpager.LoopingViewPager;
import com.example.alaa.Views.Dashboard.DashboardFragment;
import com.example.alaa.Views.UI.ProductPage.ProductPage;
import com.example.alaa.R;
import com.example.alaa.Views.ViewPager.ImageSlider;
import com.example.alaa.Views.ViewPager.PagerAdapter;

import com.example.alaa.Views.Adapters.HomeRecyclerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hzn.lib.EasyTransition;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeRecyclerAdapter.ItemClickListener{


    public static final String TAG = "===>";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_Product:
                        Intent intent  = new Intent(HomeActivity.this , ProductPage.class);
                        startActivity(intent);
                    return true;

                case R.id.navigation_forum:

                    return true;

                case R.id.navigation_MyProfile:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EasyTransition.enter(HomeActivity.this);


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

        final HomeRecyclerAdapter homeRecyclerAdapter = new HomeRecyclerAdapter(this , R.layout.content_recycler);

        RecyclerView recyclerView01 = findViewById(R.id.recycler01);
        RecyclerView recyclerView02 = findViewById(R.id.recycler02);
        RecyclerView recyclerView03 = findViewById(R.id.recycler03);
        RecyclerView recyclerView04 = findViewById(R.id.recycler04);

        recyclerView01.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        recyclerView02.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        recyclerView03.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        recyclerView04.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        recyclerView01.setAdapter(homeRecyclerAdapter);
        recyclerView02.setAdapter(homeRecyclerAdapter);
        recyclerView03.setAdapter(homeRecyclerAdapter);
        recyclerView04.setAdapter(homeRecyclerAdapter);

        homeRecyclerAdapter.setClickListener(this);


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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        EasyTransition.exit(HomeActivity.this);
    }


}
