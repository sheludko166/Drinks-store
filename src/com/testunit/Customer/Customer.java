package com.testunit.Customer;

import com.testunit.goods.BasicDrink;

import java.util.ArrayList;


public class Customer {
    private static int id = 0;
    private ArrayList orderList;

    public Customer() {
        id++;
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
}
