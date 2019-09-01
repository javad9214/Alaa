package com.example.alaa.views.ui.search.Filter;


import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

import com.example.alaa.R;
import com.example.alaa.custom_views.FilteringStepGuide;
import com.example.alaa.viewModels.FilteringViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class BaseFilterDialog extends BottomSheetDialogFragment implements FilteringStepGuide.StepSelectListener , FilterItemSelected {


    private View view ;
    private FilteringStepGuide stepGuide ;
    public static final String TAG = "===>" ;
    private NavController navController ;
    private FilterEducationSystem filterEducationSystem ;
    private FilteringViewModel model ;
    private Filter filter ;

    public BaseFilterDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_base_filter_dialog, container, false);

        setFilter();

        model = ViewModelProviders.of(this).get(FilteringViewModel.class);

        NavHostFragment hostFragment = (NavHostFragment) Objects.requireNonNull(getActivity()).getSupportFragmentManager().findFragmentById(R.id.mainNavigationFragment);
        navController = Objects.requireNonNull(hostFragment).getNavController();
        navController.popBackStack();

        stepGuide = view.findViewById(R.id.FilteringStepGuide);
        stepGuide.setStepSelectListener(this);
        filterEducationSystem = new FilterEducationSystem();
        filterEducationSystem.filterItemSelectListener(this , "Fucking Kidding me ?");

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getLabel() != null) {
                    switch (destination.getLabel().toString()){

                        case "fragment_filter_EducationSystem" :
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
                        default:
                            //TODO:// default ?
                            break;
                    }
                }
            }
        });

        return view ;
    }

    private void setFilter(){
        filter = new Filter();
        
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


            default:
                //TODO:// default ?
                break;
        }
    }

    @Override
    public void onItemSelected(String item) {
        Toast.makeText(getContext() , item , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.i(TAG , "dialog dismissed !!");
    }
}
