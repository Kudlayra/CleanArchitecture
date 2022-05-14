package com.example.android.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.android.cleanarchitecture.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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