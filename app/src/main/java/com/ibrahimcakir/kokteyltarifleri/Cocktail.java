package com.ibrahimcakir.kokteyltarifleri;

import java.io.Serializable;
import java.util.List;

public class Cocktail implements Serializable {
    public String name;
    public String cocktail;
    public String prepare;
    public int image;
    public List<Ingredients> ingredientsList;
    public boolean isFruitFlavored;
    public boolean isEspressoFlavored;
    public boolean lightAlcohols;
    public boolean strongAlcohols;



    public Cocktail(String name, String cocktail, String prepare, int image, List<Ingredients> ingredientsList,
                    boolean isFruitFlavored,boolean isEspressoFlavored,boolean lightAlcohols,boolean strongAlcohols) {
        this.name = name;
        this.cocktail = cocktail;
        this.prepare = prepare;
        this.image = image;
        this.ingredientsList = ingredientsList;
        this.isFruitFlavored = isFruitFlavored;
        this.isEspressoFlavored = isEspressoFlavored;
        this.lightAlcohols = lightAlcohols;
        this.strongAlcohols = strongAlcohols;
    }
}
