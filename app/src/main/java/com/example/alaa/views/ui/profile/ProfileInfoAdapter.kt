package com.example.alaa.views.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.customViews.InfoCard
import com.example.alaa.models.ProfileInfoCard

class ProfileInfoAdapter(private val resource: Int) : RecyclerView.Adapter<ProfileInfoAdapter.ViewHolder>() {

    private lateinit var infoCardList: ArrayList<ProfileInfoCard>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.profile_info_card, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return infoCardList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val profileInfoCard = infoCardList[position]
        holder.infoCard.setTitle(profileInfoCard.title)
        holder.infoCard.setValue(profileInfoCard.value)
        holder.infoCard.setIcon(profileInfoCard.icon)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val infoCard: InfoCard = itemView.findViewById(R.id.infoCard)
    }

}