package com.example.alaa.viewModels

import androidx.lifecycle.ViewModel

import java.util.ArrayList

class FilteringViewModel : ViewModel() {

    private val steps = ArrayList<String>()

    fun setCurrentStep(Step: Int) {
        currentStep = steps[Step]
    }

    fun getCurrentStep(): String? {
        return currentStep
    }

    private fun setSteps() {
        steps.add(0, "Filter_EducationSystem")
        steps.add(1, "Filter_Grade")
        steps.add(2, "Filter_Major")
        steps.add(3, "Filter_Lesson")
        steps.add(4, "Filter_Teacher")
    }

    init {
        setSteps()
    }

    companion object {

        private var currentStep: String? = null
    }

    var stateNum = 1
    private set // This is to prevent external modification of the variable.

    val state : State
    get() {
        return when(stateNum) {

            1 -> State.EducationSystem
            2 -> State.Grade
            3 -> State.Major
            4 -> State.Lesson
            5 -> State.Teacher

            else -> State.EducationSystem

        }
    }

}

enum class State {
    EducationSystem ,
    Grade ,
    Major ,
    Lesson ,
    Teacher
}
