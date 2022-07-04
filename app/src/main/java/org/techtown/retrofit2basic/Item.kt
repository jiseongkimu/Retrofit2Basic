package org.techtown.retrofit2basic


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("accDefRate")
    val accDefRate: Double?,
    @SerializedName("accExamCnt")
    val accExamCnt: Int?,
    @SerializedName("createDt")
    val createDt: String?,
    @SerializedName("deathCnt")
    val deathCnt: Int?,
    @SerializedName("decideCnt")
    val decideCnt: Int?,
    @SerializedName("seq")
    val seq: Int?,
    @SerializedName("stateDt")
    val stateDt: Int?,
    @SerializedName("stateTime")
    val stateTime: String?,
    @SerializedName("updateDt")
    val updateDt: String?
)