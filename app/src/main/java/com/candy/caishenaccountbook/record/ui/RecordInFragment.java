package com.candy.caishenaccountbook.record.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.candy.caishenaccountbook.R;
import com.candy.caishenaccountbook.bean.Record;

public class RecordInFragment extends Fragment {

    private Record mRecord = new Record();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record_in, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        EditText nameET = view.findViewById(R.id.name_et);
        nameET.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                mRecord.setName(s.toString());
            }
        });

        EditText countET = view.findViewById(R.id.count_et);
        countET.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                mRecord.setCount(Float.parseFloat(s.toString()));
            }
        });

        EditText rateET = view.findViewById(R.id.rate_et);
        rateET.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                mRecord.setRate(Float.parseFloat(s.toString()));
            }
        });

        EditText borrowET = view.findViewById(R.id.borrow_date_et);
        borrowET.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                mRecord.setBorrowTime(Long.parseLong(s.toString()));
            }
        });

        EditText returnET = view.findViewById(R.id.return_date_et);
        returnET.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                mRecord.setReturnTime(Long.parseLong(s.toString()));
            }
        });

        EditText noteET = view.findViewById(R.id.note_et);
        noteET.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                mRecord.setNote(s.toString());
            }
        });

        TextView finishTV = view.findViewById(R.id.finish);
        finishTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
