package com.example.alaa.customViews

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import com.example.alaa.R
import com.google.android.material.button.MaterialButton

class MyButton(context: Context, attrs: AttributeSet) : MaterialButton(context, attrs) {




    init {

        val typed : TypedArray = context.obtainStyledAttributes(attrs , R.styleable.MyButton , 0 , 0)

        val fontOrdinal : Int = typed.getInt(R.styleable.MyButton_MyButtonFont , 2)

        setFont(fontOrdinal)

        typed.recycle()
    }


    private fun setFont(fontOrdinal : Int){

        val face : Typeface

        when (fontOrdinal) {


            1 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile_Light.ttf")
                this.typeface = face
            }

            2 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile_Medium.ttf")
                this.typeface = face
            }

            3 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile_Bold.ttf")
                this.typeface = face
            }

            4 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile_UltraLight.ttf")
                this.typeface = face
            }

            5 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile_Light-4.1.ttf")
                this.typeface = face
            }

            6 -> {
                face = Typeface.createFromAsset(context.assets, "Font/BSara.ttf")
                this.typeface = face
            }


            7 -> {
                face = Typeface.createFromAsset(context.assets, "Font/shabnam_light.ttf")
                this.typeface = face
            }


            8 -> {
                face = Typeface.createFromAsset(context.assets, "Font/estedad.ttf")
                this.typeface = face
            }


            9 -> {
                face = Typeface.createFromAsset(context.assets, "Font/Suls.ttf")
                this.typeface = face
            }


            10 -> {
                face = Typeface.createFromAsset(context.assets, "Font/Shekasteh.ttf")
                this.typeface = face
            }


            11 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile(FaNum).ttf")
                this.typeface = face
            }


            12 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile(FaNum)_Bold.ttf")
                this.typeface = face
            }

            13 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile(FaNum)_Light.ttf")
                this.typeface = face
            }

            14 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile(FaNum)_Medium.ttf")
                this.typeface = face
            }


            15 -> {
                face = Typeface.createFromAsset(context.assets, "Font/IRANSansMobile(FaNum)_UltraLight.ttf")
                this.typeface = face
            }


            16 -> {
                face = Typeface.createFromAsset(context.assets, "Font/Mali_BoldItalic.ttf")
                this.typeface = face
            }

            17 -> {
                face = Typeface.createFromAsset(context.assets, "Font/RubikMonoOne_Regular.ttf")
                this.typeface = face
            }
        }
    }


}


