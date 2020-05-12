package com.example.android.appmyjob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSearch.setOnClickListener {
            searchJob()
        }
    }

    private fun searchJob() {
        val description = etDescription.text.toString()

        //voy a crear la instancia de retrofit
        val retrofit = Retrofit.Builder().baseUrl("https://jobs.github.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(JobService::class.java)
        val request = service.searchJob(description)
        request.enqueue(object: Callback<List<Job>>{
            override fun onFailure(call: Call<List<Job>>, t: Throwable) {
                //gestion si hay error

            }

            override fun onResponse(call: Call<List<Job>>, response: Response<List<Job>>) {
                //codigo cuando da la respuesta
            }

        })
    }
}
