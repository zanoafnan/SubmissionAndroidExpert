package com.zanoafnan.submission1expert.core.data.source.local.room

import androidx.room.*
import com.zanoafnan.submission1expert.core.data.source.local.entity.MealEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {

    @Query("SELECT * FROM meal WHERE strMeal LIKE '%' || :query || '%'")
    fun getAllMeal(query: String): Flow<List<MealEntity>>

    @Query("SELECT * FROM meal where isFavorite = 1")
    fun getFavoriteMeal(): Flow<List<MealEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMeal(meal: List<MealEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMeal(meal: MealEntity)
    //theadd

    @Update
    fun updateFavoriteMeal(meal: MealEntity)

    @Query("DELETE FROM meal WHERE isFavorite != 1")
    fun deleteAllMeal()

}