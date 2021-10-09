package com.lemon.team.superhero.ui.fragment.details

import com.lemon.team.superhero.model.Repository
import com.lemon.team.superhero.ui.fragment.base.BasePresenter

class DetailsPresenter(val view:IDetailsView):BasePresenter() {

    fun getPowerStats(superHeroId:String){
        handleRequest(
            Repository.getSuperHeroPowerStats(superHeroId),
            view::onError,
            view::onLoading,
            view::onSuccessPowerState
        )
    }

    fun getBiography(superHeroId:String){
        handleRequest(
            Repository.getSuperHeroBiography(superHeroId),
            view::onError,
            view::onLoading,
            view::onSuccessBiography
        )
    }
//    fun getImage(superHeroId:String){
//        handleRequest(
//            Repository.getSuperHeroBiography(superHeroId),
//            view::onError,
//            view::onLoading,
//            view::onSuccessBiography
//        )
//    }

}