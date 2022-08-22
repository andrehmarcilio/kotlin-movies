package br.com.marchiro.netflixcloneandroid

import android.app.Application
import br.com.marchiro.netflixcloneandroid.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FilmesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@FilmesApp)
            modules(listOf(
                webClientModule,
                networkModule,
                apiModule,
                repositoryModule,
                viewModelModule,
                useCasesModule
            ))
        }
    }
}