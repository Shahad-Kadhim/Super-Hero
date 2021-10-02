package com.lemon.team.superhero.model

import androidx.lifecycle.lifecycleScope
import com.lemon.team.superhero.model.data.response.SearchSuperHeroResponse.SearchCharacterResponse
import com.lemon.team.superhero.model.data.response.SuperHeroResponse
import com.lemon.team.superhero.model.network.API
import com.lemon.team.superhero.util.Constants.KEY_API
import com.lemon.team.superhero.util.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.Response

object Repository {

    fun getSuperHeroInfo(characterId: Int)
            : Flow<SuperHeroResponse?> =
        wrampWithFlow { API.apiService.getSuperHeroInfo(KEY_API , characterId ) }

    fun getSearchSuperHero(characterName: String): Flow<SearchCharacterResponse?> =
        wrampWithFlow { API.apiService.getSearchSuperHero(KEY_API , characterName ) }

    fun <T> wrampWithFlow(function: suspend () -> Response<T>): Flow<T?> =
        flow {
            function()?.let {
                emit(it.body())
            }
        }

}