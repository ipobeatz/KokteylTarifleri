package com.ibrahimcakir.kokteyltarifleri;

import java.io.Serializable;

public class Cocktail implements Serializable {
    String name;
    String cocktail;
    String prepare;
    int image;

    public Cocktail(String name, String cocktail, String prepare, int image) {
        this.name = name;
        this.cocktail = cocktail;
        this.prepare = prepare;
        this.image = image;


    }

}
