package com.example.alaa.customViews

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.InputFilter
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.alaa.R
import com.example.alaa.databinding.InfoFormBinding

/**
 * this custom view is a form for getting User Information Data such as Name , phone Number and etc .
 * and fields like EditText
 */

class InfoForm(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {

    private var title: String? = resources.getString(R.string.mobilePhoneNumber)
    private var hint: String? = resources.getString(R.string.demo_mobileNumber)
    private var icon: Drawable? = ContextCompat.getDrawable(context, R.drawable.ic_mobile_color)
    private var maxLength = 32

    private lateinit var titleTextView: TextViewWithFont
    private lateinit var valueEditText: EditTextWithFont
    private lateinit var iconImageView: AppCompatImageView

    private var binding: InfoFormBinding

    private var TAG = "===>"

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DataBindingUtil.inflate(inflater, R.layout.info_form, this, true)

        bindViews()
        loadAttributes(attrs)
        setAttributes()

        valueEditText.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                Log.i(TAG, "onFocusChange:  Got the Focus ")
            } else {
                Log.i(TAG, "onFocusChange: Lost the Focus")
            }
        }


    }

    private fun bindViews() {
        titleTextView = binding.title
        valueEditText = binding.edValue
        iconImageView = binding.icon
    }

    private fun loadAttributes(attrs: AttributeSet?) {
        // Load attributes
        val a = context.obtainStyledAttributes(
                attrs, R.styleable.InfoForm, 0, 0)

        title = a.getString(R.styleable.InfoForm_title_infoForm)
        hint = a.getString(R.styleable.InfoForm_hint_infoForm)
        icon = a.getDrawable(R.styleable.InfoForm_icon_infoForm)
        maxLength = a.getInt(R.styleable.InfoForm_editText_maxLine, 32)

        a.recycle()
    }

    private fun setAttributes() {
        titleTextView.text = title

        valueEditText.let {
            it.filters = arrayOf(InputFilter.LengthFilter(maxLength))
            it.hint = hint
        }

        iconImageView.setImageDrawable(icon)
    }

    fun setTitle(text: String) {
        titleTextView.text = text
    }

    fun setIcon(icon: Drawable?) {
        iconImageView.setImageDrawable(icon)
    }

    fun setHint(text: String) {
        valueEditText.hint = text
    }

}