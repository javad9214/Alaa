package com.example.alaa.views.ui.search.Filter;


import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.alaa.R;
import com.example.alaa.custom_views.FilteringStepGuide;
import com.example.alaa.viewModels.FilteringViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;


/**
 * @author Mjavad
 * @date 2019/09/03
 */
public class BaseFilterDialog extends BottomSheetDialogFragment implements FilteringStepGuide.StepSelectListener, FilterItemSelected {


    public static final String TAG = "===>";

    private FilterEducationSystem filterEducationSystem;
    private FilterGrade filterGrade;
    private FilterMajor filterMajor;
    private FilterLesson filterLesson;
    private FilterTeacher filterTeacher;

    @Override
    public void registerForContextMenu(@NonNull View view) {
        super.registerForContextMenu(view);
    }

    public BaseFilterDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_base_filter_dialog, container, false);

        setFilter();

        FilteringViewModel model = ViewModelProviders.of(this).get(FilteringViewModel.class);

        FilteringStepGuide stepGuide = view.findViewById(R.id.FilteringStepGuide);
        stepGuide.setStepSelectListener(this);

        filterEducationSystem = new FilterEducationSystem();
        replaceFragment(filterEducationSystem);

        //  filterEducationSystem.filterItemSelectListener(this , "Fucking Kidding me ?");

        return view;
    }

    private void setFilter() {
        Filter filter = new Filter();

    }

    @Override
    public void onStepSelected(int selectedStep) {
        switch (selectedStep) {

            case 1:
                filterEducationSystem = new FilterEducationSystem();
                replaceFragment(filterEducationSystem);
                break;

            case 2:
                filterGrade = new FilterGrade();
                replaceFragment(filterGrade);
                break;

            case 3:
                filterMajor = new FilterMajor();
                replaceFragment(filterMajor);
                break;

            case 4:
                filterLesson = new FilterLesson();
                replaceFragment(filterLesson);
                break;

            case 5:
                filterTeacher = new FilterTeacher();
                replaceFragment(filterTeacher);
                break;

            default:
                //TODO:// default ?
                break;
        }
    }

    @Override
    public void onItemSelected(String item) {
        Toast.makeText(getContext(), item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.i(TAG, "dialog dismissed !!");
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out);
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
