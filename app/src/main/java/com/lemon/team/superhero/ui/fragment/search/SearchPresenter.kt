package com.lemon.team.superhero.ui.fragment.search

import com.lemon.team.superhero.model.Repository
import com.lemon.team.superhero.ui.IView
import com.lemon.team.superhero.ui.fragment.base.BasePresenter

class SearchPresenter(private val view:IView):BasePresenter(){

    fun searchByName(superHeroName:String){
        handleRequest(
            Repository.getSuperHeroSearchResult(superHeroName),
            view::onError,
            view::onLoading,
            view::onSuccess
        )
    }

}