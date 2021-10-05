package com.lemon.team.superhero.model.reponse

import com.google.gson.annotations.SerializedName

data class SuperHeroInfoResponse (
    @SerializedName("response")
    val response: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("image")
    val image: Image? = null,
    @SerializedName("appearance")
    val appearance: Appearance? = null,
    @SerializedName("biography")
    val biography: Biography? = null,
    @SerializedName("connections")
    val connections: Connections? = null,
    @SerializedName("powerstats")
    val powerstats: Powerstats? = null,
    @SerializedName("work")
    val work: Work? = null
)