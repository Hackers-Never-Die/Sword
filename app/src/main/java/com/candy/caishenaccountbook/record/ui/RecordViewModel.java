package com.candy.caishenaccountbook.record.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.candy.caishenaccountbook.bean.Record;

public class RecordViewModel extends ViewModel {

    private MutableLiveData<Record> record;

    public RecordViewModel() {
        record = new MutableLiveData<>();
    }
}
