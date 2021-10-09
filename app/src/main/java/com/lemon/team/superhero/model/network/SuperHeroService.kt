package com.lemon.team.superhero.model.network

import com.lemon.team.superhero.model.reponse.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroService {

    @GET("api/{access-token}/{character-id}")
    suspend fun getSuperHeroInfo(
        @Path("access-token") apiKey: String,
        @Path("character-id") characterId: String,
    ): Response<SuperHeroInfoResponse>

    @GET("api/{access-token}/{character-id}/powerstats")
    suspend fun getSuperHeroPowerstats(
        @Path("access-token") apiKey: String,
        @Path("character-id") characterId: String,
    ): Response<Powerstats>

    @GET("api/{access-token}/{character-id}/biography")
    suspend fun getSuperHeroBiography(
        @Path("access-token") apiKey: String,
        @Path("character-id") characterId: String,
    ): Response<Biography>

    @GET("api/{access-token}/{character-id}/appearance")
    suspend fun getSuperHeroAppearance(
        @Path("access-token") apiKey: String,
        @Path("character-id") characterId: Int,
    ): Response<Appearance>

    @GET("api/{access-token}/{character-id}/work")
    suspend fun getSuperHeroWork(
        @Path("access-token") apiKey: String,
        @Path("character-id") characterId: Int,
    ): Response<Work>

    @GET("api/{access-token}/{character-id}/connections")
    suspend fun getSuperHeroConnections(
        @Path("access-token") apiKey: String,
        @Path("character-id") characterId: Int,
    ): Response<Connections>

    @GET("api/{access-token}/{character-id}/image")
    suspend fun getSuperHeroImage(
        @Path("access-token") apiKey: String,
        @Path("character-id") characterId: Int,
    ): Response<Image>

    @GET("api/{access-token}/search/{character-name}")
    suspend fun getSuperHeroSearchResult(
        @Path("access-token") apiKey: String,
        @Path("character-name") characterName: String,
    ): Response<SuperHeroSearchResultResponse>

}