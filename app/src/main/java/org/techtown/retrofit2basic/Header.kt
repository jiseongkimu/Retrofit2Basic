package org.techtown.retrofit2basic


import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("resultCode")
    val resultCode: Int?,
    @SerializedName("resultMsg")
    val resultMsg: String?
)