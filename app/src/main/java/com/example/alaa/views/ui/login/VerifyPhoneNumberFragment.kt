package com.example.alaa.views.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(Objects.requireNonNull<FragmentActivity>(activity)).get(AuthViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.verify_phone_number, container, false)
        val view = binding.root
        binding.lifecycleOwner = this



        return view
    }
}