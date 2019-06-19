package com.example.alaa.Views.UI.SearchPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.alaa.R

class SearchActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setupNavigation()

    }

    private fun setupNavigation(){
        Navigation.findNavController(this , R.id.mainNavigationFragment)
    }




}
