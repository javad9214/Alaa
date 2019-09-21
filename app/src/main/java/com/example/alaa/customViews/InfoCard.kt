package com.example.alaa.customViews

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.alaa.R
import com.example.alaa.databinding.InfoCardBinding


class InfoCard(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {

    private var title: String? = resources.getString(R.string.proPhone)
    private var textValue: String? = resources.getString(R.string.demo_mobileNumber)
    private var icon: Drawable? = ContextCompat.getDrawable(context, R.drawable.ic_phone_colored)

    private lateinit var titleTextView: TextViewWithFont
    private lateinit var valueTextView: TextViewWithFont
    private lateinit var iconImageView: AppCompatImageView

    private var binding: InfoCardBinding

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DataBindingUtil.inflate(inflater, R.layout.info_card, this, true)

        bindViews()
        loadAttributes(attrs)
        setAttributes()
    }

    private fun bindViews() {
        titleTextView = binding.title
        valueTextView = binding.txValue
        iconImageView = binding.icon
    }

    private fun loadAttributes(attrs: AttributeSet?) {
        // Load attributes
        val a = context.obtainStyledAttributes(
                attrs, R.styleable.InfoCard, 0, 0)

        title = a.getString(R.styleable.InfoCard_title)
        textValue = a.getString(R.styleable.InfoCard_value)
        icon = a.getDrawable(R.styleable.InfoCard_icon)

        a.recycle()
    }

    private fun setAttributes() {
        titleTextView.text = title
        valueTextView.text = textValue
        iconImageView.setImageDrawable(icon)
    }

    fun setTitle(text: String) {
        titleTextView.text = text
    }

    fun setValue(text: String) {
        valueTextView.text = text
    }

    fun setIcon(icon: Drawable?) {
        iconImageView.setImageDrawable(icon)
    }
}