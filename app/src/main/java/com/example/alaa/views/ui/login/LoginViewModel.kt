package com.example.alaa.views.ui.login

import android.util.Log
import android.widget.CompoundButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.alaa.R
import com.google.android.material.chip.Chip


class LoginViewModel : ViewModel() {

    var phoneNumber = MutableLiveData<String>()

    var personalNumber = MutableLiveData<String>()

    var name = MutableLiveData<String>()

    var lastName = MutableLiveData<String>()

    var email = MutableLiveData<String>()

    var major = MutableLiveData<Major>()



    var isMale = MutableLiveData(true)
    var isLogin = MutableLiveData(true)

    var checkedEnsani = MutableLiveData(false)
    var checkedTajrobi = MutableLiveData(false)
    var checkedRiazi = MutableLiveData(false)



    var gender: LiveData<Gender> = Transformations.map(isMale) {
        if (it)
            Gender.MALE
        else
            Gender.FEMALE
    }
    fun onGenderSelected( isMale: Boolean) {
        this.isMale.value = isMale
    }

    /** method for set Login view Show or SignUp view Show */
    fun goToSignUpLogin( isLogin: Boolean) {
        this.isLogin.value = isLogin
    }



    fun onCheckedChanged(buttonView : CompoundButton ,  isChecked : Boolean){
            when(buttonView.id){
                R.id.chip_ensani -> major.value = Major.ENSANI
                R.id.chip_tajrobi -> major.value = Major.TAJROBI
                R.id.chip_math -> major.value = Major.RIAZI
            }
    }
}

enum class Gender {
    MALE,
    FEMALE
}

enum class Major {
    RIAZI,
    TAJROBI,
    ENSANI
}

