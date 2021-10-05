package com.lemon.team.superhero.model.reponse


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("response")
    val response: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)