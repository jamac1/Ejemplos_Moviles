package com.example.android.appejemplojob

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface JobService {
    @GET("positions.json")
    fun searchJob(@Query(value="description") description: String): Call<List<Job>>
}