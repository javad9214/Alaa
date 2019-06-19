package com.example.alaa.Views.UI.SearchPage.Filter.Grade


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FilterGrade : Fragment() {

    private lateinit var myView : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        myView = inflater.inflate(R.layout.fragment_filter_grade, container, false)


        setRecycler()

        return myView
    }

    private fun setRecycler(){
        val recyclerFilterGrade : RecyclerView = myView.findViewById(R.id.recyclerFilterGrade)
        recyclerFilterGrade.layoutManager = LinearLayoutManager(context , RecyclerView.VERTICAL ,false)

    }
}
