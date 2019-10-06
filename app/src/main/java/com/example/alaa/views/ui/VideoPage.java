package com.example.alaa.views.ui;

import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alaa.R;
import com.example.alaa.customViews.TextViewWithFont;
import com.example.alaa.databinding.ActivityVideoPageBinding;
import com.example.alaa.views.adapters.HomeRecyclerAdapter;
import com.example.alaa.views.ui.dashboard.Adapter_shop;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.hzn.lib.EasyTransition;

public class VideoPage extends AppCompatActivity  {

    public static final String TAG = "===>";
    BottomSheetBehavior sheetBehavior;
    CardView cardViewUpNext;
    private AppCompatImageView upNextArrow;
    private TextViewWithFont textViewWithFont;
    private MaterialButton btnMore;
    private RecyclerView recyclerViewRelatedProducts, recyclerViewChiBeKhonam;

    private boolean isBookMarked = false;


    private ActivityVideoPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_page);

        EasyTransition.enter(VideoPage.this);

        init();
        initRecyclerRelatedProduct();
        initRecyclerChiBekhonm();
        initBottomSheet();
        expandableTextView();
    }


    private void init() {
        recyclerViewRelatedProducts = binding.contentVideoPage.recyclerRelatedProduct;
        recyclerViewChiBeKhonam = binding.contentVideoPage.recyclerChiBekhonm;
    }


    private void initBottomSheet() {

        cardViewUpNext = binding.upNextLessons.bottomSheetUpnext;
        sheetBehavior = BottomSheetBehavior.from(cardViewUpNext);
        upNextArrow = findViewById(R.id.expand_upnext);
        initRecyclerUpNext();


        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch (i) {


                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.i(TAG, "onStateChanged: state hidden");
                        break;

                    case BottomSheetBehavior.STATE_EXPANDED:
                        upNextArrow.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);

                        Log.i(TAG, "onStateChanged:   state expanded");
                        break;


                    case BottomSheetBehavior.STATE_COLLAPSED:

                        upNextArrow.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                        Log.i(TAG, "onStateChanged: state collapsed");
                        break;


                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.i(TAG, "onStateChanged: state dragging");
                        break;


                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.i(TAG, "onStateChanged:  state settling");
                        break;

                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
                        Log.i(TAG, "onStateChanged:  STATE_HALF_EXPANDED");
                        break;

                    default:
                        //TODO:// default ?
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }

    private void initRecyclerRelatedProduct() {
        HomeRecyclerAdapter adapter = new HomeRecyclerAdapter(this, R.layout.product);
        recyclerViewRelatedProducts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewRelatedProducts.setAdapter(adapter);
    }

    private void initRecyclerChiBekhonm() {
        HomeRecyclerAdapter adapter = new HomeRecyclerAdapter(this, R.layout.chi_bekhonm);
        recyclerViewChiBeKhonam.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewChiBeKhonam.setAdapter(adapter);
    }

    private void initRecyclerUpNext() {

        RecyclerView recyclerView = binding.upNextLessons.recyclerUpnext;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.canScrollVertically();
        recyclerView.setLayoutManager(linearLayoutManager);

        Adapter_shop adapter = new Adapter_shop(this, R.layout.content_recycler_videos_lessons);
        recyclerView.setAdapter(adapter);
    }

    public void onclickBack(View view) {
        onBackPressed();
    }

    public void onclickOpenUpNext(View view) {

        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            upNextArrow.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            upNextArrow.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);

        }
    }

    private void expandableTextView() {
        textViewWithFont = findViewById(R.id.description);
        btnMore = findViewById(R.id.btn_continue);

        textViewWithFont.setAnimationDuration(750L);

        // set interpolators for both expanding and collapsing animations
        textViewWithFont.setInterpolator(new OvershootInterpolator());

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMore.setIconResource(textViewWithFont.isExpanded() ? R.drawable.ic_keyboard_arrow_down_black_24dp : R.drawable.ic_keyboard_arrow_up_black_24dp);
                btnMore.setText(textViewWithFont.isExpanded() ? "ادامه ... " : "بستن");
                textViewWithFont.toggle();
            }
        });

    }

    public void goToDownloadBox(View view) {
        scrollToView(view);
    }


    private void scrollToView(View view) {
        ObjectAnimator.ofInt(binding.contentVideoPage.scrollVideoPage, "scrollY", view.getBottom()).setDuration(800).start();
    }

    public void onClickBookmark(View view) {
        isBookMarked = !isBookMarked;
        if (isBookMarked) {
            binding.contentVideoPage.btnBookmark.setImageResource(R.drawable.ic_bookmark_black_24dp);
            binding.contentVideoPage.btnBookmark.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.alaa2)));
        } else {
            binding.contentVideoPage.btnBookmark.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
            binding.contentVideoPage.btnBookmark.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.pureWhite)));
        }
    }
}
