package com.lemon.team.superhero.model.data.response


import com.google.gson.annotations.SerializedName

data class SuperHeroResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("image")
    val image: Image? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("appearance")
    val appearance: Appearance? = null,
    @SerializedName("biography")
    val biography: Biography? = null,
    @SerializedName("connections")
    val connections: Connections? = null,
    @SerializedName("powerstats")
    val powerstats: Powerstats? = null,
    @SerializedName("response")
    val response: String? = null,
    @SerializedName("work")
    val work: Work? = null
)