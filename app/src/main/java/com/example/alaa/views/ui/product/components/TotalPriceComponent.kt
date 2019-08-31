package com.example.alaa.views.ui.product.components

import android.content.Context
import android.content.res.Resources
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.cardview.widget.CardView
import com.example.alaa.R
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class TotalPriceComponent (context: Context, attributeSet: AttributeSet) : CardView(context , attributeSet){

    private var isDiscounted = false
    private val TAG = "TotalPrice"

    init {
        View.inflate(context , R.layout.total_price_component , this)

        val  res : Resources = resources

        val realPrice : com.example.alaa.customViews.MyTextView = findViewById(R.id.realPrice)
        val salePrice : com.example.alaa.customViews.MyTextView = findViewById(R.id.salePrice)

        val attributes = context.obtainStyledAttributes(attributeSet , R.styleable.TotalPriceComponent)

        isDiscounted = attributes.getBoolean(R.styleable.TotalPriceComponent_isDiscounted , false)
        val realPriceSize = attributes.getDimension(R.styleable.TotalPriceComponent_realPriceSize , 12F)
        val salePriceSize = attributes.getDimension(R.styleable.TotalPriceComponent_realPriceSize , 14F)

        Log.i(TAG , salePriceSize.toString())

        if (!isDiscounted) realPrice.visibility = View.GONE else View.VISIBLE

        val realPriceText = setCurrency(toDouble(attributes.getString(R.styleable.TotalPriceComponent_finalRealPrice).toString())) + " " +  res.getString(R.string.Toman)
        val salePriceText = setCurrency(toDouble(attributes.getString(R.styleable.TotalPriceComponent_finalSalePrice).toString())) + " " +  res.getString(R.string.Toman)

        realPrice.text =  realPriceText
        salePrice.text =  salePriceText

        realPrice.textSize = realPriceSize
        salePrice.textSize = salePriceSize


        strikeThrough(realPrice)

        attributes.recycle()
    }


    private fun strikeThrough(textView: com.example.alaa.customViews.MyTextView) {
        textView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    }


    private fun calculateDiscount(realPrice: Double , salePrice: Double): String {

        val discount: Double  = 1 - (salePrice / realPrice)

        val format: NumberFormat = NumberFormat.getPercentInstance(Locale.US)

        return format.format(discount)
    }


    private fun setCurrency (price : Double) : String {

        val  format = DecimalFormat("###,###,###")

        return format.format(price)
    }

    private fun toDouble(string: String): Double {

        return string.toDouble()
    }
}