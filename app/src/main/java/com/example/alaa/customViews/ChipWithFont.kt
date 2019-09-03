package com.example.alaa.customViews

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import com.example.alaa.R
import com.google.android.material.chip.Chip

class ChipWithFont(context: Context, attrs: AttributeSet) : Chip(context, attrs) {

    private val fontOrdinal: Int

    init {

        val typed: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.ChipWithFont, 0, 0)

        fontOrdinal = typed.getInt(R.styleable.ChipWithFont_MyChipFont, 0)

        setMyChipTypeFace(context)

        typed.recycle()
    }

    private fun setMyChipTypeFace(context: Context) {
        val face = FontFace.getInstance().getFontFace(context, fontOrdinal)
        this.typeface = face
    }
}