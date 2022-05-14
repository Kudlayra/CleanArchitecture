package com.example.android.cleanarchitecture.presentation.app

import android.app.Application
import com.example.android.cleanarchitecture.presentation.di.AppComponent
import com.example.android.cleanarchitecture.presentation.di.AppModule
import com.example.android.cleanarchitecture.presentation.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}