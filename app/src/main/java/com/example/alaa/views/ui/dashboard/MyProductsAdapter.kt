package com.example.alaa.views.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.customViews.ButtonWithFont

/**
 *  this adapter is for recycler view on Dashboard for Products that has been purchased ...
 */

class MyProductsAdapter(private val layout: Int, private val activity: FragmentActivity) : RecyclerView.Adapter<MyProductsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.btnVideos.setOnClickListener {
            val bottomSheet = ShowSetBottomSheet()
            bottomSheet.show(activity.supportFragmentManager, bottomSheet.tag)
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val btnVideos: ButtonWithFont = itemView.findViewById(R.id.btn_video)
        val btnBooklet: ButtonWithFont = itemView.findViewById(R.id.btn_booklet)

    }
}