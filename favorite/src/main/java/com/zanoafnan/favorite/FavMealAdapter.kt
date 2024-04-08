package com.zanoafnan.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.zanoafnan.submission1expert.R
import com.zanoafnan.submission1expert.core.domain.model.Meal
import com.zanoafnan.submission1expert.ui.DetailMealActivity

class FavMealAdapter : RecyclerView.Adapter<FavMealAdapter.ListViewHolder>() {

    private var listData = ArrayList<Meal>()
    var onItemClick: ((Meal) -> Unit)? = null

    fun setData(newListData: List<Meal>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(com.zanoafnan.favorite.R.layout.item_favorite_meal, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailMealActivity::class.java)
            intentDetail.putExtra("data", Gson().toJson(data))
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = com.zanoafnan.favorite.databinding.ItemFavoriteMealBinding.bind(itemView)
        fun bind(data: Meal) {
            with(binding) {
                binding.tvFavItem.text = data.strMeal
                Glide.with(binding.ivFavProfile.context)
                    .load(data.strMealThumb)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.ivFavProfile)
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}

/*
class FavMealAdapter(private val onItemClick: (FavoriteMeal) -> Unit) :
    ListAdapter<Meal, FavMealAdapter.ViewHolder>(MealDiffCallback()) {

    inner class ViewHolder(private val binding: ItemFavoriteMealBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val context = binding.root.context

        fun bind(favoriteMeal: Meal) {
            binding.tvFavItem.text = favoriteMeal.strMeal
            Glide.with(binding.ivFavProfile.context)
                .load(favoriteMeal.strMealThumb)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.ivFavProfile)

            binding.root.setOnClickListener {

                val intent = Intent(context, DetailFavMealActivity::class.java)
                // Konversi objek FavoriteMeal menjadi JSON
                val json = Gson().toJson(favoriteMeal)
                intent.putExtra("data", json)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFavoriteMealBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favoriteMeal = getItem(position)
        holder.bind(favoriteMeal)


        /*holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailMealActivity::class.java)
            intentDetail.putExtra("mealname", favoriteMeal.mealname)
            holder.itemView.context.startActivity(intentDetail)
        }

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailMealActivity::class.java)
            val jsonData = Gson().toJson(favoriteMeal) // Ubah favoriteMeal menjadi JSON
            //intentDetail.putExtra("jenis_data", "data_json") // Tandai jenis data sebagai JSON
            intentDetail.putExtra("mealname", jsonData) // Sertakan data JSON ke intent
            holder.itemView.context.startActivity(intentDetail)
        }*/

    }
}

class MealDiffCallback : DiffUtil.ItemCallback<Meal>() {

    override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem.strMeal == newItem.strMeal
    }

    override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem == newItem
    }
}*/
