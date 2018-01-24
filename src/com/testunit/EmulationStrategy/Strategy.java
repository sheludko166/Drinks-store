package com.testunit.EmulationStrategy;

import com.testunit.Customer.Customer;
import com.testunit.goods.BasicDrink;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface Strategy {
    void runStrategy(ArrayList<Customer> listCustomers, GregorianCalendar calendar, ArrayList<? extends BasicDrink> goods);
}
