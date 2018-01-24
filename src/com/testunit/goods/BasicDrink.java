package com.testunit.goods;

import com.testunit.statistics.Statistic;

public class BasicDrink {

    private String name;
    private double purchasePrice;
    private String classification;
    private String volume;
    private int existenceOfPiece;
    private int markUp;
    private int additionalGoods;
    private int saleCount;

    public void buy(){
        saleCount++;
        existenceOfPiece--;
    }

    public int getAdditionalGoods() {
        return additionalGoods;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void AddAdditionalGoods(){
        int count = 150;
        this.additionalGoods += count;
        this.existenceOfPiece += count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public int getExistenceOfPiece() {
        return existenceOfPiece;
    }

    public void setExistenceOfPiece(int existenceOfPiece) {
        this.existenceOfPiece = existenceOfPiece;
    }

    public int getMarkUp() {
        return markUp;
    }

    public void setMarkUp(int markUp) {
        this.markUp = markUp;
    }

}
