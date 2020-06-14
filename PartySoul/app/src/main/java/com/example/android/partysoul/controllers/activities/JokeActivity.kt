package com.example.android.partysoul.controllers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.android.partysoul.R
import com.example.android.partysoul.adapters.JokeAdapter
import com.example.android.partysoul.models.Joke

class JokeActivity : AppCompatActivity() {
    lateinit var jokes: List<Joke>
    lateinit var jokeAdapter: JokeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)
        loadjoke()
    }
    private fun loadjoke(){

    }
}
