package com.ibrahimcakir.kokteyltarifleri;

import java.io.Serializable;

public class Cocktail implements Serializable {
    public String  name;
    public String cocktail;
    public String prepare;
    public String ingredients;
    public int image;



    public Cocktail(String name, String cocktail, String prepare, int image,String ingredients) {
        this.name = name;
        this.cocktail = cocktail;
        this.prepare = prepare;
        this.ingredients = ingredients;
        this.image = image;

    }
}
