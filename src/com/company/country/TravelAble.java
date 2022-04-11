package com.company.country;
import com.company.Buildings.terminal;
import com.company.Person.person;
import com.company.Vehicle.vehicle;
import com.company.date;
import java.util.ArrayList;

public interface TravelAble
{
    void newTravel(terminal start, terminal end, vehicle v, ArrayList<person> passengers, person driver, date Date, int cost) ;
    void sortTravel(ArrayList<travel> travelList) ;
    int calculateCost (ArrayList<person> passengers, vehicle v, person driver) ;
    void travelArchive(String operation) ;
}
