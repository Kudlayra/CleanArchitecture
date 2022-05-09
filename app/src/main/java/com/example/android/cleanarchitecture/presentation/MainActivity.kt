package com.example.android.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.android.cleanarchitecture.R
import com.example.android.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.android.cleanarchitecture.data.storage.UserStorage
import com.example.android.cleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.android.cleanarchitecture.databinding.ActivityMainBinding
import com.example.android.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.android.cleanarchitecture.domain.models.UserName
import com.example.android.cleanarchitecture.domain.repository.UserRepository
import com.example.android.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.android.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val userRepository by lazy { UserRepositoryImpl(userStorage = SharedPrefUserStorage(applicationContext)) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            binding.dataTextView.text = "Save result = $result"
        }

        binding.receiveButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            binding.dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}