package com.example.alaa.views.ui.cart;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.alaa.R;
import com.example.alaa.databinding.FragmentCompletePurchaseBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CompletePurchase extends BottomSheetDialogFragment {


    public static final String TAG = "Cart\\CompletePurchase";

    public CompletePurchase() {
        // Required empty public constructor
    }

    private View view ;
    private CartViewModel cartViewModel ;
    private FragmentCompletePurchaseBinding binding ;


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        cartViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CartViewModel.class);

        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_complete_purchase ,container , false);
        view = binding.getRoot() ;
        binding.setCartViewModel(cartViewModel);
        binding.setLifecycleOwner(this);


        // Inflate the layout for this fragment
        return view ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.bynCompletePurchase.setOnClickListener(v ->
                Log.i(TAG, "onViewCreated: " + cartViewModel.getHasDiscountCode().getValue() + " hs donate :  " + cartViewModel.getHasDonate().getValue()));

        cartViewModel.getHasDiscountCode().observe(this, hasDiscount -> {
            if (hasDiscount){
                binding.edDiscount.setVisibility(View.VISIBLE);
                binding.btnApplyDiscount.setVisibility(View.VISIBLE);
            }else{
                binding.edDiscount.setVisibility(View.GONE);
                binding.btnApplyDiscount.setVisibility(View.GONE);
            }
        });


        cartViewModel.getHasDonate().observe(this , hasDonate -> {

            if (hasDonate){
                binding.txDonate.setText(R.string.IdoDonate);
                binding.cardTxDonate.setCardBackgroundColor(getResources().getColor(R.color.green));
                binding.imgDonateFace.setImageDrawable(ContextCompat.getDrawable(binding.imgDonateFace.getContext(), R.drawable.ic_happy));


            }else {
                binding.txDonate.setText(R.string.IdoNotDonate);
                binding.cardTxDonate.setCardBackgroundColor(getResources().getColor(R.color.RedLight));
                binding.imgDonateFace.setImageDrawable(ContextCompat.getDrawable(binding.imgDonateFace.getContext(), R.drawable.ic_sad));
            }

        });

    }
}
