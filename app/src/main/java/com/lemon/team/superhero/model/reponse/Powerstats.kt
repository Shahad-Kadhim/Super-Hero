package com.lemon.team.superhero.model.reponse


import com.google.gson.annotations.SerializedName

data class Powerstats(
    @SerializedName("response")
    val response: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("combat")
    val combat: String? = null,
    @SerializedName("durability")
    val durability: String? = null,
    @SerializedName("intelligence")
    val intelligence: String? = null,
    @SerializedName("power")
    val power: String? = null,
    @SerializedName("speed")
    val speed: String? = null,
    @SerializedName("strength")
    val strength: String? = null
)