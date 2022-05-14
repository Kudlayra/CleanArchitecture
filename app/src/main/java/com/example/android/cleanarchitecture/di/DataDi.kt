package com.example.android.cleanarchitecture.di

import com.example.android.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.android.cleanarchitecture.data.storage.UserStorage
import com.example.android.cleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.android.cleanarchitecture.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}