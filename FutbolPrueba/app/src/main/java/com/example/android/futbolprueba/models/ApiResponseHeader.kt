package com.example.android.futbolprueba.models

import com.google.gson.annotations.SerializedName

data class ApiResponseHeader (
    @SerializedName("api")
    var api: ApiResponseDetails
)