package com.ibrahimcakir.kokteyltarifleri.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ibrahimcakir.kokteyltarifleri.Adapter.FragmentAdapter;
import com.ibrahimcakir.kokteyltarifleri.Ingredients;
import com.ibrahimcakir.kokteyltarifleri.databinding.FragmentHistoryBinding;

import java.util.ArrayList;
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

        binding.recyclerFragment.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        binding.recyclerFragment.setHasFixedSize(true);
        binding.recyclerFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerFragment.setItemAnimator(new DefaultItemAnimator());

        FragmentAdapter fragmentAdapter = new FragmentAdapter(adapterList);
        binding.recyclerFragment.setAdapter(fragmentAdapter);

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

}