package com.example.alaa.views.ui.cart

import android.widget.CompoundButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CartViewModel : ViewModel(){


    var hasDiscountCode = MutableLiveData(false)

    var discountCode = MutableLiveData<String>()

    var walletValue = MutableLiveData<String>()

    var hasDonate = MutableLiveData(false)

    var totalRealPrice = MutableLiveData<String>()

    var finalSalePrice =  MutableLiveData<String>()


    fun onCheckedChangeListener(button: CompoundButton, isChecked: Boolean) {

    }


}