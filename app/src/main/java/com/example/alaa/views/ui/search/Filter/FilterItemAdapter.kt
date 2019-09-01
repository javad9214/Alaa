package com.example.alaa.views.ui.search.Filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.custom_views.ButtonWithFont

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

        holder.buttonWithFont.text = list[position]
        holder.buttonWithFont.setOnClickListener {
            listener.itemClicked(list[position])
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val buttonWithFont: ButtonWithFont = itemView.findViewById(R.id.filterItem)
    }

    interface FilterItemListener{
        fun itemClicked(itemName : String)
    }

}