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
         ""

    private val adapter by lazy { Adapter() }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.adapter = adapter

        ApiManager.getIntance().getData(api_key, 1, 10, 20200310, 20200315).enqueue((object :
            Callback<Item> {
            override fun onResponse(call: Call<Item>, response: Response<Item>) {
                if (response.isSuccessful) {
                    Log.d("TAG", "응 됐어" + response.body().toString())
                    response.body()?.let {
                        adapter.submitList(listOf(it)) // 어댑터 메소드에 리스트 넘겨줌
                        adapter.notifyDataSetChanged() // 어댑터 갱신하라고 츠발라마 하는 코드

//                        val adapter = Adapter(listOf(it))
//                        binding.rv.adapter = adapter // 어댑터연결
                    }

                }
            }

            override fun onFailure(call: Call<Item>, t: Throwable) {
                Log.d("TAG", "응 안됐어" + t.message.toString())
            }
        }))
    }
}
