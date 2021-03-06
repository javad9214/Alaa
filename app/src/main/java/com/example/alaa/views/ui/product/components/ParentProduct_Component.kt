package com.example.alaa.views.ui.product.components

import android.content.Context
import android.content.res.Resources
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class ParentProduct_Component (context: Context , attributeSet: AttributeSet) : CardView(context , attributeSet) {



    init {

        View.inflate(context , R.layout.parent_product_component , this)

        val res : Resources = resources

        val title: com.example.alaa.customViews.TextViewWithFont = findViewById(R.id.title_parent)
        val realPrice: com.example.alaa.customViews.TextViewWithFont = findViewById(R.id.realPrice_parent)
        val salePrice: com.example.alaa.customViews.TextViewWithFont = findViewById(R.id.finalPrice_parent)
        val discount: com.example.alaa.customViews.TextViewWithFont = findViewById(R.id.discount_parent)

        val childProduct_recycler : RecyclerView = findViewById(R.id.childProduct_recycler)

        val bracketLeft: String = res.getString(R.string.BracketLeft)
        val bracketRight: String = res.getString(R.string.BracketRight)

        val attributes = context.obtainStyledAttributes(attributeSet, R.styleable.MainProductComponent)

        title.text = attributes.getString(R.styleable.MainProductComponent_title_mainProduct)
        //TODO:// handle
        realPrice.text = bracketLeft + setCurrency(toDouble(attributes.getString(R.styleable.MainProductComponent_realPrice_mainProduct).toString())) + bracketRight
        salePrice.text = setCurrency(toDouble(attributes.getString(R.styleable.MainProductComponent_realPrice_mainProduct).toString()))
        discount.text = res.getString(R.string.discount) + "  " + calculateDiscount(68700.0, 54500.0)

        strikeThrough(realPrice)

        attributes.recycle()

    }


    private fun strikeThrough(textViewWithFont: com.example.alaa.customViews.TextViewWithFont) {
        textViewWithFont.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    }

    private fun calculateDiscount(realPrice: Double, salePrice: Double): String {

        val discount: Double = 1 - (salePrice / realPrice)

        val format: NumberFormat = NumberFormat.getPercentInstance(Locale.US)

        return format.format(discount)
    }

    private fun setCurrency(price: Double): String {

        val format = DecimalFormat("###,###,###")

        return format.format(price)
    }

    private fun toDouble(string: String): Double {

        return string.toDouble()
    }
}