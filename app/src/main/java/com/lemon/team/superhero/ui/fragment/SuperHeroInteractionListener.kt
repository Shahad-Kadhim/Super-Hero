package com.lemon.team.superhero.ui.fragment

import com.lemon.team.superhero.ui.fragment.base.BaseInteractionListener


interface SuperHeroInteractionListener :BaseInteractionListener{
    fun  onClickItem(superHeroId : String)
}
