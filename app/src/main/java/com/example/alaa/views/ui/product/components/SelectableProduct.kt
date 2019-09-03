package com.example.alaa.views.ui.product.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.alaa.R


class SelectableProduct : CardView {

    private var _text : String? = resources.getString(R.string.app_name)
    private var _cardColor : Int = ContextCompat.getColor(context , R.color.alaa5)
    private var _textColor : Int = ContextCompat.getColor(context , R.color.pureWhite)
    private var _textSize : Float = resources.getDimension(R.dimen.textSizeDefault)
    private var _textFont : Int = 2

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {

        View.inflate(context , R.layout.selectable_product , this)

        val title: com.example.alaa.customViews.TextViewWithFont = findViewById(R.id.title)
        val realPrice: com.example.alaa.customViews.TextViewWithFont = findViewById(R.id.realPrice)
        val salePrice: com.example.alaa.customViews.TextViewWithFont = findViewById(R.id.salePrice)
        val discount: com.example.alaa.customViews.TextViewWithFont = findViewById(R.id.discountPercent)

    }


}
