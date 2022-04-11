package com.company.country;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import com.company.Buildings.* ;
import com.company.Vehicle.* ;
import com.company.Person.* ;
import com.company.date ;

public class travel implements Comparable, Serializable
{
    private String travelName ;
    private terminal startTravel ;
    private terminal endTravel ;
    private vehicle travelVehicle ;
    private ArrayList<person> passengersList = new ArrayList<>() ;
    private person driver ;
    private date travelDate ;
    private int costOfTravel ;
    private static int setTravelNumber ;
    public static HashSet<person> carryPassengers = new HashSet<>() ;
    public static travel currentTravel ;

    public travel(terminal start, terminal end, vehicle v, ArrayList<person> passengers, person driver, date Date, int cost)
    {
        this.travelName = "Travel " + setTravelNumber ;
        this.startTravel = start ;
        this.endTravel = end ;
        this.travelVehicle = v ;
        this.passengersList.addAll(passengers) ;
        this.driver = driver ;
        this.travelDate = Date ;
        this.costOfTravel = cost ;
        ++setTravelNumber ;
    }

    public void travelInfo()
    {
        String information = "|" ;
        information = information + "ORIGIN TERMINAL:" + this.startTravel.getCity().getCityName() + " " + this.startTravel.getName()+ " , " ;
        information = information + "DESTINATION:" + this.endTravel.getCity().getCityName() + " " + this.endTravel.getName() + " , " ;
        information = information + "VEHICLE NAME:" + this.travelVehicle.getName() + " , "  ;
        information = information + "NUMBER OF PASSENGERS:" + this.passengersList.size() + " , " ;
        information = information + "DRIVER OF VEHICLE:" + this.driver.getName() + " , " ;
        information = information + "TRAVEL DATE:" + this.travelDate.toString() + " , " ;
        information = information + "COST OF TRAVEL:" +   this.costOfTravel + "|" ;
        System.out.println(information);
    }

    public ArrayList<person> getPassengersList() { return passengersList; }

    public person getDriver() { return driver; }

    public terminal getStartTravel() { return startTravel; }
    public terminal getEndTravel() {return endTravel ;}

    public int getCostOfTravel() { return costOfTravel; }

    public date getTravelDate() { return travelDate; }

    public vehicle getTravelVehicle() { return travelVehicle; }

    @Override
    public String toString(){
        return travelName ;
    }

    @Override
    public int compareTo(Object o)
    {
        travel t = (travel) o ;
        if (t.costOfTravel > this.costOfTravel)
            return 1 ;
        if (t.costOfTravel < this.costOfTravel)
            return -1 ;
        if (t.travelDate.compareTo(this.travelDate) > 0)
            return 1 ;
        if (t.travelDate.compareTo(this.travelDate) < 0)
            return -1 ;
        else
            return 0 ;
    }
}