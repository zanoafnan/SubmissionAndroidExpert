package com.zanoafnan.submission1expert.core.domain.usecase

import com.zanoafnan.submission1expert.core.domain.model.Meal
import com.zanoafnan.submission1expert.core.domain.repository.IMealRepository
import kotlinx.coroutines.flow.Flow


class MealInteractor (val mealRepository: IMealRepository): MealUseCase {

    override fun getAllMeal(query: String): Flow<com.zanoafnan.submission1expert.core.data.source.Resource<List<Meal>>> = mealRepository.getAllMeal(query)

    override fun getFavoriteMeal(): Flow<List<Meal>> = mealRepository.getFavoriteMeal()

    override fun setFavoriteMeal(meal: Meal, state: Boolean) = mealRepository.setFavoriteMeal(meal, state)
}