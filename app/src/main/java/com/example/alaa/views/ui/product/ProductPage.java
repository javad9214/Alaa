package com.example.alaa.views.ui.product;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alaa.R;
import com.example.alaa.customViews.TextViewWithFont;
import com.example.alaa.databinding.ActivityProductPageBinding;
import com.example.alaa.models.SampleVideoModel;
import com.example.alaa.models.SelectableProductModel;
import com.example.alaa.views.ui.MainActivity;
import com.example.alaa.views.ui.dashboard.Adapter_shop;
import com.example.alaa.views.ui.product.adapters.SampleVideoAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @author Alaaa2
 */
public class ProductPage extends AppCompatActivity {


    public static final String TAG = "===>";
    private TextViewWithFont txDescribe;
    private MaterialButton btnContinue;
    private RecyclerView recyclerViewSampleVideo, recyclerViewSampleBooklet;

    private ActivityProductPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_page);

        init();
        expandableTextView();
        setAdapter();
    }

    private void init() {
        txDescribe = findViewById(R.id.description);
        btnContinue = findViewById(R.id.btn_continue);
        recyclerViewSampleVideo = binding.contentProductPage.recyclerSampleVideos;
        recyclerViewSampleBooklet = binding.contentProductPage.recyclerSampleBooklet;

    }

    private void setAdapter(){

        ArrayList<SampleVideoModel> list = new ArrayList<>();


        for (int i = 0; i < 5; i++) {
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
        scrollToView(binding.contentProductPage.introVideo);
    }

    public void scrollToSamples(View view){
        scrollToView(binding.contentProductPage.cardSampleVideo);
    }

    private void expandableTextView() {

        txDescribe.setAnimationDuration(750L);

        // set interpolator for both expanding and collapsing animations
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

    private void scrollToView(View cardIntroVideo) {
        ObjectAnimator.ofInt(binding.contentProductPage.scrollProduct, "scrollY", cardIntroVideo.getTop() - 10).setDuration(1000).start();
    }

}
