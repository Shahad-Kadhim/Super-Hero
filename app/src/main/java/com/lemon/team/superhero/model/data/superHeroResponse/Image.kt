package com.lemon.team.superhero.model.data.superHeroResponse


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("url")
    val url: String? = null
)