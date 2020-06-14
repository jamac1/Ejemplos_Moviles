package com.example.android.apifilm

import com.google.gson.annotations.SerializedName

data class Film (
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String
)