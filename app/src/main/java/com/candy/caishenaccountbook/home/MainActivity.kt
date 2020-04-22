package com.candy.caishenaccountbook.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.SparseArray
import android.view.View
import androidx.fragment.app.Fragment
import com.candy.caishenaccountbook.R
import com.candy.caishenaccountbook.base.BaseActivity
import com.candy.caishenaccountbook.home.ui.accountbook.AccountBookFragment
import com.candy.caishenaccountbook.home.ui.me.MeFragment
import com.candy.caishenaccountbook.home.ui.record.RecordFragment
import com.candy.rohmerui.RohmerBottomNavigationView

class MainActivity : BaseActivity() {

    var container : View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val navView = findViewById<RohmerBottomNavigationView>(R.id.nav_view)
        navView.setAdapter(createAdapter())
    }

    private fun createAdapter(): RohmerBottomNavigationView.Adapter {
        val array = SparseArray<Fragment>()
        array.put(R.id.navigation_me, MeFragment())
        array.put(R.id.navigation_account, AccountBookFragment())
        array.put(R.id.navigation_record, RecordFragment())
        val adapter = RohmerBottomNavigationView.Adapter(supportFragmentManager, R.id.nav_container)
        adapter.setData(array)
        adapter.firstCheckItem = R.id.navigation_account
        return adapter
    }

    companion object {
        fun start(context : Context) {
            val intent = Intent()
            intent.setClass(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}