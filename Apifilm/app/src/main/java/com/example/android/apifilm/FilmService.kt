package com.example.android.apifilm

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmService {
    @GET("3/search/movie")
    fun searchFilms(@Query("api_key") api_key: String, @Query( "query") query: String): Call<FilmDetail>
}