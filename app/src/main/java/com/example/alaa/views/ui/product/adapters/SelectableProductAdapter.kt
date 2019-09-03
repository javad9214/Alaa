package com.example.alaa.views.ui.product.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.customViews.TextViewWithCardBackground
import com.example.alaa.models.SelectableProductModel

class SelectableProductAdapter(private val context: Context , private val list : ArrayList<SelectableProductModel>) : RecyclerView.Adapter<SelectableProductAdapter.ViewHolder>() {

    private var itemSize : Int = 5

    constructor(context: Context , list : ArrayList<SelectableProductModel> , itemSize : Int) : this(context  , list){
        this.itemSize = itemSize
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =  LayoutInflater.from(parent.context).inflate(R.layout.child_product_component ,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
      return itemSize
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val  product : SelectableProductModel = list[position]
        holder.title.text = product.title
        holder.salePrice.setText(product.salePrice)
        holder.realPrice.text = product.realPrice
        if (product.hasChild){
            holder.salePrice.visibility = View.GONE
            holder.realPrice.visibility = View.GONE
            holder.recyclerView.layoutManager = LinearLayoutManager(context , RecyclerView.VERTICAL , false)
            val list : ArrayList<SelectableProductModel> = setList(2 , false)
            val adapter = SelectableProductAdapter(context , list , 2)
            holder.recyclerView.adapter = adapter
        }

    }

    fun  setList(size :Int  , hasChild : Boolean) : ArrayList<SelectableProductModel>{

        val list : ArrayList<SelectableProductModel> = ArrayList()
        for (x in 0..size){
            val model = SelectableProductModel()
            model.title = context.resources.getString(R.string.titleProductItem)
            model.salePrice = context.resources.getString(R.string.salePriceDemo)
            model.realPrice = context.resources.getString(R.string.realPriceDemo)
            model.hasChild = hasChild
            list.add(model)
        }
        return list
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val title: com.example.alaa.customViews.TextViewWithFont = itemView.findViewById(R.id.tx_title_product)
        val salePrice: TextViewWithCardBackground = itemView.findViewById(R.id.salePrice)
        val realPrice: com.example.alaa.customViews.TextViewWithFont = itemView.findViewById(R.id.realPrice)
        val checkBox : CheckBox = itemView.findViewById(R.id.checkbox)
        val recyclerView : RecyclerView = itemView.findViewById(R.id.recycler_loops)


    }



}