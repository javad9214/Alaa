package com.example.alaa.views.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alaa.R;

public class BookmarkFragment extends Fragment {

    private View view ;

    public BookmarkFragment() {
    }

    public static Fragment newInstance() {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.bookmarks, container, false);

        init();

        return view ;

    }


    private void init(){
        RecyclerView recyclerView = view.findViewById(R.id.bookmark_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.canScrollVertically();
        recyclerView.setLayoutManager(linearLayoutManager);

        Adapter_shop adapter = new Adapter_shop(getContext() , R.layout.content_recycler_more);
        recyclerView.setAdapter(adapter);
    }





}
