package com.candy.caishenaccountbook.home.ui.accountbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.candy.caishenaccountbook.R
import com.candy.caishenaccountbook.base.BaseActivity

class AccountBookFragment : Fragment() {

    private var mTotalNumber : TextView? = null
    private var mIncomeNumber : TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as BaseActivity).changeStatusBarColor(R.color.themeColor)
        val view : View = inflater.inflate(R.layout.fragment_accountbook, container, false)
        initView(view)
        return  view
    }

    private fun initView(view : View) {
        mTotalNumber = view.findViewById(R.id.total_asset_number)
        mIncomeNumber = view.findViewById(R.id.today_income_number)
        mTotalNumber?.setOnClickListener {  }
    }
}