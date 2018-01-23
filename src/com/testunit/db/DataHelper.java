package com.testunit.db;

import com.opencsv.CSVReader;
import com.testunit.goods.BasicDrink;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    public List<? extends BasicDrink> getGoodsFromCSVFile(){
        ArrayList<? extends BasicDrink> list = new ArrayList<>();
        try ( CSVReader reader = new CSVReader(new FileReader("data.csv"))){

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
