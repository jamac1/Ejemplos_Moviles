package com.example.android.partysoul.models

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Joke (
   @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int = 0,
    val source: String,
    val jokeId: String,
    val content: String,
    val rating: String,
    val createdAt: String

)