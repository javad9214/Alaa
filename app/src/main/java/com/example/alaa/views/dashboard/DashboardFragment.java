package com.example.alaa.views.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.alaa.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class DashboardFragment extends BottomSheetDialogFragment {


    public static final String TAG = "===>" ;

    public DashboardFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile_fragment, container, false);


        return view;
    }


}
