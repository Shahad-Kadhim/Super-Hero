package com.lemon.team.superhero.model.data.superHeroResponse


import com.google.gson.annotations.SerializedName

data class Connections(
    @SerializedName("group-affiliation")
    val groupAffiliation: String? = null,
    @SerializedName("relatives")
    val relatives: String? = null
)