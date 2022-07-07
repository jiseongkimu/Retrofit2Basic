package org.techtown.retrofit2basic

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    // 리사이클러뷰의 상태 확인을 위한 MutableLiveData
    var isVisible = MutableLiveData(false)

    // 버튼 클릭 감지 메서드
    fun onClickBtn(v : View){
        // 버튼 눌림 toggle
        isVisible.value = isVisible.value?.not()
    }


}