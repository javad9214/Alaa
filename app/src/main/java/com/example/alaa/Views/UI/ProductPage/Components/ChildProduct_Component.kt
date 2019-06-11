package com.example.alaa.Views.UI.ProductPage.Components


import android.content.Context
import android.content.res.Resources
import android.graphics.Paint
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.example.alaa.Views.UI.CustomViews.MyTextView
import com.example.alaa.R
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class ChildProduct_Component(context: Context, attributeSet: AttributeSet) : CardView(context, attributeSet) {


    init {

        inflate(context, R.layout.child_product_component, this)

        val res: Resources = resources

        val title: MyTextView = findViewById(R.id.title)
        val realPrice: MyTextView = findViewById(R.id.realPrice)
        val salePrice: MyTextView = findViewById(R.id.SalePrice)
        val discount: MyTextView = findViewById(R.id.discount)

        val bracketLeft: String = res.getString(R.string.BracketLeft)
        val bracketRight: String = res.getString(R.string.BracketRight)

        val attributes = context.obtainStyledAttributes(attributeSet, R.styleable.CardProduct)

        title.text = attributes.getString(R.styleable.CardProduct_Title)
        realPrice.text = bracketLeft + setCurrency(toDouble(attributes.getString(R.styleable.CardProduct_RealPrice))) + bracketRight
        salePrice.text = setCurrency(toDouble(attributes.getString(R.styleable.CardProduct_RealPrice)))
        discount.text = res.getString(R.string.discount) + "  " + calculateDiscount(68700.0, 54500.0)



        strikeThrough(realPrice)

        attributes.recycle()
    }


    private fun strikeThrough(textView: MyTextView) {
        textView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
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
