package com.candy.caishenaccountbook.record;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.candy.caishenaccountbook.R;
import com.candy.caishenaccountbook.record.ui.RecordInFragment;
import com.candy.caishenaccountbook.record.ui.RecordOutFragment;

public class RecordActivity extends AppCompatActivity {

    private static final String RECORD_IN = "isRecordIn";
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        parseIntent(getIntent());
        initView();
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(R.string.title_record);
    }

    private void parseIntent(Intent intent) {
        boolean isRecordIn = intent.getBooleanExtra(RECORD_IN, true);
        if (isRecordIn) {
            showFragment(new RecordInFragment());
        } else {
            showFragment(new RecordOutFragment());
        }
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.record_container, fragment).commit();
    }

    public static void start(Context context, boolean isRecordIn) {
        Intent starter = new Intent(context, RecordActivity.class);
        starter.putExtra(RECORD_IN, isRecordIn);
        context.startActivity(starter);
    }
}
