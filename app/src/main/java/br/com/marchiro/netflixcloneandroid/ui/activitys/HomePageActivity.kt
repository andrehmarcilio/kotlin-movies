package br.com.marchiro.netflixcloneandroid.ui.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import br.com.marchiro.netflixcloneandroid.databinding.ActivityHomePageBinding
import br.com.marchiro.netflixcloneandroid.ui.recyclerview.adapters.HomePageAdapter
import br.com.marchiro.netflixcloneandroid.viewmodel.HomePageViewModel
import coil.load
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding

    private val viewModel: HomePageViewModel by viewModel()

    private val adapter = HomePageAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.homePageRv.adapter = adapter
        buscarFilmes()
    }


    private fun buscarFilmes() {
        lifecycleScope.launch {
            viewModel.buscarGeneros()
            viewModel.filmesPorGeneroFlow.observe(this@HomePageActivity) { filmes ->
                MainScope().launch {
                    if (filmes.isNotEmpty()) {
                        adapter.atualizar(filmes)
                        binding.homePageDestaqueIv.load(
                            filmes.first().filmes.last().getImageLink()
                        )
                    }
                }
            }
        }
    }


}