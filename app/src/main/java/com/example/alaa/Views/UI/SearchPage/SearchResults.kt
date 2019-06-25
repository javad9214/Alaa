package com.example.alaa.Views.UI.SearchPage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation

import com.example.alaa.R
import com.example.alaa.Views.UI.SearchPage.Filter.BaseFilterDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SearchResults : Fragment()  , SearchBarComponent.BackListener {

    private lateinit var myView : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_search_results, container, false)

        val btnBack : SearchBarComponent  = myView.findViewById(R.id.search_bar)
        btnBack.setOnBackClickListener(this)


        val openFilter : FloatingActionButton  = myView.findViewById(R.id.openFilter)
        openFilter.setOnClickListener{
           val baseFilterDialog : BaseFilterDialog = BaseFilterDialog()
            activity?.supportFragmentManager?.let { it1 -> baseFilterDialog.show(it1, baseFilterDialog.tag) }
        }

        return myView
    }

    override fun onBackClicked() {
        Toast.makeText(context , "please fucking show ... " , Toast.LENGTH_SHORT).show()
    }



}
