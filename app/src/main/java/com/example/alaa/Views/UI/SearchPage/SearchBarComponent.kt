package com.example.alaa.Views.UI.SearchPage

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.alaa.R
import com.google.android.material.textfield.TextInputEditText


class SearchBarComponent (context: Context, attributeSet: AttributeSet) : RelativeLayout(context , attributeSet){

    init {

        View.inflate(context , R.layout.searchbar_component , this)

        val editTextSearchBar : TextInputEditText = findViewById(R.id.ed_searchbar)

        val attributes = context.obtainStyledAttributes(attributeSet ,R.styleable.SearchBarComponent )

        editTextSearchBar.hint = attributes.getString(R.styleable.SearchBarComponent_searchbarHint)

        setFont(editTextSearchBar)


        attributes.recycle()
    }


    private fun setFont (editText: TextInputEditText ){

        val font : Typeface = Typeface.createFromAsset(context.assets , "Font/estedad.ttf")
        editText.typeface = font
    }


}