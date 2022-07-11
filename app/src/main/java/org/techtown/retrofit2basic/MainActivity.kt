package org.techtown.retrofit2basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.techtown.retrofit2basic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = DataBindingUtil.setContentView(this, R.layout.activity_main)

        bindingMain.tab1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.tab1, OneFragment())
        }

        bindingMain.tab2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.tab2, TwoFragment())
        }


    }
}
