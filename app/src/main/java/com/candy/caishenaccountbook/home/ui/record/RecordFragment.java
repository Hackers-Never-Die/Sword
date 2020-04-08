package com.candy.caishenaccountbook.home.ui.record;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.candy.caishenaccountbook.R;
import com.candy.caishenaccountbook.record.RecordActivity;

public class RecordFragment extends Fragment implements View.OnClickListener {

    private RecordViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(RecordViewModel.class);
        View root = inflater.inflate(R.layout.fragment_record, container, false);
        TextView recordInTV = root.findViewById(R.id.text_record_in);
        TextView recordOutTV = root.findViewById(R.id.text_record_out);
        recordInTV.setOnClickListener(this);
        recordOutTV.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_record_in:
                onRecordInClick();
                break;
            case R.id.text_record_out:
                onRecordOutClick();
                break;
            default:
                break;
        }
    }

    private void onRecordInClick() {
        RecordActivity.start(getActivity(), true);
    }

    private void onRecordOutClick() {
        RecordActivity.start(getActivity(), false);
    }
}
