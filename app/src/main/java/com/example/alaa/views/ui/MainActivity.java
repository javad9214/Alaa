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

            case R.id.navigation_MyProfile:

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


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);


        homeFragment = new HomeFragment();
        shopFragment = new ShopFragment();
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

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (!(fragment instanceof IOnBackPressed) || !((IOnBackPressed) fragment).onBackPressed()) {
            finish();
        }
    }

    public interface IOnBackPressed {
        /**
         * If you return true the back press will not be taken into account, otherwise the activity will act naturally
         *
         * @return true if your processing has priority if not false
         */
        boolean onBackPressed();
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
