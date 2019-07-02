package com.example.alaa.Views.UI.CustomViews

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.example.alaa.R
import kotlinx.android.synthetic.main.filtering_guide_step.view.*

class FilteringStepGuide(context: Context, attributeSet: AttributeSet) : RelativeLayout(context, attributeSet) {


    private val TAG: String = "===>"

    // 1 : Education System   2 : Grade   3 : Major   4 : Lesson   5 : Teacher
    private var currentStep: Int = 0
    private var stepList = listOf<MyButton>()
    private lateinit var listener: StepSelectListener

    private var myView = View.inflate(context, R.layout.filtering_guide_step, this)


    init {
        val typed: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.FilteringStepGuide, 0, 0)
        currentStep = typed.getInt(R.styleable.FilteringStepGuide_FilterGuideCurrentStep, 0)
        Log.i(TAG, currentStep.toString())
        typed.recycle()

        setStepList()
        setButtonsListener()


    }

    private fun setButtonsListener() {
        Step_EducationSystem.setOnClickListener { listener.onStepSelected(1) }
        Step_Grade.setOnClickListener { listener.onStepSelected(2) }
        Step_Major.setOnClickListener { listener.onStepSelected(3) }
        Step_Lesson.setOnClickListener { listener.onStepSelected(4) }
        Step_Teacher.setOnClickListener { listener.onStepSelected(5) }
    }

    private fun setStepList() {

        stepList = listOf(Step_EducationSystem,
                Step_Grade,
                Step_Major,
                Step_Lesson,
                Step_Teacher)

    }

    private fun setStepActive(myButton: MyButton) {
        myButton.backgroundTintList = ContextCompat.getColorStateList(context, R.color.colorAccent)
        myButton.setTextColor(ContextCompat.getColorStateList(context, R.color.pureWhite))
        myButton.iconTint = ContextCompat.getColorStateList(context, R.color.pureWhite)
        myButton.isEnabled = true
    }

    private fun setStepPassed(myButton: MyButton) {
        myButton.backgroundTintList = ContextCompat.getColorStateList(context, R.color.pureWhite)
        myButton.setTextColor(ContextCompat.getColorStateList(context, R.color.green))
        myButton.iconTint = ContextCompat.getColorStateList(context, R.color.green)
        myButton.strokeColor = ContextCompat.getColorStateList(context, R.color.default_gray)
    }

    private fun setStepDisable(myButton: MyButton) {
        myButton.backgroundTintList = ContextCompat.getColorStateList(context, R.color.pureWhite)
        myButton.setTextColor(ContextCompat.getColorStateList(context, R.color.blackTitle))
        myButton.iconTint = ContextCompat.getColorStateList(context, R.color.blackTitle)
        myButton.strokeColor = ContextCompat.getColorStateList(context, R.color.pureWhite)
        myButton.isEnabled = false
    }

    fun updateFilterStep(step: Int) {
        setStepActive(stepList[step])
        when (step) {
            0 -> {
                setStepActive(stepList[0])
                setStepDisable(stepList[1])
                setStepDisable(stepList[2])
                setStepDisable(stepList[3])
                setStepDisable(stepList[4])
            }

            1 -> {
                setStepActive(stepList[1])
                setStepDisable(stepList[2])
                setStepDisable(stepList[3])
                setStepDisable(stepList[4])
                setStepPassed(stepList[0])
            }

            2 -> {
                setStepActive(stepList[2])
                setStepDisable(stepList[3])
                setStepDisable(stepList[4])
                setStepPassed(stepList[0])
                setStepPassed(stepList[1])
            }

            3 -> {
                setStepActive(stepList[3])
                setStepDisable(stepList[4])
                setStepPassed(stepList[0])
                setStepPassed(stepList[1])
                setStepPassed(stepList[2])
            }

            4 -> {
                setStepActive(stepList[4])
                setStepPassed(stepList[0])
                setStepPassed(stepList[1])
                setStepPassed(stepList[2])
                setStepPassed(stepList[3])
            }
        }

    }

    interface StepSelectListener {
        fun onStepSelected(selectedStep: Int)
    }

    fun setStepSelectListener(listener: StepSelectListener) {
        this.listener = listener
    }

}