package com.nipun.extension.model


import com.google.gson.annotations.SerializedName

data class responseX(
    @SerializedName("id")
    var id: Int?,
    @SerializedName("token")
    var token: String?
)