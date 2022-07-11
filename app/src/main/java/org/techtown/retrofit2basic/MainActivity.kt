package org.techtown.retrofit2basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import org.techtown.retrofit2basic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = DataBindingUtil.setContentView(this, R.layout.activity_main)

        bindingMain.tab1.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
                .add(R.id.framelayout, OneFragment())
            transaction.commit()
            Log.d("TAB1","TAB1 눌리니?")
        }

        bindingMain.tab2.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
                .add(R.id.framelayout, TwoFragment())
            transaction.commit()
            Log.d("TAB2","TAB2 눌리니?")
        }


    }
}
