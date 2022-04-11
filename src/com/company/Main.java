package com.company;
import com.company.country.* ;
import com.company.graphics.StartMenu;
import javax.swing.*;
import java.util.*;
import java.io.* ;
public class Main {

    public static void main(String[] args)
    {
        Country country = new Country("IRAN", 1000) ;
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                StartMenu sm = new StartMenu() ;
                sm.setVisible(true);
                return null ;
            }
        }.execute();
    }

    public static void readFile(Country country)
    {
        File f = new File("country");
        File[] cities = f.listFiles() ;

        for (File City : Objects.requireNonNull(cities))
        {
            try {
                FileInputStream fis = new FileInputStream(City) ;
                ObjectInputStream ois = new ObjectInputStream(fis) ;
                city c = (city) ois.readObject() ;
                c.setFinallyBudget();
                country.addCity(c);
                ois.close();
                fis.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}