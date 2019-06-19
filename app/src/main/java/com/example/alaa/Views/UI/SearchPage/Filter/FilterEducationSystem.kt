package com.example.alaa.Views.UI.SearchPage.Filter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.alaa.R
import com.example.alaa.Tools.SelectableCard
import com.example.alaa.Views.UI.SearchPage.SearchBarComponent

class FilterEducationSystem() : Fragment() , SelectableCard.CardSelectListener {


    private val TAG = "===>"
    private lateinit var myView : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.search_filter_education_system, container, false)


        initCards()
        return myView
    }

    private fun initCards (){

        val cardNewSystem : SelectableCard = myView.findViewById(R.id.card_newSystem)
        val cardOldSystem : SelectableCard = myView.findViewById(R.id.card_oldSystem)


        cardNewSystem.setCardSelectListener(this , cardNewSystem.getText())
        cardOldSystem.setCardSelectListener(this , cardOldSystem.getText())
    }



    override fun onCardSelected(text: String?) {
       Navigation.findNavController(myView).navigate(R.id.action_filter_EducationSystem_to_filterGrade)
    }

}