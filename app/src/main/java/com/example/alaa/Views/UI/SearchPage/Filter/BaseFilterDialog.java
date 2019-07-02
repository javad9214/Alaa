package com.example.alaa.Views.UI.SearchPage.Filter;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alaa.R;
import com.example.alaa.Views.UI.CustomViews.FilteringStepGuide;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class BaseFilterDialog extends BottomSheetDialogFragment implements FilteringStepGuide.StepSelectListener {

    private View view ;
    private FilteringStepGuide stepGuide ;
    public static final String TAG = "===>" ;
    private NavController navController ;

    public BaseFilterDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_base_filter_dialog, container, false);

        NavHostFragment hostFragment = (NavHostFragment) Objects.requireNonNull(getActivity()).getSupportFragmentManager().findFragmentById(R.id.mainNavigationFragment);
        navController = Objects.requireNonNull(hostFragment).getNavController();
        navController.popBackStack();

        stepGuide = view.findViewById(R.id.FilteringStepGuide);
        stepGuide.setStepSelectListener(this);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getLabel() != null) {
                    switch (destination.getLabel().toString()){

                        case "Filter_EducationSystem" :
                            stepGuide.updateFilterStep(0);
                            break;
                        case "fragment_filter_grade" :
                            stepGuide.updateFilterStep(1);
                            break;
                        case "fragment_filter_major" :
                            stepGuide.updateFilterStep(2);
                            break;

                        case "fragment_filter_lesson" :
                            stepGuide.updateFilterStep(3);
                            break;

                        case "fragment_filter_teacher" :
                            stepGuide.updateFilterStep(4);
                            break;
                    }
                }
            }
        });

        return view ;
    }


    @Override
    public void onStepSelected(int selectedStep) {
        switch (selectedStep){

            case 1 : navController.navigate(R.id.filter_EducationSystem);
                break;

            case 2 : navController.navigate(R.id.filterGrade);
                break;

            case 3 : navController.navigate(R.id.filterMajor);
                break;

            case 4: navController.navigate(R.id.filterLesson);
                break;

            case 5 : navController.navigate(R.id.filterTeacher);
                break;


        }
    }
}
