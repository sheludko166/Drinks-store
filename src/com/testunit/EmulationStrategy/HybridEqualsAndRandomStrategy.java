package com.testunit.EmulationStrategy;

import com.testunit.Customer.Customer;
import com.testunit.Helper.Helper;
import com.testunit.goods.BasicDrink;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HybridEqualsAndRandomStrategy extends BasicStrategy implements Strategy {
    @Override
    public void runStrategy(ArrayList<Customer> listCustomers, GregorianCalendar calendar, ArrayList<? extends BasicDrink> goods, ArrayList endedGoods) {
        System.out.println("This is " + HybridEqualsAndRandomStrategy.class.getName());
        int secondsPerHour = 3600;
        int timeOrderCustomers = secondsPerHour / listCustomers.size();

        for(Customer customer : listCustomers){
            int randomTimeCustomers = Helper.random(timeOrderCustomers);
            int additionalTime = timeOrderCustomers - randomTimeCustomers;

            calendar.add(Calendar.SECOND, randomTimeCustomers);
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
            /*if(list.size() > 0 && list.size() < 3){
                if(isSalesTime(calendar)){
                    System.out.println(customer.getClass().getSimpleName() + customer.getId() + " купил 1 - 2 товара! Распродажа");
                }else{
                    System.out.println(customer.getClass().getSimpleName() + customer.getId() + " купил 1 - 2 товара!");
                }
            }else if (list.size() >= 3){
                if(isSalesTime(calendar)){
                    System.out.println(customer.getClass().getSimpleName() + customer.getId() + " купил больше 2 напитков! Распродажа");
                }else {
                    System.out.println(customer.getClass().getSimpleName() + customer.getId() + " купил больше 2 напитков!");
                }*/

            }else{
                System.out.println(customer.getClass().getSimpleName() + customer.getId() + " некупил!");
            }
            calendar.add(Calendar.SECOND, additionalTime);
        }


    }
}
