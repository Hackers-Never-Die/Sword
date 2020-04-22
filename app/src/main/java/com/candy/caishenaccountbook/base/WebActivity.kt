package com.candy.caishenaccountbook.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.widget.Toolbar
import com.candy.caishenaccountbook.R

class WebActivity : BaseActivity() {

    var mUrl : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        parseIntent()
        initView()
    }

    private fun parseIntent() {
        mUrl = intent.getStringExtra(URL)
    }
    private fun initView() {
        val toolbar = findViewById<Toolbar>(R.id.web_toolbar)
        setSupportActionBar(toolbar)
        changeStatusBarColor(R.color.themeColor)
        val webContainer = findViewById<WebView>(R.id.webview)
        webContainer.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
        webContainer.webChromeClient = object : WebChromeClient() {

        }
        webContainer.loadUrl(mUrl)

    }

    companion object {
        val URL : String = "URL"

        fun start(context : Context, url : String = "http://www.baidu.com") {
            val intent = Intent()
            intent.setClass(context, WebActivity::class.java)
            intent.putExtra(URL, url)
            context.startActivity(intent)
        }
    }
}
