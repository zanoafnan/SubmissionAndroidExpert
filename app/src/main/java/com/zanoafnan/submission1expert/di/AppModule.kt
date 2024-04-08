package com.zanoafnan.submission1expert.di

import com.zanoafnan.submission1expert.core.domain.usecase.MealInteractor
import com.zanoafnan.submission1expert.core.domain.usecase.MealUseCase
import com.zanoafnan.submission1expert.ui.DetailMealViewModel
import com.zanoafnan.submission1expert.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MealUseCase> { MealInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }

    viewModel { DetailMealViewModel(get()) }
}