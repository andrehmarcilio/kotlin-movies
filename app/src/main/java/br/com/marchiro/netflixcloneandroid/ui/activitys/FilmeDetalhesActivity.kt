package br.com.marchiro.netflixcloneandroid.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import br.com.marchiro.netflixcloneandroid.databinding.ActivityFilmeDetalhesBinding
import br.com.marchiro.netflixcloneandroid.viewmodel.FilmesDetalhesViewModel
import coil.load
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilmeDetalhesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilmeDetalhesBinding
    private val viewModel: FilmesDetalhesViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmeDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.getIntExtra(FILME_ID_KEY, -1).let { id ->
            buscarFilmeDetalhes(id)
        }
    }

    private fun buscarFilmeDetalhes(id: Int) {
        lifecycleScope.launch {
            if(id != -1) {
                viewModel.getFilmeDetalhes(id)
                viewModel.filmeDetalheFlow.collect {
                    it?.let { filme ->
                        with(binding) {
                            filmeDetalhesIv.load(filme.getImageLink())
                            filmeDetalhesTitulo.text = filme.titulo
                            filmeDetalhesDescricao.text = filme.descricao
                        }
                    }
                }
            }
        }
    }
}