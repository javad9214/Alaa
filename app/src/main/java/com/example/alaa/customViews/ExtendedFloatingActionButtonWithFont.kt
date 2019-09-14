package com.example.alaa.customViews

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import com.example.alaa.R
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class ExtendedFloatingActionButtonWithFont(context: Context, attrs: AttributeSet) : ExtendedFloatingActionButton(context, attrs) {

    private val fontOrdinal: Int


    init {

        val typed: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.ExtendedFloatingActionButtonWithFont, 0, 0)

        fontOrdinal = typed.getInt(R.styleable.ExtendedFloatingActionButtonWithFont_MyExtendedButtonFont, 2)

        setMyButtonTypeFace(context)

        typed.recycle()
    }

    private fun setMyButtonTypeFace(context: Context) {
        val face = FontFace.getInstance().getFontFace(context, fontOrdinal)
        this.typeface = face
    }
}