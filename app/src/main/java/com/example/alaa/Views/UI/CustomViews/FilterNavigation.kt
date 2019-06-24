package com.example.alaa.Views.UI.CustomViews

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.nfc.Tag
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.alaa.R
import com.example.alaa.Views.UI.SearchPage.Filter.FilterEducationSystem
import com.google.android.material.button.MaterialButton

/**
 * TODO: document your custom view class.
 */
class FilterNavigation(context: Context, attributeSet: AttributeSet) : HorizontalScrollView(context, attributeSet) {

    private val TAG: String = "===>"

    private var currentStep: Int
    private lateinit var btnEducationSystem: MaterialButton
    private lateinit var btnGrade: MaterialButton
    private lateinit var btnMajor: MaterialButton
    private lateinit var btnLesson: MaterialButton
    private lateinit var btnTeacher: MaterialButton

    init {
        View.inflate(context, R.layout.filter_navigation, this)
        val typed: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.FilterNavigation, 0, 0)
        currentStep = typed.getInt(R.styleable.FilterNavigation_NavCurrentStep, 0)
        Log.i(TAG, currentStep.toString())
        typed.recycle()
        initButtonSteps()
        setActiveStepColor()
        disableNextButtons()
    }

    private fun initButtonSteps() {
        btnEducationSystem = this.findViewById(R.id.btn_nav_filter_educationSystem)
        btnGrade = this.findViewById(R.id.btn_nav_filter_grade)
        btnMajor = this.findViewById(R.id.btn_nav_filter_major)
        btnLesson = this.findViewById(R.id.btn_nav_filter_lesson)
        btnTeacher = this.findViewById(R.id.btn_nav_filter_teacher)
    }

    private fun setActiveStepColor() {
        when (currentStep) {
            1 -> btnEducationSystem.backgroundTintList = ContextCompat.getColorStateList(context, R.color.purple)
            2 -> btnGrade.backgroundTintList = ContextCompat.getColorStateList(context, R.color.purple)
            3 -> btnMajor.backgroundTintList = ContextCompat.getColorStateList(context, R.color.purple)
            4 -> btnLesson.backgroundTintList = ContextCompat.getColorStateList(context, R.color.purple)
            5 -> btnTeacher.backgroundTintList = ContextCompat.getColorStateList(context, R.color.purple)
        }

    }

    private fun disableNextButtons() {
        when (currentStep) {
            1 -> {
                disableButton(btnGrade)
                disableButton(btnMajor)
                disableButton(btnLesson)
                disableButton(btnTeacher)
            }

            2 -> {
                disableButton(btnMajor)
                disableButton(btnLesson)
                disableButton(btnTeacher)
            }
            3 -> {
                disableButton(btnLesson)
                disableButton(btnTeacher)
            }
            4 -> disableButton(btnTeacher)

        }
    }

    private fun disableButton(button: MaterialButton){
        button.isEnabled = false
    }

    private fun enableButton(button: MaterialButton){
        button.isEnabled = true
    }


}
