package br.com.marchiro.netflixcloneandroid.domain

import br.com.marchiro.netflixcloneandroid.data.remote.repository.IFilmesRepository

class ListarGenerosUseCase(private val repository: IFilmesRepository) {
    operator fun invoke() = repository.getGeneros()
}