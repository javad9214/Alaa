package com.example.alaa.Views.UI.SearchPage.Filter.Grade

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.Tools.SelectableCard

class FilterGradeAdapter(private val list: ArrayList<String> , val listener: SelectableCard.CardSelectListener) : RecyclerView.Adapter<FilterGradeAdapter.ViewHolder>()  {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.filter_items , parent , false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
            return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.selectableCard.setCardSelectListener(listener)
        holder.selectableCard.setText(list[position])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val selectableCard : SelectableCard = itemView.findViewById(R.id.filter_selectableCard)
    }


}