package com.lemon.team.superhero.ui.fragment

import android.widget.ImageView
import com.lemon.team.superhero.ui.fragment.base.BaseInteractionListener


interface SuperHeroInteractionListener :BaseInteractionListener{
    fun  onClickItem(superHeroId : String,image:ImageView)
}
