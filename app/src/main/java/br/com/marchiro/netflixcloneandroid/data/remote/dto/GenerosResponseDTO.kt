package br.com.marchiro.netflixcloneandroid.data.remote.dto

import com.google.gson.annotations.SerializedName

data class GenerosResponseDTO(
    @SerializedName("genres") val generos: List<GenerosDTO>,
)