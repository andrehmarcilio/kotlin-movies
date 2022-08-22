package br.com.marchiro.netflixcloneandroid.di

import br.com.marchiro.netflixcloneandroid.viewmodel.FilmesDetalhesViewModel
import br.com.marchiro.netflixcloneandroid.viewmodel.HomePageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { FilmesDetalhesViewModel(get()) }
    viewModel { HomePageViewModel(get(), get()) }
}