package com.example.alaa.views.ui.login;

import android.os.Bundle;
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

public class LoginFragment extends Fragment {

    public  LoginFragment(){}

    private View view ;
    private AuthViewModel viewModel;
    private LoginFragmentBinding binding ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bookmarks, container, false);

        viewModel = ViewModelProviders.of(this).get(AuthViewModel.class);
        binding = DataBindingUtil.setContentView(getActivity(), R.layout.sign_up_fragment);

        binding.setAuthViewModel(viewModel);
        binding.setLifecycleOwner(this);

        return view ;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
