package com.example.alaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.example.alaa.CustomViews.MyTextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProductPage extends AppCompatActivity {

    private MyTextView myTextView;
    private Chip btnMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

       init();
      // expandableTextView();

    }

    public void Onclick_dashboard(View view) {
    }

    private void init(){

       // myTextView = findViewById(R.id.text1);
    }

    private void expandableTextView() {


        //btnMore = findViewById(R.id.viewMore);

        myTextView.setAnimationDuration(750L);

        // set interpolators for both expanding and collapsing animations
        myTextView.setInterpolator(new OvershootInterpolator());

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMore.setChipIconResource(myTextView.isExpanded() ? R.drawable.ic_keyboard_arrow_down_black_24dp : R.drawable.ic_keyboard_arrow_up_black_24dp);
                btnMore.setText(myTextView.isExpanded() ? "ادامه ... " : "بستن");
                myTextView.toggle();
            }
        });

    }

}
