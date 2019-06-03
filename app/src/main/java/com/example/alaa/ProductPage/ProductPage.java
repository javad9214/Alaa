package com.example.alaa.ProductPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import com.example.alaa.CustomViews.MyTextView;
import com.example.alaa.HomeActivity;
import com.example.alaa.ProductPage.customViews.CardParentProduct;
import com.example.alaa.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.chip.Chip;

public class ProductPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

    }

    public void Onclick_dashboard(View view) {
    }


    public void GoHome(View view) {
        Intent intent = new Intent(ProductPage.this , HomeActivity.class);
        startActivity(intent);
    }

    public void Onclick_Attribute(View view) {
        BottomSheetDialog bottomSheetDialog =  new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.attributes_product);
        bottomSheetDialog.show();
    }

    public void SamplePhotoOnClick(View view){
        GalleryViewFragment galleryViewFragment = new GalleryViewFragment();
        galleryViewFragment.show(getSupportFragmentManager() , galleryViewFragment.getTag());
    }



}
