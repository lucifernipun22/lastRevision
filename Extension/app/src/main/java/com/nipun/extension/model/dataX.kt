package com.nipun.extension.model


import com.google.gson.annotations.SerializedName

data class dataX(
    @SerializedName("email")
    var email: String?,
    @SerializedName("password")
    var password: String?
)