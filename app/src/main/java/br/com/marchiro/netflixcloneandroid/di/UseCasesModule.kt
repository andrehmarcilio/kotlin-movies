package br.com.marchiro.netflixcloneandroid.di

import br.com.marchiro.netflixcloneandroid.domain.ListarFilmesPorGeneroUseCase
import br.com.marchiro.netflixcloneandroid.domain.ListarGenerosUseCase
import br.com.marchiro.netflixcloneandroid.domain.PegarFilmesDetalhesUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { ListarGenerosUseCase(get()) }
    factory { ListarFilmesPorGeneroUseCase(get()) }
    factory { PegarFilmesDetalhesUseCase(get()) }
}