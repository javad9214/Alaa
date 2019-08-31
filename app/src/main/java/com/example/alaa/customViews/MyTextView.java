package com.example.alaa.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.example.alaa.R;

import at.blogc.android.views.ExpandableTextView;


public class MyTextView extends ExpandableTextView  {



    public MyTextView(Context context) {
        super(context);
    }

    private boolean isStrikeThrough = false ;

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.MyTextView, 0, 0);


        isStrikeThrough = a.getBoolean( R.styleable.MyTextView_strikeThrough , false);
        if (isStrikeThrough) strikeThrough();

        int fontOrdinal = a.getInt(R.styleable.MyTextView_MyTextViewFont, 0);
        a.getIndexCount();

        Typeface face;


        switch (fontOrdinal) {


            case 1:
                face = Typeface.createFromAsset(context.getAssets(), "Font/IRANSansMobile_Light.ttf");
                this.setTypeface(face);
                break;

            case 2:
                face = Typeface.createFromAsset(context.getAssets(), "Font/IRANSansMobile_Medium.ttf");
                this.setTypeface(face);
                break;

            case 3:
                face = Typeface.createFromAsset(context.getAssets(), "Font/IRANSansMobile_Bold.ttf");
                this.setTypeface(face);
                break;

            case 4:
                face = Typeface.createFromAsset(context.getAssets(), "Font/IRANSansMobile_UltraLight.ttf");
                this.setTypeface(face);
                break;

            case 5:
                face = Typeface.createFromAsset(context.getAssets(), "Font/IRANSansMobile_Light-4.1.ttf");
                this.setTypeface(face);
                break;

            case 6:
                face = Typeface.createFromAsset(context.getAssets(), "Font/BSara.ttf");
                this.setTypeface(face);
                break;


            case 7:
                face = Typeface.createFromAsset(context.getAssets(), "Font/shabnam_light.ttf");
                this.setTypeface(face);
                break;


            case 8:
                face = Typeface.createFromAsset(context.getAssets(), "Font/estedad.ttf");
                this.setTypeface(face);
                break;



            case 9:
                face = Typeface.createFromAsset(context.getAssets(), "Font/Suls.ttf");
                this.setTypeface(face);
                break;



            case 10:
                face = Typeface.createFromAsset(context.getAssets(), "Font/Shekasteh.ttf");
                this.setTypeface(face);
                break;


            case 11 :
                face = Typeface.createFromAsset(context.getAssets() , "Font/IRANSansMobile(FaNum).ttf");
                this.setTypeface(face);
                break;


            case 12 :
                face = Typeface.createFromAsset(context.getAssets() , "Font/IRANSansMobile(FaNum)_Bold.ttf");
                this.setTypeface(face);
                break;

            case 13 :
                face = Typeface.createFromAsset(context.getAssets() , "Font/IRANSansMobile(FaNum)_Light.ttf");
                this.setTypeface(face);
                break;

            case 14 :
                face = Typeface.createFromAsset(context.getAssets() , "Font/IRANSansMobile(FaNum)_Medium.ttf");
                this.setTypeface(face);
                break;


            case 15 :
                face = Typeface.createFromAsset(context.getAssets() , "Font/IRANSansMobile(FaNum)_UltraLight.ttf");
                this.setTypeface(face);
                break;



            case 16 :
                face = Typeface.createFromAsset(context.getAssets() , "Font/Mali_BoldItalic.ttf");
                this.setTypeface(face);
                break;

            case 17 :
                face = Typeface.createFromAsset(context.getAssets() , "Font/RubikMonoOne_Regular.ttf");
                this.setTypeface(face);
                break;

            case 18 :
                face = Typeface.createFromAsset(context.getAssets() , "Font/Dima.ttf");
                this.setTypeface(face);
                break;
        }
        a.recycle();


    }


    private void strikeThrough (){
        this.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
