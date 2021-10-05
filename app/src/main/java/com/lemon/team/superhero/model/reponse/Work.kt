package com.lemon.team.superhero.model.reponse


import com.google.gson.annotations.SerializedName

data class Work(
    @SerializedName("response")
    val response: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("base")
    val base: String? = null,
    @SerializedName("occupation")
    val occupation: String? = null
)