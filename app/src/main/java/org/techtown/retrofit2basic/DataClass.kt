package org.techtown.retrofit2basic


import com.google.gson.annotations.SerializedName

data class DataClass(
    val response: Response
)

data class Response(
    val body: Body,
    val header: Header
)

data class Body(
    val items: Items,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
)


data class Header(
    val resultCode: String,
    val resultMsg: String
)

data class Items(
    val item: List<Item>
)

data class Item(
    val accDefRate: Double,
    val accExamCnt: Int,
    val createDt: String,
    val deathCnt: Int,
    val decideCnt: Int,
    val seq: Int,
    val stateDt: Int,
    var stateTime: String,
    val updateDt: String
)

