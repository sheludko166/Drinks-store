import com.testunit.Customer.Customer;
import com.testunit.EmulationStrategy.EqualTimeStrategy;
import com.testunit.EmulationStrategy.HybridEqualsAndRandomStrategy;
import com.testunit.EmulationStrategy.RandomTimeStrategy;
import com.testunit.EmulationStrategy.Strategy;
import com.testunit.Helper.Helper;
import com.testunit.db.DataHelper;


import java.util.*;

public class ShopOperations {
    private static ShopOperations shopOperations;
    private ArrayList goods = new ArrayList();
    private Calendar calendar;
    private Strategy strategy;

    private int workingDay = 1;
    private int workingPeriod = 30;
    private int openingTime = 8;
    private int closingTime = 21;



    public static void main(String[] args) throws InterruptedException {
        shopOperations = new ShopOperations();
        shopOperations.goods = DataHelper.getGoodsFromCSVFile();
        shopOperations.calendar = setBeginDate();

        while (!shopOperations.emulationFinished()) {
            System.out.println("========================= DAY" + shopOperations.workingDay + " ================================");
            shopOperations.run();
        }

        //shopOperations.run();
        //shopOperations.run();


        //DataHelper.updateDataBase(shopOperations.goods);




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
        for(int i =0; i <24; i++){
            if(chekcWorkingTime(calendar.get(Calendar.HOUR_OF_DAY))){
                switch (Helper.random(2)){
                    case 0: strategy = new EqualTimeStrategy();
                        strategy.runStrategy(getCustomersList(), (GregorianCalendar) calendar.clone(), goods);
                        break;

                    case 1: strategy = new HybridEqualsAndRandomStrategy();
                        strategy.runStrategy(getCustomersList(), (GregorianCalendar) calendar.clone(), goods);
                        break;

                    case 2: strategy = new RandomTimeStrategy();
                        strategy.runStrategy(getCustomersList(), (GregorianCalendar) calendar.clone(), goods);
                        break;

                }
            }
            addOneHour();
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
        return new GregorianCalendar(2018,2,1,0,0);
    }
}














