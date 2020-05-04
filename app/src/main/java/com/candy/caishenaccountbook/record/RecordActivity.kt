package com.candy.caishenaccountbook.record

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.candy.caishenaccountbook.R
import com.candy.caishenaccountbook.base.BaseActivity
import com.candy.caishenaccountbook.record.ui.RecordInFragment
import com.candy.caishenaccountbook.record.ui.RecordOutFragment

class RecordActivity : BaseActivity(){

    private var mToolbar: androidx.appcompat.widget.Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        changeStatusBarColor(R.color.themeColor)
        parseIntent(intent)
    }

    private fun parseIntent(intent: Intent) {
        val isRecordIn = intent.getBooleanExtra(RECORD, true)
        if (isRecordIn) {
            showFragment(RecordInFragment())
        } else {
            showFragment(RecordOutFragment())
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(R.id.record_container, fragment).commit()
    }

    companion object {
        private val RECORD = "isRecordIn"

        fun start(context: Context, isRecordIn: Boolean) {
            val starter = Intent(context, RecordActivity::class.java)
            starter.putExtra(RECORD, isRecordIn)
            context.startActivity(starter)
        }
    }
}