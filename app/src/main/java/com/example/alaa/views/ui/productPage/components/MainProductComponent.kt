package com.example.alaa.views.ui.productPage.components

import android.content.Context
import android.content.res.Resources
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.alaa.R
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class MainProductComponent (context: Context, attr : AttributeSet) : CardView(context , attr){

        private val photoProduct : ImageView

        init {
            View.inflate(context , R.layout.main_product_component , this)

            val  res : Resources = resources

            val  title : com.example.alaa.customViews.MyTextView = findViewById(R.id.tx_title_product)
            val realPrice : com.example.alaa.customViews.MyTextView = findViewById(R.id.realPrice)
            val salePrice : com.example.alaa.customViews.MyTextView = findViewById(R.id.salePrice)
            val discount : com.example.alaa.customViews.MyTextView = findViewById(R.id.discountPercent)
            photoProduct  = findViewById(R.id.thumbnail_product_photo)


            val attributes = context.obtainStyledAttributes(attr , R.styleable.MainProductComponent)

           // val realPriceText = setCurrency(toDouble(attributes.getString(R.styleable.MainProductComponent_realPrice_mainProduct))) + " " +  res.getString(R.string.Toman)
           // val salePriceText = setCurrency(toDouble(attributes.getString(R.styleable.MainProductComponent_salePrice_mainProduct))) + " " +  res.getString(R.string.Toman)

            val realPriceText = attributes.getString(R.styleable.MainProductComponent_realPrice_mainProduct)
            val salePriceText = attributes.getString(R.styleable.MainProductComponent_salePrice_mainProduct)

            val discountText =  res.getString(R.string.discount) + "  " +  calculateDiscount(97600.0, 24300.0 )
            title.text = attributes.getString(R.styleable.MainProductComponent_title_mainProduct)
            realPrice.text =  realPriceText
            salePrice.text =  salePriceText

            discount.text = discountText


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


    private fun setCurrency (price : Double?) : String {

        val  format = DecimalFormat("###,###,###")

        return format.format(price)
    }

    private fun toDouble(string: String?): Double? {

        return string?.toDouble()
    }

    public fun setPicture (resId :Int){
        photoProduct.setImageResource(resId)
    }

}