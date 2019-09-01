package com.example.alaa.views.ui.product.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.alaa.R
import java.text.NumberFormat
import java.util.*

class MainProductComponent (context: Context, attr : AttributeSet) : CardView(context , attr){

        private val photoProduct : ImageView

        init {
            View.inflate(context , R.layout.main_product_component , this)


            val title: com.example.alaa.custom_views.TextViewWithFont = findViewById(R.id.tx_title_product)
            // val discount : TextViewWithCardBackground = findViewById(R.id.discountPercent)
            photoProduct  = findViewById(R.id.thumbnail_product_photo)


            val attributes = context.obtainStyledAttributes(attr , R.styleable.MainProductComponent)

           // val discountText =  res.getString(R.string.discount) + "  " +  calculateDiscount(97600.0, 24300.0 )
            title.text = attributes.getString(R.styleable.MainProductComponent_title_mainProduct)


           // discount.setText(discountText)




            attributes.recycle()

        }




    private fun calculateDiscount(realPrice: Double , salePrice: Double): String {

        val discount: Double  = 1 - (salePrice / realPrice)

        val format: NumberFormat = NumberFormat.getPercentInstance(Locale.US)

        return format.format(discount)
    }


    fun setPicture(resId: Int) {
        photoProduct.setImageResource(resId)
    }

}