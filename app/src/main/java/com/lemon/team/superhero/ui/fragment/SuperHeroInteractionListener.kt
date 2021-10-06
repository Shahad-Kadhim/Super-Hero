package com.lemon.team.superhero.ui.fragment

import com.lemon.team.superhero.model.reponse.SuperHeroInfoResponse

interface SuperHeroInteractionListener {
    fun  onClickItem(item : SuperHeroInfoResponse)
}
