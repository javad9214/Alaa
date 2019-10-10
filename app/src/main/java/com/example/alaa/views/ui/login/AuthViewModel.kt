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

    var keyboardHeight = MutableLiveData(0)

    fun setKeyboardHeight(height: Int) {
        this.keyboardHeight.value = height
    }

    var isMale = MutableLiveData(false)

    // for set default gender null
    var isDefault = MutableLiveData(true)

    // for visibility keyboard
    var isKeyboardVisible = MutableLiveData(false)

    fun onKeyboardVisibilityChange(visibility: Boolean) {
        this.isKeyboardVisible.value = visibility
    }

    /**
     * 0 : Login
     * 1: signUp
     */
    var selectedPage = MutableLiveData(0)



    fun select(page: Int) {
        selectedPage.run { value = page }
    }

    var gender: LiveData<Gender> = Transformations.map(isMale) {
        if (it)
            Gender.MALE
        else
            Gender.FEMALE
    }

    fun onGenderSelected(isMale: Boolean, isDefault: Boolean) {
        this.isMale.value = isMale
        this.isDefault.value = isDefault
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