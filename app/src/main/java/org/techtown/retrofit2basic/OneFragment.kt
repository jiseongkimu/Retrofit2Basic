package org.techtown.retrofit2basic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.techtown.retrofit2basic.databinding.FragmentTab1Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OneFragment : Fragment() {
    private val api_key =
        ""

    private val adapter by lazy { Adapter() }

    private lateinit var binding: FragmentTab1Binding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab1, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding = DataBindingUtil.setContentView(, R.layout.fragment_tab1)
        //activity?.let { binding = DataBindingUtil.setContentView(it, R.layout.fragment_tab1) }
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.isVisible.observe(viewLifecycleOwner) { isVisible ->
            if (isVisible) {
                binding.visibleTxt.text = "숨김"
                binding.loading = true
            } else {
                binding.visibleTxt.text = "표시"
                binding.loading = false
            }
        }

        with(binding) {
            viewModel = mainViewModel
        }

        binding.recyclerView.adapter = adapter
        binding.loading = false

        // 표시 상태로 변경
        binding.btnVisible.setOnClickListener {
            binding.loading = true
            binding.visibleTxt.text = "숨김"
        }

        // 숨김 상태로 변경
        binding.btnInvisible.setOnClickListener {
            binding.loading = false
            binding.visibleTxt.text = "표시"
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
    override fun onDestroy() {
        Log.d("TAG", "onDestroy()")
        super.onDestroy()
    }

}

