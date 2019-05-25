package com.example.alaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.example.alaa.CustomViews.MyTextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProductPage extends AppCompatActivity {

    private MyTextView tx_realPrice , tx_realFinalPrice;
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
        StrikeThrough(tx_realPrice);

        tx_realFinalPrice =findViewById(R.id.realFinalPrice);
        StrikeThrough(tx_realFinalPrice);
    }

    private void StrikeThrough(MyTextView textView){

        textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    public void GoHome(View view) {
        Intent intent = new Intent(ProductPage.this , MainActivity.class);
        startActivity(intent);
    }
}
