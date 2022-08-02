package com.ibrahimcakir.kokteyltarifleri.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibrahimcakir.kokteyltarifleri.Cocktail;
import com.ibrahimcakir.kokteyltarifleri.DetailActivity;
import com.ibrahimcakir.kokteyltarifleri.Fragments.HistoryFragment;
import com.ibrahimcakir.kokteyltarifleri.Ingredients;
import com.ibrahimcakir.kokteyltarifleri.Singleton;
import com.ibrahimcakir.kokteyltarifleri.databinding.FragmentRowBinding;
import com.ibrahimcakir.kokteyltarifleri.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class FragmentAdapter extends RecyclerView.Adapter<FragmentAdapter.FragmentHolder> {
    ArrayList<Ingredients> AdapterList;

    public FragmentAdapter(ArrayList<Ingredients> AdapterList) {
        this.AdapterList = AdapterList;
    }

    @NonNull
    @Override
    public FragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FragmentRowBinding recyclerRowBinding = FragmentRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new FragmentHolder(recyclerRowBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull FragmentHolder holder, int position) {
        holder.binding.textRow.setText(AdapterList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return AdapterList.size();
    }

    public class FragmentHolder extends RecyclerView.ViewHolder {
        private final FragmentRowBinding binding;


        public FragmentHolder(FragmentRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
