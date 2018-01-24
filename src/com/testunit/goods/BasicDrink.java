package com.testunit.goods;

public class BasicDrink {

    private String name;
    private float purchasePrice;
    private String classification;
    private String volume;
    private int existenceOfPiece;
    private int markUp;
    private int additionalGoods;
    private int saleCount;

    public int getAdditionalGoods() {
        return additionalGoods;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void addSaleCount(){
        this.saleCount++;
    }

    public void AddAdditionalGoods(){
        this.additionalGoods += 150;
        this.existenceOfPiece += 150;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
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
