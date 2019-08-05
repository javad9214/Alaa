package com.example.alaa.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.CompoundButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.*
import com.example.alaa.R
import com.example.alaa.views.ui.login.Gender
import com.example.alaa.views.ui.login.Major
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.textfield.TextInputEditText


object BindingAdapters {

    @InverseBindingAdapter( attribute = "android:text")
    fun getText(view: TextInputEditText) : String{

        return view.text.toString()
    }


    @BindingAdapter("app:onGenderChange")
    @JvmStatic
    fun onGenderChange(view : AppCompatImageView , gender: Gender ) {

    }

    @BindingAdapter("onMajorSelected")
    fun onMajorSelected(buttonView : CompoundButton, isChecked : Boolean){

        Log.i("===>" , isChecked.toString())
    }








}