package com.ibrahimcakir.kokteyltarifleri.Fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibrahimcakir.kokteyltarifleri.Cocktail;
import com.ibrahimcakir.kokteyltarifleri.MainActivity;
import com.ibrahimcakir.kokteyltarifleri.R;
import com.ibrahimcakir.kokteyltarifleri.Singleton;


public class HomeFragment extends Fragment {
    public TextView textView1;
    private Activity activity = getActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);



        //TextView textView = textView1.setText(selectedCocktail.name);

    }
    Singleton singleton = Singleton.getInstance();
    Cocktail selectedCocktail = singleton.getSelectedCocktail();


}
