package com.example.android.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.android.cleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.android.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.android.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(val getUserNameUseCase: GetUserNameUseCase,
                           val saveUserNameUseCase: SaveUserNameUseCase): ViewModelProvider.Factory {



    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase = getUserNameUseCase, saveUserNameUseCase = saveUserNameUseCase) as T
    }

}