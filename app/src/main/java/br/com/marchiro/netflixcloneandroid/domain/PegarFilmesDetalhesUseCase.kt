package br.com.marchiro.netflixcloneandroid.domain

import br.com.marchiro.netflixcloneandroid.data.remote.repository.IFilmesRepository

class PegarFilmesDetalhesUseCase(private val repository: IFilmesRepository) {
    operator fun invoke(id: Int) = repository.getFilmeDetalhes(id)
}