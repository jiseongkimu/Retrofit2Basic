package org.techtown.retrofit2basic


import com.google.gson.annotations.SerializedName

data class dataClass(
    @SerializedName("response")
    val response: Response?
)