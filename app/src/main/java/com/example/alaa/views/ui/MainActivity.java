package com.example.alaa.views.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.alaa.R;
import com.example.alaa.views.adapters.HomeRecyclerAdapter;
import com.example.alaa.views.ui.cart.Cart;
import com.example.alaa.views.ui.dashboard.DashboardFragment;
import com.example.alaa.views.ui.main.HomeFragment;
import com.example.alaa.views.ui.main.ShopFragment;
import com.example.alaa.views.ui.profile.ProfileFragment;
import com.example.alaa.views.ui.search.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hzn.lib.EasyTransition;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements HomeRecyclerAdapter.ItemClickListener {


    public static final String TAG = "===>";
    private HomeFragment homeFragment;
    private ShopFragment shopFragment;
    private DashboardFragment dashboardFragment;

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
                Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                return true;

            case R.id.navigation_MyDashboard:
                replaceFragment(dashboardFragment);
                return true;
            default:
                //TODO:// default ?
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EasyTransition.enter(MainActivity.this);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);


        homeFragment = new HomeFragment();
        shopFragment = new ShopFragment();
        dashboardFragment = new DashboardFragment();
        replaceFragment(homeFragment);


    }


    private void replaceFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        boolean fragmentPopped = getSupportFragmentManager().popBackStackImmediate(backStateName, 0);
        if (!fragmentPopped) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out);
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(backStateName);
            transaction.commit();
        }
    }

    @Override
    public void onItemClick(View view, int position) {

        Intent intent = new Intent(this, VideoPage.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
            finish();
    }

    public void onClickCart(View view) {
        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
    }

    public void onProfile(View view) {
        ProfileFragment profileFragment = new ProfileFragment();
        profileFragment.show(getSupportFragmentManager(), profileFragment.getTag());
    }

}
