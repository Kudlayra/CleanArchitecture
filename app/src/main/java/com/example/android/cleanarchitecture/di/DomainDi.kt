package com.example.android.cleanarchitecture.di

import com.example.android.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.android.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}