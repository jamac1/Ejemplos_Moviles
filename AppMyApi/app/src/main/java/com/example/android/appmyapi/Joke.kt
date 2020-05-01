package com.example.android.appmyapi

import com.google.gson.annotations.SerializedName

class Joke(
    @SerializedName("joke")
    var joke: String
)