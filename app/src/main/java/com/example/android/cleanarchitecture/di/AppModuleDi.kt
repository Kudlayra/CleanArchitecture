package com.example.android.cleanarchitecture.di

import com.example.android.cleanarchitecture.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel>{
        MainViewModel(getUserNameUseCase = get(),
        saveUserNameUseCase = get())
    }

}