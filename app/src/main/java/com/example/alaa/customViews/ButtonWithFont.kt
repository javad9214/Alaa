package com.example.alaa.customViews

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import com.example.alaa.R
import com.google.android.material.button.MaterialButton

open class ButtonWithFont(context: Context, attrs: AttributeSet) : MaterialButton(context, attrs) {

    private val fontOrdinal: Int


    init {

        val typed: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.ButtonWithFont, 0, 0)

        fontOrdinal = typed.getInt(R.styleable.ButtonWithFont_MyButtonFont, 2)

        setMyButtonTypeFace(context)

        typed.recycle()
    }

    private fun setMyButtonTypeFace(context: Context) {
        val face = FontFace.getInstance().getFontFace(context, fontOrdinal)
        this.typeface = face
    }

}


