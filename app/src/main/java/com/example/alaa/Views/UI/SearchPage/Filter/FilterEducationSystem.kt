package com.example.alaa.Views.UI.SearchPage.Filter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.alaa.R
import com.example.alaa.Views.UI.CustomViews.FilteringStepGuide
import com.example.alaa.Views.UI.CustomViews.MyButton
import com.example.alaa.Views.UI.CustomViews.SelectableCard
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_base_filter_dialog.view.*

class FilterEducationSystem() : Fragment()  {


    private val TAG = "===>"
    private lateinit var myView : View
    private lateinit var NewSystem : MyButton
    private lateinit var OldSystem : MyButton


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.fragment_filter_education_system, container, false)

        NewSystem = myView.findViewById(R.id.FilterItemNewSystem)
        OldSystem = myView.findViewById(R.id.FilterItemOldSystem)

        NewSystem.setOnClickListener{


           // Log.i(TAG  , NavHostFragment.findNavController(this).currentDestination?.id.toString())
           // Navigation.createNavigateOnClickListener(R.id.action_filter_EducationSystem_to_filterGrade)
           // NavHostFragment.findNavController(this).navigate(R.id.action_filter_EducationSystem_to_filterGrade)
            Navigation.findNavController(myView).navigate(R.id.filterGrade)
        }

        OldSystem.setOnClickListener{
           // NavHostFragment.findNavController(this).navigate(R.id.action_filter_EducationSystem_to_filterGrade)
        }

        return myView
    }


}