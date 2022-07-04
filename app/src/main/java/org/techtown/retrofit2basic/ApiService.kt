package org.techtown.retrofit2basic

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("getCovid19InfStateJson")
    fun getData(@Query("serviceKey") serviceKey : String,
                @Query("pageNo") pageNo : Int,
                @Query("numOfRows") numOfRows : Int,
                @Query("startCreateDt") startCreateDt : Int,
                @Query("endCreateDt") endCreateDt : Int) : Call<Item>
}

// http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson
// ?serviceKey=YyaJKps0%2FkekxwrrVHBWQ7og4zx%2FABO7rPKD%2BwTMWfcZp3C4vBVp502qXVGBgNOKTWPGdmuMDR6M7Ei3SyfBTA%3D%3D
// &pageNo=1
// &numOfRows=10
// &startCreateDt=20200310
// &endCreateDt=20200315