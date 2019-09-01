package com.example.alaa.custom_views

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.alaa.R
import com.example.alaa.databinding.FilteringGuideStepBinding
import kotlinx.android.synthetic.main.filtering_guide_step.view.*


class FilteringStepGuide(context: Context, attributeSet: AttributeSet) : RelativeLayout(context, attributeSet) {


    private val TAG: String = "===>"

    // 1 : Education System   2 : Grade   3 : Major   4 : lesson   5 : teacher
    private var currentStep: Int = 0
    private var stepList = listOf<ButtonWithFont>()
    private lateinit var listener: StepSelectListener

     private var myView = View.inflate(context, R.layout.filtering_guide_step, this)
     var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
     var mBinding : FilteringGuideStepBinding


    init {
        mBinding = DataBindingUtil.inflate(inflater , R.layout.filtering_guide_step , parent as ViewGroup?, false)
        mBinding.education = "باشه"

        val typed: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.FilteringStepGuide, 0, 0)
        currentStep = typed.getInt(R.styleable.FilteringStepGuide_FilterGuideCurrentStep, 0)
        Log.i(TAG, currentStep.toString())
        typed.recycle()

        //setButtonsListener()


    }

    private fun dataBinding(){


    }

    private fun setButtonsListener() {
        Step_EducationSystem.setOnClickListener { listener.onStepSelected(1) }
        Step_Grade.setOnClickListener { listener.onStepSelected(2) }
        Step_Major.setOnClickListener { listener.onStepSelected(3) }
        Step_Lesson.setOnClickListener { listener.onStepSelected(4) }
        Step_Teacher.setOnClickListener { listener.onStepSelected(5) }
    }


    private fun setStepActive(buttonWithFont: ButtonWithFont) {
        buttonWithFont.backgroundTintList = ContextCompat.getColorStateList(context, R.color.colorAccent)
        buttonWithFont.setTextColor(ContextCompat.getColorStateList(context, R.color.pureWhite))
        buttonWithFont.iconTint = ContextCompat.getColorStateList(context, R.color.pureWhite)
        buttonWithFont.isEnabled = true
    }

    private fun setStepPassed(buttonWithFont: ButtonWithFont) {
        buttonWithFont.backgroundTintList = ContextCompat.getColorStateList(context, R.color.pureWhite)
        buttonWithFont.setTextColor(ContextCompat.getColorStateList(context, R.color.green))
        buttonWithFont.iconTint = ContextCompat.getColorStateList(context, R.color.green)
        buttonWithFont.strokeColor = ContextCompat.getColorStateList(context, R.color.default_gray)
    }

    private fun setStepDisable(buttonWithFont: ButtonWithFont) {
        buttonWithFont.backgroundTintList = ContextCompat.getColorStateList(context, R.color.pureWhite)
        buttonWithFont.setTextColor(ContextCompat.getColorStateList(context, R.color.blackTitle))
        buttonWithFont.iconTint = ContextCompat.getColorStateList(context, R.color.blackTitle)
        buttonWithFont.strokeColor = ContextCompat.getColorStateList(context, R.color.pureWhite)
        buttonWithFont.isEnabled = false
    }

    fun updateFilterStep(step: Int) {
       // scrollToCurrentStep(stepList[step])
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