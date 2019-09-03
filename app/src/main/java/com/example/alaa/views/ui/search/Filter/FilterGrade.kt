package com.example.alaa.views.ui.search.Filter


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.viewModels.FilteringViewModel

class FilterGrade : Fragment() , FilterItemAdapter.FilterItemListener {


    private lateinit var myView : View
    private  var gradeList: ArrayList<String> = ArrayList()
    private lateinit var model : FilteringViewModel

    private val TAG = "===>"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_filter_grade, container, false)

        model = ViewModelProviders.of(this).get(FilteringViewModel ::class.java)
        model.setCurrentStep(1)
        setGradeListNewSystem()
        setRecycler()

        return myView
    }

    private fun setRecycler(){
        val recyclerFilterGrade : RecyclerView = myView.findViewById(R.id.recyclerFilterGrade)
        recyclerFilterGrade.layoutManager = GridLayoutManager(context , 2 , RecyclerView.HORIZONTAL , false)

        val adapter = FilterItemAdapter(gradeList, this)
        recyclerFilterGrade.adapter = adapter

    }

    private fun setGradeListNewSystem (){

        gradeList.add(resources.getString(R.string.GradeAll))
        gradeList.add(resources.getString(R.string.GradeKonkur))
        gradeList.add(resources.getString(R.string.GradeOlympiad))
        gradeList.add(resources.getString(R.string.GradeNew10th))
        gradeList.add(resources.getString(R.string.GradeNew11th))
        gradeList.add(resources.getString(R.string.GradeNew12th))
    }


    private fun setGradeListOldSystem(){
        gradeList.add(resources.getString(R.string.GradeAll))
        gradeList.add(resources.getString(R.string.GradeKonkur))
        gradeList.add(resources.getString(R.string.GradeOlympiad))
        gradeList.add(resources.getString(R.string.GradeOld1))
        gradeList.add(resources.getString(R.string.GradeOld2))
        gradeList.add(resources.getString(R.string.GradeOld3))
        gradeList.add(resources.getString(R.string.GradeOld4))

    }

    override fun itemClicked(itemName: String) {
        Log.i(TAG , itemName )
        NavHostFragment.findNavController(this).navigate(R.id.filterMajor)
    }


}
