package com.zanoafnan.submission1expert.core.domain.usecase

import com.zanoafnan.submission1expert.core.data.source.Resource
import com.zanoafnan.submission1expert.core.domain.model.Meal
import kotlinx.coroutines.flow.Flow

interface MealUseCase {
    fun getAllMeal(query: String): Flow<Resource<List<Meal>>>
    fun getFavoriteMeal(): Flow<List<Meal>>
    fun setFavoriteMeal(meal: Meal, state: Boolean)
}