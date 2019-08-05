package com.example.alaa.views.ui.SearchPage.Filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.customViews.MyButton

class FilterItemAdapter(private val list: ArrayList<String>, private val listener: FilterItemListener) : RecyclerView.Adapter<FilterItemAdapter.ViewHolder>()  {



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
        holder.button.setOnClickListener{
            listener.itemClicked(list[position])
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button : MyButton = itemView.findViewById(R.id.filterItem)
    }

    interface FilterItemListener{
        fun itemClicked(itemName : String)
    }

}