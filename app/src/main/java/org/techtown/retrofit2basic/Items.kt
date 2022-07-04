package org.techtown.retrofit2basic


import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("item")
    val item: List<Item?>?
)