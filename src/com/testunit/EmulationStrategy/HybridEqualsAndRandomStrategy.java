package com.testunit.EmulationStrategy;

import com.testunit.Customer.Customer;
import com.testunit.Helper.Helper;
import com.testunit.goods.BasicDrink;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HybridEqualsAndRandomStrategy extends BasicStrategy implements Strategy {

    private static final Logger logger = LogManager.getLogger(HybridEqualsAndRandomStrategy.class);

    @Override
    public void runStrategy(ArrayList<Customer> listCustomers, GregorianCalendar calendar, ArrayList<? extends BasicDrink> goods, ArrayList endedGoods) {
        //logger.debug("This is " + HybridEqualsAndRandomStrategy.class.getName());
        int secondsPerHour = 3600;
        int timeOrderCustomers = secondsPerHour / listCustomers.size();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");


        for(Customer customer : listCustomers){
            int randomTimeCustomers = Helper.random(timeOrderCustomers);
            int additionalTime = timeOrderCustomers - randomTimeCustomers;

            calendar.add(Calendar.SECOND, randomTimeCustomers);
            logger.debug(customer.getClass().getSimpleName() + customer.getId() + " зашел в магазин "
                    + sdf.format(calendar.getTime()));
            customer.fillOrderList(goods, endedGoods);
            ArrayList orderList = customer.getOrderList();
            if(orderList.size() > 0){
                logger.debug("Купил:");
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
                logger.debug("Ничего некупил!");
            }
            calendar.add(Calendar.SECOND, additionalTime);
        }
    }
}
