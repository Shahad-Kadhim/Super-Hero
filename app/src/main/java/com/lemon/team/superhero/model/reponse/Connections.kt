package com.lemon.team.superhero.model.reponse


import com.google.gson.annotations.SerializedName

data class Connections(
    @SerializedName("response")
    val response: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("group-affiliation")
    val groupAffiliation: String? = null,
    @SerializedName("relatives")
    val relatives: String? = null
)