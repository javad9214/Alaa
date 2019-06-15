package com.example.alaa.Views.UI.SearchPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alaa.R
import com.example.alaa.Tools.Checkable_Card

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val card_pressed : Checkable_Card = findViewById(R.id.card_view_pressed)

    }
}
