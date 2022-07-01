package com.ibrahimcakir.kokteyltarifleri;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ibrahimcakir.kokteyltarifleri.databinding.RecyclerAdapBinding;
import com.ibrahimcakir.kokteyltarifleri.databinding.RecyclerRowBinding;

public class Details extends AppCompatActivity {

    private RecyclerAdapBinding binding;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = RecyclerAdapBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Singleton singleton = Singleton.getInstance();
        Cocktail selectedCocktail = singleton.getSelectedCocktail();

        binding.textView1.setText(selectedCocktail.name);
        binding.textView2.setText(selectedCocktail.cocktail);
        binding.textView3.setText(selectedCocktail.prepare);
        binding.imageView.setImageResource(selectedCocktail.image);

        }
 }
