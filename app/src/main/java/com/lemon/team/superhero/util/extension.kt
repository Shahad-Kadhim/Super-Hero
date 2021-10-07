package com.lemon.team.superhero.util

import android.view.View
import android.widget.EditText
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun View.goToFragment(navDir: NavDirections) {
    Navigation.findNavController(this).navigate(navDir)
}

fun View.hide(){
    this.visibility=View.INVISIBLE
}

fun View.show(){
    this.visibility=View.VISIBLE
}