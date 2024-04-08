package com.zanoafnan.submission1expert.core.data.source.remote.network

import com.zanoafnan.submission1expert.core.domain.model.MealResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search.php")
    suspend fun getMeals(@Query("s") query: String): MealResponse
}
