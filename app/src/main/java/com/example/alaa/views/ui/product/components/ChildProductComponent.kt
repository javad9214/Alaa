package com.example.alaa.views.ui.product.components


import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.customViews.TextViewWithCardBackground
import com.example.alaa.models.SelectableProductModel
import com.example.alaa.views.ui.product.adapters.SelectableProductAdapter
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class ChildProductComponent(context: Context, attributeSet: AttributeSet) : ConstraintLayout(context, attributeSet) {

    private var recycler: RecyclerView

    init {

        View.inflate(context, R.layout.child_product_component, this)


        val title: com.example.alaa.customViews.TextViewWithFont = findViewById(R.id.tx_title_product)
        val realPrice: com.example.alaa.customViews.TextViewWithFont = findViewById(R.id.realPrice)
        val salePrice: TextViewWithCardBackground = findViewById(R.id.salePrice)

        //  val discount: com.example.alaa.customViews.TextViewWithFont = findViewById(R.id.discountPercent)
        recycler = findViewById(R.id.recycler_loops)


        val attributes = context.obtainStyledAttributes(attributeSet, R.styleable.ChildProductComponent)

        val hasChildren: Boolean = attributes.getBoolean(R.styleable.ChildProductComponent_hasChildren, false)
        // val realPriceText = setCurrency(toDouble(attributes.getString(R.styleable.ChildProductComponent_realPrice_childProduct))) + " " +  res.getString(R.string.Toman)
        // val salePriceText = setCurrency(toDouble(attributes.getString(R.styleable.ChildProductComponent_salePrice_childProduct))) + " " +  res.getString(R.string.Toman)

        val realPriceText = attributes.getString(R.styleable.ChildProductComponent_realPrice_childProduct)
        val salePriceText = attributes.getString(R.styleable.ChildProductComponent_salePrice_childProduct)

        //  val discountText =  res.getString(R.string.discount) + "  " +  calculateDiscount(97600.0, 24300.0 )
        title.text = attributes.getString(R.styleable.ChildProductComponent_title_childProduct)
        realPrice.text = realPriceText
        salePrice.setText(salePriceText)

        //  discount.text = discountText

        if (hasChildren) {
            realPrice.visibility = View.GONE
            salePrice.visibility = View.GONE
        }

        setAdapter()

        strikeThrough(realPrice)

        attributes.recycle()
    }

    private fun setSelectableProduct(): SelectableProductModel {
        val productModel = SelectableProductModel()
        productModel.title = resources.getString(R.string.titleProductItem)
        productModel.salePrice = resources.getString(R.string.salePriceDemo)
        productModel.realPrice = resources.getString(R.string.realPriceDemo)
        productModel.hasChild = true
        return productModel
    }

    private fun setAdapter() {
        val productModeList = ArrayList<SelectableProductModel>()

        for (i in 0..4) {
            productModeList.add(setSelectableProduct())
        }

        val productAdapter = SelectableProductAdapter(context, productModeList, 3)
        recycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recycler.adapter = productAdapter
    }

    private fun strikeThrough(textViewWithFont: com.example.alaa.customViews.TextViewWithFont) {
        textViewWithFont.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
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
