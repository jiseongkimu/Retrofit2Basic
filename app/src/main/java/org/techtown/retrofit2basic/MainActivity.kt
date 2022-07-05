package org.techtown.retrofit2basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import org.techtown.retrofit2basic.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private val api_key =
         "YyaJKps0/kekxwrrVHBWQ7og4zx/ABO7rPKD+wTMWfcZp3C4vBVp502qXVGBgNOKTWPGdmuMDR6M7Ei3SyfBTA=="
        // "YyaJKps0%2FkekxwrrVHBWQ7og4zx%2FABO7rPKD%2BwTMWfcZp3C4vBVp502qXVGBgNOKTWPGdmuMDR6M7Ei3SyfBTA%3D%3D"
    private val adapter by lazy { Adapter() }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.adapter = adapter

        ApiManager.getIntance().getData(api_key, 1, 10, 20200310, 20200315, "json").enqueue((object :
            Callback<DataClass> {
            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                Log.d("TAG", "onResponse : " + response.body().toString())
                if (response.isSuccessful) {
                    Log.d("TAG", "response.isSuccessful : " + response.body().toString())
                    response.body()?.let {
                        adapter.submitList(listOf(it)) // 어댑터 메소드에 리스트 넘겨줌
                        adapter.notifyDataSetChanged() // 어댑터 갱신하라고 츠발라마 하는 코드

//                        val adapter = Adapter(listOf(it))
//                        binding.rv.adapter = adapter // 어댑터연결
                    }

                }
            }

            override fun onFailure(call: Call<DataClass>, t: Throwable) {
                Log.d("TAG", "응 안됐어" + t.message.toString())
            }
        }))
    }
}