package com.example.alaa.views.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.alaa.R;
import com.example.alaa.databinding.LoginFragmentBinding;
import com.example.alaa.views.ui.MainActivity;

import java.util.Objects;

public class LoginFragment extends Fragment {

    public LoginFragment() {
    }

    private AuthViewModel viewModel;
    private LoginFragmentBinding binding;
    public static final String TAG = "Alaa\\LoginFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(AuthViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false);
        View view = binding.getRoot();
        binding.setAuthViewModel(viewModel);
        binding.setLifecycleOwner(this);


        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
        });

        binding.infoFormPhoneNumber.requestFocus();
        binding.infoFormPhoneNumber.setOnFocusChangeListener((view1, hasFocus) -> Log.i(TAG, "onFocusChange:  " + hasFocus));

        binding.infoFormPersonalNumber.setOnClickListener(view12 -> Log.i(TAG, "onClick: "));

        binding.infoFormPhoneNumber.setOnTouchListener((view13, motionEvent) -> {
            Log.i(TAG, "onTouch: ");
            return false;
        });


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


}
