package com.example.alaa.Views.UI.SearchPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.alaa.R
import com.example.alaa.Tools.CheckableCard
import kotlinx.android.synthetic.main.checkable_card_view.view.*

class SearchActivity : AppCompatActivity() , SearchBarComponent.backListener {


    private val TAG = "===>"

    override fun onBackClicked() {
        Toast.makeText(this , "please fucking show ... " , Toast.LENGTH_SHORT).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val checkedCard : CheckableCard = findViewById(R.id.checkedCard)
        Log.i(TAG , checkedCard.getText())



        val btn_back : SearchBarComponent  = findViewById(R.id.search_bar)
        btn_back.setOnBackClickListener(this)
    }

}
