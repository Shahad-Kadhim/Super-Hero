package com.lemon.team.superhero.ui

interface IView {
    fun<T> onSuccess(data:T)
    fun onError(message:String)
    fun onLoading()
}