package com.ibrahimcakir.kokteyltarifleri;

import java.io.Serializable;

public class Cocktail implements Serializable {
    public String name;
    public String cocktail;
    public String prepare;
    public int image;
    public String history;


    public Cocktail(String name, String cocktail, String prepare, int image,String history) {
        this.name = name;
        this.cocktail = cocktail;
        this.prepare = prepare;
        this.image = image;
        this.history = history;
    }
}
