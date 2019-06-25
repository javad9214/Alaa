package com.example.alaa.Views.UI.SearchPage.Filter.Grade

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.Views.UI.CustomViews.SelectableCard
import com.google.android.material.button.MaterialButton

class FilterGradeAdapter(private val list: ArrayList<String>) : RecyclerView.Adapter<FilterGradeAdapter.ViewHolder>()  {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.filter_items , parent , false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
            return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.button.text = list[position]
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button : MaterialButton = itemView.findViewById(R.id.filterItem)
    }


}