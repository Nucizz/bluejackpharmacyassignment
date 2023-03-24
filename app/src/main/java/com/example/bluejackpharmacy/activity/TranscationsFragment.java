package com.example.bluejackpharmacy.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.bluejackpharmacy.Data;
import com.example.bluejackpharmacy.R;
import com.example.bluejackpharmacy.object.User;
import com.example.bluejackpharmacy.system.TransactionAdapter;

public class TranscationsFragment extends Fragment {

    RecyclerView transactionView;

    ImageButton logout;

    public TranscationsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transcations, container, false);

        TransactionAdapter transactionAdapter = new TransactionAdapter(getContext(), Data.transactionList);

        transactionView = (RecyclerView) view.findViewById(R.id.transcationsView);
        transactionView.setAdapter(transactionAdapter);
        transactionView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        logout = (ImageButton) view.findViewById(R.id.logoutButton);
        logout.setOnClickListener(e -> {
            getActivity().finish();
            User.setUser(null);
        });

        return view;
    }
}