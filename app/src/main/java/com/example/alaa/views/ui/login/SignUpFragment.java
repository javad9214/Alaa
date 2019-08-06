package com.example.alaa.views.ui.login;

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

public class SignUpFragment extends Fragment {


    public SignUpFragment(){}


    private View view ;
    private AuthViewModel viewModel;
    private SignUpFragmentBinding binding ;

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

        onGenderSelected();
    }


    /**
     * Method for select gender in SignUp Form ...
     */
    private void onGenderSelected() {
        viewModel.isMale().observe(this, isMale -> {
            if (isMale) {
                binding.imgProfileBoySignUp.setImageDrawable(ContextCompat.getDrawable(binding.imgProfileBoySignUp.getContext(), R.drawable.ic_account_large));
                binding.imgProfileGirlSignUp.setImageDrawable(ContextCompat.getDrawable(binding.imgProfileGirlSignUp.getContext(), R.drawable.ic_girl_profile_black));
            } else {
                binding.imgProfileGirlSignUp.setImageDrawable(ContextCompat.getDrawable(binding.imgProfileGirlSignUp.getContext(), R.drawable.ic_girl_profile));
                binding.imgProfileBoySignUp.setImageDrawable(ContextCompat.getDrawable(binding.imgProfileBoySignUp.getContext(), R.drawable.ic_profile_boy_black));
            }
        });
        binding.imgProfileBoySignUp.setImageDrawable(ContextCompat.getDrawable(binding.imgProfileBoySignUp.getContext(), R.drawable.ic_profile_boy_black));
    }
}
