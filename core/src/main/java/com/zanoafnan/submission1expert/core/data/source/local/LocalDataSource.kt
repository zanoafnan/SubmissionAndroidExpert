package com.zanoafnan.submission1expert.core.data.source.local

import android.util.Log
import com.zanoafnan.submission1expert.core.data.source.local.entity.MealEntity
import com.zanoafnan.submission1expert.core.data.source.local.room.MealDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext


class LocalDataSource ( val mealDao: MealDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(mealDao: MealDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(mealDao)
            }

    }

    fun getAllMeal(query: String): Flow<List<MealEntity>> = mealDao.getAllMeal(query)

    fun getFavoriteMeal(): Flow<List<MealEntity>> = mealDao.getFavoriteMeal()

    suspend fun insertMeal(mealList: List<MealEntity>) {
        // Hapus data lama terlebih dahulu sebelum menyimpan data baru
        withContext(Dispatchers.IO) {
            mealDao.deleteAllMeal()
            // Simpan data baru
            mealDao.insertMeal(mealList)
        }


    }

    suspend fun setFavoriteMeal(meal: MealEntity, newState: Boolean) {
        mealDao.addMeal(meal)
        Log.d("LocalDataSource", "Before update: ${meal.isFavorite}")
        meal.isFavorite = newState
        if(newState){
            mealDao.updateFavoriteMeal(meal)
        }//theadd


        Log.d("LocalDataSource", "After update: ${meal.isFavorite}")
    }



}