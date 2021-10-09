package com.lemon.team.superhero.ui.fragment.details

import android.util.Log
import com.lemon.team.superhero.model.Repository
import com.lemon.team.superhero.ui.fragment.base.BasePresenter
import com.lemon.team.superhero.util.Constants.LOG_TAG_ERROR
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class DetailsPresenter(val view:IDetailsView):BasePresenter() {

    fun getSuperHeroInfo(superHeroId:String){
        customScope.launch {
            Repository
                .getSuperHeroInfo(superHeroId)
                .flowOn(Dispatchers.IO)
                .catch { throwable->
                    Log.i(LOG_TAG_ERROR,"${throwable.message}")
                }.collect (view::onResponseSuperHeroInfo)
        }
    }

}