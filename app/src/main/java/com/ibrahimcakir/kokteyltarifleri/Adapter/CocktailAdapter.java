package com.ibrahimcakir.kokteyltarifleri.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibrahimcakir.kokteyltarifleri.Cocktail;
import com.ibrahimcakir.kokteyltarifleri.DetailActivity;
import com.ibrahimcakir.kokteyltarifleri.Singleton;
import com.ibrahimcakir.kokteyltarifleri.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class CocktailAdapter extends RecyclerView.Adapter<CocktailAdapter.KokteylHolder> { 
    ArrayList<Cocktail> AdapterArrayList;


    public CocktailAdapter(ArrayList<Cocktail> AdapterArrayList) {
        this.AdapterArrayList = AdapterArrayList;
    }

    @NonNull
    @Override
    public KokteylHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new KokteylHolder(recyclerRowBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull KokteylHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(AdapterArrayList.get(position).name);
        holder.binding.imageView2.setImageResource(AdapterArrayList.get(position).image);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            Singleton singleton = Singleton.getInstance();
            singleton.setChosenCocktail(AdapterArrayList.get(position));

            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return AdapterArrayList.size();
    }

    public class KokteylHolder extends RecyclerView.ViewHolder {
        private final RecyclerRowBinding binding;

        public KokteylHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}

