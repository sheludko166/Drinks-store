package com.testunit.EmulationStrategy;

import com.testunit.Customer.Customer;
import com.testunit.goods.BasicDrink;

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
        System.out.println("buy No Sales Time");
    }

    protected void buyAtSalesTime(ArrayList<? extends BasicDrink> orderList) {
        System.out.println("buy At Sales Time");
    }

    protected void buYOnTheWeekend(ArrayList<? extends BasicDrink> orderList){
        System.out.println("buY On The Weekend");
    }
}
