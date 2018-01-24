package com.testunit.Customer;

import com.testunit.Helper.Helper;
import com.testunit.goods.BasicDrink;

import java.util.ArrayList;


public class Customer {
    private static int staticId = 0;
    private int id;
    private ArrayList orderList = new ArrayList();

    public Customer() {
        id = ++staticId;
    }

    public int getId() {
        return id;
    }


    public ArrayList getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<? extends BasicDrink> order) {
        this.orderList = order;
    }

    public void fillOrderList(ArrayList<? extends BasicDrink> goods, ArrayList endedGoods) {
        int countOfGoods = Helper.random(10);
        while (countOfGoods > 0 && goods.size() > 0){
            int i = Helper.random(goods.size() - 1);
            if(goods.get(i).getExistenceOfPiece() > 0){
                orderList.add(goods.get(i));
                countOfGoods--;
            }else {
                endedGoods.add(goods.get(i));
                goods.remove(i);
            }
        }
    }

}
