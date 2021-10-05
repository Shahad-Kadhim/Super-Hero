package com.lemon.team.superhero.model.network

import com.lemon.team.superhero.model.data.SearchSuperHeroResponse.SearchCharacterResponse
import com.lemon.team.superhero.model.data.superHeroResponse.SuperHeroResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroService {

    @GET("api/{access-token}/{character-id}")
    suspend fun getSuperHeroInfo(
        @Path("access-token") apiKey: String,
        @Path("character-id") characterId: Int,
    ): Response<SuperHeroResponse>

    @GET("api/{access-token}/search/{character-name}")
    suspend fun getSearchSuperHero(
        @Path("access-token") apiKey: String,
        @Path("character-name") characterName: String,
    ): Response<SearchCharacterResponse>

}