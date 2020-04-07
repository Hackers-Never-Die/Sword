package com.candy.rohmerui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RohmerBottomNavigationView extends BottomNavigationView implements BottomNavigationView.OnNavigationItemSelectedListener  {

    private final static int UN_INIT = -1;

    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;

    private Adapter mAdapter;
    private int mCurrentId = UN_INIT;

    public RohmerBottomNavigationView(Context context) {
        super(context);
    }

    public RohmerBottomNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAdapter(Adapter adapter) {
        mAdapter = adapter;
        mFragmentManager = adapter.getFragmentManager();
        setOnNavigationItemSelectedListener(this);
        showFragment(adapter.getFirstCheckItem());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        showFragment(menuItem.getItemId());
        return true;
    }

    private void showFragment(int id) {
        if (mCurrentId != id) {
            if (mCurrentId != UN_INIT) {
                destroyFragment();
            }
            mCurrentId = id;
            realShowFragment(id);
        }
    }

    private void destroyFragment() {
        if (mFragmentTransaction == null) {
            mFragmentTransaction = mFragmentManager.beginTransaction();
        }
        String tag = mCurrentId + "";
        Fragment fragment = mFragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            mFragmentTransaction.detach(fragment);
            finishUpdate();
        }
    }

    private void realShowFragment(int id) {
        if (mFragmentTransaction == null) {
            mFragmentTransaction = mFragmentManager.beginTransaction();
        }
        String tag = id + "";
        Fragment fragment = mFragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            fragment = getItem(id);
            mFragmentTransaction.add(mAdapter.getContainerLayoutID(), fragment, tag);
        } else {
            mFragmentTransaction.attach(fragment);
        }
        finishUpdate();
    }

    private Fragment getItem(int id) {
        return mAdapter.getItem(id);
    }

    private void finishUpdate() {
        if (mFragmentTransaction != null) {
            mFragmentTransaction.commitAllowingStateLoss();
            mFragmentTransaction = null;
        }
    }
    public static class Adapter {

        private SparseArray<Fragment> array;
        private int containerLayoutID;
        private FragmentManager fragmentManager;
        private int firstCheckItem;

        public Adapter(FragmentManager fragmentManager , int containerLayoutID) {
            this.fragmentManager = fragmentManager;
            this.containerLayoutID = containerLayoutID;
        }

        public void setFirstCheckItem(int id) {
            this.firstCheckItem = id;
        }

        int getFirstCheckItem() {
            return firstCheckItem;
        }

        public void setData(SparseArray<Fragment> array) {
            this.array = array;
        }

        FragmentManager getFragmentManager() {
            return fragmentManager;
        }

        int getContainerLayoutID() {
            return containerLayoutID;
        }

        Fragment getItem(int id) {
            if (array != null) {
                return array.get(id);
            }
            return null;
        }
    }
}
