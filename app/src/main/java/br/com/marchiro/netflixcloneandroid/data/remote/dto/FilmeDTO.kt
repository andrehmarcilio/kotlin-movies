package br.com.marchiro.netflixcloneandroid.data.remote.dto

import com.google.gson.annotations.SerializedName

data class FilmeDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("backdrop_path") private val imagem: String,
    @SerializedName("poster_path") private val poster: String,
    @SerializedName("title") val titulo: String,
    @SerializedName("overview") val descricao: String
) {
    fun getImageLink() = "https://image.tmdb.org/t/p/w500$imagem"
    fun getPosterLink() = "https://image.tmdb.org/t/p/w500$poster"
}