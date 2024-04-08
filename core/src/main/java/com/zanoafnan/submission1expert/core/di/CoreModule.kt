package com.zanoafnan.submission1expert.core.di

import androidx.room.Room
import com.zanoafnan.submission1expert.core.data.MealRepository
import com.zanoafnan.submission1expert.core.data.source.local.LocalDataSource
import com.zanoafnan.submission1expert.core.data.source.local.room.MealDatabase
import com.zanoafnan.submission1expert.core.data.source.remote.RemoteDataSource
import com.zanoafnan.submission1expert.core.data.source.remote.network.ApiService
import com.zanoafnan.submission1expert.core.domain.repository.IMealRepository
import com.zanoafnan.submission1expert.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<MealDatabase>().mealDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("zanoafnan".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            MealDatabase::class.java, "meal.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "themealdb.com"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/bzvACOpfMvpGYuaNM21RK/GRLUd38LFMaJxtxu3/XAk=")
            .add(hostname, "sha256/81Wf12bcLlFHQAfJluxnzZ6Frg+oJ9PWY/Wrwur8viQ=")
            .add(hostname, "sha256/hxqRlPTu1bMS/0DITB1SSu0vd4u/8l8TjPgfaAp63Gc=")

            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMealRepository> {
        MealRepository(
            get(),
            get(),
            get()
        )
    }
}