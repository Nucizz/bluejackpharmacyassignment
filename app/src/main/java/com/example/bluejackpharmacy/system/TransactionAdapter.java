package com.example.bluejackpharmacy.system;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluejackpharmacy.Data;
import com.example.bluejackpharmacy.R;
import com.example.bluejackpharmacy.object.Transaction;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    Context ctx;
    ArrayList<Transaction> data;

    public TransactionAdapter(Context ctx, ArrayList<Transaction> items) {
        this.ctx = ctx;
        this.data = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_transaction, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.transactionNameText.setText(data.get(position).getItem().getName());
        holder.transactionDateText.setText(data.get(position).getTranscationDate());
        holder.transactionPriceQtyText.setText(Feature.getCurrecntyFormat(data.get(position).getItem().getPrice()).concat(" • ")
                .concat(String.valueOf(data.get(position).getQuantity())).concat(" items"));

        holder.transactionTotalPriceText.setText(Feature.getCurrecntyFormat(data.get(position).getItem().getPrice() * data.get(position).getQuantity()));

        if(data.get(position).getItem().getImagePath() != null) {
            Picasso.with(holder.itemView.getContext()).load(data.get(position).getItem().getImagePath()).into(holder.transactionImage);
        }

        AtomicInteger quantity = new AtomicInteger(data.get(position).getQuantity());
        holder.qtyText.setText(String.valueOf(quantity.get()));

        holder.qtyMin.setOnClickListener(e -> {
            if(quantity.get() <= 1) {
                quantity.set(1);
            } else {
                quantity.set(quantity.get()-1);
            }
            holder.qtyText.setText(String.valueOf(quantity.get()));
        });

        holder.qtyPlus.setOnClickListener(e -> {
            quantity.set(quantity.get()+1);
            holder.qtyText.setText(String.valueOf(quantity.get()));
        });

        holder.qtyText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                quantity.set(Integer.parseInt(holder.qtyText.getText().toString()));
                holder.qtyText.setText(String.valueOf(quantity.get()));
            }
        });

        holder.modifyButton.setOnClickListener(view -> {
            if (holder.expandableCard.getVisibility() == View.GONE) {
                holder.expandableCard.setVisibility(View.VISIBLE);
                holder.qtyText.setText(String.valueOf(data.get(position).getQuantity()));
                quantity.set(data.get(position).getQuantity());
                holder.modifyButton.setText(" Cancel");
            } else {
                holder.expandableCard.setVisibility(View.GONE);
                holder.modifyButton.setText(" Modify");
            }
        });

        holder.deleteButton.setOnClickListener(e -> {
            Data.allTransactionList.remove(data.get(position));
            Data.dataUpdate();
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, getItemCount());
            Toast.makeText(e.getContext(), "Sucessfully deleted transactions!", Toast.LENGTH_SHORT).show();
        });

        holder.saveButton.setOnClickListener(e -> {
            Data.allTransactionList.get(Data.allTransactionList.indexOf(data.get(position))).setQuantity(quantity.get());
            Data.dataUpdate();
            notifyItemChanged(position);
            notifyItemRangeChanged(position, getItemCount());

            holder.expandableCard.setVisibility(View.GONE);
            holder.modifyButton.setText(" Modify");
            Toast.makeText(e.getContext(), "Sucessfully updated transactions!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView transactionNameText, transactionDateText, transactionPriceQtyText, transactionTotalPriceText;
        ImageView transactionImage;

        LinearLayout expandableCard;
        Button modifyButton;


        Button deleteButton, saveButton;
        ImageButton qtyPlus, qtyMin;
        EditText qtyText;


        @SuppressLint("ResourceAsColor")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            transactionNameText = itemView.findViewById(R.id.transactionNameText);
            transactionDateText = itemView.findViewById(R.id.transactionDateText);
            transactionPriceQtyText = itemView.findViewById(R.id.transactionPriceQtyText);
            transactionTotalPriceText = itemView.findViewById(R.id.transactionTotalPriceText);

            transactionImage = itemView.findViewById(R.id.transactionImage);

            expandableCard = itemView.findViewById(R.id.expandableLayout);
            modifyButton = itemView.findViewById(R.id.transactionModifyButton);

            qtyText = itemView.findViewById(R.id.medicineQuantity);
            qtyMin = itemView.findViewById(R.id.decreaseQuantity);
            qtyPlus = itemView.findViewById(R.id.increaseQuantity);

            deleteButton = itemView.findViewById(R.id.transactionDeleteButton);
            saveButton = itemView.findViewById(R.id.transactionSaveButton);
        }
    }
}
