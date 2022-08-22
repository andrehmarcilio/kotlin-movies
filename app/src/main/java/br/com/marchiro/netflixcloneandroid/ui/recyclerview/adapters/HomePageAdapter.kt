package br.com.marchiro.netflixcloneandroid.ui.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.marchiro.netflixcloneandroid.data.remote.dto.FilmeDTO
import br.com.marchiro.netflixcloneandroid.data.remote.dto.GenerosDTO
import br.com.marchiro.netflixcloneandroid.databinding.FilmeListItemBinding
import br.com.marchiro.netflixcloneandroid.model.FilmesPorGenero

class HomePageAdapter(filmesPorGenero: List<FilmesPorGenero> = listOf()) :
    RecyclerView.Adapter<HomePageAdapter.HomePageViewHolder>() {

    private var filmesPorGenero = filmesPorGenero.toMutableList()

    inner class HomePageViewHolder(private val binding: FilmeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(genero: GenerosDTO, filmes: List<FilmeDTO>) {
            binding.filmeItemTituloTv.text = genero.nome
            binding.filmeItemRv.adapter = FilmeListAdapter(filmes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        val binding =
            FilmeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomePageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        holder.bind(filmesPorGenero[position].genero, filmesPorGenero[position].filmes)
    }

    override fun getItemCount(): Int = filmesPorGenero.size


    fun atualizar(list: List<FilmesPorGenero>) {
        filmesPorGenero.clear()
        filmesPorGenero.addAll(list)
        notifyDataSetChanged()
    }

}
