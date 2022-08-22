package br.com.marchiro.netflixcloneandroid.data.remote.repository

import br.com.marchiro.netflixcloneandroid.data.remote.dto.FilmeDTO
import br.com.marchiro.netflixcloneandroid.data.remote.dto.FilmeResponseDTO
import br.com.marchiro.netflixcloneandroid.data.remote.dto.GenerosResponseDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface IFilmesRepository {

    @GET("/3/movie/popular")
    fun getFilmesPopulares(
        @Query("page") page: String = "1"
    ): Call<FilmeResponseDTO>

    @GET("/3/movie/{id}")
    fun getFilmeDetalhes(
        @Path("id") id: Int,
    ): Call<FilmeDTO>

    @GET("/3/genre/movie/list")
    fun getGeneros(): Call<GenerosResponseDTO>

    @GET("/3/discover/movie")
    fun getFilmePorGenenro(
        @Query("with_genres") generoId: Int,
        @Query("page") page: String = "1",
    ): Call<FilmeResponseDTO>


}



