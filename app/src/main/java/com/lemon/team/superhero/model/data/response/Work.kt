package com.lemon.team.superhero.model.data.response


import com.google.gson.annotations.SerializedName

data class Work(
    @SerializedName("base")
    val base: String? = null,
    @SerializedName("occupation")
    val occupation: String? = null
)