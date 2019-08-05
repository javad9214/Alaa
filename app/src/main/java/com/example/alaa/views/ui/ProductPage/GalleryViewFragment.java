package com.example.alaa.views.ui.ProductPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.bumptech.glide.Glide;
import com.example.alaa.R;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class GalleryViewFragment extends BottomSheetDialogFragment {

    public GalleryViewFragment() {
    }

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.gallery_view, container, false);

        initImage();

        return view;
    }


    private void initImage(){

        ImageView imageView = view.findViewById(R.id.imageView);
        Glide.with(view).load("https://alaatv.com/image/4/1400/2000/tarkibiat_1_20171206235131.jpg").into(imageView);

    }

}
