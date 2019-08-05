package com.example.alaa.views.ui.SearchPage

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import com.example.alaa.R
import com.google.android.material.textfield.TextInputEditText

class SearchBarComponent(context: Context, attributeSet: AttributeSet) : RelativeLayout(context, attributeSet) {

    lateinit var listener: BackListener

    init {

        inflate(context, R.layout.searchbar_component, this)

        val editTextSearchBar: TextInputEditText = this.findViewById(R.id.ed_searchbar)

        val back_btn: AppCompatImageView = findViewById(R.id.btn_back)

        val attributes = context.obtainStyledAttributes(attributeSet, R.styleable.SearchBarComponent)

        editTextSearchBar.hint = attributes.getString(R.styleable.SearchBarComponent_searchbarHint)

        setFont(editTextSearchBar)

        back_btn.setOnClickListener {
            listener.onBackClicked()
        }

        attributes.recycle()
    }


    private fun setFont(editText: TextInputEditText) {

        val font: Typeface = Typeface.createFromAsset(context.assets, "Font/estedad.ttf")
        editText.typeface = font
    }


    interface BackListener {

        fun onBackClicked()
    }

    fun setOnBackClickListener(BackListener: BackListener) {
        listener = BackListener
    }
}