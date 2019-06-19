package com.example.alaa.Views.UI.SearchPage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.alaa.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SearchResults : Fragment()  , SearchBarComponent.BackListener {

    private lateinit var myView : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_search_results, container, false)

        return myView
    }

    init {
        val btnBack : SearchBarComponent  = myView.findViewById(R.id.search_bar)
        btnBack.setOnBackClickListener(this)
    }

    override fun onBackClicked() {
        Toast.makeText(context , "please fucking show ... " , Toast.LENGTH_SHORT).show()
    }



}
