package com.example.android.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.android.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.android.cleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.android.cleanarchitecture.databinding.ActivityMainBinding
import com.example.android.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.android.cleanarchitecture.domain.models.UserName
import com.example.android.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.android.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        viewModel.resultLive.observe(this) { it ->
            binding.dataTextView.text = it
        }

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            viewModel.save(text)
        }

        binding.receiveButton.setOnClickListener {
            viewModel.load()
        }
    }
}