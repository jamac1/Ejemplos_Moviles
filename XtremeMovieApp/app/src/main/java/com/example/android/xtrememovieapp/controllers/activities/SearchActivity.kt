package com.example.android.xtrememovieapp.controllers.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.xtrememovieapp.R
import com.example.android.xtrememovieapp.adapters.FilmAdapter
import com.example.android.xtrememovieapp.models.Film
import com.example.android.xtrememovieapp.network.FilmService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchActivity : AppCompatActivity() {
    lateinit var films: List<Film>
    lateinit var filmAdapter : FilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        btnBuscar.setOnClickListener {
            searchFilm()
        }


    }

    private fun searchFilm() {
        var apikey  = "3cae426b920b29ed2fb1c0749f258325"
        val title = etFilm.text.toString()
        val retrofit = Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(FilmService::class.java)
        val request = service.searchFilms(apikey,title)
        request.enqueue(object : Callback<List<Film>> {
            override fun onFailure(call: Call<List<Film>>, t: Throwable) {
                Log.d("SearchActivity",t.toString())
            }

            override fun onResponse(call: Call<List<Film>>, response: Response<List<Film>>) {
               films = response.body()!!
                filmAdapter = FilmAdapter(films)
                rvFilm.adapter = filmAdapter
                rvFilm.layoutManager = LinearLayoutManager(this@SearchActivity)
            }


        })
    }
}
