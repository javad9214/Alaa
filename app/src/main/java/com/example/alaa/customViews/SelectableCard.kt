package com.example.alaa.customViews

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.Checkable
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.alaa.R

class SelectableCard (context: Context, attributeSet: AttributeSet ) : CardView(context , attributeSet ) , Checkable  {

    constructor(context: Context, attributeSet: AttributeSet , listener: CardSelectListener) : this(context , attributeSet){
        this.listener =  listener
    }

    private lateinit var listener : CardSelectListener

    private  var isChecked : Boolean = false

    private var text : String?

    private val textView : com.example.alaa.customViews.MyTextView

    private val TAG  = "K===>O"

    init {

        View.inflate(context , R.layout.selectable_card_view ,this)

        textView = findViewById(R.id.text)

        val typed : TypedArray = context.obtainStyledAttributes(attributeSet , R.styleable.SelectableCard , 0 , 0)

        text  = typed.getString(R.styleable.SelectableCard_SelectableCard_text)

        textView.text = text
        typed.recycle()

    }


    override fun isChecked(): Boolean {
        return isChecked
    }

    override fun toggle() {
        setChecked(!this.isChecked)
    }

    override fun setChecked(checked: Boolean) {
        this.isChecked = checked
        setBackground()
    }

    override fun performClick(): Boolean {
        toggle()
        return super.performClick()
    }

    private fun setBackground(){
        if (isChecked) setCardBackgroundColor(ContextCompat.getColor(context , R.color.alaa2))
        else           setCardBackgroundColor(ContextCompat.getColor(context , R.color.pureWhite))

        listener.onCardSelected(text)
    }

    interface CardSelectListener{
        fun onCardSelected(text: String?)
    }

    fun setCardSelectListener(listener: CardSelectListener){
        this.listener = listener
    }

    fun setText (text: String){
        textView.text = text
        this.text = text
    }

    fun getText (): String{
        return text.toString()
    }


}
