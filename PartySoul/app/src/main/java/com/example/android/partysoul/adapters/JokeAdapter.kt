package com.example.android.partysoul.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.partysoul.R
import com.example.android.partysoul.models.Joke
import kotlinx.android.synthetic.main.prototype_joke.view.*

class JokeAdapter(val jokes: List<Joke>) : RecyclerView.Adapter<JokePrototype>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokePrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_joke, parent, false)

        return JokePrototype(view)
    }

    override fun getItemCount(): Int {
        return  jokes.size
    }

    override fun onBindViewHolder(prototype: JokePrototype, position: Int) {
        prototype.bind(jokes[position])
    }
}

class JokePrototype(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvSource= itemView.tvSource
        val tvJokeId = itemView.tvJokeId
        val tvContent = itemView.tvContent
        val tvCreatedAt = itemView.tvCreatedAt
        val tvRating = itemView.tvRating
        fun bind(joke: Joke){
            tvSource.text = joke.source
            tvJokeId.text = joke.jokeId
            tvContent.text= joke.content
            tvCreatedAt.text = joke.createdAt
            tvRating.text= joke.rating

        }
}
