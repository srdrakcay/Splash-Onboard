package com.serdar.firstapp.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.serdar.firstapp.MainActivity

import com.serdar.firstapp.R
import com.serdar.firstapp.databinding.OnboardingScreenBinding

class Onboarding : AppCompatActivity() {
    private lateinit var binding: OnboardingScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OnboardingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}