package com.lemon.team.superhero.model.data.SearchSuperHeroResponse

import com.google.gson.annotations.SerializedName
import com.lemon.team.superhero.model.data.superHeroResponse.SuperHeroResponse

data class SearchCharacterResponse(
    @SerializedName("response")
    val response: String? = null,
    @SerializedName("results")
    val results: List<SuperHeroResponse>? = null,
    @SerializedName("results-for")
    val resultsFor: String? = null
)