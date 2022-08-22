package br.com.marchiro.netflixcloneandroid.data.remote.dto

import com.google.gson.annotations.SerializedName

data class GenerosDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nome: String
)