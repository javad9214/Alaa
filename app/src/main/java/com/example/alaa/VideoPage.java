package com.example.alaa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.alaa.Dashboard.Adapter_shop;
import com.example.alaa.Dashboard.DashboardFragment;
import com.example.alaa.Dashboard.TabAdapter;
import com.example.alaa.Teacher.Dashboard_Teacher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class VideoPage extends AppCompatActivity {

    public static final String TAG = "===>" ;
    BottomSheetBehavior sheetBehavior;
    CardView cardView_upnext;
    private AppCompatImageView upnext_arrow ;
    private RecyclerView recyclerView ;
    private TabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_page);

        init_bottomSheet();
    }


    private void init_bottomSheet() {

        cardView_upnext = findViewById(R.id.bottom_sheet_upnext);
        sheetBehavior = BottomSheetBehavior.from(cardView_upnext);
        upnext_arrow  = findViewById(R.id.expand_upnext);
        init_recycler();


        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch (i) {


                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.i(TAG, "onStateChanged: state hidden");
                        break;

                    case BottomSheetBehavior.STATE_EXPANDED:
                        upnext_arrow.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                        Log.i(TAG, "onStateChanged:   state expanded");
                        break;


                    case BottomSheetBehavior.STATE_COLLAPSED:

                        upnext_arrow.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
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

    private void init_recycler(){

        recyclerView = findViewById(R.id.recycler_upnext);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.canScrollVertically();
        recyclerView.setLayoutManager(linearLayoutManager);

        Adapter_shop adapter = new Adapter_shop(this , R.layout.content_recycler_more);
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
            upnext_arrow.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            upnext_arrow.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);

        }
    }
}
