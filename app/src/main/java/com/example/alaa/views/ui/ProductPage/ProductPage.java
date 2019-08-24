package com.example.alaa.views.ui.ProductPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alaa.R;
import com.example.alaa.customViews.MyTextView;
import com.example.alaa.models.SampleVideoModel;
import com.example.alaa.views.Dashboard.Adapter_shop;
import com.example.alaa.views.ui.MainActivity;
import com.example.alaa.views.ui.ProductPage.adapters.SampleVideoAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class ProductPage extends AppCompatActivity {


    public static final String TAG = "===>";
    private MyTextView tx_describe;
    private MaterialButton btn_continue;
    private ScrollView scrollView;
    private RecyclerView recyclerView_sample_video , recyclerView_sample_booklet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        init();
        expandableTextView();
        setAdapter();
    }

    private void init() {
        scrollView = findViewById(R.id.scrollProduct);
        tx_describe = findViewById(R.id.Description);
        btn_continue = findViewById(R.id.btn_continue);
        recyclerView_sample_video = findViewById(R.id.recycler_sample_videos);
        recyclerView_sample_booklet = findViewById(R.id.recycler_sample_booklet);
    }

    private void setAdapter(){

        ArrayList<SampleVideoModel> list = new ArrayList<>();

        for (int i = 0 ; i < 5 ; i++){
            list.add(setSampleVideo());
        }

        SampleVideoAdapter adapter = new SampleVideoAdapter(list);
        recyclerView_sample_video.setLayoutManager(new LinearLayoutManager(this , RecyclerView.HORIZONTAL, false));
        recyclerView_sample_video.setAdapter(adapter);

        Adapter_shop bookletAdapter = new Adapter_shop(this , R.layout.sample_booklet);
        recyclerView_sample_booklet.setLayoutManager(new LinearLayoutManager(this , RecyclerView.HORIZONTAL, false));
        recyclerView_sample_booklet.setAdapter(bookletAdapter);
    }

    private SampleVideoModel setSampleVideo(){
        SampleVideoModel sampleVideoModel = new SampleVideoModel();
        sampleVideoModel.setTitle(getResources().getString(R.string.demo_title_sample_video));
        sampleVideoModel.setTeacherName(getResources().getString(R.string.demo_teacherName));

        return sampleVideoModel ;
    }

    public void Onclick_dashboard(View view) {
    }

    public void GoHome(View view) {
        Intent intent = new Intent(ProductPage.this, MainActivity.class);
        startActivity(intent);
    }

    public void Onclick_Attribute(View view) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.attributes_product);
        bottomSheetDialog.show();
    }

    public void SamplePhotoOnClick(View view) {
        GalleryViewFragment galleryViewFragment = new GalleryViewFragment();
        galleryViewFragment.show(getSupportFragmentManager(), galleryViewFragment.getTag());
    }

    private void expandableTextView() {

        tx_describe.setAnimationDuration(750L);

        // set interpolators for both expanding and collapsing animations
        tx_describe.setInterpolator(new OvershootInterpolator());

        btn_continue.setOnClickListener(view -> {
            btn_continue.setIconResource(tx_describe.isExpanded() ? R.drawable.ic_keyboard_arrow_down_black_24dp : R.drawable.ic_keyboard_arrow_up_black_24dp);
            btn_continue.setText(tx_describe.isExpanded() ? "ادامه ... " : "بستن");
            tx_describe.toggle();
        });

    }

    public void ScrollToDescription(View view) {

        scrollView.smoothScrollTo(0, tx_describe.getBottom());

    }


    public void ScrollToSamples(View view){

        scrollView.smoothScrollTo(0 , recyclerView_sample_video.getBottom());
    }

}
