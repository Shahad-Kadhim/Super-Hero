package com.lemon.team.superhero.ui.fragment.details

import com.lemon.team.superhero.model.reponse.Biography
import com.lemon.team.superhero.model.reponse.Powerstats

interface IDetailsView {
    fun onSuccessBiography(data:Biography?)
    fun onSuccessPowerState(data:Powerstats?)
    fun onError(message:String)
    fun onLoading()
}