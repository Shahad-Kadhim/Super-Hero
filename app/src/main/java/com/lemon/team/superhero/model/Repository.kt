package com.lemon.team.superhero.model

import com.lemon.team.superhero.model.data.SearchSuperHeroResponse.SearchCharacterResponse
import com.lemon.team.superhero.model.data.superHeroResponse.SuperHeroResponse
import com.lemon.team.superhero.model.network.API
import com.lemon.team.superhero.util.Constants.KEY_API
import com.lemon.team.superhero.util.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.Response


object Repository {

    fun getSuperHeroInfo(characterId: Int)
            : Flow<State<SuperHeroResponse?>> =
        wrapWithFlow { API.apiService.getSuperHeroInfo(KEY_API, characterId) }

    fun getSearchSuperHero(characterName: String): Flow<State<SearchCharacterResponse?>> =
        wrapWithFlow { API.apiService.getSearchSuperHero(KEY_API, characterName) }


    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>>
    = flow {
           emit(State.Loading)
           emit(checkIsSuccessful( function()))
       }.flowOn(Dispatchers.IO)

    private fun <T> checkIsSuccessful(response: Response<T>): State<T?>
        = try {
            if (response.isSuccessful)  State.Success(response.body())
            else State.Error(response.message())
        } catch (e: Exception) {
            State.Error(e.message.toString())
        }


}