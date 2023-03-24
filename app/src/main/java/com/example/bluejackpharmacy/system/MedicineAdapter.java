package com.example.bluejackpharmacy.system;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluejackpharmacy.R;
import com.example.bluejackpharmacy.object.Medicine;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {

    Context ctx;
    ArrayList<Medicine> data;
    OnClickListener onClickListener;

    public MedicineAdapter(Context ctx, ArrayList<Medicine> items, OnClickListener onClickListener) {
        this.ctx = ctx;
        this.data = items;
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(Medicine item);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_medicine, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.medicineNameText.setText(data.get(position).getName());
        holder.medicineManufacturerText.setText(String.valueOf(data.get(position).getManufacturer()));
        holder.medicinePriceText.setText(Feature.getCurrecntyFormat(data.get(position).getPrice()));

        if(data.get(position).getImagePath() != null) {
            Picasso.with(holder.itemView.getContext()).load(data.get(position).getImagePath()).into(holder.medicineImage);
        }

        holder.itemView.setOnClickListener(view -> {
            onClickListener.onClick(data.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView medicineNameText, medicineManufacturerText, medicinePriceText;
        ImageView medicineImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            medicineNameText = itemView.findViewById(R.id.medicineNameText);
            medicineManufacturerText = itemView.findViewById(R.id.medicineManufacturerText);
            medicinePriceText = itemView.findViewById(R.id.medicinePriceText);

            medicineImage = itemView.findViewById(R.id.medicineImage);
        }
    }

}
