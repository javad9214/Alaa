package com.example.alaa.views.ui.search.filter


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.alaa.R
import com.example.alaa.customViews.ButtonWithFont


class FilterMajor : Fragment()  {

    private val TAG = "===>"
    private lateinit var myView : View
    private lateinit var allMajor: ButtonWithFont
    private lateinit var riazi: ButtonWithFont
    private lateinit var tajrobi: ButtonWithFont
    private lateinit var ensani: ButtonWithFont

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.fragment_filter_major, container, false)

        allMajor = myView.findViewById(R.id.ItemMajorAll)
        riazi = myView.findViewById(R.id.ItemMajorMath)
        tajrobi = myView.findViewById(R.id.filterMajorItem_Tajrobi)
        ensani = myView.findViewById(R.id.FilterItemMajor_Ensani)


        allMajor.setOnClickListener{
            NavHostFragment.findNavController(this).navigate(R.id.filterLesson)
        }

        riazi.setOnClickListener{
            NavHostFragment.findNavController(this).navigate(R.id.filterLesson)
        }

        tajrobi.setOnClickListener{
            NavHostFragment.findNavController(this).navigate(R.id.filterLesson)
        }

        ensani.setOnClickListener{
            NavHostFragment.findNavController(this).navigate(R.id.filterLesson)
        }

        return myView
    }



}
