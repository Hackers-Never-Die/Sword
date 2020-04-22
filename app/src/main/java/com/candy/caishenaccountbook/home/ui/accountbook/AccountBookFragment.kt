package com.candy.caishenaccountbook.home.ui.accountbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.candy.caishenaccountbook.R
import com.candy.caishenaccountbook.base.BaseActivity

class AccountBookFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as BaseActivity).changeStatusBarColor(R.color.themeColor)
        return  inflater.inflate(R.layout.fragment_accountbook, container, false)
    }
}