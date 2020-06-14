package com.example.android.xtrememovieapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "films"
)
data class Film (
    @PrimaryKey
    val filmId : Int =0,
    @SerializedName("title")
    val title: String?,

    @SerializedName("overview")
    val overview: String
)