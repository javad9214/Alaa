package com.example.alaa.views.ui.search.Filter


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R


class FilterLesson : Fragment() , FilterItemAdapter.FilterItemListener {


    private lateinit var myView : View
    private  var lessonList: ArrayList<String> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_filter_lesson, container, false)

        setLessonList()
        setRecycler()

        return myView
    }


    private fun setRecycler(){
        val recyclerFilterLesson : RecyclerView = myView.findViewById(R.id.recyclerFilterLesson)
        recyclerFilterLesson.layoutManager = GridLayoutManager(context , 2 , RecyclerView.HORIZONTAL , false)

        val adapter = FilterItemAdapter(lessonList, this)
        recyclerFilterLesson.adapter = adapter

    }

    private fun setLessonList (){

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

    }


    override fun itemClicked(itemName: String) {
       Toast.makeText(context , itemName , Toast.LENGTH_SHORT).show()
    }

}
