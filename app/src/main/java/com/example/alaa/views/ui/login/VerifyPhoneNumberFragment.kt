package com.example.alaa.views.ui.login

import android.animation.ObjectAnimator
import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.example.alaa.R
import com.example.alaa.databinding.VerifyPhoneNumberBinding
import java.util.*


class VerifyPhoneNumberFragment : Fragment() {


    private var viewModel: AuthViewModel? = null
    private lateinit var binding: VerifyPhoneNumberBinding

    private var height: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(Objects.requireNonNull<FragmentActivity>(activity)).get(AuthViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.verify_phone_number, container, false)
        val view = binding.root
        binding.lifecycleOwner = this

        onKeyboardVisibilityChange()

        binding.authPinView.addTextChangedListener(object : TextWatcher {


            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p1 == 4) {
                    activity?.let { hideKeyboard(it) }
                }
            }
        })

        return view
    }


    private fun onKeyboardVisibilityChange() {
        viewModel?.isKeyboardVisible?.observe(this, androidx.lifecycle.Observer {
            height = viewModel!!.keyboardHeight.value
            if (isVisible) {
                ObjectAnimator.ofInt(binding.consLogin, "scrollY", height!!).setDuration(600).start()
            } else {
                Log.i("===>", "onKeyboardVisibilityChange: InVisible")
                ObjectAnimator.ofInt(binding.consLogin, "scrollY", -height!!).setDuration(600).start()
            }

        })
    }

    fun hideKeyboard(activity: FragmentActivity) {
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = activity.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)

        // imm.showSoftInput(view , 0);
        view.clearFocus()
    }
}