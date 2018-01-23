package com.testunit.db;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.testunit.goods.AlcoholDrink;
import com.testunit.goods.BasicDrink;
import com.testunit.goods.NonAlcoholDrink;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    public static ArrayList getGoodsFromCSVFile(){
        ArrayList list = new ArrayList();
        try ( CSVReader reader = new CSVReader(new FileReader("data.csv"),';')){

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String s = nextLine[nextLine.length - 2];
                if (s.endsWith("%")) {
                    AlcoholDrink ad = new AlcoholDrink(s);
                    ad.setName(nextLine[0]);
                    ad.setPurchasePrice(Float.parseFloat(nextLine[1]));
                    ad.setClassification(nextLine[2]);
                    ad.setVolume(nextLine[3]);
                    ad.setExistenceOfPiece(Integer.parseInt(nextLine[5]));
                    list.add(ad);
                }else {
                    NonAlcoholDrink nad = new NonAlcoholDrink(s);
                    nad.setName(nextLine[0]);
                    nad.setPurchasePrice(Float.parseFloat(nextLine[1]));
                    nad.setClassification(nextLine[2]);
                    nad.setVolume(nextLine[3]);
                    nad.setExistenceOfPiece(Integer.parseInt(nextLine[5]));
                    list.add(nad);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void updateDataBase(ArrayList<? extends BasicDrink> goods){
        try (CSVWriter writer = new CSVWriter(new FileWriter("data.csv"),';')) {

            for(int i = 0; i < goods.size(); i++ ){
                String[] line = new String[6];
                line[0] = goods.get(i).getName();
                line[1] = String.valueOf(goods.get(i).getPurchasePrice());
                line[2] = goods.get(i).getClassification();
                line[3] = goods.get(i).getVolume();
                if(goods.get(i) instanceof AlcoholDrink){
                    line[4] = ((AlcoholDrink) goods.get(i)).getAlcohol();
                }else if(goods.get(i) instanceof NonAlcoholDrink){
                    line[4] = ((NonAlcoholDrink) goods.get(i)).getComposition();
                }
                line[5] = String.valueOf(goods.get(i).getExistenceOfPiece());

                writer.writeNext(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
