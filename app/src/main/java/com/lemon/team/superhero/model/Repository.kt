package com.lemon.team.superhero.model

import com.lemon.team.superhero.model.data.SearchSuperHeroResponse.SearchCharacterResponse
import com.lemon.team.superhero.model.data.superHeroResponse.SuperHeroResponse
import com.lemon.team.superhero.model.network.API
import com.lemon.team.superhero.util.Constants.KEY_API
import kotlinx.coroutines.flow.*
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