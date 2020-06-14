package com.example.android.apifilm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.film_prototype.view.*

class FilmAdapter(val films: List<Result>) : RecyclerView.Adapter<FilmPrototype>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmPrototype {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_prototype,parent,false)
        return FilmPrototype(view)
    }

    override fun getItemCount(): Int {
        return films.size
    }

    override fun onBindViewHolder(prototype: FilmPrototype, position: Int) {
        prototype.bind(films.get(position))
    }
}

class FilmPrototype(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvTitle = itemView.tvTitle
    val tvOverview = itemView.tvSipnose
    fun bind(film: Film){
        tvTitle.text = film.title
        tvOverview.text = film.overview
    }

}
