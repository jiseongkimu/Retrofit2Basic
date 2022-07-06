package org.techtown.retrofit2basic

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("createDt")
    fun setText1(view: TextView, text: String){
        view.text = "createDt : " + text
    }

    @JvmStatic
    @BindingAdapter("decideCnt")
    fun setText2(view: TextView, text: String){
        view.text = "decideCnt : " + text
    }

    @JvmStatic
    @BindingAdapter("deathCnt")
    fun setText3(view: TextView, text: String){
        view.text = "deathCnt : " + text
    }

    @JvmStatic
    @BindingAdapter("visible")
    fun isVisible(view: View, isGone: Boolean) {
        view.visibility = if (isGone) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    @JvmStatic
    @BindingAdapter("setVisiblrBtnText")
    fun setVisiblrBtnText(view: TextView, isGone: Boolean) {
        view.text = if(isGone) "VISIBLE" else "INVISIBLE"
    }
}