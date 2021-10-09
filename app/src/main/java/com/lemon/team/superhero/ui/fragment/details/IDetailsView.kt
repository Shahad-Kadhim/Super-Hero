package com.lemon.team.superhero.ui.fragment.details

import com.lemon.team.superhero.model.reponse.SuperHeroInfoResponse
import com.lemon.team.superhero.util.State

interface IDetailsView {
    fun onResponseSuperHeroInfo(state:State<SuperHeroInfoResponse?>)
}