package br.com.marchiro.netflixcloneandroid.di

import okhttp3.*
import org.koin.dsl.module


val webClientModule = module {
    fun getWebClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
            var request: Request = chain.request()
            val url: HttpUrl =
                request.url.newBuilder().addQueryParameter("api_key", key)
                    .addQueryParameter("language", "pt-BR").build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }).build()
    }

    single { getWebClient() }
}


const val key = "API_KEY_MOVIEDB_VERSÃO_3"