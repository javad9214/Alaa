package com.example.alaa.customViews

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.alaa.R

/**
 *   this custom view is for text on a Card view with colored background
 */

class MyCardText (context: Context, attrs: AttributeSet) : FrameLayout (context , attrs) {


    private var _text : String? = resources.getString(R.string.app_name)
    private var _cardColor : Int = ContextCompat.getColor(context , R.color.alaa5)
    private var _textColor : Int = ContextCompat.getColor(context , R.color.pureWhite)
    private var _textSize : Float = resources.getDimension(R.dimen.textSizeDefault)
    private var _textFont : Int = 2
    private var _cardRadius : Float = 4f
    private var _leftIcon : Drawable? = ContextCompat.getDrawable(context , R.drawable.ic_left_quote)
    private var _rightIcon : Drawable? = ContextCompat.getDrawable(context , R.drawable.ic_right_quote)


    private var textView : MyTextView
    private var cardView : CardView
    private var leftImageView : AppCompatImageView
    private var rightImageView : AppCompatImageView


   init {

        View.inflate(context , R.layout.my_card_text , this)

        textView = findViewById(R.id.my_card_textView)
        cardView  = findViewById(R.id.my_card_text)
        leftImageView = findViewById(R.id.left_icon)
        rightImageView = findViewById(R.id.right_icon)


        // Load attributes
        val a = context.obtainStyledAttributes(
                attrs, R.styleable.MyCardText, 0, 0)

        _text = a.getString(R.styleable.MyCardText_text)
        _cardColor = a.getColor(R.styleable.MyCardText_card_color , _cardColor)
        _textColor = a.getColor(R.styleable.MyCardText_text_color , _textColor)
        _textSize = a.getDimension(R.styleable.MyCardText_text_size , _textSize)
        _textFont = a.getInt(R.styleable.MyCardText_text_font , 2)
       _cardRadius = a.getDimension(R.styleable.MyCardText_card_radius , 4f)
       _leftIcon = a.getDrawable(R.styleable.MyCardText_leftIcon)
       _rightIcon = a.getDrawable(R.styleable.MyCardText_rightIcon)

        textView.let {
            it.text = _text
            it.textSize = _textSize
            it.setTextColor(_textColor)
            setFont(_textFont , it)
        }


        cardView.setCardBackgroundColor(_cardColor)
        cardView.radius = _cardRadius


       if (_leftIcon == null) leftImageView.visibility = View.GONE
        else {
           leftImageView.visibility = View.VISIBLE
           leftImageView.setImageDrawable(_leftIcon)
       }


       if (_rightIcon == null) rightImageView.visibility = View.GONE
       else {
           rightImageView.visibility = View.VISIBLE
           rightImageView.setImageDrawable(_rightIcon)
       }

        a.recycle()
    }




    private fun setFont(fontOrdinal : Int , text: TextView){

        val face : Typeface

        when (fontOrdinal) {


            1 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile_Light.ttf")
                text.typeface = face
            }

            2 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile_Medium.ttf")
                text.typeface = face
            }

            3 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile_Bold.ttf")
                text.typeface = face
            }

            4 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile_UltraLight.ttf")
                text.typeface = face
            }

            5 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile_Light-4.1.ttf")
                text.typeface = face
            }

            6 -> {
                face = Typeface.createFromAsset(context.assets, "Font/BSara.ttf")
                text.typeface = face
            }


            7 -> {
                face = Typeface.createFromAsset(context.assets, "Font/shabnam_light.ttf")
                text.typeface = face
            }


            8 -> {
                face = Typeface.createFromAsset(context.assets, "Font/estedad.ttf")
                text.typeface = face
            }


            9 -> {
                face = Typeface.createFromAsset(context.assets, "Font/Suls.ttf")
                text.typeface = face
            }


            10 -> {
                face = Typeface.createFromAsset(context.assets, "Font/Shekasteh.ttf")
                text.typeface = face
            }


            11 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile(FaNum).ttf")
                text.typeface = face
            }


            12 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile(FaNum)_Bold.ttf")
                text.typeface = face
            }

            13 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile(FaNum)_Light.ttf")
                text.typeface = face
            }

            14 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile(FaNum)_Medium.ttf")
                text.typeface = face
            }


            15 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile(FaNum)_UltraLight.ttf")
                text.typeface = face
            }


            16 -> {
                face = Typeface.createFromAsset(context.assets, "Font/Mali_BoldItalic.ttf")
                text.typeface = face
            }

            17 -> {
                face = Typeface.createFromAsset(context.assets, "Font/RubikMonoOne_Regular.ttf")
                text.typeface = face
            }
        }
    }

    fun setText (text : String?){

        textView.text = text
    }

}