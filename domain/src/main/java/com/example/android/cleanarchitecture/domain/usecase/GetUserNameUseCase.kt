package com.example.android.cleanarchitecture.domain.usecase

import com.example.android.cleanarchitecture.domain.models.UserName
import com.example.android.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }

}