package com.example.bluejackpharmacy.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.bluejackpharmacy.R;
import com.example.bluejackpharmacy.object.User;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AboutUsFragment extends Fragment {

    MapView mapFragment;
    ImageButton logout;

    public AboutUsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            mapFragment.onResume();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            mapFragment.onDestroy();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);

        mapFragment = view.findViewById(R.id.googleMaps);

        try {
            mapFragment.onCreate(savedInstanceState);
            mapFragment.getMapAsync(googleMap -> {
                LatLng position = new LatLng(-6.202053, 106.7820726);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 15));
                googleMap.addMarker(new MarkerOptions().position(position).title("Bluejack Pharmacy"));
            });
        }
        catch (Exception e) {
            Toast.makeText(getContext(), "Map service unavailable!", Toast.LENGTH_SHORT).show();
        }


        logout = (ImageButton) view.findViewById(R.id.logoutButton);
        logout.setOnClickListener(e -> {
            getActivity().finish();
            User.setUser(null);
        });

        return view;
    }
}