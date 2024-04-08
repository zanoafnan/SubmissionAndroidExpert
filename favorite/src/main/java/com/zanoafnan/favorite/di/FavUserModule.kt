package com.zanoafnan.favorite.di

//import com.zanoafnan.favorite.FavMealViewModel
import com.zanoafnan.favorite.FavMealViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val favMealModule = module {
    viewModel { FavMealViewModel(get()) }
}