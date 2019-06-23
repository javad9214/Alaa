package com.example.alaa.Views.UI.SearchPage.Filter


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.alaa.R
import com.example.alaa.Views.UI.CustomViews.SelectableCard


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FilterMajor : Fragment() , SelectableCard.CardSelectListener {

    private val TAG = "===>"
    private lateinit var myView : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.fragment_filter_major, container, false)


        initCards()
        return myView
    }


    private fun initCards (){

        val cardMajorRiazi : SelectableCard = myView.findViewById(R.id.card_Major_Riazi)
        val cardMajorTajrobi : SelectableCard = myView.findViewById(R.id.card_Major_Tajrobi)
        val cardMajorEnsani : SelectableCard = myView.findViewById(R.id.card_Major_Ensani)


        cardMajorRiazi.setCardSelectListener(this)
        cardMajorTajrobi.setCardSelectListener(this)
        cardMajorEnsani.setCardSelectListener(this)

        cardMajorRiazi.setText(cardMajorRiazi.getText())
        cardMajorTajrobi.setText(cardMajorTajrobi.getText())
        cardMajorEnsani.setText(cardMajorEnsani.getText())
    }

    override fun onCardSelected(text: String?) {
       // Navigation.findNavController(myView).navigate(R.id.action_filterGrade_to_filterMajor)
        Toast.makeText(context , text , Toast.LENGTH_SHORT).show()
    }

}
