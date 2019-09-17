package com.example.alaa.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.alaa.R

/*
    this Custom view is for Title Headers on top of Recycler views .
 */

class HeaderWithLine(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {


    private var _text: String? = resources.getString(R.string.app_name)
    private var _textColor: Int = ContextCompat.getColor(context, R.color.pureWhite)
    private var _textSize: Float = resources.getDimension(R.dimen.textSizeDefault)
    private var _textFont: Int = 2
    private var _textButton: String? = resources.getString(R.string.app_name)
    private var _colorButton: Int = ContextCompat.getColor(context, R.color.pureWhite)
    private var _hasButton: Boolean = false

    private var textView: TextViewWithFont
    private var button: ButtonWithFont

    init {
        View.inflate(context, R.layout.header_with_line, this)

        textView = findViewById(R.id.tx_header)
        button = findViewById(R.id.btn_header)
        loadAttributes(attrs)
        setAttributes()


    }

    private fun loadAttributes(attrs: AttributeSet) {
        // Load attributes
        val a = context.obtainStyledAttributes(
                attrs, R.styleable.HeaderWithLine, 0, 0)

        _text = a.getString(R.styleable.HeaderWithLine_header_text)
        _textColor = a.getColor(R.styleable.HeaderWithLine_header_textColor, _textColor)
        _textFont = a.getInt(R.styleable.HeaderWithLine_header_textFont, 2)
        _textSize = a.getDimension(R.styleable.HeaderWithLine_header_textSize, _textSize)
        _hasButton = a.getBoolean(R.styleable.HeaderWithLine_header_hasButton, false)
        _textButton = a.getString(R.styleable.HeaderWithLine_header_buttonText)
        _colorButton = a.getColor(R.styleable.HeaderWithLine_header_buttonColor, _colorButton)


        a.recycle()
    }


    private fun setAttributes() {
        textView.let {
            it.text = _text
            it.textSize = _textSize
            it.setTextColor(_textColor)
            setTextViewTypeFace(context, it)
        }
        button.let {
            it.text = _textButton
            it.setBackgroundColor(_colorButton)
        }

        if (_hasButton) button.visibility = View.VISIBLE
    }

    private fun setTextViewTypeFace(context: Context, textView: TextViewWithFont) {
        val face = FontFace.getInstance().getFontFace(context, _textFont)
        textView.typeface = face
    }

    fun setText(text: String?) {

        textView.text = text
    }
}