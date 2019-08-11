package com.example.alaa.views.ui.ProductPage.Components

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

        val realPrice : com.example.alaa.customViews.MyTextView = findViewById(R.id.realFinalPrice)
        val salePrice : com.example.alaa.customViews.MyTextView = findViewById(R.id.finalSalePrice)


        val bracketLeft: String = res.getString(R.string.BracketLeft)
        val bracketRight: String = res.getString(R.string.BracketRight)

        val attributes = context.obtainStyledAttributes(attributeSet , R.styleable.TotalPriceComponent)

        isDiscounted = attributes.getBoolean(R.styleable.TotalPriceComponent_isDiscounted , false)
        val realPriceSize = attributes.getDimension(R.styleable.TotalPriceComponent_realPriceSize , 18F)
        val salePriceSize = attributes.getDimension(R.styleable.TotalPriceComponent_realPriceSize , 21F)

        Log.i(TAG , salePriceSize.toString())

        if (!isDiscounted) realPrice.visibility = View.GONE else View.VISIBLE

        realPrice.text =  bracketLeft + setCurrency(toDouble(attributes.getString(R.styleable.TotalPriceComponent_finalRealPrice))) + bracketRight
        salePrice.text =  setCurrency(toDouble(attributes.getString(R.styleable.TotalPriceComponent_finalSalePrice))) + " " +  res.getString(R.string.Toman)

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