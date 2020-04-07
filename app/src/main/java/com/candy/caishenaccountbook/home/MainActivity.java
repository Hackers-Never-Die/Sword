package com.candy.caishenaccountbook.home;

import android.os.Bundle;
import android.util.SparseArray;

import com.candy.caishenaccountbook.R;
import com.candy.caishenaccountbook.home.ui.accountbook.AccountBookFragment;
import com.candy.caishenaccountbook.home.ui.me.MeFragment;
import com.candy.caishenaccountbook.home.ui.record.RecordFragment;
import com.candy.rohmerui.RohmerBottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RohmerBottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setAdapter(createAdapter());
    }

    private RohmerBottomNavigationView.Adapter createAdapter() {
        SparseArray<Fragment> array = new SparseArray<>();
        array.put(R.id.navigation_me, new MeFragment());
        array.put(R.id.navigation_account, new AccountBookFragment());
        array.put(R.id.navigation_record, new RecordFragment());
        RohmerBottomNavigationView.Adapter adapter = new RohmerBottomNavigationView.Adapter(getSupportFragmentManager(), R.id.nav_container);
        adapter.setData(array);
        adapter.setFirstCheckItem(R.id.navigation_account);
        return adapter;
    }
}
