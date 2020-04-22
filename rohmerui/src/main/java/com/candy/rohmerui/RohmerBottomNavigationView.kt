package com.candy.rohmerui

import android.content.Context
import android.util.AttributeSet
import android.util.SparseArray
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class RohmerBottomNavigationView(context : Context, attributeSet : AttributeSet) : BottomNavigationView(context, attributeSet) , BottomNavigationView.OnNavigationItemSelectedListener {

    private val UN_INIT = -1

    private var mFragmentTransaction: FragmentTransaction? = null
    private var mFragmentManager: FragmentManager? = null

    private var mAdapter: Adapter? = null
    private var mCurrentId = UN_INIT

    fun setAdapter(adapter: Adapter) {
        mAdapter = adapter
        mFragmentManager = adapter.fragmentManager
        setOnNavigationItemSelectedListener(this)
        showFragment(adapter.firstCheckItem)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        showFragment(menuItem.itemId)
        return true
    }

    private fun showFragment(id: Int) {
        if (mCurrentId != id) {
            if (mCurrentId != UN_INIT) {
                destroyFragment()
            }
            mCurrentId = id
            realShowFragment(id)
        }
    }

    private fun destroyFragment() {
        if (mFragmentTransaction == null) {
            mFragmentTransaction = mFragmentManager!!.beginTransaction()
        }
        val tag = mCurrentId.toString() + ""
        val fragment = mFragmentManager!!.findFragmentByTag(tag)
        if (fragment != null) {
            mFragmentTransaction!!.detach(fragment)
            finishUpdate()
        }
    }

    private fun realShowFragment(id: Int) {
        if (mFragmentTransaction == null) {
            mFragmentTransaction = mFragmentManager!!.beginTransaction()
        }
        val tag = id.toString() + ""
        var fragment = mFragmentManager!!.findFragmentByTag(tag)
        if (fragment == null) {
            fragment = getItem(id)
            mFragmentTransaction!!.add(mAdapter!!.containerLayoutID, fragment!!, tag)
        } else {
            mFragmentTransaction!!.attach(fragment)
        }
        finishUpdate()
    }

    private fun getItem(id: Int): Fragment? {
        return mAdapter!!.getItem(id)
    }

    private fun finishUpdate() {
        if (mFragmentTransaction != null) {
            mFragmentTransaction!!.commitAllowingStateLoss()
            mFragmentTransaction = null
        }
    }

    class Adapter(val fragmentManager: FragmentManager, val containerLayoutID: Int) {
        private var array: SparseArray<Fragment>? = null
        var firstCheckItem = 0

        fun setData(array: SparseArray<Fragment>?) {
            this.array = array
        }

        fun getItem(id: Int): Fragment? {
            return if (array != null) {
                array!![id]
            } else null
        }

    }
}