package com.example.alaa.customViews

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import com.example.alaa.R
import com.google.android.material.textfield.TextInputEditText

class EditTextWithFont(context: Context, attrs: AttributeSet) : TextInputEditText(context, attrs) {

    private val fontOrdinal: Int


    init {

        val typed: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.EditTextWithFont, 0, 0)

        fontOrdinal = typed.getInt(R.styleable.EditTextWithFont_EditTextFont, 2)

        setEditTextTypeFace(context)

        typed.recycle()
    }

    private fun setEditTextTypeFace(context: Context) {
        val face = FontFace.getInstance().getFontFace(context, fontOrdinal)
        this.typeface = face
    }


}