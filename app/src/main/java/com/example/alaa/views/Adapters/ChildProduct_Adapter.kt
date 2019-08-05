package com.example.alaa.views.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.models.ChildProductModel
import com.example.alaa.R

class ChildProduct_Adapter (private val children : ArrayList<ChildProductModel>): RecyclerView.Adapter<ChildProduct_Adapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =  LayoutInflater.from(parent.context).inflate(R.layout.child_product_component,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val children : ChildProductModel = children[position]
        holder.title.text = children.title
        holder.realPrice.text = children.realPrice.toString()
        holder.salePrice.text = children.salePrice.toString()
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

                val title : com.example.alaa.customViews.MyTextView = itemView.findViewById(R.id.title)
                val realPrice : com.example.alaa.customViews.MyTextView = itemView.findViewById(R.id.realPrice)
                val salePrice : com.example.alaa.customViews.MyTextView = itemView.findViewById(R.id.SalePrice)

    }
}