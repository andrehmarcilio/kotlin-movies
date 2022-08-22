package br.com.marchiro.netflixcloneandroid.data.remote.repository

import br.com.marchiro.netflixcloneandroid.data.remote.dto.FilmeDTO
import br.com.marchiro.netflixcloneandroid.data.remote.dto.FilmeResponseDTO
import br.com.marchiro.netflixcloneandroid.data.remote.dto.GenerosResponseDTO
import retrofit2.Call

class FilmesRepository(private val api: IFilmesRepository) : IFilmesRepository {

    override fun getFilmesPopulares(
        page: String
    ): Call<FilmeResponseDTO> =
        api.getFilmesPopulares()


    override fun getFilmeDetalhes(id: Int): Call<FilmeDTO> =
        api.getFilmeDetalhes(id)

    override fun getGeneros(): Call<GenerosResponseDTO> =
        api.getGeneros()

    override fun getFilmePorGenenro(
        generoId: Int,
        page: String
    ): Call<FilmeResponseDTO> =
        api.getFilmePorGenenro(generoId)


}