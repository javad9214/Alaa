package com.example.alaa.Views.UI.SearchPage;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.alaa.Models.ActivityUtil;
import com.example.alaa.R;

public class SearchActivity extends AppCompatActivity {

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
}
