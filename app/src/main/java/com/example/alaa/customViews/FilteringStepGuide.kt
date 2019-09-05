package com.example.alaa.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.databinding.FilteringGuideStepBinding
import com.example.alaa.views.ui.search.filter.FilterItemAdapter
import kotlinx.android.synthetic.main.filtering_guide_step.view.*


class FilteringStepGuide(context: Context, attributeSet: AttributeSet? = null) : ConstraintLayout(context, attributeSet), FilterItemAdapter.FilterItemListener, View.OnClickListener {


    private val TAG: String = "===>"

    // 1 : Education System   2 : Grade   3 : Major   4 : lesson   5 : teacher
    private lateinit var currentStep: ButtonWithFont
    private var stepList = listOf<ButtonWithFont>()

    private var mBinding: FilteringGuideStepBinding


    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mBinding = DataBindingUtil.inflate(inflater, R.layout.filtering_guide_step, this, true)

        setButtonsListener()


    }

    private fun setButtonsListener() {
        Step_EducationSystem.setOnClickListener(this)
        Step_Grade.setOnClickListener(this)
        Step_Major.setOnClickListener(this)
        Step_Lesson.setOnClickListener(this)
        Step_Teacher.setOnClickListener(this)
    }

    private fun setRecycler(list: ArrayList<String>) {
        val recyclerFilterGrade: RecyclerView = mBinding.recyclerFilteringStepGuide
        recyclerFilterGrade.layoutManager = GridLayoutManager(context, 1, RecyclerView.HORIZONTAL, false)

        val adapter = FilterItemAdapter(list, this)
        recyclerFilterGrade.adapter = adapter

    }

    private fun setCurrentStep(buttonWithFont: ButtonWithFont) {
        if (currentStep == null) currentStep = buttonWithFont
        else setStepDeActive(currentStep)
        currentStep = buttonWithFont
    }

    private fun setStepActive(buttonWithFont: ButtonWithFont) {

        buttonWithFont.backgroundTintList = ContextCompat.getColorStateList(context, R.color.green)
        buttonWithFont.setTextColor(ContextCompat.getColorStateList(context, R.color.pureWhite))
        buttonWithFont.iconTint = ContextCompat.getColorStateList(context, R.color.pureWhite)
    }

    private fun setStepDeActive(buttonWithFont: ButtonWithFont) {
        setCurrentStep(buttonWithFont)
        buttonWithFont.backgroundTintList = ContextCompat.getColorStateList(context, R.color.pureWhite)
        buttonWithFont.setTextColor(ContextCompat.getColorStateList(context, R.color.black))
        buttonWithFont.iconTint = ContextCompat.getColorStateList(context, R.color.black)
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

    private fun updateFilterStep(step: Int) {
        // scrollToCurrentStep(stepList[step])
        setStepActive(stepList[step])
        when (step) {
            0 -> {
                setStepDisable(stepList[1])
                setStepDisable(stepList[2])
                setStepDisable(stepList[3])
                setStepDisable(stepList[4])
            }

            1 -> {
                setStepDisable(stepList[2])
                setStepDisable(stepList[3])
                setStepDisable(stepList[4])
                setStepPassed(stepList[0])
            }

            2 -> {
                setStepDisable(stepList[3])
                setStepDisable(stepList[4])
                setStepPassed(stepList[0])
                setStepPassed(stepList[1])
            }

            3 -> {
                setStepDisable(stepList[4])
                setStepPassed(stepList[0])
                setStepPassed(stepList[1])
                setStepPassed(stepList[2])
            }

            4 -> {
                setStepPassed(stepList[0])
                setStepPassed(stepList[1])
                setStepPassed(stepList[2])
                setStepPassed(stepList[3])
            }
        }

    }


    override fun itemClicked(itemName: String) {
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            Step_EducationSystem.id -> {
                setRecycler(setEducationSystemList())
                setStepActive(Step_EducationSystem)
            }
            Step_Grade.id -> {
                setRecycler(setGradeListNewSystem())
                setStepActive(Step_Grade)
            }
            Step_Major.id -> {
                setRecycler(setMajorList())
                setStepActive(Step_Major)
            }
            Step_Lesson.id -> {
                setRecycler(setLessonList())
                setStepActive(Step_Lesson)
            }
            Step_Teacher.id -> {
                setRecycler(setGradeListOldSystem())
                setStepActive(Step_Teacher)
            }
        }
    }


    private fun setEducationSystemList(): ArrayList<String> {
        val educationList: ArrayList<String> = ArrayList()
        educationList.add(resources.getString(R.string.NewSystem))
        educationList.add(resources.getString(R.string.OldSystem))
        return educationList
    }

    private fun setGradeListNewSystem(): ArrayList<String> {
        val gradeList: ArrayList<String> = ArrayList()
        gradeList.add(resources.getString(R.string.GradeAll))
        gradeList.add(resources.getString(R.string.GradeKonkur))
        gradeList.add(resources.getString(R.string.GradeOlympiad))
        gradeList.add(resources.getString(R.string.GradeNew10th))
        gradeList.add(resources.getString(R.string.GradeNew11th))
        gradeList.add(resources.getString(R.string.GradeNew12th))
        return gradeList
    }

    private fun setGradeListOldSystem(): ArrayList<String> {
        val gradeList: ArrayList<String> = ArrayList()
        gradeList.add(resources.getString(R.string.GradeAll))
        gradeList.add(resources.getString(R.string.GradeKonkur))
        gradeList.add(resources.getString(R.string.GradeOlympiad))
        gradeList.add(resources.getString(R.string.GradeOld1))
        gradeList.add(resources.getString(R.string.GradeOld2))
        gradeList.add(resources.getString(R.string.GradeOld3))
        gradeList.add(resources.getString(R.string.GradeOld4))
        return gradeList
    }

    private fun setMajorList(): ArrayList<String> {
        val majorList: ArrayList<String> = ArrayList()
        majorList.add(resources.getString(R.string.MajorAll))
        majorList.add(resources.getString(R.string.Major_Riazi))
        majorList.add(resources.getString(R.string.Major_Tajrobi))
        majorList.add(resources.getString(R.string.Major_Ensani))
        return majorList
    }

    private fun setLessonList(): ArrayList<String> {
        val lessonList: ArrayList<String> = ArrayList()
        lessonList.add("همه دروس")
        lessonList.add("آمار و مدلسازی")
        lessonList.add("المیپاد فیزیک")
        lessonList.add("حسابان")
        lessonList.add("دیفرانسیل")
        lessonList.add("جبر و احتمال")
        lessonList.add("دین و زندگی")
        lessonList.add("زبان انگلیسی")
        lessonList.add("فیزیک ")
        lessonList.add("شیمی")
        lessonList.add("عربی")
        lessonList.add("تحلیلی")
        lessonList.add("زبان و ادبیات فارسی")
        lessonList.add("هندسه")
        return lessonList
    }


}