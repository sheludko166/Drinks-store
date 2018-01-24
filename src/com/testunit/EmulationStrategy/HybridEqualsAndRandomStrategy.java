package com.testunit.EmulationStrategy;

import com.testunit.Customer.Customer;
import com.testunit.Helper.Helper;
import com.testunit.goods.BasicDrink;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HybridEqualsAndRandomStrategy extends BasicStrategy implements Strategy {
    @Override
    public void runStrategy(ArrayList<Customer> listCustomers, GregorianCalendar calendar, ArrayList<? extends BasicDrink> goods, ArrayList endedGoods) {
        System.out.println("This is " + HybridEqualsAndRandomStrategy.class.getName());
        int secondsPerHour = 3600;
        int timeOrderCustomers = secondsPerHour / listCustomers.size();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");


        for(Customer customer : listCustomers){
            int randomTimeCustomers = Helper.random(timeOrderCustomers);
            int additionalTime = timeOrderCustomers - randomTimeCustomers;

            calendar.add(Calendar.SECOND, randomTimeCustomers);
            System.out.println(customer.getClass().getSimpleName() + customer.getId() + " зашел в магазин "
                    + sdf.format(calendar.getTime()));
            customer.fillOrderList(goods, endedGoods);
            ArrayList orderList = customer.getOrderList();
            if(orderList.size() > 0){
                System.out.println("Купил:");
                if(isSalesTime(calendar)){

                    buyAtSalesTime(orderList);
                }
                else if(isWeekend(calendar)){
                    buYOnTheWeekend(orderList);
                }
                else {
                    buyNoSalesTime(orderList);
                }

            }else{
                System.out.println("Ничего некупил!");
            }
            calendar.add(Calendar.SECOND, additionalTime);
        }


    }
}
