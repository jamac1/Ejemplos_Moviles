package com.example.android.xtrememovieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.android.xtrememovieapp.R
import com.example.android.xtrememovieapp.models.Film
import kotlinx.android.synthetic.main.prototype_film.view.*

class FilmAdapter(val films: List<Film>): RecyclerView.Adapter<FilmPrototype>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmPrototype {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prototype_film,parent,false)
        return FilmPrototype(view)
    }

    override fun getItemCount(): Int {
        return films.size
    }

    override fun onBindViewHolder(prototype: FilmPrototype, position: Int) {
        prototype.bind(films[position])
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
