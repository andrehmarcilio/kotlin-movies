package br.com.marchiro.netflixcloneandroid.model

import br.com.marchiro.netflixcloneandroid.data.remote.dto.FilmeDTO
import br.com.marchiro.netflixcloneandroid.data.remote.dto.GenerosDTO

data class FilmesPorGenero (val filmes: List<FilmeDTO>, val genero: GenerosDTO)