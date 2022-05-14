package com.example.android.cleanarchitecture.presentation.di

import android.content.Context
import com.example.android.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.android.cleanarchitecture.data.storage.UserStorage
import com.example.android.cleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.android.cleanarchitecture.domain.repository.UserRepository
import com.example.android.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.android.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides


@Module
class DataModule {
    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }
    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}


