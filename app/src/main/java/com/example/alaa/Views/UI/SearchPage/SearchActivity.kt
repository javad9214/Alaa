package com.example.alaa.Views.UI.SearchPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.alaa.R
import com.example.alaa.Tools.SelectableCard
import kotlinx.android.synthetic.main.selectable_card_view.view.*

class SearchActivity : AppCompatActivity() , SearchBarComponent.BackListener , SelectableCard.CardSelectListener {



    override fun onCardSelected(text: String?) {
        Log.i(TAG , "$text card selected ")
    }


    private val TAG = "===>"

    override fun onBackClicked() {
        Toast.makeText(this , "please fucking show ... " , Toast.LENGTH_SHORT).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        val checkedCard : SelectableCard = findViewById(R.id.selectableA)
        checkedCard.setCardSelectListener(this , checkedCard.getText())

        val selectableB : SelectableCard = findViewById(R.id.selectableB)
        val selectableC : SelectableCard = findViewById(R.id.selectableC)

        selectableB.setText("I Fucking Change It :)")

        selectableB.setCardSelectListener(this , selectableB.getText())
        selectableC.setCardSelectListener(this , selectableC.getText())



        val btn_back : SearchBarComponent  = findViewById(R.id.search_bar)
        btn_back.setOnBackClickListener(this)
    }


}
