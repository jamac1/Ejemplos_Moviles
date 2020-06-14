package com.example.android.apifilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var films: List<Result>
    lateinit var filmAdapter : FilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

        request.enqueue(object : Callback<film_details> {

            override fun onFailure(call: Call<film_details>, t: Throwable) {
                Log.d("Activity Fail", "Error: "+t.toString())
            }

            override fun onResponse(call: Call<film_details>, response: Response<film_details>) {
                films = response.body()
                filmAdapter = FilmAdapter(films)
                rvFilm.adapter = filmAdapter
                rvFilm.layoutManager = LinearLayoutManager(this@MainActivity)
            }


        })
    }
}

