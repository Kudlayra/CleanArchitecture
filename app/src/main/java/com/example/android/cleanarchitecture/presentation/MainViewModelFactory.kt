package com.example.android.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.android.cleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.android.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.android.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val userRepository by lazy { UserRepositoryImpl(userStorage = SharedPrefUserStorage(context)) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase = getUserNameUseCase, saveUserNameUseCase = saveUserNameUseCase) as T
    }

}