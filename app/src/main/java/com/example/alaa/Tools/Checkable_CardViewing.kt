package com.example.alaa.Tools

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.Checkable
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.alaa.R

abstract class Checkable_CardView (context: Context , attributeSet: AttributeSet): CardView(context , attributeSet), Checkable {

    private  var isChecked : Boolean = false

    private var CHECKED_STATE_SET : IntArray = intArrayOf(android.R.attr.state_checked )

    init {
        View.inflate(context , R.layout.checkable_card_view , this)


        setChecked(true)
        setCardBackgroundColor(ContextCompat.getColorStateList(context , R.color.selector_card_view_background))

        if (attributeSet != null){

            val typed : TypedArray = context.obtainStyledAttributes(attributeSet , R.styleable.CheckableCardView , 0 , 0)

            try {
                val  text : String = typed.getString(R.styleable.CheckableCardView_card_text)
                val  textView : TextView = findViewById(R.id.text)

                if (text!= null){
                    textView.text = text
                }

            }finally {
                typed.recycle()
            }

        }
    }


    override fun onCreateDrawableState(extraSpace: Int): IntArray {

        val drawableState : IntArray = super.onCreateDrawableState(extraSpace + 1)

        if (isChecked) View.mergeDrawableStates(drawableState , CHECKED_STATE_SET )

        return super.onCreateDrawableState(extraSpace)
    }

    override fun isChecked(): Boolean {
        return isChecked
    }

    override fun toggle() {
        setChecked(!this.isChecked)
    }

    final override fun setChecked(checked: Boolean) {
        this.isChecked = checked
    }

    override fun  performClick() : Boolean{
        toggle()
        return super.performClick()
    }


}

