package com.testunit.statistics;


public class Statistic {
    private static double profit;

    public double getProfit() {
        return profit;
    }

    public static void addProfit(double profit1) {
        profit += profit1;
    }


}
