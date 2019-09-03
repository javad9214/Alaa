package com.example.alaa.views.ui.search;


import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.alaa.R;
import com.example.alaa.views.ui.search.Filter.FilterItemSelected;

public class SearchActivity extends AppCompatActivity implements FilterItemSelected  , LifecycleOwner {

    public static final String TAG = "===>" ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getLifecycle().addObserver(new SearchLifeCycleObserver());

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(android.R.id.content , new SearchResults());
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onItemSelected(String item) {
        Log.i(TAG , item);
    }


   class SearchLifeCycleObserver implements LifecycleObserver {
       @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
       public void connectListener() {
           Log.i(TAG, "connectListener:  on Resume");
       }

       @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
       public void disconnectListener() {
           Log.i(TAG, "disconnectListener: on Pause");
       }
   }
}
