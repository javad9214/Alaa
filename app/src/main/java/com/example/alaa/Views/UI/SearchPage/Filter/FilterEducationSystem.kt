package com.example.alaa.Views.UI.SearchPage.Filter

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.alaa.R
import com.example.alaa.ViewModels.FilteringViewModel
import com.example.alaa.Views.UI.CustomViews.MyButton
import java.lang.ClassCastException



class FilterEducationSystem() : Fragment() , View.OnClickListener {



    private val TAG = "===>"
    private lateinit var myView : View
    private lateinit var NewSystem : MyButton
    private lateinit var OldSystem : MyButton
    private lateinit var listener : FilterItemSelected
    private var intTest: String = null.toString()
    private lateinit var model : FilteringViewModel



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.fragment_filter_education_system, container, false)

        NewSystem = myView.findViewById(R.id.FilterItemNewSystem)
        OldSystem = myView.findViewById(R.id.FilterItemOldSystem)

        NewSystem.setOnClickListener(this)
        OldSystem.setOnClickListener(this)

        model = ViewModelProviders.of(this).get(FilteringViewModel ::class.java)
        model.setCurrentStep(0)
        Log.i(TAG , model.currentStep)


        // Log.i(TAG  , NavHostFragment.findNavController(this).currentDestination?.id.toString())
        // Navigation.createNavigateOnClickListener(R.id.action_filter_EducationSystem_to_filterGrade)
        // NavHostFragment.findNavController(this).navigate(R.id.action_filter_EducationSystem_to_filterGrade)


        return myView
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception

        try {
            //listener = targetFragment as FilterItemSelected
            Log.i(TAG , targetFragment.toString())
        } catch (e: ClassCastException) {
            throw ClassCastException("$activity must implement FilterItemSelected")
        }

    }

    override fun onClick(v: View?) {


        when(v?.id){
            R.id.FilterItemNewSystem -> NavHostFragment.findNavController(this).navigate(R.id.filterGrade)
            R.id.FilterItemOldSystem -> NavHostFragment.findNavController(this).navigate(R.id.filterGrade)
        }
    }

    fun filterItemSelectListener (listener : FilterItemSelected , intTest : String){
        this.listener = listener
        this.intTest = intTest

    }


}