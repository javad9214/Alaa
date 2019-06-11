package com.example.alaa.Views.UI.SearchPage

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView
import com.example.alaa.R
import com.google.android.material.textfield.TextInputEditText


class SearchBar_Component (context: Context , attributeSet: AttributeSet) : CardView(context , attributeSet){

    init {

        View.inflate(context , R.layout.searchbar_component , this)

        val editText_searchbar : TextInputEditText = findViewById(R.id.ed_searchbar)

        val attributes = context.obtainStyledAttributes(attributeSet ,R.styleable.SearchBar_Component )

        editText_searchbar.hint = attributes.getString(R.styleable.SearchBar_Component_searchbarHint)
    }
}