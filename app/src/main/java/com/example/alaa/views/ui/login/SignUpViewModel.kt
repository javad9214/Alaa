package com.example.alaa.views.ui.login

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;

class SignUpViewModel : ViewModel() {

    private val _phoneNumber = MutableLiveData<String>()
    val phoneNumber: LiveData<String> = _phoneNumber

    private val _personalNumber = MutableLiveData<String>()
    var personalNumber: LiveData<String> = _personalNumber

    private val _name = MutableLiveData<String>()
    var name: LiveData<String> = _name

    private val _lastName = MutableLiveData<String>()
    var lastName: LiveData<String> = _lastName

    private val _email = MutableLiveData<String>()
    var email: LiveData<String> = _email

    private val _major = MutableLiveData<String>()
    var major: LiveData<String> = _major


    private var gender = Gender.Male

    /**
    * Used to indicate to the UI that the Which gender Is Selected ... ( MALE , FEMALE)
     * return false if gender is female
     * return true if gender is male
     */



    fun setGenderMale(){
        Log.i("===>" , "gender is male")
    }

    fun setGenderFemale(){
        Log.i("===>" , "gender is FEMALE")
    }


    private fun setGenderActive(gender: Gender){}

    private fun setGenderDeActive(gender: Gender){}

    enum class Gender {
        Male,
        Female
    }
}
