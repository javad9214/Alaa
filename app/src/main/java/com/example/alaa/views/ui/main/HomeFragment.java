package com.example.alaa.views.ui.main;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.asksira.loopingviewpager.LoopingViewPager;
import com.example.alaa.R;
import com.example.alaa.views.ViewPager.PagerAdapter;
import com.example.alaa.views.adapters.HomeRecyclerAdapter;
import com.example.alaa.views.ui.VideoPage;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Objects;


public class HomeFragment extends Fragment implements HomeRecyclerAdapter.ItemClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }

    private View view ;
    private HomeViewModel viewModel ;

    public static final String TAG = "===>";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(HomeViewModel.class);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        // onBackPressed();
        return view ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setAdapters();
        initViewPager();
    }

    private void initViewPager() {



        PagerAdapter pagerAdapter = new PagerAdapter(getContext(), viewModel.getImageList());
        LoopingViewPager loopingViewPager = view.findViewById(R.id.viewpager);

        // loopingViewPager.setClipToPadding(false);
        //loopingViewPager.setPadding(50 , 0 , 50 , 0);
        // loopingViewPager.setPageMargin(-50);

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
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    private void setAdapters() {

        final HomeRecyclerAdapter homeRecyclerAdapter = new HomeRecyclerAdapter(getContext() , R.layout.set);

        RecyclerView recyclerView01 = view.findViewById(R.id.recycler01);
        RecyclerView recyclerView02 = view.findViewById(R.id.recycler02);
        RecyclerView recyclerView03 = view.findViewById(R.id.recycler03);
        RecyclerView recyclerView04 = view.findViewById(R.id.recycler04);

        recyclerView01.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
        recyclerView02.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
        recyclerView03.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
        recyclerView04.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));

        recyclerView01.setAdapter(homeRecyclerAdapter);
        recyclerView02.setAdapter(homeRecyclerAdapter);
        recyclerView03.setAdapter(homeRecyclerAdapter);
        recyclerView04.setAdapter(homeRecyclerAdapter);

        homeRecyclerAdapter.setClickListener(this);


    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent  = new Intent(getContext() , VideoPage.class);
        startActivity(intent);
    }

    private class FixedSpeedScroller extends Scroller {

        private int mDuration = 500;

        public FixedSpeedScroller(Context context) {
            super(context);
        }

        FixedSpeedScroller(Context context, Interpolator interpolator) {
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
