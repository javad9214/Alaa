package com.example.alaa.Views.UI.SearchPage.Filter;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alaa.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;


public class BaseFilterDialog extends BottomSheetDialogFragment {

    private View view ;

    public BaseFilterDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_base_filter_dialog, container, false);

        NavHostFragment hostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.mainNavigationFragment);
        NavController navController = hostFragment.getNavController();
        navController.popBackStack();

        return view ;
    }




}
