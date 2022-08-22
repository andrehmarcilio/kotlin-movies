package br.com.marchiro.netflixcloneandroid.di

import br.com.marchiro.netflixcloneandroid.data.remote.repository.IFilmesRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    fun provideFilmeApi(retrofit: Retrofit): IFilmesRepository {
        return retrofit.create(IFilmesRepository::class.java)
    }

    single { provideFilmeApi(get()) }
}