package com.lemon.team.superhero.model.reponse


import com.google.gson.annotations.SerializedName

data class Biography(
    @SerializedName("response")
    val response: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("aliases")
    val aliases: List<String>? = null,
    @SerializedName("alignment")
    val alignment: String? = null,
    @SerializedName("alter-egos")
    val alterEgos: String? = null,
    @SerializedName("first-appearance")
    val firstAppearance: String? = null,
    @SerializedName("full-name")
    val fullName: String? = null,
    @SerializedName("place-of-birth")
    val placeOfBirth: String? = null,
    @SerializedName("publisher")
    val publisher: String? = null
)