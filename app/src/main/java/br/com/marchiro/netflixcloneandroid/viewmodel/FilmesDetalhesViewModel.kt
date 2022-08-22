package br.com.marchiro.netflixcloneandroid.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.marchiro.netflixcloneandroid.data.remote.dto.FilmeDTO
import br.com.marchiro.netflixcloneandroid.domain.PegarFilmesDetalhesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmesDetalhesViewModel(private val getFilmesDetalhesUseCase: PegarFilmesDetalhesUseCase ) : ViewModel() {

    private val _filmeDetalheFlow : MutableStateFlow<FilmeDTO?> = MutableStateFlow(null)
    val filmeDetalheFlow: StateFlow<FilmeDTO?> = _filmeDetalheFlow

    fun getFilmeDetalhes(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getFilmesDetalhesUseCase(id).enqueue(object : Callback<FilmeDTO> {
                override fun onResponse(call: Call<FilmeDTO>, response: Response<FilmeDTO>) {
                    if(response.isSuccessful) {
                        response.body()?.let {
                            _filmeDetalheFlow.value = it
                        }
                    }
                }
                override fun onFailure(call: Call<FilmeDTO>, t: Throwable) {
                    Log.e("FilmesDetalhesViewModel", "onFailure: ", t)
                }
            })
        }
    }
}