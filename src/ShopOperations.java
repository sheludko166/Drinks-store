import com.testunit.Helper.Helper;
import com.testunit.db.DataHelper;


import java.util.*;

public class ShopOperations {
    private static ShopOperations shopOperations;
    private ArrayList goods = new ArrayList();
    private Calendar calendar;



    public static void main(String[] args) throws InterruptedException {
        /*shopOperations = new ShopOperations();
        shopOperations.goods = DataHelper.getGoodsFromCSVFile();
        shopOperations.calendar = new GregorianCalendar();

        shopOperations.firstRun();
        shopOperations.run();

        DataHelper.updateDataBase(shopOperations.goods);*/
        shopOperations = new ShopOperations();
        shopOperations.calendar = new GregorianCalendar();
       shopOperations.firstRun();



    }


    private boolean chekcWorkingTime(int i) {
        if(i >= 8 && i<21){
            return true;
        }
        return false;
    }


    private void run(){
        if(chekcWorkingTime(calendar.get(Calendar.HOUR_OF_DAY))){

        }
    }

    private void firstRun(){
        int numbersCustomersPerHours = Helper.random(9) + 1;

    }
}














