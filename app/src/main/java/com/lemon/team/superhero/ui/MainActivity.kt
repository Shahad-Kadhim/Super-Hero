package com.lemon.team.superhero.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lemon.team.superhero.R
import com.lemon.team.superhero.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SuperHero)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}