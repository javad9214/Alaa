package com.example.alaa.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.models.AttributesModel

class AttributesAdapter (private val attrList : ArrayList<AttributesModel>) : RecyclerView.Adapter<AttributesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =  LayoutInflater.from(parent.context).inflate(R.layout.attribute_box , parent ,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return  attrList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val attrModel :AttributesModel = attrList[position]
        holder.attrName.text = attrModel.attrName
        holder.attrValue.text = attrModel.attrValue
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val attrName : com.example.alaa.customViews.MyTextView = itemView.findViewById(R.id.tx_attribute)
        val attrValue : com.example.alaa.customViews.MyTextView = itemView.findViewById(R.id.tx_attr_value)


    }


}