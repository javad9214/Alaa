package com.example.alaa.ProductPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ScrollView;

import com.example.alaa.CustomViews.MyTextView;
import com.example.alaa.HomeActivity;
import com.example.alaa.ProductPage.customViews.CardParentProduct;
import com.example.alaa.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;

public class ProductPage extends AppCompatActivity {


    public static final String TAG = "===>";
    private MyTextView tx_describe;
    private MaterialButton btn_continue;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        init();
        expandableTextView();
    }

    private void init() {
        scrollView = findViewById(R.id.scrollProduct);
        tx_describe = findViewById(R.id.Description);
        btn_continue = findViewById(R.id.btn_continue);
    }

    public void Onclick_dashboard(View view) {
    }

    public void GoHome(View view) {
        Intent intent = new Intent(ProductPage.this, HomeActivity.class);
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

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_continue.setIconResource(tx_describe.isExpanded() ? R.drawable.ic_keyboard_arrow_down_black_24dp : R.drawable.ic_keyboard_arrow_up_black_24dp);
                btn_continue.setText(tx_describe.isExpanded() ? "ادامه ... " : "بستن");
                tx_describe.toggle();
            }
        });

    }

    public void ScrollToDescription(View view) {

        Log.i(TAG, "ScrollToDescription: " + tx_describe.getTop() + tx_describe.getBottom());
        scrollView.smoothScrollTo(0, tx_describe.getBottom());

    }

}
