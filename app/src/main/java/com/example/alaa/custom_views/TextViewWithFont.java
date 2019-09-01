package com.example.alaa.custom_views;

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
public class TextViewWithFont extends ExpandableTextView {
    int fontOrdinal;

    public TextViewWithFont(Context context) {
        super(context);
    }

    public TextViewWithFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.TextViewWithFont, 0, 0);
        fontOrdinal = a.getInt(R.styleable.TextViewWithFont_MyTextViewFont, 0);
        if (isStrikeThrough(a)) {
            strikeThrough();
        }
        setMyTextViewTypeFace(context);
        a.recycle();
    }

    private boolean isStrikeThrough(TypedArray a) {
        return a.getBoolean(R.styleable.TextViewWithFont_strikeThrough, false);
    }

    private void strikeThrough() {
        this.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    private void setMyTextViewTypeFace(Context context) {
        Typeface face = FontFace.getInstance().getFontFace(context, fontOrdinal);
        this.setTypeface(face);
    }


}
