package com.example.alaa.Views.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.example.alaa.Views.UI.CustomViews.MyTextView;
import com.example.alaa.Views.Dashboard.Adapter_shop;
import com.example.alaa.Views.Dashboard.DashboardFragment;
import com.example.alaa.R;
import com.example.alaa.Views.Teacher.Dashboard_Teacher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.hzn.lib.EasyTransition;

public class VideoPage extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "===>";
    BottomSheetBehavior sheetBehavior;
    CardView cardView_upNext;
    private AppCompatImageView upNext_arrow;
    private RecyclerView recyclerView;
    private MyTextView myTextView;
    private MaterialButton btnMore;
    private MaterialButton btn_bookmark, btn_download, btn_share;


    private boolean isBookMarked ;
    private boolean isDownloadCompleted ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_page);

        EasyTransition.enter(VideoPage.this);

        initButtons();
        init_bottomSheet();
        expandableTextView();
    }


    private void initButtons() {
        btn_bookmark = findViewById(R.id.btn_bookmark);
        btn_download = findViewById(R.id.btn_download);
        btn_share = findViewById(R.id.btn_share);


        btn_bookmark.setOnClickListener(this);
        btn_share.setOnClickListener(this);
        btn_download.setOnClickListener(this);

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

    public void Onclick_dashboard(View view) {
        DashboardFragment dashboardFragment = new DashboardFragment();
        dashboardFragment.show(getSupportFragmentManager(), dashboardFragment.getTag());
    }

    public void onclick_back(View view) {
        onBackPressed();
    }

    public void onclick_teacher(View view) {
        Dashboard_Teacher dashboard_teacher = new Dashboard_Teacher();
        dashboard_teacher.show(getSupportFragmentManager(), dashboard_teacher.getTag());
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


        myTextView = findViewById(R.id.Description);
        btnMore = findViewById(R.id.viewMore);

        myTextView.setAnimationDuration(750L);

        // set interpolators for both expanding and collapsing animations
        myTextView.setInterpolator(new OvershootInterpolator());

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMore.setIconResource(myTextView.isExpanded() ? R.drawable.ic_keyboard_arrow_down_black_24dp : R.drawable.ic_keyboard_arrow_up_black_24dp);
                btnMore.setText(myTextView.isExpanded() ? "ادامه ... " : "بستن");
                myTextView.toggle();
            }
        });

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_bookmark:
                btn_bookmark.setIconResource(isBookMarked ? R.drawable.ic_bookmark_plus : R.drawable.ic_bookmark_done);
                btn_bookmark.setBackgroundTintList(isBookMarked ? this.getResources().getColorStateList(android.R.color.transparent) : this.getResources().getColorStateList(R.color.alaa0));
                isBookMarked = !isBookMarked ;
                break;


            case R.id.btn_download:
                btn_download.setIconResource(isDownloadCompleted ? R.drawable.ic_download : R.drawable.ic_download_finish);
                btn_download.setBackgroundTintList(isDownloadCompleted ? this.getResources().getColorStateList(android.R.color.transparent) : this.getResources().getColorStateList(R.color.alaa0));
                isDownloadCompleted = !isDownloadCompleted ;
                break;


            case R.id.btn_share:
                break;

        }

    }
}
