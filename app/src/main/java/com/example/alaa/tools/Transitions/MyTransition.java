package com.example.alaa.tools.Transitions;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;

import com.transitionseverywhere.Rotate;
import com.transitionseverywhere.extra.Scale;

public class MyTransition {

    public void scaleTransition(ViewGroup viewGroup, View view, boolean visible) {


        TransitionSet set = new TransitionSet()
                .addTransition(new Scale(0.7f))
                .addTransition(new Fade())
                .setInterpolator(!visible ? new LinearOutSlowInInterpolator() :
                        new FastOutLinearInInterpolator())
                .setDuration(500);


        TransitionManager.beginDelayedTransition(viewGroup, set);

        view.setVisibility(visible ? View.VISIBLE : View.GONE);

    }


    public void changeImageTransition(ViewGroup viewGroup, AppCompatImageView imageView, boolean visible, int resId) {


        TransitionSet set = new TransitionSet()
                .addTransition(new Scale(0.7f))
                .addTransition(new Fade())
                .setInterpolator(!visible ? new LinearOutSlowInInterpolator() :
                        new FastOutLinearInInterpolator())
                .setDuration(500);


        TransitionManager.beginDelayedTransition(viewGroup, set);

        imageView.setImageResource(resId);

    }

    public void searchBarTransition(ViewGroup viewGroup, AppCompatImageView imageView, boolean isSearching) {

        TransitionSet set = new TransitionSet()
                .addTransition(new Rotate())
                .addTransition(new ChangeBounds())
                .setDuration(500);

        TransitionManager.beginDelayedTransition(viewGroup, set);

        Toolbar.LayoutParams params = (Toolbar.LayoutParams) imageView.getLayoutParams();
        params.gravity = isSearching ? Gravity.END : Gravity.START;
        if (isSearching) {
            params.rightMargin = 20;
        } else {
            params.leftMargin = 20;
        }

        imageView.setLayoutParams(params);
        imageView.setRotation(isSearching ? 180 : 0 );

    }


}
