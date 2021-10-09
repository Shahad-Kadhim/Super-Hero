package com.lemon.team.superhero.ui.fragment.search

import android.util.Log
import com.lemon.team.superhero.model.Repository
import com.lemon.team.superhero.ui.fragment.base.BasePresenter
import com.lemon.team.superhero.util.Constants.LOG_TAG_ERROR
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class SearchPresenter(val view:SearchView):BasePresenter(){

    fun searchByName(superHeroName:String){
        customScope.launch {
            Repository
                .getSuperHeroSearchResult(superHeroName)
                .flowOn(Dispatchers.IO)
                .catch { throwable->
                    Log.i(LOG_TAG_ERROR,"${throwable.message}")
                }.collect (view::onResponseSearchingResult)
        }
    }

}