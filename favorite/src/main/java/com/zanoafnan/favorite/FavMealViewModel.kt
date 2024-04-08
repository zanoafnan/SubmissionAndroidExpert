package com.zanoafnan.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.zanoafnan.submission1expert.core.domain.usecase.MealUseCase


class FavMealViewModel(mealUseCase: MealUseCase) : ViewModel() {
    val favoriteMeal = mealUseCase.getFavoriteMeal().asLiveData()
}