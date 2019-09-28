package com.example.alaa.views.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.alaa.R;
import com.example.alaa.databinding.SignUpFragmentBinding;
import com.example.alaa.views.ui.MainActivity;

import java.util.Objects;

public class SignUpFragment extends Fragment {


    public SignUpFragment(){}


    private AuthViewModel viewModel;
    private SignUpFragmentBinding binding ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(AuthViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater , R.layout.sign_up_fragment , container , false);
        View view = binding.getRoot();

        binding.setAuthViewModel(viewModel);
        binding.setLifecycleOwner(this);

        binding.imgProfileBoySignUp.setImageDrawable(ContextCompat.getDrawable(binding.imgProfileBoySignUp.getContext(), R.drawable.ic_profile_boy_black));

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onGenderSelected();

        binding.btnSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
        });
    }


    /**
     * Method for select gender in SignUp Form ...
     */
    private void onGenderSelected() {
        /*
            is default is for set default gender to none
         */
        viewModel.isDefault().observe(this, isDefault -> {
            if (isDefault) {
                binding.imgProfileBoySignUp.setImageDrawable(ContextCompat.getDrawable(binding.imgProfileBoySignUp.getContext(), R.drawable.ic_profile_boy_black));
            } else {
                viewModel.isMale().observe(this, isMale -> {
                    if (isMale) {
                        binding.imgProfileBoySignUp.setImageDrawable(ContextCompat.getDrawable(binding.imgProfileBoySignUp.getContext(), R.drawable.ic_account_large));
                        binding.imgProfileGirlSignUp.setImageDrawable(ContextCompat.getDrawable(binding.imgProfileGirlSignUp.getContext(), R.drawable.ic_girl_profile_black));
                    } else {
                        binding.imgProfileGirlSignUp.setImageDrawable(ContextCompat.getDrawable(binding.imgProfileGirlSignUp.getContext(), R.drawable.ic_girl_profile));
                        binding.imgProfileBoySignUp.setImageDrawable(ContextCompat.getDrawable(binding.imgProfileBoySignUp.getContext(), R.drawable.ic_profile_boy_black));
                    }
                });
            }
        });


    }


}
