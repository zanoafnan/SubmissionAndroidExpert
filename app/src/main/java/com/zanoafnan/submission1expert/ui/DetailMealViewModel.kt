package com.zanoafnan.submission1expert.ui

import androidx.lifecycle.ViewModel
import com.zanoafnan.submission1expert.core.domain.model.Meal
import com.zanoafnan.submission1expert.core.domain.usecase.MealUseCase

class DetailMealViewModel ( val mealUseCase: MealUseCase) : ViewModel() {
    fun setFavoriteMeal(meal: Meal, newStatus: Boolean) =
        mealUseCase.setFavoriteMeal(meal, newStatus)

    }


