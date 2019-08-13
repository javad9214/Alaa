package com.example.alaa.views.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.alaa.R;
import com.example.alaa.views.Adapters.HomeRecyclerAdapter;
import com.example.alaa.views.Dashboard.DashboardFragment;
import com.example.alaa.views.ui.SearchPage.SearchActivity;
import com.example.alaa.views.ui.cart.Cart;
import com.example.alaa.views.ui.main.HomeFragment;
import com.example.alaa.views.ui.main.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hzn.lib.EasyTransition;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements HomeRecyclerAdapter.ItemClickListener {


    public static final String TAG = "===>";
    private HomeFragment homeFragment;
    private ShopFragment shopFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                homeFragment = new HomeFragment();
                replaceFragment(homeFragment);
                return true;

            case R.id.navigation_Product:
                 replaceFragment(shopFragment);
                return true;

            case R.id.navigation_forum:

                return true;

            case R.id.navigation_MyProfile:

                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EasyTransition.enter(MainActivity.this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);


        homeFragment = new HomeFragment();
        shopFragment = new ShopFragment();
        replaceFragment(homeFragment);


    }


    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out);
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    public void Onclick_dashboard(View view) {
        DashboardFragment dashboardFragment = new DashboardFragment();
        dashboardFragment.show(getSupportFragmentManager(), dashboardFragment.getTag());
    }

    @Override
    public void onItemClick(View view, int position) {

        Intent intent = new Intent(this, VideoPage.class);
        startActivity(intent);
    }

    public void GoTOSearch(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        EasyTransition.exit(MainActivity.this);
    }


    public void onclick_cart(View view) {
        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
    }
}