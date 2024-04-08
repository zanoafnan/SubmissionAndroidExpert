package com.zanoafnan.submission1expert.core.domain.repository

import com.zanoafnan.submission1expert.core.domain.model.Meal
import kotlinx.coroutines.flow.Flow

interface IMealRepository {

        fun getAllMeal(query: String): Flow<com.zanoafnan.submission1expert.core.data.source.Resource<List<Meal>>>

        fun getFavoriteMeal(): Flow<List<Meal>>

        fun setFavoriteMeal(meal: Meal, state: Boolean)
}
