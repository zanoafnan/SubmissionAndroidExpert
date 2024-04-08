package com.zanoafnan.submission1expert.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.zanoafnan.submission1expert.core.domain.model.Meal
import com.zanoafnan.submission1expert.databinding.ItemReviewBinding

class MealAdapter : ListAdapter<Meal, MealAdapter.ListViewHolder>(DIFF_CALLBACK) {


    fun setData(newListData: List<Meal>?) {
        submitList(newListData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailMealActivity::class.java)
            intentDetail.putExtra("data", Gson().toJson(data))
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    inner class ListViewHolder(private val binding: ItemReviewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Meal) {
            binding.tvItem.text = data.strMeal
            Glide.with(binding.root.context)
                .load(data.strMealThumb)
                .into(binding.ivProfile)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Meal>() {
            override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
                return oldItem.idMeal == newItem.idMeal
            }
            override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
                return oldItem == newItem
            }
        }
    }
}



/*
class MealAdapter : ListAdapter<Meal, MealAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val review = getItem(position)
        holder.bind(review)

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailMealActivity::class.java)
            intentDetail.putExtra("data", Gson().toJson(review))
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class MyViewHolder(private val binding: ItemReviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(review: Meal){

            binding.tvItem.text = review.strMeal
            Glide.with(binding.root.context)
                .load(review.strMealThumb)
                .into(binding.ivProfile)
        }
    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Meal>() {
            override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
                return oldItem == newItem
            }
            override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
                return oldItem == newItem
            }
        }
    }
}*/