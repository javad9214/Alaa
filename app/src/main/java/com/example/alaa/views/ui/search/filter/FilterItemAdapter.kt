package com.example.alaa.views.ui.search.filter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.customViews.ButtonWithFont

class FilterItemAdapter(private val list: ArrayList<String>, private val listener: FilterItemListener) : RecyclerView.Adapter<FilterItemAdapter.ViewHolder>()  {

    constructor(list: ArrayList<String>, listener: FilterItemListener, width: Int) : this(list, listener) {
        this.width = width
    }

    private var width: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.filter_items , parent , false)
        return ViewHolder(view, width)
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


    class ViewHolder(itemView: View, width: Int) : RecyclerView.ViewHolder(itemView) {
        val buttonWithFont: ButtonWithFont = itemView.findViewById(R.id.filterItem)

        init {
            Log.i("====", width.toString())
            buttonWithFont.width = 250
        }
    }

    interface FilterItemListener{
        fun itemClicked(itemName : String)
    }

}