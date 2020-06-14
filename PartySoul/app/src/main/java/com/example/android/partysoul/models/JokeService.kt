package com.example.android.partysoul.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeService {
    @GET("positions.json")
    fun searchJoke(@Query("description") description: String): Call<List<Joke>>
}