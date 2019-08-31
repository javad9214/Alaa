package com.example.alaa.views.ui.productPage;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alaa.R;
import com.example.alaa.customViews.MyTextView;
import com.example.alaa.models.SampleVideoModel;
import com.example.alaa.models.SelectableProductModel;
import com.example.alaa.views.Dashboard.Adapter_shop;
import com.example.alaa.views.ui.MainActivity;
import com.example.alaa.views.ui.productPage.adapters.SampleVideoAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ProductPage extends AppCompatActivity {


    public static final String TAG = "===>";
    private MyTextView txDescribe;
    private CardView cardSampleVideo, cardIntroVideo;
    private MaterialButton btnContinue;
    private ScrollView scrollView;
    private RecyclerView recyclerViewSampleVideo, recyclerViewSampleBooklet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        init();
        expandableTextView();
        setAdapter();
    }

    private void init() {
        scrollView = findViewById(R.id.scroll_product);
        txDescribe = findViewById(R.id.description);
        btnContinue = findViewById(R.id.btn_continue);
        cardSampleVideo = findViewById(R.id.card_sample_video);
        cardIntroVideo = findViewById(R.id.intro_video);
        recyclerViewSampleVideo = findViewById(R.id.recycler_sample_videos);
        recyclerViewSampleBooklet = findViewById(R.id.recycler_sample_booklet);

    }

    private void setAdapter(){

        ArrayList<SampleVideoModel> list = new ArrayList<>();


        for (int i = 0 ; i < 5 ; i++){
            list.add(setSampleVideo());

        }

        SampleVideoAdapter adapter = new SampleVideoAdapter(list);
        recyclerViewSampleVideo.setLayoutManager(new LinearLayoutManager(this , RecyclerView.HORIZONTAL, false));
        recyclerViewSampleVideo.setAdapter(adapter);

        Adapter_shop bookletAdapter = new Adapter_shop(this , R.layout.sample_booklet);
        recyclerViewSampleBooklet.setLayoutManager(new LinearLayoutManager(this , RecyclerView.HORIZONTAL, false));
        recyclerViewSampleBooklet.setAdapter(bookletAdapter);

    }

    private SampleVideoModel setSampleVideo(){
        SampleVideoModel sampleVideoModel = new SampleVideoModel();
        sampleVideoModel.setTitle(getResources().getString(R.string.demo_title_sample_video));
        sampleVideoModel.setTeacherName(getResources().getString(R.string.demo_teacherName));

        return sampleVideoModel ;
    }

    private SelectableProductModel setSelectableProduct(){
        SelectableProductModel  productModel = new SelectableProductModel();
        productModel.setTitle(getResources().getString(R.string.titleProductItem));
        productModel.setSalePrice(getResources().getString(R.string.salePriceDemo));
        productModel.setRealPrice(getResources().getString(R.string.realPriceDemo));
        productModel.setHasChild(true);
        return productModel ;
    }


    public void onClickDashboard(View view) {
    }

    public void goHome(View view) {
        Intent intent = new Intent(ProductPage.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickAttribute(View view) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.attributes_product);
        bottomSheetDialog.show();
    }

    public void samplePhotoOnClick(View view) {
        GalleryViewFragment galleryViewFragment = new GalleryViewFragment();
        galleryViewFragment.show(getSupportFragmentManager(), galleryViewFragment.getTag());
    }

    public void scrollToDescription(View view) {
        scrollToView(cardIntroVideo);
    }

    public void scrollToSamples(View view){

        scrollToView(cardSampleVideo);
    }

    private void expandableTextView() {

        txDescribe.setAnimationDuration(750L);

        // set interpolators for both expanding and collapsing animations
        txDescribe.setInterpolator(new OvershootInterpolator());

        btnContinue.setOnClickListener(view -> {
            btnContinue.setIconResource(getIconOfContinueBtn());
            btnContinue.setText(getTextOfContinueBtn());
            txDescribe.toggle();
        });

    }

    private int getIconOfContinueBtn() {
        return txDescribe.isExpanded() ? R.drawable.ic_keyboard_arrow_down_black_24dp : R.drawable.ic_keyboard_arrow_up_black_24dp;
    }

    @NotNull
    private String getTextOfContinueBtn() {
        return txDescribe.isExpanded() ? getString(R.string.countinue) : getString(R.string.close);
    }

    private void scrollToView(CardView cardIntroVideo) {
        ObjectAnimator.ofInt(scrollView, "scrollY", cardIntroVideo.getTop() - 10).setDuration(1000).start();
    }

}
