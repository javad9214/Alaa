package com.example.alaa.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.example.alaa.R;

import at.blogc.android.views.ExpandableTextView;


/**
 * @author Alaaa2
 */
public class MyTextView extends ExpandableTextView  {

    String[] fontFace = new String[]{
            "Font/IRANSansMobile_Light.ttf",
            "Font/IRANSansMobile_Medium.ttf",
            "Font/IRANSansMobile_Bold.ttf",
            "Font/IRANSansMobile_UltraLight.ttf",
            "Font/IRANSansMobile_Light-4.1.ttf",
            "Font/BSara.ttf",
            "Font/shabnam_light.ttf",
            "Font/estedad.ttf",
            "Font/Suls.ttf",
            "Font/Shekasteh.ttf",
            "Font/IRANSansMobile(FaNum).ttf",
            "Font/IRANSansMobile(FaNum)_Bold.ttf",
            "Font/IRANSansMobile(FaNum)_Light.ttf",
            "Font/IRANSansMobile(FaNum)_Medium.ttf",
            "Font/IRANSansMobile(FaNum)_UltraLight.ttf",
            "Font/Mali_BoldItalic.ttf",
            "Font/RubikMonoOne_Regular.ttf",
            "Font/Dima.ttf"
    };

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.MyTextView, 0, 0);
        if (isStrikeThrough(a)) {
            strikeThrough();
        }
        a.getIndexCount();
        setMyTextViewTypeFace(context, a);
        a.recycle();
    }

    private void setMyTextViewTypeFace(Context context, TypedArray a) {
        int fontFaceIndex = getFontFaceIndex(a);
        Typeface face = Typeface.createFromAsset(context.getAssets(), fontFace[fontFaceIndex]);
        this.setTypeface(face);
    }

    private boolean isStrikeThrough(TypedArray a) {
        return a.getBoolean(R.styleable.MyTextView_strikeThrough, false);
    }

    private int getFontFaceIndex(TypedArray a) {
        int fontOrdinal = a.getInt(R.styleable.MyTextView_MyTextViewFont, 0);
        return ( (fontOrdinal - 1) >= 0 && fontOrdinal <= fontFace.length ) ? fontOrdinal - 1 : 0;
    }


    private void strikeThrough (){
        this.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
