package com.example.android.cleanarchitecture.presentation.di

import com.example.android.cleanarchitecture.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}