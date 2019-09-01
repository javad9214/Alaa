package com.example.alaa.custom_views

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.alaa.R

/**
 *   this custom view is for text on a Card view with colored background
 */

class TextViewWithCardBackground(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {


    private var _text: String? = resources.getString(R.string.app_name)
    private var _cardColor: Int = ContextCompat.getColor(context, R.color.alaa5)
    private var _textColor: Int = ContextCompat.getColor(context, R.color.pureWhite)
    private var _textSize: Float = resources.getDimension(R.dimen.textSizeDefault)
    private var _textFont: Int = 2
    private var _cardRadius: Float = 4f
    private var _leftIcon: Drawable? = ContextCompat.getDrawable(context, R.drawable.ic_left_quote)
    private var _rightIcon: Drawable? = ContextCompat.getDrawable(context, R.drawable.ic_right_quote)


    private var textView: TextViewWithFont
    private var cardView: CardView
    private var leftImageView: AppCompatImageView
    private var rightImageView: AppCompatImageView


    init {

        View.inflate(context, R.layout.my_card_text, this)

        textView = findViewById(R.id.my_card_textView)
        cardView = findViewById(R.id.my_card_text)
        leftImageView = findViewById(R.id.left_icon)
        rightImageView = findViewById(R.id.right_icon)


        loadAttributes(attrs)

        setChanges()

    }

    private fun loadAttributes(attrs: AttributeSet) {
        // Load attributes
        val a = context.obtainStyledAttributes(
                attrs, R.styleable.TextViewWithCardBackground, 0, 0)

        _text = a.getString(R.styleable.TextViewWithCardBackground_text)
        _cardColor = a.getColor(R.styleable.TextViewWithCardBackground_card_color, _cardColor)
        _textColor = a.getColor(R.styleable.TextViewWithCardBackground_text_color, _textColor)
        _textSize = a.getDimension(R.styleable.TextViewWithCardBackground_text_size, _textSize)
        _textFont = a.getInt(R.styleable.TextViewWithCardBackground_text_font, 2)
        _cardRadius = a.getDimension(R.styleable.TextViewWithCardBackground_card_radius, 4f)
        _leftIcon = a.getDrawable(R.styleable.TextViewWithCardBackground_leftIcon)
        _rightIcon = a.getDrawable(R.styleable.TextViewWithCardBackground_rightIcon)

        a.recycle()
    }

    private fun setChanges() {
        textView.let {
            it.text = _text
            it.textSize = _textSize
            it.setTextColor(_textColor)
            setTextViewTypeFace(context, it)
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
    }

    private fun setTextViewTypeFace(context: Context, textView: TextViewWithFont) {
        val face = FontFace.getInstance().getFontFace(context, _textFont)
        textView.typeface = face
    }

    fun setText(text: String?) {

        textView.text = text
    }

}