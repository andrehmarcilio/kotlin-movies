package br.com.marchiro.netflixcloneandroid.data.remote.dto

import com.google.gson.annotations.SerializedName

data class FilmeResponseDTO(
    val page: Int,
    @SerializedName("results")
    val movieList: List<FilmeDTO>
)