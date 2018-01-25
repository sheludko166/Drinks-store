package com.testunit.goods;

public class NonAlcoholDrink extends BasicDrink{
    private String composition;

    public NonAlcoholDrink(String composition) {
        this.composition = composition;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }
}
