package com.company.Buildings;
import com.company.Person.person;
import com.company.city ;
import com.company.Vehicle.* ;
import com.company.country.* ;
import com.company.date ;
import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public abstract class terminal implements TravelAble, Serializable
{
    private String terminalName;
    private int cost;
    private city City ;
    private Country country ;
    private String address;
    private int space;
    private int numberOfVehicle;
    private int numberOfPersonnel ;
    private ArrayList<person> employee = new ArrayList<>() ;
    private ArrayList<person> VehicleLeader = new ArrayList<>() ;
    private ArrayList<vehicle> vehicleList = new ArrayList<>() ;
    private ArrayList<travel> InputTravelList = new ArrayList<>() ;
    private ArrayList<travel> outputTravelList = new ArrayList<>() ;
    //fields for travel
    public static terminal currentTerminal ;
    public static terminal originTerminal ;
    public static terminal destinationTerminal ;


    public void setTerminalName(String terminalName) { this.terminalName = terminalName; }
    public String getTerminalName() { return terminalName; }

    public void setCost(int cost) { this.cost = cost; }

    public void setAddress(String address) { this.address = address; }
    public String getAddress() { return address; }

    public void setSpace(int space) { this.space = space; }
    public int getSpace() { return space; }

    public void setNumberOfVehicle(int numberOfVehicle) { this.numberOfVehicle = numberOfVehicle; }
    public int getNumberOfVehicle() { return numberOfVehicle; }

    public abstract void createTerminalPanel() ;
    public abstract void getTerminalPanel() ;

    public ArrayList<person> getEmployee() { return employee; }
    public ArrayList<person> getVehicleLeader() { return VehicleLeader; }
    public ArrayList<vehicle> getVehicleList(){ return vehicleList ; }
    public ArrayList<travel> getInputTravelList() { return InputTravelList; }
    public ArrayList<travel> getOutputTravelList() { return outputTravelList; }

    public abstract String getName() ;
    public abstract String getTerminalType() ;
    public abstract int getCost() ;

    public void setCity(city city) { City = city; }
    public city getCity() { return City ; }

    public void setCountry(Country country) { this.country = country; }
    public Country getCountry() { return country; }

    public void setNumberOfPersonnel(int numberOfPersonnel) { this.numberOfPersonnel = numberOfPersonnel; }
    public int getNumberOfPersonnel() { return numberOfPersonnel ; }

    public abstract void addPersonnel(person p) throws Exception;
    public abstract void removePersonnel(person p) ;
    public abstract void addVehicle(vehicle Vehicle) throws Exception;
    public abstract void removeVehicle(vehicle Vehicle) ;

    public abstract void checkPersonJob() throws Exception ;
    public abstract void hireJob() throws Exception;



    @Override
    public String toString(){return getTerminalName() ; }


    public vehicle getVehicle(int i)
    {
        return getVehicleList().get(i) ;
    }


    @Override
    public void newTravel(terminal start, terminal destination, vehicle v, ArrayList<person> passengers,person driver, date Date, int cost)
    {
        try {
            travel t = new travel(start, destination, v, passengers, driver, Date, cost ) ;

            start.getOutputTravelList().add(t);
            destination.getInputTravelList().add(t) ;

            start.removeVehicle(v) ;
            start.getCity().removeVehicle(v);
            destination.addVehicle (v) ;


            start.removePersonnel(driver);
            destination.addPersonnel(driver);
            start.getCity().removePeople(driver);
            destination.getCity().addPeople(driver);


            for (person p : passengers)
            {
                start.getCity().removePeople(p);

                destination.getCity().addPeople(p);
            }

            start.getCity().addBudget( this.calculateCost(passengers, v, driver) ) ;
            destination.getCity().withdrawBudget(this.calculateCost(passengers, v, driver));

            start.getCity().writeCity();
            destination.getCity().writeCity();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void sortTravel(ArrayList<travel> travelList)
    {
        Collections.sort(travelList);
    }

    @Override
    public int calculateCost(ArrayList<person> passengers, vehicle v, person driver)
    {
        return v.getCost() + driver.getSalary() + (passengers.size() * v.getCost()) / 10 ;
    }

    @Override
    public void travelArchive(String travelType)
    {
        if (travelType.equals("input"))
            for (int i = 0 ; i < this.getInputTravelList().size() ; ++i)
                this.getInputTravelList().get(i).travelInfo() ;

        if (travelType.equals("output"))
            for (int i = 0 ; i < this.getOutputTravelList().size() ; ++i)
                this.getOutputTravelList().get(i).travelInfo() ;
    }
}