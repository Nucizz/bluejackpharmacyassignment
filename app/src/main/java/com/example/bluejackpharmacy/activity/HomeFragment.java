package com.example.bluejackpharmacy.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bluejackpharmacy.Data;
import com.example.bluejackpharmacy.R;
import com.example.bluejackpharmacy.object.User;
import com.example.bluejackpharmacy.system.Feature;
import com.example.bluejackpharmacy.system.MedicineAdapter;

public class HomeFragment extends Fragment {

    RecyclerView medicineView;
    TextView greetingsText;
    ImageButton logout;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        MedicineAdapter medicineAdapter = new MedicineAdapter(getContext(), Data.medicineList, item -> {
            Intent details = new Intent(getActivity(), MedicineDetailActivity.class);
            details.putExtra("item", item);
            startActivity(details);
        });

        greetingsText = (TextView) view.findViewById(R.id.greetingsText);
        greetingsText.setText(Feature.getTimeGreetings() + ", " + User.currentUser.getName().split(" ")[0] + "!");

        medicineView = (RecyclerView) view.findViewById(R.id.medicineView);
        medicineView.setAdapter(medicineAdapter);
        medicineView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        logout = (ImageButton) view.findViewById(R.id.logoutButton);
        logout.setOnClickListener(e -> {
            getActivity().finish();
            User.setUser(null);
        });

        return view;
    }

}