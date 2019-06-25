package com.example.alaa.Views.UI.SearchPage.Filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.alaa.R
import com.example.alaa.Views.UI.CustomViews.SelectableCard
import com.google.android.material.button.MaterialButton

class FilterEducationSystem() : Fragment()  {


    private val TAG = "===>"
    private lateinit var myView : View
    private lateinit var NewSystem : MaterialButton
    private lateinit var OldSystem : MaterialButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.fragment_filter_education_system, container, false)

        NewSystem = myView.findViewById(R.id.FilterItemNewSystem)
        OldSystem = myView.findViewById(R.id.FilterItemOldSystem)


        NewSystem.setOnClickListener{
            Navigation.findNavController(myView).navigate(R.id.action_filter_EducationSystem_to_filterGrade)
        }

        OldSystem.setOnClickListener{
            Navigation.findNavController(myView).navigate(R.id.action_filter_EducationSystem_to_filterGrade)
        }

        return myView
    }




}