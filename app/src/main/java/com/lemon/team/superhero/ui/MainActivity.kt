package com.lemon.team.superhero.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lemon.team.superhero.databinding.ActivityMainBinding
import com.lemon.team.superhero.ui.fragment.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addFragment(SearchFragment())
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            binding.fragmentContainer.id,
            fragment
        ).commit()
    }
}