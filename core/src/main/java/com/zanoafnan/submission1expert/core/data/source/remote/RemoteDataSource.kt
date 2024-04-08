package com.zanoafnan.submission1expert.core.data.source.remote

//import androidx.lifecycle.MutableLiveData
import android.util.Log
import com.zanoafnan.submission1expert.core.data.source.remote.network.ApiResponse
import com.zanoafnan.submission1expert.core.data.source.remote.network.ApiService
import com.zanoafnan.submission1expert.core.domain.model.MealsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class RemoteDataSource (private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllMeal(query: String): Flow<ApiResponse<List<MealsItem>>> {
        Log.d("RemoteDataSource", query)
        return flow {
            try {
                val response = apiService.getMeals(query)
                val dataArray = response.meals
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.meals))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}