package com.example.alaa.views.ui.search.filter;


import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alaa.R;
import com.example.alaa.customViews.FilteringStepGuide;
import com.example.alaa.viewModels.FilteringViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.jetbrains.annotations.NotNull;


/**
 * @author Mjavad
 * @date 2019/09/03
 */
public class BaseFilterDialog extends BottomSheetDialogFragment {


    public static final String TAG = "===>";

    public BaseFilterDialog() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private View view;


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_base_filter_dialog, container, false);

        init();

        return view;
    }

    private void init() {
        FilteringViewModel model = ViewModelProviders.of(this).get(FilteringViewModel.class);
        FilteringStepGuide stepGuide = view.findViewById(R.id.FilteringStepGuide);
        recyclerView = view.findViewById(R.id.recyclerFiltering);
    }

    private void setRecycler() {

    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.i(TAG, "dialog dismissed !!");
    }


}
