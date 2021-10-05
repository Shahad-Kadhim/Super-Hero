package com.lemon.team.superhero.model.reponse

import com.google.gson.annotations.SerializedName

data class SuperHeroSearchResultResponse (
    @SerializedName("response")
    val response: String? = null,
    @SerializedName("results")
    val results: List<SuperHeroInfoResponse>? = null,
    @SerializedName("results-for")
    val resultsFor: String? = null
)