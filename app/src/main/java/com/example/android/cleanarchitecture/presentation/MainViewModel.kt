package com.example.android.cleanarchitecture.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.android.cleanarchitecture.domain.models.UserName
import com.example.android.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.android.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel(private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase): ViewModel() {

    private val _resultLive = MutableLiveData<String>()
    val resultLive = _resultLive

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val result: Boolean = saveUserNameUseCase.execute(param = params)
        _resultLive.value = "Save result = $result"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        _resultLive.value = "${userName.firstName} ${userName.lastName}"
    }


}