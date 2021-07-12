package com.nipun.evaluation5


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("resultCount")
    var resultCount: Int?,
    @SerializedName("results")
    var results: List<Result>?
)