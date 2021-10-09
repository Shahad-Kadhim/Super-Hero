package com.lemon.team.superhero.ui.fragment.search

import com.lemon.team.superhero.model.reponse.SuperHeroSearchResultResponse
import com.lemon.team.superhero.util.State

interface SearchView {
    fun onResponseSearchingResult(state: State<SuperHeroSearchResultResponse?>)
}