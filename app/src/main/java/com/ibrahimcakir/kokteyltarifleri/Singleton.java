package com.ibrahimcakir.kokteyltarifleri;

public class Singleton {
    private static Singleton singleton;
    private Cocktail selectedCocktail;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public Cocktail getSelectedCocktail() {
        return selectedCocktail;
    }

    public void setChosenCocktail(Cocktail selectedCocktail) {
        this.selectedCocktail = selectedCocktail;
    }

}
