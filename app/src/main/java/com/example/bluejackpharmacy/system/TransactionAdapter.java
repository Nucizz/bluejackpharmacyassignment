package com.example.bluejackpharmacy.system;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluejackpharmacy.R;
import com.example.bluejackpharmacy.object.Transaction;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

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


        @SuppressLint("ResourceAsColor")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            transactionNameText = (TextView) itemView.findViewById(R.id.transactionNameText);
            transactionDateText = (TextView) itemView.findViewById(R.id.transactionDateText);
            transactionPriceQtyText = (TextView) itemView.findViewById(R.id.transactionPriceQtyText);
            transactionTotalPriceText = (TextView) itemView.findViewById(R.id.transactionTotalPriceText);

            transactionImage = itemView.findViewById(R.id.transactionImage);

            expandableCard = itemView.findViewById(R.id.expandableLayout);
            modifyButton = itemView.findViewById(R.id.transactionModifyButton);
            modifyButton.setOnClickListener(view -> {
                if (expandableCard.getVisibility() == View.GONE) {
                    expandableCard.setVisibility(View.VISIBLE);
                    modifyButton.setText(" Cancel");
                } else {
                    expandableCard.setVisibility(View.GONE);
                    modifyButton.setText(" Modify");
                }
            });
        }
    }

}
