package com.zanoafnan.submission1expert.core.data

import android.util.Log
import com.zanoafnan.submission1expert.core.data.source.NetworkBoundResource
import com.zanoafnan.submission1expert.core.data.source.Resource
import com.zanoafnan.submission1expert.core.data.source.local.LocalDataSource
import com.zanoafnan.submission1expert.core.data.source.remote.RemoteDataSource
import com.zanoafnan.submission1expert.core.data.source.remote.network.ApiResponse
import com.zanoafnan.submission1expert.core.domain.model.Meal
import com.zanoafnan.submission1expert.core.domain.model.MealsItem
import com.zanoafnan.submission1expert.core.domain.repository.IMealRepository
import com.zanoafnan.submission1expert.core.utils.AppExecutors
import com.zanoafnan.submission1expert.core.utils.DataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MealRepository (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMealRepository {

    companion object {
        @Volatile
        private var instance: MealRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): MealRepository =
            instance ?: synchronized(this) {
                instance
                    ?: MealRepository(
                        remoteData,
                        localData,
                        appExecutors
                    )
            }
    }

    override fun getAllMeal(query: String): Flow<Resource<List<Meal>>> =
        object : NetworkBoundResource<List<Meal>, List<MealsItem>>() {
            override fun loadFromDB(): Flow<List<Meal>> {
                return localDataSource.getAllMeal(query).map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Meal>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<MealsItem>>> =
                remoteDataSource.getAllMeal(query)

            override suspend fun saveCallResult(data: List<MealsItem>) {
                val mealList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMeal(mealList)
            }
        }.asFlow()


    override fun getFavoriteMeal(): Flow<List<Meal>> {
        return localDataSource.getFavoriteMeal().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMeal(meal: Meal, state: Boolean) {
        Log.d("MealRepos", "Before update: ${meal.isFavorite}")
        val mealEntity = DataMapper.mapDomainToEntity(meal)
        GlobalScope.launch(Dispatchers.IO) {
            localDataSource.setFavoriteMeal(mealEntity, state)
        }//theadd

        //appExecutors.diskIO().execute { localDataSource.setFavoriteMeal(mealEntity, state) }

        Log.d("MealRepos", "After update: ${meal.isFavorite}")

    }



}