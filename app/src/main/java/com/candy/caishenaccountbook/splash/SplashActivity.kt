package com.candy.caishenaccountbook.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.candy.caishenaccountbook.R
import com.candy.caishenaccountbook.base.BaseActivity
import com.candy.caishenaccountbook.home.MainActivity
import com.candy.caishenaccountbook.splash.ui.splash.SplashFragment

class SplashActivity : BaseActivity() {

    private val START : Int = 1

    private var handler : Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when(msg.what) {
                START -> skipToMain()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        changeStatusBarColor(R.color.themeColor)
        initView()
        var msg : Message = Message()
        msg.what = START
        handler.sendMessageDelayed(msg, 2000)
    }

    private fun initView() {
        supportFragmentManager.beginTransaction().add(R.id.splash_container, SplashFragment()).commit()
    }

    private fun skipToMain() {
        MainActivity.start(this)
        finish()
    }
}
