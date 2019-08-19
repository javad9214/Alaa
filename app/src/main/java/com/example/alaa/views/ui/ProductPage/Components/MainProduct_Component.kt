package com.example.alaa.views.ui.ProductPage.Components

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

class MainProduct_Component (context: Context, attr : AttributeSet) : CardView(context , attr){

        private val photoProduct : ImageView

        init {
            View.inflate(context , R.layout.main_product_component , this)

            val  res : Resources = resources

            val  title : com.example.alaa.customViews.MyTextView = findViewById(R.id.tx_title_product)
            val realPrice : com.example.alaa.customViews.MyTextView = findViewById(R.id.realPrice)
            val salePrice : com.example.alaa.customViews.MyTextView = findViewById(R.id.salePrice)
            val discount : com.example.alaa.customViews.MyTextView = findViewById(R.id.discountPercent)
            photoProduct  = findViewById(R.id.thumbnail_product_photo)

            val bracketLeft: String = res.getString(R.string.BracketLeft)
            val bracketRight: String = res.getString(R.string.BracketRight)

            val attributes = context.obtainStyledAttributes(attr , R.styleable.CardProduct)


            title.text = attributes.getString(R.styleable.CardProduct_Title)
            realPrice.text =  bracketLeft + setCurrency(toDouble(attributes.getString(R.styleable.CardProduct_RealPrice)))  + bracketRight + " " + res.getString(R.string.Toman)
            salePrice.text =  setCurrency(toDouble(attributes.getString(R.styleable.CardProduct_salePrice))) + " " +  res.getString(R.string.Toman)
            discount.text =  res.getString(R.string.discount) + "  " +  calculateDiscount(97600.0, 24300.0 )



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

    public fun setPicture (resId :Int){
        photoProduct.setImageResource(resId)
    }

}