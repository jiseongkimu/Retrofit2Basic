package org.techtown.retrofit2basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.techtown.retrofit2basic.databinding.ActivityMainBinding
import org.techtown.retrofit2basic.databinding.FragmentTab1Binding
import org.techtown.retrofit2basic.databinding.ItemViewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private val api_key =
        ""

    private val adapter by lazy { Adapter() }

    private lateinit var bindingMain: ActivityMainBinding
    private lateinit var bindingTab1: FragmentTab1Binding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bindingTab1 = FragmentTab1Binding.inflate(layoutInflater, con)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.isVisible.observe(this) { isVisible ->
            if (isVisible) {
                bindingTab1.visibleTxt.text = "숨김"
                bindingTab1.loading = true
            } else {
                bindingTab1.visibleTxt.text = "표시"
                bindingTab1.loading = false
            }
        }

        with(bindingTab1) {
            viewModel = mainViewModel
        }

        bindingTab1.recyclerView.adapter = adapter
        bindingTab1.loading = false

        bindingTab1.btnInvisible.setOnClickListener {
            bindingTab1.loading = false
        }

        bindingTab1.btnVisible.setOnClickListener {
            bindingTab1.loading = true
        }

        bindingMain.tab1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.tab1, OneFragment())
        }

        bindingMain.tab2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.tab2, TwoFragment())
        }

        ApiManager.getIntance().getData(api_key, 1, 10, 20200110, 20200615, "json")
            .enqueue((object :
                Callback<DataClass> {
                override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                    Log.d("TAG", "onResponse : " + response.body().toString())
                    if (response.isSuccessful) {
                        Log.d("TAG", "response.isSuccessful : " + response.body().toString())
                        response.body()?.let {

                            adapter.submitList(it.response.body.items.item) // 어댑터 메소드에 리스트 넘겨줌
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
