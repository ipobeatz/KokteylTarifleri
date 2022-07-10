package com.ibrahimcakir.kokteyltarifleri.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibrahimcakir.kokteyltarifleri.Cocktail;
import com.ibrahimcakir.kokteyltarifleri.R;
import com.ibrahimcakir.kokteyltarifleri.Singleton;


public class NoteFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Singleton singleton = Singleton.getInstance();
        Cocktail selectedCocktail = singleton.getSelectedCocktail();
        String xx = selectedCocktail.name;

        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView noteText = view.findViewById(R.id.noteTextView);
        //2- Datayı çek.
        Singleton singleton = Singleton.getInstance();
        Cocktail selectedCocktail = singleton.getSelectedCocktail();
        //3- Datayı set et.
        noteText.setText(selectedCocktail.history);
    }
}