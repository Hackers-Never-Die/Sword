package com.candy.caishenaccountbook.base

import android.content.Context
import android.content.SharedPreferences

class AccountSession(context : Context) {

    private val ACCOUNT_SP_NAME : String = "account_session"
    private val IS_LOGIN : String = "isLogin"
    private var context : Context? = null
    private var accountSp : SharedPreferences? = null

    init {
        this.context = context
        this.accountSp = context.getSharedPreferences(ACCOUNT_SP_NAME, Context.MODE_PRIVATE)
    }

    fun isLogin() : Boolean {
        return accountSp!!.getBoolean(IS_LOGIN, false)
    }

    fun markLogin(isLogin : Boolean) {
        accountSp!!.edit().putBoolean(IS_LOGIN, isLogin).apply()
    }
}