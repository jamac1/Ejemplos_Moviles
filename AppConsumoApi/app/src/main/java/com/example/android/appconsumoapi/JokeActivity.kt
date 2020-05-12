package com.example.android.appconsumoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_joke.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)
        btnjoke.setOnClickListener {
            loadJoke()
        }
    }

    private fun loadJoke() {
        val retrofit = Retrofit.Builder().baseUrl("https://geek-jokes.sameerkumar.website/").
        addConverterFactory(GsonConverterFactory.create())
            .build()
        //tvbroma.text = "Broma encontrada!!!"

    }
}
