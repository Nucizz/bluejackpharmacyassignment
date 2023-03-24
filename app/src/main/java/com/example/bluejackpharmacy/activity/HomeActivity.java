package com.example.bluejackpharmacy.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.bluejackpharmacy.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends FragmentActivity {

    BottomNavigationView navbar;

    HomeFragment homePage = new HomeFragment();
    TranscationsFragment transcationsPage = new TranscationsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navbar = findViewById(R.id.navbar);

        navbar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home_fragment:
                    getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new HomeFragment()).commit();
                    return true;
                case R.id.transcations_fragment:
                    getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new TranscationsFragment()).commit();
                    return true;
                case R.id.about_us_fragment:
                    getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new AboutUsFragment()).commit();
                    return true;
                default:
                    return false;
            }
        });
        navbar.setSelectedItemId(R.id.home_fragment);

    }

}