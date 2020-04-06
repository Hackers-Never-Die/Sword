package com.candy.caishenaccountbook.ui.accountbook;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AccountBookViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AccountBookViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}