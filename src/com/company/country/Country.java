package com.company.country;
import com.company.city ;
import java.io.*;
import java.util.ArrayList;


import com.company.graphics.CountryFolder.CountryMenu;

public class Country implements Serializable
{
    private static ArrayList<Country> countries = new ArrayList<>() ;
    private ArrayList<city> cities = new ArrayList<>();
    private String name;
    private int maxPopulation ;
    private int budget ;
    private int numberOfCities ;
    private transient CountryMenu countryMenu ;

    public Country(String name, int volume)
    {
        this.name = name;
        this.maxPopulation = volume ;
        countryMenu = new CountryMenu() ;
        countries.add(this) ;
    }

    public void addCity(city newCity)
    {
        this.cities.add(newCity);
        this.setNumberOfCities(this.getCities().size());
    }

    public void removeCity(city deletedCity)
    {
        this.cities.remove(deletedCity) ;
        this.setNumberOfCities(this.getCities().size());
        File city = new File(deletedCity.getPathCityFolder()) ;
        city.delete();
    }


    public int getPopulation()
    {
        int numberOfPeople = 0 ;
        for (int i = 0 ; i < this.getCities().size() ; ++i)
        {
            numberOfPeople = numberOfPeople + this.getCities().get(i).getAllPeople().size();
        }
        return numberOfPeople ;
    }

    public int getBudget()
    {
        int sum = 0 ;
        for (city c : getCities())
            sum = sum + c.getBudgetOfCity() ;
        return sum ;
    }

    public static Country getCountry(){return Country.getCountries().get(0);}

    public String getName() { return name; }
    public city getCity(int code) { return this.cities.get(code) ; }
    public static ArrayList<Country> getCountries() { return countries; }
    public ArrayList<city> getCities() { return cities ; }

    public void setNumberOfCities(int numberOfCities) { this.numberOfCities = numberOfCities; }

    //graphical methods

    public void showCountryMenu()
    {
        countryMenu.setVisible(true);
        updateCountryInfo();
    }

    public void updateCountryInfo()
    {
        countryMenu.populationLBL.setText(String.valueOf(this.getPopulation()));
        countryMenu.cityLBL.setText(String.valueOf(this.numberOfCities));
        countryMenu.budgetLBL.setText(String.valueOf(this.getBudget()));
    }

    public void addCityGraphically(String name, String volume)
    {
        int Volume = Integer.parseInt(volume) ;
        city newCity = new city(name,Country.getCountry(),Volume,true) ;
        Country.getCountry().addCity(newCity);
    }

    public CountryMenu getCountryMenu() { return countryMenu; }
}
