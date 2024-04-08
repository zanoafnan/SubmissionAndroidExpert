package com.zanoafnan.submission1expert.ui
/*
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zanoafnan.submission1expert.core.data.response.DetailMealResponse
import com.zanoafnan.submission1expert.core.data.retrofit.ApiConfig

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class FollowersViewModel (private val mealname: String) : ViewModel() {

    companion object{
        private const val TAG = "DetailMealActivity"
    }

    private val _followersCount = MutableLiveData<Int>()
    val followersCount: LiveData<Int> = _followersCount

    private val _followingCount = MutableLiveData<Int>()
    val followingCount: LiveData<Int> = _followingCount

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    val apiService = ApiConfig.getApiService()

    fun getFollInfo(mealname: String) {
        _isLoading.value = true
        apiService.getDetailMeal(mealname).enqueue(object : Callback<DetailMealResponse> {
            override fun onResponse(
                call: Call<DetailMealResponse>,
                response: Response<DetailMealResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    val detailMealResponse = response.body()


                    val followingCount = detailMealResponse?.following ?: 0
                    val followersCount = detailMealResponse?.followers ?: 0
                    val name = detailMealResponse?.name ?: "No Name"

                    _followingCount.value = followingCount
                    _followersCount.value = followersCount
                    _name.value = name

                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DetailMealResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }




}*/