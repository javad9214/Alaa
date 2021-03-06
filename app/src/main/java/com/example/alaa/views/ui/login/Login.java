package com.example.alaa.views.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.alaa.R;
import com.example.alaa.tools.KeyboardHeight.KeyboardHeightObserver;
import com.example.alaa.tools.KeyboardHeight.KeyboardHeightProvider;
import com.example.alaa.views.ui.MainActivity;

/**
 * @author Alaaa2
 */
public class Login extends AppCompatActivity implements KeyboardHeightObserver {

    public static final String TAG = "===>";

    private AuthViewModel viewModel;
    private KeyboardHeightProvider keyboardHeightProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewModel = ViewModelProviders.of(this).get(AuthViewModel.class);
        LoginFragment loginFragment = new LoginFragment();
        SignUpFragment signUpFragment = new SignUpFragment();
        VerifyPhoneNumberFragment verifyPhoneNumberFragment = new VerifyPhoneNumberFragment();

        keyboardHeightProvider = new KeyboardHeightProvider(this);

        View view = findViewById(android.R.id.content);

        view.post(() -> keyboardHeightProvider.start());

        viewModel.getSelectedPage().observe(this, page -> {
            if (page == 0){
                replaceFragment(loginFragment);
            }else {
                replaceFragment(signUpFragment);
            }
        });


    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out , android.R.animator.fade_in, android.R.animator.fade_out);
        transaction.replace(android.R.id.content , fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    public void login(View view) {

        Log.i(TAG, "login: " + viewModel.getName().getValue());
        Log.i(TAG, "login: " + viewModel.getLastName().getValue());
        Log.i(TAG, "login: " + viewModel.getPersonalNumber().getValue());
        Log.i(TAG, "login: " + viewModel.getMajor().toString());

        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        keyboardHeightProvider.setKeyboardHeightObserver(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        keyboardHeightProvider.setKeyboardHeightObserver(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        keyboardHeightProvider.close();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onKeyboardHeightChanged(int height, int orientation) {
        viewModel.setKeyboardHeight(height);
        if (height > 0) {
            viewModel.onKeyboardVisibilityChange(true);
        } else {
            viewModel.onKeyboardVisibilityChange(false);
        }

    }
}
