package com.example.alaa.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R

class ComplexCartAdapter (private val size : Int) : RecyclerView.Adapter<ComplexCartAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =  LayoutInflater.from(parent.context).inflate(R.layout.cart_product_complex,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = "همایش های طلای شیمی نظام قدیم الاء کنکور 98 "
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val title : com.example.alaa.customViews.MyTextView = itemView.findViewById(R.id.tx_title_product)
        val finalSalePrice : com.example.alaa.customViews.MyTextView = itemView.findViewById(R.id.salePrice)



    }

}