package com.example.alaa.Views.UI.CustomViews

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
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
        typed.recycle()
        initButtonSteps()
        setActiveStepColor()
    }

    private fun initButtonSteps() {
        btnEducationSystem = findViewById(R.id.btn_nav_filter_educationSystem)
        btnGrade = findViewById(R.id.btn_nav_filter_grade)
        btnGrade.setBackgroundColor(Color.CYAN)
        btnMajor = findViewById(R.id.btn_nav_filter_major)
        btnLesson = findViewById(R.id.btn_nav_filter_lesson)
        btnTeacher = findViewById(R.id.btn_nav_filter_teacher)
    }

    private fun setActiveStepColor() {
        when (currentStep) {
            1 -> Toast.makeText(context , "Choose Education System " , Toast.LENGTH_SHORT).show()
        }
    }


}
