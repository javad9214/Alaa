package com.example.alaa.views.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.lifecycle.ViewModelProviders;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;

import com.example.alaa.R;
import com.example.alaa.customViews.MyTextView;
import com.example.alaa.tools.KeyboardHeight.KeyboardHeightObserver;
import com.example.alaa.tools.KeyboardHeight.KeyboardHeightProvider;
import com.example.alaa.tools.TextWatcher.MultiTextWatcher;
import com.example.alaa.tools.TextWatcher.TextWatcherWithInstance;
import com.example.alaa.tools.Transitions.MyTransition;
import com.example.alaa.views.ui.MainActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.transitionseverywhere.extra.Scale;

import java.util.Objects;

public class Login extends AppCompatActivity implements View.OnClickListener, ChipGroup.OnCheckedChangeListener, View.OnFocusChangeListener, KeyboardHeightObserver {

    public static final String TAG = "Alaa\\Login";
    private TextInputEditText ed_phoneNumber, ed_personalNumber, ed_NameSignUp, ed_LastNameSignUp, ed_PhoneSignUp, ed_PersonalNumberSignUp, ed_EmailSignUp;
    private AppCompatImageView img_phoneNumber, img_personalNumber;
    private AppCompatImageView img_NameSignUp, img_LastNameSignUp, img_PhoneSignUp, img_PersonalNumberSignUp, img_EmailSignUp;
    private AppCompatImageView doneIcon, doneIcon2;
    private AppCompatImageView img_profile, img_profile_Boy, img_profile_Girl;
    private ImageView img_Alaa_logo;
    private MyTextView describe1, describe2;
    private CardView cardLogin, cardSignUp;
    private MaterialButton btn_login, btn_GoToSignUp, btn_GoToLogin;
    private ViewGroup transitionLogoContainer;
    private ViewGroup loginContainer;
    private MyTransition myTransition;
    private Chip chip_math, chip_tajrobi, chip_ensani;

    private KeyboardHeightProvider keyboardHeightProvider;

    private AuthViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        viewModel = ViewModelProviders.of(this).get(AuthViewModel.class);
        LoginFragment loginFragment = new LoginFragment();
        SignUpFragment signUpFragment = new SignUpFragment();




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


    private void init() {

        keyboardHeightProvider = new KeyboardHeightProvider(this);

        // make sure to start the keyboard height provider after the onResume
        // of this activity. This is because a popup window must be initialised
        // and attached to the activity root view.
        View view = loginContainer;
        view.post(new Runnable() {
            @Override
            public void run() {
                keyboardHeightProvider.start();
            }
        });
    }

    public void login(View view) {

//        EasyTransitionOptions options =
//                EasyTransitionOptions.makeTransitionOptions(
//                        Login.this,
//                        findViewById(R.id.alaa_logo),
//                        findViewById(R.id.img_profile));
//
//
//        Intent intent = new Intent(Login.this , MainActivity.class);
//        EasyTransition.startActivity(intent , options);

        Log.i(TAG, "login: " + viewModel.getName().getValue());
        Log.i(TAG, "login: " + viewModel.getLastName().getValue());
        Log.i(TAG, "login: " + viewModel.getPersonalNumber().getValue());
        Log.i(TAG, "login: " + viewModel.getMajor().toString());

        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);

    }

    private Transition logoTransition(boolean visible) {


        return new TransitionSet()
                .addTransition(new Scale(0.7f))
                .addTransition(new Fade())
                .setInterpolator(visible ? new LinearOutSlowInInterpolator() :
                        new FastOutLinearInInterpolator())
                .setDuration(500);
    }

    private void cardTransition(boolean visible) {

        final View root = getWindow().getDecorView().findViewById(android.R.id.content);
        int height = root.getHeight() - root.getRootView().getHeight();
        height = root.getHeight() - cardLogin.getHeight() + height * 2;
        height = height + cardLogin.getHeight() - root.getHeight();


        int height2 = root.getRootView().getHeight() - cardLogin.getMeasuredHeight() + height;

        int height3 = cardLogin.getMeasuredHeight() / 2;

        cardLogin.animate().translationY(visible ? -(height3) : 0).setDuration(600);

        TransitionManager.beginDelayedTransition(transitionLogoContainer, logoTransition(visible));
        img_Alaa_logo.setVisibility(visible ? View.INVISIBLE : View.VISIBLE);
        describe1.setVisibility(visible ? View.INVISIBLE : View.VISIBLE);
        describe2.setVisibility(visible ? View.INVISIBLE : View.VISIBLE);
    }

    private void IconScaleTransition(View view, boolean visible) {


        TransitionSet set = new TransitionSet()
                .addTransition(new Scale(0.7f))
                .setInterpolator(!visible ? new LinearOutSlowInInterpolator() :
                        new FastOutLinearInInterpolator())
                .setDuration(400);


        TransitionManager.beginDelayedTransition(cardLogin, set);

        view.setVisibility(!visible ? View.GONE : View.VISIBLE);

    }

    private void trans() {

        TransitionManager.beginDelayedTransition(loginContainer, new ChangeBounds().setDuration(1000));
        //TransitionManager.beginDelayedTransition(loginContainer , new Slide());

        ViewGroup.LayoutParams layoutParams = transitionLogoContainer.getLayoutParams();

        final TypedArray styledAttributes = this.getTheme().obtainStyledAttributes(
                new int[]{android.R.attr.actionBarSize});
        int mActionBarSize = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        Log.i(TAG, "trans: " + mActionBarSize);
        layoutParams.height = mActionBarSize;
        transitionLogoContainer.setLayoutParams(layoutParams);

    }

    private void editTextCounter() {

        ed_phoneNumber.setOnFocusChangeListener(this);
        ed_personalNumber.setOnFocusChangeListener(this);


        new MultiTextWatcher().registerEditText(ed_phoneNumber)
                .setCallBack(new TextWatcherWithInstance() {
                    @Override
                    public void afterTextChanged(EditText editText, Editable editable) {

                        if (Objects.requireNonNull(ed_phoneNumber.getText()).length() == 11) {
                            img_phoneNumber.setImageResource(R.drawable.ic_mobile_color);
                            IconScaleTransition(doneIcon, true);

                        } else {
                            img_phoneNumber.setImageResource(R.drawable.ic_mobile);
                            IconScaleTransition(doneIcon, false);
                        }

                    }
                });


        new MultiTextWatcher().registerEditText(ed_personalNumber)
                .setCallBack(new TextWatcherWithInstance() {
                    @Override
                    public void afterTextChanged(EditText editText, Editable editable) {
                        if (Objects.requireNonNull(ed_personalNumber.getText()).length() == 10) {
                            img_personalNumber.setImageResource(R.drawable.ic_personal_code_colored);
                            IconScaleTransition(doneIcon2, true);
                            hideKeyboard(Login.this);
                            cardTransition(false);
                            IconScaleTransition(btn_login, true);

                        } else {
                            img_personalNumber.setImageResource(R.drawable.ic_personal_code);
                            IconScaleTransition(doneIcon2, false);
                        }
                    }
                });


        new MultiTextWatcher().registerEditText(ed_NameSignUp)
                .setCallBack(new TextWatcherWithInstance() {
                    @Override
                    public void afterTextChanged(EditText editText, Editable editable) {
                        if (Objects.requireNonNull(ed_NameSignUp.getText()).length() >= 1) {
                            img_NameSignUp.setImageResource(R.drawable.ic_name_signup_colored);
                        } else {
                            img_NameSignUp.setImageResource(R.drawable.ic_name_signup);
                        }
                    }
                });

        new MultiTextWatcher().registerEditText(ed_LastNameSignUp)
                .setCallBack(new TextWatcherWithInstance() {
                    @Override
                    public void afterTextChanged(EditText editText, Editable editable) {
                        if (Objects.requireNonNull(ed_LastNameSignUp.getText()).length() >= 1) {
                            img_LastNameSignUp.setImageResource(R.drawable.ic_lastname_signup_colored);
                        } else {
                            img_LastNameSignUp.setImageResource(R.drawable.ic_lastname_signup);
                        }
                    }
                });

        new MultiTextWatcher().registerEditText(ed_PhoneSignUp)
                .setCallBack(new TextWatcherWithInstance() {
                    @Override
                    public void afterTextChanged(EditText editText, Editable editable) {
                        if (Objects.requireNonNull(ed_PhoneSignUp.getText()).length() == 11) {
                            img_PhoneSignUp.setImageResource(R.drawable.ic_mobile_color);
                        } else {
                            img_PhoneSignUp.setImageResource(R.drawable.ic_mobile);
                        }
                    }
                });

        new MultiTextWatcher().registerEditText(ed_PersonalNumberSignUp)
                .setCallBack(new TextWatcherWithInstance() {
                    @Override
                    public void afterTextChanged(EditText editText, Editable editable) {
                        if (Objects.requireNonNull(ed_PersonalNumberSignUp.getText()).length() == 10) {
                            img_PersonalNumberSignUp.setImageResource(R.drawable.ic_personal_code_colored);
                        } else {
                            img_PersonalNumberSignUp.setImageResource(R.drawable.ic_personal_code);
                        }
                    }
                });

        new MultiTextWatcher().registerEditText(ed_EmailSignUp)
                .setCallBack(new TextWatcherWithInstance() {
                    @Override
                    public void afterTextChanged(EditText editText, Editable editable) {
                        if (Objects.requireNonNull(ed_EmailSignUp.getText()).length() >= 1) {
                            img_EmailSignUp.setImageResource(R.drawable.ic_email_colored);
                        } else {
                            img_EmailSignUp.setImageResource(R.drawable.ic_mail_signup);
                        }
                    }
                });


    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        // imm.showSoftInput(view , 0);
        view.clearFocus();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_GoToSignUpCard:
                myTransition.scaleTransition(loginContainer, cardLogin, false);
                myTransition.scaleTransition(loginContainer, cardSignUp, true);
                break;

            case R.id.btn_GoToLoginCard:
                myTransition.scaleTransition(loginContainer, cardSignUp, false);
                myTransition.scaleTransition(loginContainer, cardLogin, true);
                cardTransition(false);
                break;

            default:
                break;
        }

    }

    @Override
    public void onCheckedChanged(ChipGroup chipGroup, int checkedId) {


        switch (checkedId) {

            case R.id.chip_math:
                chip_math.setChipBackgroundColorResource(R.color.alaa1);
                //chip_tajrobi.setChipBackgroundColor(chipBgColor);
               // chip_ensani.setChipBackgroundColor(chipBgColor);
                break;


            case R.id.chip_tajrobi:
                chip_tajrobi.setChipBackgroundColorResource(R.color.alaa1);
               // chip_ensani.setChipBackgroundColor(chipBgColor);
               // chip_math.setChipBackgroundColor(chipBgColor);
                break;


            case R.id.chip_ensani:
                chip_ensani.setChipBackgroundColorResource(R.color.alaa1);
                //chip_math.setChipBackgroundColor(chipBgColor);
                //chip_tajrobi.setChipBackgroundColor(chipBgColor);
                break;
            default:
                //TODO:// default ?
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {

        cardTransition(true);
        /*switch (view.getId()) {

            case R.id.ed_phoneNumber:
                cardTransition(true);
                break;


            case R.id.ed_personalNumber:
                cardTransition(true);
                break;
        }*/

    }

    @Override
    public void onKeyboardHeightChanged(int height, int orientation) {
        if (height == 0) {
            cardTransition(false);
        } else {
            cardTransition(true);
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        keyboardHeightProvider.close();
    }

    public static float convertPixelsToDp(float px, Context context) {
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static int dpToPx(float dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }


}
