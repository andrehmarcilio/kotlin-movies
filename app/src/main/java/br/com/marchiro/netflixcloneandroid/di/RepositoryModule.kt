package br.com.marchiro.netflixcloneandroid.di

import br.com.marchiro.netflixcloneandroid.data.remote.repository.FilmesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { FilmesRepository(get()) }
}