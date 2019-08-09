package com.example.alaa.views.ui.login


import android.widget.CompoundButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.alaa.R

class AuthViewModel : ViewModel() {


    var phoneNumber = MutableLiveData<String>()

    var personalNumber = MutableLiveData<String>()

    var name = MutableLiveData<String>()

    var lastName = MutableLiveData<String>()

    var email = MutableLiveData<String>()

    var major = Major.RIAZI


    var isMale = MutableLiveData(true)

    /**
     * 0 : Login
     * 1: signUp
     */
    var selectedPage = MutableLiveData(0)


    fun select(page: Int) {
        selectedPage.run { setValue(page) }
    }

    var gender: LiveData<Gender> = Transformations.map(isMale) {
        if (it)
            Gender.MALE
        else
            Gender.FEMALE
    }

    fun onGenderSelected(isMale: Boolean) {
        this.isMale.value = isMale
    }

    fun onCheckedChangeListener(button: CompoundButton, isChecked: Boolean) {
        when (button.id) {
            R.id.chip_math -> this.major = Major.RIAZI
            R.id.chip_tajrobi -> this.major = Major.TAJROBI
            R.id.chip_ensani -> this.major = Major.ENSANI
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