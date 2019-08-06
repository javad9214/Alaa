package com.example.alaa.util

import android.util.Log
import android.widget.CompoundButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.example.alaa.views.ui.login.Gender
import com.google.android.material.textfield.TextInputEditText

object BindingAdapters {

    @InverseBindingAdapter(attribute = "android:text")
    fun getText(view: TextInputEditText): String {

        return view.text.toString()
    }


    @BindingAdapter("app:onGenderChange")
    @JvmStatic
    fun onGenderChange(view: AppCompatImageView, gender: Gender) {

    }

    @BindingAdapter("onMajorSelected")
    fun onMajorSelected(buttonView: CompoundButton, isChecked: Boolean) {

        Log.i("===>", isChecked.toString())
    }
}