package com.zanoafnan.submission1expert.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zanoafnan.submission1expert.R
import com.zanoafnan.submission1expert.core.domain.model.MealsItem
import de.hdodenhof.circleimageview.CircleImageView

class FollowersAdapter : ListAdapter<MealsItem, FollowersAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_followers, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val follower = getItem(position)
        holder.mealname.text = follower.strMeal

        Glide.with(holder.itemView.context)
            .load(follower.strMealThumb)
            .into(holder.avatarImage)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mealname: TextView = itemView.findViewById(R.id.tvFollItem)
        val avatarImage: CircleImageView = itemView.findViewById(R.id.ivFollProfile)

    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MealsItem>() {
            override fun areItemsTheSame(oldItem: MealsItem, newItem: MealsItem): Boolean {
                return oldItem.idMeal == newItem.idMeal
            }

            override fun areContentsTheSame(oldItem: MealsItem, newItem: MealsItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
