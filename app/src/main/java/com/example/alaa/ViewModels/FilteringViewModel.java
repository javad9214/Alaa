package com.example.alaa.ViewModels;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class FilteringViewModel extends ViewModel {

    private static String currentStep = null;
    private ArrayList<String> steps = new ArrayList<>() ;

    public void setCurrentStep(int Step){
        currentStep = steps.get(Step);
    }

    public String getCurrentStep() {
        return currentStep;
    }

    private void setSteps (){
        steps.add(0 , "Filter_EducationSystem");
        steps.add(1 , "Filter_Grade");
        steps.add(2 , "Filter_Major");
        steps.add(3 , "Filter_Lesson");
        steps.add(4 , "Filter_Teacher");
    }

    public FilteringViewModel() {
        super();
        setSteps();
    }


}
