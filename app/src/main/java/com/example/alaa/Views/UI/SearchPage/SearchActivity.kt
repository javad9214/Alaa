package com.example.alaa.Views.UI.SearchPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.alaa.R
import com.example.alaa.Tools.CheckableCard

class SearchActivity : AppCompatActivity() , SearchbarComponent.backListener {


    override fun onBackClicked() {
        Toast.makeText(this , "please fucking show ... " , Toast.LENGTH_SHORT).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val card_pressed : CheckableCard = findViewById(R.id.card_view_pressed)

        val btn_back : SearchbarComponent  = findViewById(R.id.search_bar)

        btn_back.setOnBackClickListener(this)
    }
}
