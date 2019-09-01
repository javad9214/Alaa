package com.example.alaa.views.ui.product.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.models.SampleVideoModel

class SampleVideoAdapter (private val sampleList : ArrayList<SampleVideoModel>): RecyclerView.Adapter<SampleVideoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =  LayoutInflater.from(parent.context).inflate(R.layout.sample_video,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return  sampleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val sample : SampleVideoModel = sampleList[position]
        holder.title.text = sample.title
        holder.teacherName.text = sample.teacherName
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val title: com.example.alaa.customViews.TextViewWithFont = itemView.findViewById(R.id.title_sample_video)
        val teacherName: com.example.alaa.customViews.TextViewWithFont = itemView.findViewById(R.id.tx_teacherName)


    }
}