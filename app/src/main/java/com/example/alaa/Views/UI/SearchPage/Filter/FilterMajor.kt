package com.example.alaa.Views.UI.SearchPage.Filter


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.example.alaa.R
import com.example.alaa.Views.UI.CustomViews.MyButton
import com.example.alaa.Views.UI.CustomViews.SelectableCard
import com.google.android.material.button.MaterialButton


class FilterMajor : Fragment()  {

    private val TAG = "===>"
    private lateinit var myView : View
    private lateinit var allMajor : MyButton
    private lateinit var riazi : MyButton
    private lateinit var tajrobi : MyButton
    private lateinit var ensani : MyButton

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
