package com.testunit.EmulationStrategy;

import com.testunit.Customer.Customer;

import java.util.ArrayList;

public interface Strategy {
    void runStrategy(ArrayList<Customer> listCustomers);
}
