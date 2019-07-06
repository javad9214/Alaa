package com.example.alaa.Views.UI.SearchPage;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.alaa.Models.ActivityUtil;
import com.example.alaa.R;
import com.example.alaa.Views.UI.SearchPage.Filter.FilterItemSelected;

public class SearchActivity extends AppCompatActivity implements FilterItemSelected {

    public static final String TAG = "===>" ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ActivityUtil.addFragmentToActivity(
                getSupportFragmentManager(), new SearchResults() , android.R.id.content);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onItemSelected(String item) {
        Log.i(TAG , item);
    }
}
