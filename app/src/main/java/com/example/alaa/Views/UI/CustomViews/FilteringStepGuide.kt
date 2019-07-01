package com.example.alaa.Views.UI.CustomViews

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import com.example.alaa.R
import com.example.alaa.Views.UI.SearchPage.Filter.FilterEducationSystem
import kotlinx.android.synthetic.main.filtering_guide_step.view.*

class FilteringStepGuide(context: Context, attributeSet: AttributeSet) : RelativeLayout(context, attributeSet) {

    private val TAG: String = "===>"

    // 1 : Education System  2 : Grade  3 :  Major  4 : Lesson  5 : Teacher
    private var currentStep: Int = 0

    private var myView  = View.inflate(context, R.layout.filtering_guide_step, this)

    private lateinit var stepEducationsystem : LinearLayout
    private lateinit var stepGrade : LinearLayout
    private lateinit var stepMajor : LinearLayout
    private lateinit var stepLesson : LinearLayout
    private lateinit var stepTeacher : LinearLayout

    private lateinit var textViewEducationSystem: MyTextView
    private lateinit var textViewGrade: MyTextView
    private lateinit var textViewMajor: MyTextView
    private lateinit var textViewLesson: MyTextView
    private lateinit var textViewTeacher: MyTextView

    private lateinit var imgEducationSystem: AppCompatImageView
    private lateinit var imgGrade: AppCompatImageView
    private lateinit var imgMajor: AppCompatImageView
    private lateinit var imgLesson: AppCompatImageView
    private lateinit var imgTeacher: AppCompatImageView

    init {

        initialize()

        val typed: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.FilteringStepGuide, 0, 0)
        currentStep = typed.getInt(R.styleable.FilteringStepGuide_FilterGuideCurrentStep, 0)
        Log.i(TAG, currentStep.toString())
        typed.recycle()

    }

    private fun initialize(){
        stepEducationsystem = myView.findViewById(R.id.step_educationSystem)
        stepGrade = myView.findViewById(R.id.step_Grade)
        stepMajor = myView.findViewById(R.id.step_Major)
        stepLesson = myView.findViewById(R.id.step_lesson)
        stepTeacher = myView.findViewById(R.id.step_teacher)


        textViewEducationSystem = myView.findViewById(R.id.textView_step_educationSystem)
        textViewGrade = myView.findViewById(R.id.textView_step_Grade)
        textViewMajor = myView.findViewById(R.id.textView_step_major)
        textViewLesson = myView.findViewById(R.id.textView_step_lesson)
        textViewTeacher = myView.findViewById(R.id.textView_step_teacher)


        imgEducationSystem = myView.findViewById(R.id.img_step_educationSystem)
        imgGrade = myView.findViewById(R.id.img_step_Grade)
        imgMajor = myView.findViewById(R.id.img_step_major)
        imgLesson = myView.findViewById(R.id.img_step_lesson)
        imgTeacher = myView.findViewById(R.id.img_step_teacher)
    }

}