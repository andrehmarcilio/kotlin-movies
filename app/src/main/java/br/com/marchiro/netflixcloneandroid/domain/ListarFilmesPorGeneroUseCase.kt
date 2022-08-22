package br.com.marchiro.netflixcloneandroid.domain

import br.com.marchiro.netflixcloneandroid.data.remote.repository.IFilmesRepository

class ListarFilmesPorGeneroUseCase(private val repository: IFilmesRepository) {
    operator fun invoke(id: Int) = repository.getFilmePorGenenro(id)
}