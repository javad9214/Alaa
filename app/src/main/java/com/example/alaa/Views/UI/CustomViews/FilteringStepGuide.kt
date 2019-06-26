package com.example.alaa.Views.UI.CustomViews

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.RelativeLayout
import com.example.alaa.R

class FilteringStepGuide(context: Context, attributeSet: AttributeSet) : RelativeLayout(context, attributeSet) {

    private val TAG: String = "===>"

    // 1 : Education System  2 : Grade  3 :  Major  4 : Lesson  5 : Teacher
    private var currentStep: Int = 0

    init {
        View.inflate(context, R.layout.filtering_guide_step, this)
        val typed: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.FilteringStepGuide, 0, 0)
        currentStep = typed.getInt(R.styleable.FilteringStepGuide_FilterGuideCurrentStep, 0)
        Log.i(TAG, currentStep.toString())
        typed.recycle()

    }


}