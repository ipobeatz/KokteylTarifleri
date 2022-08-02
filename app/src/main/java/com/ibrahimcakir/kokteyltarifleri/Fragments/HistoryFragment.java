package com.ibrahimcakir.kokteyltarifleri.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ibrahimcakir.kokteyltarifleri.Adapter.CocktailAdapter;
import com.ibrahimcakir.kokteyltarifleri.Adapter.FragmentAdapter;
import com.ibrahimcakir.kokteyltarifleri.Cocktail;
import com.ibrahimcakir.kokteyltarifleri.Ingredients;
import com.ibrahimcakir.kokteyltarifleri.R;
import com.ibrahimcakir.kokteyltarifleri.Singleton;
import com.ibrahimcakir.kokteyltarifleri.databinding.FragmentHistoryBinding;
import com.ibrahimcakir.kokteyltarifleri.databinding.RecyclerRowBinding;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

public class HistoryFragment extends Fragment {
    FragmentHistoryBinding binding;
    ArrayList<Ingredients> adapterList = new ArrayList<>();

    public HistoryFragment(List<Ingredients> ingredientsList) {
        adapterList.addAll(ingredientsList);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHistoryBinding binding = FragmentHistoryBinding.inflate(inflater, container, false);

        binding.recyclerFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
        FragmentAdapter fragmentAdapter = new FragmentAdapter(adapterList);
        binding.recyclerFragment.setAdapter(fragmentAdapter);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}