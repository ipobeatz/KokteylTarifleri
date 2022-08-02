package com.ibrahimcakir.kokteyltarifleri;

import java.io.Serializable;
import java.util.List;

public class Cocktail implements Serializable {
    public String name;
    public String cocktail;
    public String prepare;

    public int image;
    public List<Ingredients> ingredientsList;

    public Cocktail(String name, String cocktail, String prepare, int image, List<Ingredients> ingredientsList) {
        this.name = name;
        this.cocktail = cocktail;
        this.prepare = prepare;

        this.image = image;
        this.ingredientsList = ingredientsList;
    }
}
