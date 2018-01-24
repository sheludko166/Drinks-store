package com.testunit.EmulationStrategy;

import com.testunit.Customer.Customer;
import com.testunit.Helper.Helper;
import com.testunit.goods.BasicDrink;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RandomTimeStrategy extends BasicStrategy implements Strategy {
    @Override
    public void runStrategy(ArrayList<Customer> listCustomers, GregorianCalendar calendar, ArrayList<? extends BasicDrink> goods, ArrayList endedGoods) {

        System.out.println("This is " + RandomTimeStrategy.class.getName());
        int secondsPerHour = 3600;
        for(Customer customer : listCustomers){
            int timeOrderCustomers = Helper.random(secondsPerHour);
            secondsPerHour -= timeOrderCustomers;
            calendar.add(Calendar.SECOND, timeOrderCustomers);
            System.out.println(customer.getClass().getSimpleName() + customer.getId() + " зашел в магазин " + calendar.getTime());
            customer.fillOrderList(goods, endedGoods);
            ArrayList orderList = customer.getOrderList();

            if(orderList.size() > 0){
                if(isSalesTime(calendar)){
                    buyAtSalesTime(orderList);
                }
                else if(isWeekend(calendar)){
                    buYOnTheWeekend(orderList);
                }
                else {
                    buyNoSalesTime(orderList);
                }
            /* if(orderList.size() > 0 && orderList.size() < 3){
                if(isSalesTime(calendar)){
                    System.out.println(customer.getClass().getSimpleName() + customer.getId() + " купил 1 - 2 товара! Распродажа");
                }else{
                    buyNoSalesTime(orderList, calendar);
                    System.out.println(customer.getClass().getSimpleName() + customer.getId() + " купил 1 - 2 товара!");
                }
            }else if (orderList.size() >= 3){
                if(isSalesTime(calendar)){
                    System.out.println(customer.getClass().getSimpleName() + customer.getId() + " купил больше 2 напитков! Распродажа");
                }else {
                    System.out.println(customer.getClass().getSimpleName() + customer.getId() + " купил больше 2 напитков!");
                }*/

            }else{
                System.out.println(customer.getClass().getSimpleName() + customer.getId() + " некупил!");
            }

        }


    }



}
