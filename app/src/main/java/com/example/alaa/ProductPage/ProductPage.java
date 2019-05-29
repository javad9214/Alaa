package com.example.alaa.ProductPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import com.example.alaa.CustomViews.MyTextView;
import com.example.alaa.HomeActivity;
import com.example.alaa.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.chip.Chip;

public class ProductPage extends AppCompatActivity {

    private MyTextView tx_realPrice , tx_realPrice2   , tx_realPrice3 , tx_realFinalPrice , tx_realPriceAllProduct ;
    private Chip btnMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

       init();


    }

    public void Onclick_dashboard(View view) {
    }

    private void init(){

        tx_realPrice = findViewById(R.id.realPrice);
        tx_realPrice2 = findViewById(R.id.realPrice2);
        tx_realPrice3 = findViewById(R.id.realPrice3);
        StrikeThrough(tx_realPrice);
        StrikeThrough(tx_realPrice2);
        StrikeThrough(tx_realPrice3);

        tx_realFinalPrice = findViewById(R.id.realFinalPrice);
        StrikeThrough(tx_realFinalPrice);

        tx_realPriceAllProduct = findViewById(R.id.realPriceAllProduct);
        StrikeThrough(tx_realPriceAllProduct);
    }

    private void StrikeThrough(MyTextView textView){

        textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
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
