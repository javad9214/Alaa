package com.example.alaa.views.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alaa.R;
import com.example.alaa.databinding.ProfileFragmentBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ProfileFragment extends BottomSheetDialogFragment {

    private ProfileFragmentBinding binding;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return null;
    }

    private RecyclerView recyclerViewProfileInfo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.profile_fragment, container, false);

        View view = binding.getRoot();
        init();
        onClose();


        return view;
    }

    private void init() {
        recyclerViewProfileInfo = binding.recyclerProfileInfo;
    }

    private void setRecyclerViewProfileInfo() {

    }

    private void onClose() {
        binding.closeProfile.setOnClickListener(view -> {
            onStop();
        });
    }


}
