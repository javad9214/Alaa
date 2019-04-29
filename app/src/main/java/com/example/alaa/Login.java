package com.example.alaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;

import com.transitionseverywhere.Rotate;
import com.transitionseverywhere.extra.Scale;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alaa.CustomViews.MyTextView;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    public static final String TAG = "===>";
    private TextInputEditText ed_phoneNumber, ed_personalNumber;
    private AppCompatImageView img_phoneNumber, img_personalNumber;
    private AppCompatImageView doneIcon , doneIcon2 ;
    private ImageView img_logo;
    private MyTextView describe1, describe2;
    private CardView transitionCardViewLogin;

    private ViewGroup transitionLogoContainer;
    private ViewGroup loginContainer;
    boolean visible ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE| WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        init();
        editTextCounter();
    }


    private void init() {

        ed_personalNumber = findViewById(R.id.ed_personalNumber);
        ed_phoneNumber = findViewById(R.id.ed_phoneNumber);

        img_personalNumber = findViewById(R.id.img_personalNumber);
        img_phoneNumber = findViewById(R.id.img_phoneNumber);


        transitionLogoContainer = findViewById(R.id.transition_logo);
        img_logo = transitionLogoContainer.findViewById(R.id.img_logo);
        describe1 = transitionLogoContainer.findViewById(R.id.login_describe1);
        describe2 = transitionLogoContainer.findViewById(R.id.login_describe2);


        loginContainer = findViewById(R.id.loginContainer);
        transitionCardViewLogin = loginContainer.findViewById(R.id.card_login);

        doneIcon = transitionCardViewLogin.findViewById(R.id.done_icon);
        doneIcon2 = transitionCardViewLogin.findViewById(R.id.done_icon2);


    }

    public void login(View view) {
        Intent intent = new Intent(this , MainActivity.class);
         startActivity(intent);

    }

    private Transition logoTransition(boolean visible) {

        TransitionSet set = new TransitionSet()
                .addTransition(new Scale(0.7f))
                .addTransition(new Fade())
                .setInterpolator(visible ? new LinearOutSlowInInterpolator() :
                        new FastOutLinearInInterpolator())
                .setDuration(500);


        return set;
    }

    private void cardTransition(boolean visible){

        transitionCardViewLogin.animate().translationY(visible ? -700 : 0).setDuration(500);
        TransitionManager.beginDelayedTransition(transitionLogoContainer, logoTransition(visible));
        img_logo.setVisibility(visible ? View.GONE : View.VISIBLE);
        describe1.setVisibility(visible ? View.GONE : View.VISIBLE);
        describe2.setVisibility(visible ? View.GONE : View.VISIBLE);
    }

    private void DoneIconTransition(AppCompatImageView iconDone , boolean visible ){



        TransitionSet set = new TransitionSet()
                .addTransition(new Scale(0.7f))
                .addTransition(new Rotate())
                .setInterpolator(!visible ? new LinearOutSlowInInterpolator() :
                        new FastOutLinearInInterpolator())
                .setDuration(1000);


        TransitionManager.beginDelayedTransition(transitionCardViewLogin , set );

        iconDone.setVisibility(!visible ?  View.GONE : View.VISIBLE);
        iconDone.setRotation(!visible ? 135 : 0 );

    }

    private void editTextCounter() {

        ed_phoneNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
               cardTransition(true);

            }
        });

        ed_personalNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                cardTransition(true);
            }
        });

        ed_phoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (ed_phoneNumber.getText().length() == 11) {
                    img_phoneNumber.setImageResource(R.drawable.ic_mobile_color);
                    DoneIconTransition(doneIcon , true);

                } else img_phoneNumber.setImageResource(R.drawable.ic_mobile);
            }
        });

        ed_personalNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (ed_personalNumber.getText().length() == 10) {
                    img_personalNumber.setImageResource(R.drawable.ic_personal_code_colored);
                    DoneIconTransition(doneIcon2 , true);
                    hideKeyboard(Login.this);
                    cardTransition(false);
                } else img_personalNumber.setImageResource(R.drawable.ic_personal_code);
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
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
       // imm.showSoftInput(view , 0);
        view.clearFocus();
    }
}
