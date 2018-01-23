import com.testunit.db.DataHelper;
import com.testunit.goods.AlcoholDrink;

import java.util.ArrayList;

public class ShopOperations {
    private static ShopOperations shopOperations;
    private ArrayList goods = new ArrayList();


    public static void main(String[] args) {
        shopOperations = new ShopOperations();
        shopOperations.goods = DataHelper.getGoodsFromCSVFile();

        AlcoholDrink ad = new AlcoholDrink("40%");
        ad.setName("Водка");
        ad.setPurchasePrice(Float.parseFloat("86.50"));
        ad.setClassification("Mendeleev Drink");
        ad.setVolume("0.5");
        ad.setExistenceOfPiece(Integer.parseInt("186"));

        shopOperations.goods.add(ad);

        DataHelper.updateDataBase(shopOperations.goods);
    }
}
