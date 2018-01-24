package com.testunit.EmulationStrategy;

import com.testunit.Customer.Customer;
import com.testunit.goods.AlcoholDrink;
import com.testunit.goods.BasicDrink;
import com.testunit.statistics.Statistic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BasicStrategy implements Strategy {
    @Override
    public void runStrategy(ArrayList<Customer> listCustomers, GregorianCalendar calendar, ArrayList<? extends BasicDrink> goods, ArrayList endedGoods) {
        System.out.println("This is Basic Strategy!");
    }

    protected  boolean isSalesTime(GregorianCalendar calendar) {
        int i = calendar.get(Calendar.HOUR_OF_DAY);
        if(i >= 18 && i < 20){
            return true;
        }
        return false;
    }

    protected boolean isWeekend(GregorianCalendar calendar){
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        if(i == 1 || i == 7){
            return true;
        }
        return false;
    }

    protected void buyNoSalesTime(ArrayList<? extends BasicDrink> orderList){
        for(int i = 0; i < orderList.size(); i++){
            double purchasePrice = orderList.get(i).getPurchasePrice();
            double salePrice;
            if(i > 1){
                salePrice = purchasePrice * 1.07;
                System.out.println(orderList.get(i).getClassification() + " " + orderList.get(i).getName() + " стоимость: "
                        + String.format("%.2f", salePrice) + " - наценка согласно товаров больше двух...");
            }else {
                salePrice = purchasePrice * 1.1;
                System.out.println(orderList.get(i).getClassification() + " " + orderList.get(i).getName() + " стоимость: "
                        + String.format("%.2f", salePrice) + " - стандартная наценка...");
            }

            Statistic.addProfit(salePrice - purchasePrice);
        }
    }

    protected void buyAtSalesTime(ArrayList<? extends BasicDrink> orderList) {
        for(int i = 0; i < orderList.size(); i++){
            double purchasePrice = orderList.get(i).getPurchasePrice();
            double salePrice;
            if(i > 1){
                salePrice = purchasePrice * 1.07;
                System.out.println(orderList.get(i).getClassification() + " " + orderList.get(i).getName() + " стоимость: "
                        + String.format("%.2f", salePrice) + " - наценка согласно товаров больше двух...");
            }else {
                salePrice = purchasePrice * 1.08;
                System.out.println(orderList.get(i).getClassification() + " " + orderList.get(i).getName() + " стоимость: "
                        + String.format("%.2f", salePrice) + " - наценка вечернего времени...");
            }

            Statistic.addProfit(salePrice - purchasePrice);
        }
    }

    protected void buYOnTheWeekend(ArrayList<? extends BasicDrink> orderList){
        for(int i = 0; i < orderList.size(); i++){
            double purchasePrice = orderList.get(i).getPurchasePrice();
            double salePrice;
            if(i > 1){
                salePrice = purchasePrice * 1.07;
                System.out.println(orderList.get(i).getClassification() + " " + orderList.get(i).getName() + " стоимость: "
                        + String.format("%.2f", salePrice) + " - наценка согласно товаров больше двух...");
            }else {
                salePrice = purchasePrice * 1.15;
                System.out.println(orderList.get(i).getClassification() + " " + orderList.get(i).getName() + " стоимость: "
                        + String.format("%.2f", salePrice) + " - наценка выходного дня...");
            }

            Statistic.addProfit(salePrice - purchasePrice);
        }
    }
}
