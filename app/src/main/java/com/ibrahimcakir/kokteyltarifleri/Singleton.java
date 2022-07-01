package com.ibrahimcakir.kokteyltarifleri;

public class Singleton {
    private Cocktail selectedCocktail;
    private static Singleton singleton;

    private Singleton() {

    }

    public Cocktail getSelectedCocktail() {
        return selectedCocktail;
    }

    public void setChosenCocktail(Cocktail selectedCocktail) {
        this.selectedCocktail = selectedCocktail;
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;

    }

}
