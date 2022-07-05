package org.techtown.retrofit2basic

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import com.google.gson.GsonBuilder

import com.google.gson.Gson

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

//    fun getUnsafeOkHttpClient(): OkHttpClient.Builder {
//        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
//            override fun checkClientTrusted(p0: Array<out X509Certificate>?, authType: String?) {
//
//            }
//
//            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
//
//            }
//
//            override fun getAcceptedIssuers(): Array<X509Certificate> {
//                return arrayOf()
//            }
//        })
//
//        val sslContext = SSLContext.getInstance("SSL")
//        sslContext.init(null, trustAllCerts, SecureRandom())
//
//        val sslSocketFactory = sslContext.socketFactory
//
//        val builder = OkHttpClient.Builder()
//        builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
//        builder.hostnameVerifier { hostname, session -> true }
//
//        return builder
//    }
    var gson = GsonBuilder()
        .setLenient()
        .create()
}