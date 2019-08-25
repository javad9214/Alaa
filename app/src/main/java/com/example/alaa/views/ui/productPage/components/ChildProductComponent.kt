package com.example.alaa.views.ui.productPage.components


import android.content.Context
import android.content.res.Resources
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView
import com.example.alaa.R
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class ChildProductComponent(context: Context, attributeSet: AttributeSet) : CardView(context, attributeSet) {



    init {

        View.inflate(context, R.layout.child_product_component, this)

        val res: Resources = resources

        val title: com.example.alaa.customViews.MyTextView = findViewById(R.id.tx_title_product)
        val realPrice: com.example.alaa.customViews.MyTextView = findViewById(R.id.realPrice)
        val salePrice: com.example.alaa.customViews.MyTextView = findViewById(R.id.salePrice)
        val discount: com.example.alaa.customViews.MyTextView = findViewById(R.id.discountPercent)



        val attributes = context.obtainStyledAttributes(attributeSet , R.styleable.ChildProductComponent)

        val realPriceText = setCurrency(toDouble(attributes.getString(R.styleable.ChildProductComponent_realPrice_childProduct))) + " " +  res.getString(R.string.Toman)
        val salePriceText = setCurrency(toDouble(attributes.getString(R.styleable.ChildProductComponent_salePrice_childProduct))) + " " +  res.getString(R.string.Toman)
        val discountText =  res.getString(R.string.discount) + "  " +  calculateDiscount(97600.0, 24300.0 )
        title.text = attributes.getString(R.styleable.ChildProductComponent_discount_childProduct)
        realPrice.text =  realPriceText
        salePrice.text =  salePriceText

        discount.text = discountText



        strikeThrough(realPrice)

        attributes.recycle()
    }


    private fun strikeThrough(textView: com.example.alaa.customViews.MyTextView) {
        textView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    }

    private fun calculateDiscount(realPrice: Double, salePrice: Double): String {

        val discount: Double = 1 - (salePrice / realPrice)

        val format: NumberFormat = NumberFormat.getPercentInstance(Locale.US)

        return format.format(discount)
    }

    private fun setCurrency(price: Double?): String {

        val format = DecimalFormat("###,###,###")

        return format.format(price)
    }

    private fun toDouble(string: String?): Double? {

        return string?.toDouble()
    }


}
