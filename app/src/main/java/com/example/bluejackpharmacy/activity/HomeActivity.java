package com.example.bluejackpharmacy.activity;


import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.bluejackpharmacy.Data;
import com.example.bluejackpharmacy.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends FragmentActivity {

    BottomNavigationView navbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Data.dataUpdate();

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