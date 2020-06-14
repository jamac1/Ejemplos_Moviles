package com.example.android.apifilm

import androidx.annotation.IntegerRes
import com.google.gson.annotations.SerializedName

class FilmDetail (
    @SerializedName("page")
    val page : Int,
    @SerializedName("total_results")
    val total_result : Int,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("results")
    val results: List<Film>

)