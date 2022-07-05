package org.techtown.retrofit2basic

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder

object ApiManager {

    private const val BASE_URL = "http://openapi.data.go.kr/openapi/service/rest/Covid19/"
    private lateinit var instance : ApiService

    fun getIntance() : ApiService{
        if(!::instance.isInitialized){
            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(
                    OkHttpClient.Builder()
                        // gradle 작업 필요
                        .addInterceptor(HttpLoggingInterceptor().apply{
                            level = HttpLoggingInterceptor.Level.BODY
                        })
                        .build()
                )
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ApiService::class.java)
        }
        return instance
    }

    var gson = GsonBuilder()
        .setLenient()
        .create()
}