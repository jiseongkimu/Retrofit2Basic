package org.techtown.retrofit2basic


import com.google.gson.annotations.SerializedName

data class testGson(
    @SerializedName("response")
    val response: Response?
)

data class Response(
    @SerializedName("body")
    val body: Body?,
    @SerializedName("header")
    val header: Header?
)

data class Body(
    @SerializedName("items")
    val items: Items?,
    @SerializedName("numOfRows")
    val numOfRows: Int?,
    @SerializedName("pageNo")
    val pageNo: Int?,
    @SerializedName("totalCount")
    val totalCount: Int?
)

data class Header(
    @SerializedName("resultCode")
    val resultCode: Int?,
    @SerializedName("resultMsg")
    val resultMsg: String?
)

data class Items(
    @SerializedName("item")
    val item: List<Item?>?
)


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