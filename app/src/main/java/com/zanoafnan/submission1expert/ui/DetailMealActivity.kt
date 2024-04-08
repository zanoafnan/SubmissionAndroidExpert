package com.zanoafnan.submission1expert.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.zanoafnan.submission1expert.R
import com.zanoafnan.submission1expert.core.domain.model.Meal
import com.zanoafnan.submission1expert.databinding.ActivityDetailmealBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMealActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "data"
    }

    private val detailMealViewModel: DetailMealViewModel by viewModel()
    private lateinit var binding: ActivityDetailmealBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailmealBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val jsonData = intent.getStringExtra("data")


        if (jsonData != null) {
            val detailMeal = Gson().fromJson(jsonData, Meal::class.java)
            Log.d("1st", detailMeal.toString())
            showDetailMeal(detailMeal)
        }
    }

    private fun showDetailMeal(detailMeal: Meal?) {
        detailMeal?.let {
            supportActionBar?.title = detailMeal.strMeal
            binding.tvLoginDetail.text = detailMeal.strMeal
            Glide.with(binding.root.context)
                .load(detailMeal.strMealThumb)
                .into(binding.ivProfileDetail)
            //binding.tvMealIdValue.text = detailMeal.id.toString()
            //binding.tvNodeIdValue.text = detailMeal.nodeId


            GlobalScope.launch(Dispatchers.IO) {
                detailMealViewModel.mealUseCase.getFavoriteMeal().collect { favoriteMeals ->
                    val isFavorite = favoriteMeals.any { it.strMeal == detailMeal.strMeal && it.isFavorite }
                    if (isFavorite) {
                        withContext(Dispatchers.Main) {
                            // Eksekusi kode di utas utama
                            detailMeal.isFavorite = true
                            binding.fab.setImageDrawable(ContextCompat.getDrawable(this@DetailMealActivity, R.drawable.favorite))
                        }
                    }
                }
            }



            binding.fab.setOnClickListener {
                if (detailMeal.isFavorite == true) {

                    //var statusFavorite = detailMeal.isFavorite
                    //setStatusFavorite(statusFavorite, detailMeal)

                    val info: Boolean? = detailMeal.isFavorite
                    Log.d("//3rd listener", "changed from $info")
                    //detailMealViewModel.setFavoriteMeal(detailMeal, false)
                    setStatusFavorite(false, detailMeal)

                } else {
                    // Nilai isFavorite sudah diisi sebelumnya, lakukan sesuatu yang sesuai
                    // Misalnya, atur tampilan fab berdasarkan nilai isFavorite yang sudah ada
                    val info: Boolean? = detailMeal.isFavorite
                    Log.d("//3rd listener", "changed from $info")
                    //detailMealViewModel.setFavoriteMeal(detailMeal, true)
                    setStatusFavorite(true, detailMeal)}
            }
        }
    }


    private fun setStatusFavorite(statusFavorite: Boolean, meal: Meal) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.favorite))
            meal.isFavorite = true
            detailMealViewModel.setFavoriteMeal(meal, true)
            Log.d("to true", meal.toString())
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.favorite_border))
            meal.isFavorite = false
            detailMealViewModel.setFavoriteMeal(meal, false)
            Log.d("to false", meal.toString())
        }
    }
}




