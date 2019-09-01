package com.example.alaa.views.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alaa.R;
import com.example.alaa.customViews.TextViewWithFont;
import com.example.alaa.views.dashboard.Adapter_shop;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.hzn.lib.EasyTransition;

public class VideoPage extends AppCompatActivity  {

    public static final String TAG = "===>";
    BottomSheetBehavior sheetBehavior;
    CardView cardView_upNext;
    private AppCompatImageView upNext_arrow;
    private RecyclerView recyclerView;
    private TextViewWithFont textViewWithFont;
    private MaterialButton btnMore;
    private MaterialButton btn_bookmark, btn_download, btn_share;


    private boolean isBookMarked ;
    private boolean isDownloadCompleted ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_page);

        EasyTransition.enter(VideoPage.this);


        init_bottomSheet();
        expandableTextView();
    }




    private void init_bottomSheet() {

        cardView_upNext = findViewById(R.id.bottom_sheet_upnext);
        sheetBehavior = BottomSheetBehavior.from(cardView_upNext);
        upNext_arrow = findViewById(R.id.expand_upnext);
        init_recycler();


        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch (i) {


                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.i(TAG, "onStateChanged: state hidden");
                        break;

                    case BottomSheetBehavior.STATE_EXPANDED:
                        upNext_arrow.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);

                        Log.i(TAG, "onStateChanged:   state expanded");
                        break;


                    case BottomSheetBehavior.STATE_COLLAPSED:

                        upNext_arrow.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
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

    private void init_recycler() {

        recyclerView = findViewById(R.id.recycler_upnext);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.canScrollVertically();
        recyclerView.setLayoutManager(linearLayoutManager);

        Adapter_shop adapter = new Adapter_shop(this, R.layout.content_recycler_more);
        recyclerView.setAdapter(adapter);
    }

    public void onclick_back(View view) {
        onBackPressed();
    }

    public void onclick_open_upnext(View view) {

        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            upNext_arrow.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            upNext_arrow.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);

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


}
