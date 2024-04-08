package com.zanoafnan.submission1expert

//import com.zanoafnan.submission1expert.di.useCaseModule
//import com.zanoafnan.submission1expert.di.viewModelModule
import android.app.Application
import com.zanoafnan.submission1expert.core.di.databaseModule
import com.zanoafnan.submission1expert.core.di.networkModule
import com.zanoafnan.submission1expert.core.di.repositoryModule
import com.zanoafnan.submission1expert.di.useCaseModule
import com.zanoafnan.submission1expert.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}