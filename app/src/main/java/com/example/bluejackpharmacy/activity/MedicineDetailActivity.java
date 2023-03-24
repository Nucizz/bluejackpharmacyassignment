package com.example.bluejackpharmacy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bluejackpharmacy.Data;
import com.example.bluejackpharmacy.object.Transaction;
import com.example.bluejackpharmacy.object.User;
import com.example.bluejackpharmacy.system.Feature;
import com.squareup.picasso.Picasso;

import com.example.bluejackpharmacy.R;
import com.example.bluejackpharmacy.object.Medicine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MedicineDetailActivity extends Activity {
    int quantity = 1;
    Medicine item;

    TextView medicineNameText, medicineManufacturerText, medicinePriceText, medicineDescriptionText, qtyText;

    ImageView medicineImage;

    Button qtyPlus, qtyMin, backButton, purchaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_detail);
        item = getIntent().getParcelableExtra("item", Medicine.class);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(e -> {finish();});

        medicineNameText = findViewById(R.id.medicineNameText);
        medicineManufacturerText = findViewById(R.id.medicineManufacturerText);
        medicinePriceText = findViewById(R.id.medicinePriceText);
        medicineDescriptionText = findViewById(R.id.medicineDescriptionText);

        medicineNameText.setText(item.getName());
        medicineManufacturerText.setText(item.getManufacturer());
        medicinePriceText.setText(Feature.getCurrecntyFormat(item.getPrice()));
        medicineDescriptionText.setText(item.getDescription());

        medicineImage = findViewById(R.id.medicineImage);

        if(item.getImagePath() != null) {
            Picasso.with(this).load(item.getImagePath()).into(medicineImage);
        }

        qtyText = findViewById(R.id.medicineQuantity);
        qtyMin = findViewById(R.id.decreaseQuantity);
        qtyPlus = findViewById(R.id.increaseQuantity);

        qtyText.setText(String.valueOf(quantity));

        qtyMin.setOnClickListener(e -> {
            if(quantity <= 1) {
                quantity = 1;
            } else {
                quantity--;
            }
            updateState();
        });

        qtyPlus.setOnClickListener(e -> {
            quantity++;
            updateState();
        });

        qtyText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                quantity = Integer.parseInt(qtyText.getText().toString());
                updateState();
            }
        });

        purchaseButton = findViewById(R.id.purchaseButton);
        purchaseButton.setOnClickListener(e -> {
            DateFormat dateFormat = new SimpleDateFormat("dd mm yyyy");
            Calendar cal = Calendar.getInstance();
            Data.transactionList.add(new Transaction(Data.userList.size()+1, User.currentUser, item, quantity, dateFormat.format(cal.getTime())));
            Toast.makeText(this, "Item succesfully purchased!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    void updateState() {
        qtyText.setText(String.valueOf(quantity));
        if(quantity == 1) {
            purchaseButton.setText("Purchase");
        } else {
            purchaseButton.setText(Feature.getCurrecntyFormat(item.getPrice() * quantity));
        }

    }
}