package com.testunit.statistics;


import com.testunit.goods.BasicDrink;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Statistic {

    private static final Logger logger = LogManager.getLogger(Statistic.class);

    private static double profit;
    private static double spentMoneyForPurchase;

    public static void addSpentMoney(double spentMoney){
        spentMoneyForPurchase += spentMoney;
    }

    public static void addProfit(double profit1) {
        profit += profit1;
    }

    public void printStatistics(ArrayList<? extends BasicDrink> goods){
        logger.debug("Запись статистики в файл");
        for(int i = 0; i < goods.size(); i++){
            logger.info(String.format("%s %s %s продано %d шт., закуплено %d шт.",goods.get(i).getClassification(),
                    goods.get(i).getName(), goods.get(i).getVolume(), goods.get(i).getSaleCount(),
                    goods.get(i).getAdditionalGoods()));
        }
        logger.info(String.format("Прибыль магазина от продаж, составила %.2f грн.", profit));
        logger.info(String.format("Затраты на дозакупку товара, составили %.2f грн.", spentMoneyForPurchase));
    }
}
