package com.candy.caishenaccountbook.record.ui

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.candy.caishenaccountbook.R
import com.candy.caishenaccountbook.bean.Record

class RecordInFragment : Fragment() {

    val mRecord = Record()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_record_in, container, false)
        initView(view)
        return view
    }

    private fun initView(view : View) {
        view.findViewById<EditText>(R.id.name_et).addTextChangedListener(object : TextWatcherAdapter() {
            override fun afterTextChanged(s: Editable?) {
                super.afterTextChanged(s)
                mRecord.name = s.toString()
            }
        })
        view.findViewById<EditText>(R.id.borrow_date_et).addTextChangedListener(object : TextWatcherAdapter() {
            override fun afterTextChanged(s: Editable?) {
                super.afterTextChanged(s)
                mRecord.borrowTime = s.toString().toLong()
            }
        })
        view.findViewById<EditText>(R.id.return_date_et).addTextChangedListener(object : TextWatcherAdapter() {
            override fun afterTextChanged(s: Editable?) {
                super.afterTextChanged(s)
                mRecord.returnTime = s.toString().toLong()
            }
        })
        view.findViewById<EditText>(R.id.count_et).addTextChangedListener(object : TextWatcherAdapter() {
            override fun afterTextChanged(s: Editable?) {
                super.afterTextChanged(s)
            }
        })
        view.findViewById<EditText>(R.id.photo_et).addTextChangedListener(object : TextWatcherAdapter() {
            override fun afterTextChanged(s: Editable?) {
                super.afterTextChanged(s)
            }
        })
        view.findViewById<EditText>(R.id.rate_et).addTextChangedListener(object : TextWatcherAdapter() {
            override fun afterTextChanged(s: Editable?) {
                super.afterTextChanged(s)
                mRecord.rate = s.toString().toFloat()
            }
        })
        view.findViewById<EditText>(R.id.note_et).addTextChangedListener(object : TextWatcherAdapter() {
            override fun afterTextChanged(s: Editable?) {
                super.afterTextChanged(s)
                mRecord.note = s.toString()
            }
        })
        view.findViewById<TextView>(R.id.finish).setOnClickListener {  }

    }
}