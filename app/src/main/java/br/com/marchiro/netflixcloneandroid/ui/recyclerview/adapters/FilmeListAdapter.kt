package br.com.marchiro.netflixcloneandroid.ui.recyclerview.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.marchiro.netflixcloneandroid.data.remote.dto.FilmeDTO
import br.com.marchiro.netflixcloneandroid.databinding.FilmeItemBinding
import br.com.marchiro.netflixcloneandroid.ui.activitys.FILME_ID_KEY
import br.com.marchiro.netflixcloneandroid.ui.activitys.FilmeDetalhesActivity
import coil.load

class FilmeListAdapter(private val filmes: List<FilmeDTO>) :
    RecyclerView.Adapter<FilmeListAdapter.FilmeListViewHolder>() {


    inner class FilmeListViewHolder(private val binding: FilmeItemBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(filme: FilmeDTO) {
            binding.filmeItemIv.load(filme.getPosterLink())
            binding.root.setOnClickListener {
                Intent(context, FilmeDetalhesActivity::class.java).apply {
                    putExtra(FILME_ID_KEY, filme.id)
                    context.startActivity(this)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeListViewHolder {
        val binding =
            FilmeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmeListViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: FilmeListViewHolder, position: Int) {
        holder.bind(filmes[position])
    }

    override fun getItemCount(): Int = filmes.size

}
