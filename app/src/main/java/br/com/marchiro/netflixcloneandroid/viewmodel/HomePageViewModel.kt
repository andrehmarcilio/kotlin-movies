package br.com.marchiro.netflixcloneandroid.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.marchiro.netflixcloneandroid.data.remote.dto.FilmeResponseDTO
import br.com.marchiro.netflixcloneandroid.data.remote.dto.GenerosDTO
import br.com.marchiro.netflixcloneandroid.data.remote.dto.GenerosResponseDTO
import br.com.marchiro.netflixcloneandroid.domain.ListarFilmesPorGeneroUseCase
import br.com.marchiro.netflixcloneandroid.domain.ListarGenerosUseCase
import br.com.marchiro.netflixcloneandroid.model.FilmesPorGenero
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageViewModel(private val listarGenerosUseCase: ListarGenerosUseCase,
                        private val listarFilmesPorGeneroUseCase: ListarFilmesPorGeneroUseCase) :
    ViewModel() {

     private val _filmesPorGeneroFlow: MutableLiveData<List<FilmesPorGenero>> = MutableLiveData(listOf())

    val filmesPorGeneroFlow: LiveData<List<FilmesPorGenero>> = _filmesPorGeneroFlow


    fun buscarGeneros() {
        CoroutineScope(Dispatchers.IO).launch {
            listarGenerosUseCase()
                .enqueue(object : Callback<GenerosResponseDTO> {
                    override fun onResponse(
                        call: Call<GenerosResponseDTO>,
                        response: Response<GenerosResponseDTO>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.generos?.let { generos ->
                                buscarFilmes(generos)
                            }
                        }
                    }
                    override fun onFailure(call: Call<GenerosResponseDTO>, t: Throwable) {
                        Log.e("HomePageLegal", "onFailure: ", t)
                    }
                }
                )
        }
    }

    private fun buscarFilmes(generos: List<GenerosDTO>) {

        val listaFilmesPorGenero: MutableList<FilmesPorGenero> = mutableListOf()
        CoroutineScope(Dispatchers.IO).launch {
            generos.forEach { genero ->
                listarFilmesPorGeneroUseCase(genero.id)
                    .enqueue(object : Callback<FilmeResponseDTO> {
                        override fun onResponse(
                            call: Call<FilmeResponseDTO>,
                            response: Response<FilmeResponseDTO>
                        ) {
                            if (response.isSuccessful) {
                                response.body()?.movieList?.let { movies ->
                                    listaFilmesPorGenero.add(FilmesPorGenero(movies, genero))
                                    _filmesPorGeneroFlow.value = listaFilmesPorGenero
                                }
                            }
                        }
                        override fun onFailure(call: Call<FilmeResponseDTO>, t: Throwable) {
                            Log.e("HomePageLegal", "onFailure: ", t)
                        }
                    })
            }
        }
    }

}