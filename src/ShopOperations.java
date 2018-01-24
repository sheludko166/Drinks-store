import com.testunit.Customer.Customer;
import com.testunit.EmulationStrategy.*;
import com.testunit.Helper.Helper;
import com.testunit.db.DataHelper;
import com.testunit.goods.BasicDrink;
import com.testunit.statistics.Statistic;


import java.util.*;

public class ShopOperations {
    private static ShopOperations shopOperations;
    private ArrayList goods = new ArrayList();
    private ArrayList endedGoods = new ArrayList();
    private Calendar calendar;
    private Strategy strategy;
    private static Statistic statistic;

    private int workingDay = 1;
    private int workingPeriod = 30;
    private int openingTime = 8;
    private int closingTime = 21;

    public ShopOperations(Statistic statistic) {
        this.statistic = statistic;
    }

    public static void main(String[] args) throws InterruptedException {
        statistic = new Statistic();
        shopOperations = new ShopOperations(statistic);
        shopOperations.goods = DataHelper.getGoodsFromCSVFile();
        shopOperations.calendar = setBeginDate();


        while (!shopOperations.emulationFinished()) {
            System.out.println("========================= DAY " + shopOperations.workingDay + " ================================");
            shopOperations.run();
        }


        System.out.println(String.format("%.2f", statistic.getProfit()));




        DataHelper.updateDataBase(shopOperations.goods);




    }


    private boolean chekcWorkingTime(int i) {
        if(i >= openingTime & i < closingTime){
            return true;
        }
        return false;
    }


    private void run(){
        if(emulationFinished()){
            return;
        }

        for(int i = calendar.get(Calendar.HOUR_OF_DAY); i <24; i++){
            if(chekcWorkingTime(calendar.get(Calendar.HOUR_OF_DAY))){
                switch (Helper.random(2)){
                    case 0: strategy = new EqualTimeStrategy();
                        strategy.runStrategy(getCustomersList(), (GregorianCalendar) calendar.clone(), goods, endedGoods);
                        break;

                    case 1: strategy = new HybridEqualsAndRandomStrategy();
                        strategy.runStrategy(getCustomersList(), (GregorianCalendar) calendar.clone(), goods, endedGoods);
                        break;

                    case 2: strategy = new RandomTimeStrategy();
                        strategy.runStrategy(getCustomersList(), (GregorianCalendar) calendar.clone(), goods, endedGoods);
                        break;

                }
            }
            addOneHour();
            if(calendar.get(Calendar.HOUR_OF_DAY ) == 21){
                purchaseGoods(goods, endedGoods);
            }
        }

    }

    private void purchaseGoods(ArrayList<? extends BasicDrink> goods, ArrayList<? extends BasicDrink> endedGoods) {
        for(int i = 0; i < goods.size(); i++){
            if (goods.get(i).getExistenceOfPiece() < 10) {
                goods.get(i).AddAdditionalGoods();
            }
        }
        while (endedGoods.size() > 0){
            endedGoods.get(endedGoods.size() - 1).AddAdditionalGoods();
            this.goods.add(endedGoods.get(endedGoods.size() - 1));
            this.endedGoods.remove(endedGoods.size() - 1);
        }
    }

    private boolean emulationFinished() {
        return workingDay > workingPeriod ? true : false;
    }

    private void addOneHour() {
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        if(calendar.get(Calendar.HOUR_OF_DAY) == openingTime){
            workingDay++;
        }
    }

    private ArrayList<Customer> getCustomersList() {
        ArrayList<Customer> list = new ArrayList<>();
        int i = Helper.random(9) + 1;
        for(; i > 0; i-- ){
            list.add(new Customer());
        }
        return list;
    }

    private static GregorianCalendar setBeginDate(){
        return new GregorianCalendar(2018,2,3,0,0);
    }
}














