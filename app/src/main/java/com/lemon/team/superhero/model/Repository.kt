package com.lemon.team.superhero.model

import com.lemon.team.superhero.model.network.API
import com.lemon.team.superhero.model.reponse.*
import com.lemon.team.superhero.util.Constants.KEY_API
import com.lemon.team.superhero.util.State
import kotlinx.coroutines.flow.*
import retrofit2.Response


object Repository {

    fun getSuperHeroInfo(characterId: Int)
            : Flow<State<SuperHeroInfoResponse?>> =
        wrapWithFlow { API.apiService.getSuperHeroInfo(KEY_API, characterId) }

    fun getSuperHeroSearchResult(characterName: String)
            : Flow<State<SuperHeroSearchResultResponse?>> =
        wrapWithFlow { API.apiService.getSuperHeroSearchResult(KEY_API, characterName) }

    fun getSuperHeroPowerstats(characterId: Int)
            : Flow<State<Powerstats?>> =
        wrapWithFlow { API.apiService.getSuperHeroPowerstats(KEY_API, characterId) }

    fun getSuperHeroBiography(characterId: Int)
            : Flow<State<Biography?>> =
        wrapWithFlow { API.apiService.getSuperHeroBiography(KEY_API, characterId) }

    fun getSuperHeroAppearance(characterId: Int)
            : Flow<State<Appearance?>> =
        wrapWithFlow { API.apiService.getSuperHeroAppearance(KEY_API, characterId) }

    fun getSuperHeroWork(characterId: Int)
            : Flow<State<Work?>> =
        wrapWithFlow { API.apiService.getSuperHeroWork(KEY_API, characterId) }

    fun getSuperHeroConnections(characterId: Int)
            : Flow<State<Connections?>> =
        wrapWithFlow { API.apiService.getSuperHeroConnections(KEY_API, characterId) }

    fun getSuperHeroImage(characterId: Int)
            : Flow<State<Image?>> =
        wrapWithFlow { API.apiService.getSuperHeroImage(KEY_API, characterId) }


    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>>
        = flow {
               emit(State.Loading)
               emit(checkIsSuccessful(function()))
        }

    private fun <T> checkIsSuccessful(response: Response<T>): State<T?>
        = try {
             if (response.isSuccessful)  State.Success(response.body())
             else   State.Error(response.message())
        } catch (e: Exception) {
             State.Error(e.message.toString())
        }

}