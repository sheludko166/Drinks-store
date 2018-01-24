package com.testunit.EmulationStrategy;

import com.testunit.Customer.Customer;
import com.testunit.Helper.Helper;
import com.testunit.goods.BasicDrink;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HybridEqualsAndRandomStrategy implements Strategy {
    @Override
    public void runStrategy(ArrayList<Customer> listCustomers, GregorianCalendar calendar, ArrayList<? extends BasicDrink> goods) {
        System.out.println("This is " + HybridEqualsAndRandomStrategy.class.getName());
        int secondsPerHour = 3600;
        int timeOrderCustomers = secondsPerHour / listCustomers.size();

        for(Customer customer : listCustomers){
            int randomTimeCustomers = Helper.random(timeOrderCustomers);
            int additionalTime = timeOrderCustomers - randomTimeCustomers;

            calendar.add(Calendar.SECOND, randomTimeCustomers);
            System.out.println(customer.getClass().getSimpleName() + customer.getId() + " зашел в магазин " + calendar.getTime());
            customer.fillOrderList(goods);
            ArrayList list = customer.getOrderList();
            if(list.size() > 0 && list.size() < 3){
                System.out.println(customer.getClass().getSimpleName() + customer.getId() + " купил больше 2 напитков!");
            }else if (list.size() >= 3){
                System.out.println(customer.getClass().getSimpleName() + customer.getId() + " купил 1 - 2 товара!");
            }else{
                System.out.println(customer.getClass().getSimpleName() + customer.getId() + " некупил");
            }
            calendar.add(Calendar.SECOND, additionalTime);
        }


    }
}
