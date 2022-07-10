package com.ibrahimcakir.kokteyltarifleri;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.ibrahimcakir.kokteyltarifleri.Adapter.CustomViewPager;
import com.ibrahimcakir.kokteyltarifleri.Fragments.HistoryFragment;
import com.ibrahimcakir.kokteyltarifleri.Fragments.HomeFragment;
import com.ibrahimcakir.kokteyltarifleri.Fragments.NoteFragment;
import com.ibrahimcakir.kokteyltarifleri.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    private ViewPager mViewPager;
    private CustomViewPager mAdapter;
    private TabLayout mTablayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Singleton singleton = Singleton.getInstance();
        Cocktail selectedCocktail = singleton.getSelectedCocktail();
        example();

        binding.textView1.setText(selectedCocktail.name);
        binding.textView2.setText(selectedCocktail.cocktail);
        binding.textView3.setText(selectedCocktail.prepare);
        binding.imageView.setImageResource(selectedCocktail.image);
        binding.mainTableLayout.setupWithViewPager(binding.viewPager);

    }

    public void example(){
        mViewPager = binding.viewPager;
        mTablayout = binding.mainTableLayout;

        mAdapter = new CustomViewPager(getSupportFragmentManager(),getApplicationContext());

        mAdapter.addFragment(new HistoryFragment(),"history");
        mAdapter.addFragment(new HomeFragment(),"home");
        mAdapter.addFragment(new NoteFragment(),"note");
        mViewPager.setAdapter(mAdapter);

        mTablayout.setupWithViewPager(mViewPager);

    }
}
