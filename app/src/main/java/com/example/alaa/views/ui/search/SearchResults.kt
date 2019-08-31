package com.example.alaa.views.ui.search


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

import com.example.alaa.R
import com.example.alaa.views.ui.search.Filter.BaseFilterDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SearchResults : Fragment()  , SearchBarComponent.BackListener , LifecycleOwner {

    private lateinit var myView : View

    private val TAG = "===>"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_search_results, container, false)

        lifecycle.addObserver(MyObserver())

        val btnBack : SearchBarComponent  = myView.findViewById(R.id.search_bar)
        btnBack.setOnBackClickListener(this)


        val openFilter : FloatingActionButton  = myView.findViewById(R.id.openFilter)
        openFilter.setOnClickListener{
           val baseFilterDialog = BaseFilterDialog()
            activity?.supportFragmentManager?.let { it1 -> baseFilterDialog.show(it1, baseFilterDialog.tag) }
            baseFilterDialog
        }

        return myView
    }

    override fun onBackClicked() {
      val fm : FragmentManager? = activity?.supportFragmentManager
        if (fm != null) {
            if (fm.backStackEntryCount > 0) {

                fm.popBackStack()
            }
        }

    }


    inner class MyObserver : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun connectListener() {
           Log.i("===>"  , "on resume")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun disconnectListener() {
         Log.i("===>" , "on pause")
        }
    }

}
