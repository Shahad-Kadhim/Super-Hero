package com.lemon.team.superhero.model.data.superHeroResponse


import com.google.gson.annotations.SerializedName

data class Powerstats(
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