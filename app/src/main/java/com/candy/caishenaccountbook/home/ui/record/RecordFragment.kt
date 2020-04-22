package com.candy.caishenaccountbook.home.ui.record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.candy.caishenaccountbook.R
import com.candy.caishenaccountbook.base.BaseActivity
import com.candy.caishenaccountbook.record.RecordActivity

class RecordFragment : Fragment() , View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_record, container, false)
        initView(rootView)
        return rootView
    }

    private fun initView(view : View) {
        view.findViewById<TextView>(R.id.text_record_in).setOnClickListener(this)
        view.findViewById<TextView>(R.id.text_record_out).setOnClickListener(this)
        (activity as BaseActivity).changeStatusBarColor(R.color.themeColor)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.text_record_out -> skipActivity(false)
            R.id.text_record_in -> skipActivity(true)
        }
    }

    private fun skipActivity(isRecordIn : Boolean) {
        RecordActivity.start(this.activity!!, isRecordIn)
    }
}