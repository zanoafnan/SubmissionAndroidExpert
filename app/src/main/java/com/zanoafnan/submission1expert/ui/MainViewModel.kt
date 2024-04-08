package com.zanoafnan.submission1expert.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.zanoafnan.submission1expert.core.domain.usecase.MealUseCase


class MainViewModel(mealUseCase: MealUseCase) : ViewModel() {

    private var _inputLiveData = MutableLiveData<String>()
    val inputLiveData: LiveData<String> = _inputLiveData

    val meal = _inputLiveData.switchMap { query ->
        mealUseCase.getAllMeal(query).asLiveData()
    }

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun setQuery(query: String) {
        _inputLiveData.value = query // Ubah nilai dari MutableLiveData
        Log.d("maincheck", "$query")
    }
}


