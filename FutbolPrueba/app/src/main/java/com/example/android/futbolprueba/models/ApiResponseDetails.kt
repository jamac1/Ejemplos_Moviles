package com.example.android.futbolprueba.models

import com.google.gson.annotations.SerializedName

data class ApiResponseDetails (
    @SerializedName("results")
    var results: Int,
    @SerializedName("teams")
    var teams: List<Team>
)