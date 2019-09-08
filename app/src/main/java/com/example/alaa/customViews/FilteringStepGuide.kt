package com.example.alaa.customViews

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.databinding.FilteringGuideStepBinding
import com.example.alaa.util.StringUtil
import com.example.alaa.views.ui.search.filter.FilterItemAdapter
import kotlinx.android.synthetic.main.filtering_guide_step.view.*


class FilteringStepGuide(context: Context, attributeSet: AttributeSet? = null) : ConstraintLayout(context, attributeSet), FilterItemAdapter.FilterItemListener, View.OnClickListener {


    private val TAG: String = "===>"

    // 0 : Education System   1 : Grade   2 : Major   3 : lesson   4 : teacher
    private var currentStep: Int = 5
    private var stepList = arrayListOf<ButtonWithFont>()

    private var mBinding: FilteringGuideStepBinding

    private var mSelectedItem = arrayListOf<String>()

    interface FilteringStepGuideInterface {
        fun itemSelected(selectedItem: ArrayList<String>)
    }

    private lateinit var mCallback: FilteringStepGuideInterface

    fun setFilteringStepGuideInterface(callback: FilteringStepGuideInterface) {
        mCallback = callback
    }

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mBinding = DataBindingUtil.inflate(inflater, com.example.alaa.R.layout.filtering_guide_step, this, true)
        initCallback()
        setButtonsListener()
    }

    private fun initCallback() {
        mCallback = object : FilteringStepGuideInterface {
            override fun itemSelected(selectedItem: ArrayList<String>) {
                //Empty
            }
        }
    }

    private fun setButtonsListener() {
        Step_EducationSystem.setOnClickListener(this)
        Step_Grade.setOnClickListener(this)
        Step_Major.setOnClickListener(this)
        Step_Lesson.setOnClickListener(this)
        Step_Teacher.setOnClickListener(this)
        setButtonList()
    }

    private fun setButtonList() {
        stepList.add(Step_EducationSystem)
        stepList.add(Step_Grade)
        stepList.add(Step_Major)
        stepList.add(Step_Lesson)
        stepList.add(Step_Teacher)
    }

    override fun itemClicked(itemName: String) {
        handleItemValueClicked(itemName)
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            Step_EducationSystem.id -> {
                setStepActivated(0)
            }
            Step_Grade.id -> {
                setStepActivated(1)
            }
            Step_Major.id -> {
                setStepActivated(2)
            }
            Step_Lesson.id -> {
                setStepActivated(3)
            }
            Step_Teacher.id -> {
                setStepActivated(4)
            }
        }
    }

    private fun setRecycler(list: ArrayList<String>, width: Int, spanCount: Int) {
        val recyclerFilterGrade: RecyclerView = mBinding.recyclerFilteringStepGuide
        recyclerFilterGrade.layoutManager = GridLayoutManager(context, spanCount, RecyclerView.HORIZONTAL, false)

        val adapter = FilterItemAdapter(list, this, width)
        recyclerFilterGrade.adapter = adapter
    }

    private fun setCurrentStep(step: Int) {
        currentStep = step
    }

    private fun setButtonActive(buttonWithFont: ButtonWithFont) {
        buttonWithFont.backgroundTintList = ContextCompat.getColorStateList(context, R.color.alaa5)
        buttonWithFont.setTextColor(ContextCompat.getColorStateList(context, R.color.pureWhite))
        buttonWithFont.iconTint = ContextCompat.getColorStateList(context, R.color.pureWhite)
    }

    private fun getSlugOfItemName(str: String): String {
        return StringUtil.slugify(str)
    }

    private fun handleItemValueClicked(itemName: String) {
        setButtonStepName(currentStep, itemName)

        mSelectedItem.add(getSlugOfItemName(itemName))

        if (currentStep != 4) {
            setStepActivated(currentStep + 1)
        } else {
            setStepDeActive(currentStep)
            mBinding.recyclerFilteringStepGuide.visibility = View.GONE
        }
        mCallback.itemSelected(mSelectedItem)
    }

    private fun setButtonStepName(step: Int, name: String) {
        stepList[step].text = name
    }

    private fun setStepDeActive(step: Int) {
        if (step != 5) {
            stepList[step].backgroundTintList = ContextCompat.getColorStateList(context, R.color.pureWhite)
            stepList[step].setTextColor(ContextCompat.getColorStateList(context, R.color.black))
            stepList[step].iconTint = ContextCompat.getColorStateList(context, R.color.black)
        }
    }

    private fun setStepActivated(step: Int) {
        ObjectAnimator.ofInt(scrollViewFilteringStep, "scrollX", stepList[step].left - 10).setDuration(700).start()
        setRecycler(getRecyclerItemList(step), getRecyclerItemWidth(step), getRecyclerItemSpanCount(step))
        mBinding.recyclerFilteringStepGuide.visibility = View.VISIBLE
        setButtonActive(stepList[step])
        setStepDeActive(currentStep)
        setCurrentStep(step)
    }

    private fun getRecyclerItemWidth(step: Int): Int {
        var width: Int = ViewGroup.LayoutParams.WRAP_CONTENT
        when (step) {
            0 -> width = ViewGroup.LayoutParams.MATCH_PARENT
            1 -> width = ViewGroup.LayoutParams.WRAP_CONTENT
            2 -> width = ViewGroup.LayoutParams.WRAP_CONTENT
            3 -> width = 150
            4 -> width = 150
        }
        return width
    }

    private fun getRecyclerItemSpanCount(step: Int): Int {
        var spanCount = 2
        when (step) {
            0 -> spanCount = 1
            1 -> spanCount = 3
            2 -> spanCount = 2
            3 -> spanCount = 3
            4 -> spanCount = 3
        }
        return spanCount
    }

    private fun getRecyclerItemList(step: Int): ArrayList<String> {
        var itemList = ArrayList<String>()
        when (step) {
            0 -> itemList = setEducationSystemList()
            1 -> itemList = setGradeListNewSystem()
            2 -> itemList = setMajorList()
            3 -> itemList = setLessonList()
            4 -> itemList = setGradeListOldSystem()
        }
        return itemList
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