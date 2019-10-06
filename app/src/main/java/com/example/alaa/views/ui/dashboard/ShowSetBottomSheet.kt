package com.example.alaa.views.ui.dashboard


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alaa.R
import com.example.alaa.databinding.FragmentShowSetBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * A Bottom Sheet Dialog Fragment for Display Set on Purchased Product
 */
class ShowSetBottomSheet : BottomSheetDialogFragment() {


    private lateinit var binding: FragmentShowSetBottomSheetBinding
    private lateinit var viewModel: DashboardViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_show_set_bottom_sheet, container, false)
        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        setUpRecycler()

        Log.i("===>", viewModel.type.value.toString())

        onClose()
        return binding.root
    }


    private fun setUpRecycler() {

        val adapter = MyVideosAdapter(R.layout.set_dashboard)

        val recyclerView = binding.recyclerVideos
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter

    }


    private fun onClose() {
        binding.close.setOnClickListener { dismiss() }
    }


}
