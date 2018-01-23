package com.testunit.goods;

public class AlcoholDrink extends BasicDrink{
    private String alcohol;

    public AlcoholDrink(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }
}
