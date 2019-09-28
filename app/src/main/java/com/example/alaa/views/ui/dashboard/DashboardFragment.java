package com.example.alaa.views.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alaa.R;
import com.example.alaa.databinding.DashboardFragmentBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.jetbrains.annotations.NotNull;


public class DashboardFragment extends BottomSheetDialogFragment {


    public static final String TAG = "===>" ;

    private DashboardFragmentBinding binding;

    public DashboardFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.dashboard_fragment, container, false);
        View view = binding.getRoot();
        binding.setLifecycleOwner(this);

        setUpRecycler();

        return view;
    }


    private void setUpRecycler() {

        MyProductsAdapter adapter = new MyProductsAdapter();

        RecyclerView recyclerView = binding.recyclerDashboard;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);

    }

}
