package com.company.Buildings;
import com.company.Vehicle.*;
import com.company.Person.*;
import com.company.Person.person.job ;
import com.company.city;
import com.company.country.* ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.company.graphics.AirPortFolder.AirportInfoPanel;
import com.company.graphics.AirPortFolder.AirportPanel;

public class airPort extends terminal
{
    private boolean airportType;
    private int numberOfBand;
    private int createAirPort ;
    private int indexOfAirVehicle = 0 ;
    private transient AirportPanel airportPanel ;
    public static airPort currentAirport ;
    public transient AirportInfoPanel airportInfoPanel ;


    public airPort(String name,city City,Country country, String address, boolean airportType, int numberOfBand)
    {
        this.setTerminalName(name) ;
        super.setCity(City) ;
        super.setCountry(country);
        this.setAddress(address);
        this.setSpace(10000) ;
        this.airportType = airportType ;
        this.numberOfBand = numberOfBand;
        this.createAirPort = 500 ;
        this.getCity().addBuilding(this);
    }

    @Override
    public String getTerminalType() { return "Airport" ; }

    @Override
    public String getName() { return  "Airport " + this.getTerminalName() ; }

    @Override
    public void checkPersonJob() throws Exception
    {
        boolean isThere = false ;
        for (person p : getCity().getAllPeople())
            if (! p.getEmploymentStatus())
                if (p.getJob().equals(job.Pilot) || p.getJob().equals(job.AirportEmployee) )
                    isThere = true ;

        if (!isThere)
            throw new Exception("There is no person who can work at Airport") ;
    }

    @Override
    public void hireJob() throws Exception
    {
        if (getVehicleLeader().size() >= getVehicleList().size())
            throw new Exception("number of drivers is sufficient");

        else {
            ArrayList<person> tempPilot = new ArrayList<>() ;
            ArrayList<person> tempEmployee = new ArrayList<>() ;

            for (person p : getCity().getAllPeople())
                if (!p.getEmploymentStatus())
                {
                    if (p.getJob().equals(job.Pilot))
                        tempPilot.add(p) ;

                    if (p.getJob().equals(job.AirportEmployee))
                        tempEmployee.add(p) ;
                }

            int numberOfNewPilot = this.getVehicleList().size() ;
            int numberOfNewEmployee = 7 ;
            if (tempPilot.size() <= this.getVehicleList().size())
                numberOfNewPilot = tempPilot.size() ;
            if (tempEmployee.size() <= 7)
                numberOfNewEmployee = tempEmployee.size() ;

            for (int i = 0 ; i < numberOfNewPilot ; ++i)
                this.addPersonnel(tempPilot.get(i));

            for (int i = 0 ; i < numberOfNewEmployee ; ++i)
                this.addPersonnel(tempEmployee.get(i));
        }
    }


    public void addAirPlane(String name,int numberOfCrew,int volume)
    {
        String Name =  this.indexOfAirVehicle + name ;
        airliner Airliner = new airliner(Name, numberOfCrew, volume);
        Airliner.setVehicleTerminal(this);
        this.getVehicleList().add(Airliner) ;
        this.getCity().addVehicle(Airliner);
        this.setNumberOfVehicle(this.getVehicleList().size());
        //write part
        this.getCity().writeCity();
        ++indexOfAirVehicle ;
    }

    public void addCargoPlane(String name,int weight, int maxVolume) throws Exception
    {
        if(weight > maxVolume)
            throw new Exception("load weight is bigger than max weight") ;

        else
        {
            String Name = this.indexOfAirVehicle + name ;
            cargoPlane CargoPlane = new cargoPlane(Name,weight,maxVolume) ;
            CargoPlane.setVehicleTerminal(this);
            this.getVehicleList().add(CargoPlane) ;
            this.getCity().addVehicle(CargoPlane);
            this.setNumberOfVehicle(this.getVehicleList().size());
            //write part
            this.getCity().writeCity();
            ++indexOfAirVehicle ;
        }
    }

    @Override
    public void addVehicle(vehicle Vehicle) throws Exception
    {
        if (Vehicle instanceof airliner)
        {
            airliner a = (airliner) Vehicle ;
            this.addAirPlane(a.getName(),a.getCrew(), a.getVolume());
        }

        if (Vehicle instanceof cargoPlane)
        {
            cargoPlane c = (cargoPlane) Vehicle ;
            this.addCargoPlane(c.getName(), c.getLoadWeight(), c.getMaxVolume() );
        }
    }

    @Override
    public void removeVehicle(vehicle Vehicle)
    {
        this.getVehicleList().remove(Vehicle) ;
        this.getCity().getAllVehicle().remove(Vehicle) ;
        this.setNumberOfVehicle(this.getVehicleList().size());
        //write part
        this.getCity().writeCity();
    }


    @Override
    public void addPersonnel(person p) {
        new SwingWorker<>() {
            @Override
            public Object doInBackground() {
                if (p.getJob().equals(job.Pilot)) {
                    p.setSalary(35);
                    p.setEmploymentStatus(true);
                    p.setWorkHouse(getName());
                    getVehicleLeader().add(p);
                    setNumberOfPersonnel(getVehicleLeader().size() + getEmployee().size());
                    //write part
                    getCity().writeCity();
                }

                if (p.getJob().equals(job.AirportEmployee)) {
                    p.setSalary(3);
                    p.setEmploymentStatus(true);
                    p.setWorkHouse(getName());
                    getEmployee().add(p);
                    setNumberOfPersonnel(getVehicleLeader().size() + getEmployee().size());
                    //write part
                    getCity().writeCity();
                }
                return null;
            }
        }.execute();
    }


    @Override
    public void removePersonnel(person p)
    {
        if (p.getJob().equals(job.Pilot))
        {
            int indexOfPerson = this.getVehicleLeader().indexOf(p) ;
            this.getVehicleLeader().get(indexOfPerson).setSalary(0) ;
            this.getVehicleLeader().get(indexOfPerson).setEmploymentStatus(false);
            this.getVehicleLeader().get(indexOfPerson).setWorkHouse("");
            this.getVehicleLeader().remove(p) ;
            this.setNumberOfPersonnel(this.getVehicleLeader().size() + this.getEmployee().size());
            //write part
            this.getCity().writeCity();
        }

        if (p.getJob().equals(job.AirportEmployee))
        {
            int indexOfPerson = this.getEmployee().indexOf(p) ;
            this.getEmployee().get(indexOfPerson).setSalary(0) ;
            this.getEmployee().get(indexOfPerson).setEmploymentStatus(false);
            this.getEmployee().get(indexOfPerson).setWorkHouse("");
            this.getEmployee().remove(p) ;
            this.setNumberOfPersonnel(this.getVehicleLeader().size() + this.getEmployee().size());
            //write part
            this.getCity().writeCity();
        }
    }

    @Override
    public int getCost()
    {
        int sum;

        int type = 0 ;
        if(this.airportType)
            type = 100;
        if(! this.airportType)
            type = 50;

        int costOfAirVehicle = 0;
        for (vehicle v : getVehicleList())
            costOfAirVehicle = costOfAirVehicle + v.getCost() ;


        int salaryOfPilot = 0 ;
        for (person p : getVehicleLeader())
            salaryOfPilot = salaryOfPilot + p.getSalary() ;

        int salaryOfEmployees = 0;
        for (person p : getEmployee())
            salaryOfEmployees = salaryOfEmployees + p.getSalary() ;

        int createAirport = this.createAirPort ;

        sum =  costOfAirVehicle + salaryOfPilot + salaryOfEmployees + createAirport + type;
        this.setCost(sum);
        return sum;
    }


    //Graphical method
    public void createAirportPanel()
    {
        airportPanel = new AirportPanel() ;
        airportPanel.setVisible(true);
    }

    public void updateAirportPanel()
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                airportPanel.nameLBL.setText(getTerminalName());
                airportPanel.addressLBL.setText(getAddress());
                airportPanel.spaceLBL.setText(String.valueOf(getSpace()));
                airportPanel.vehicleLBL.setText(String.valueOf(getNumberOfVehicle()));
                airportPanel.bandsLBL.setText(String.valueOf(numberOfBand));
                airportPanel.personnelsLBL.setText(String.valueOf(getNumberOfPersonnel()));
                airportPanel.costsLBL.setText(getCost() + "$");
                return null ;
            }
        }.execute();
    }

    @Override
    public void createTerminalPanel()
    {
        currentAirport = this ;
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                createAirportPanel();
                updateAirportPanel();
                return null ;
            }
        }.execute();
    }


    @Override
    public void getTerminalPanel() {

        airportInfoPanel = new AirportInfoPanel() ;
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {

                airportInfoPanel.nameLBL.setText(getTerminalName());
                airportInfoPanel.addressLBL.setText(getAddress());
                airportInfoPanel.spaceLBL.setText(String.valueOf(getSpace()));
                airportInfoPanel.vehicleLBL.setText(String.valueOf(getNumberOfVehicle()));
                airportInfoPanel.bandsLBL.setText(String.valueOf(numberOfBand));
                airportInfoPanel.personnelsLBL.setText(String.valueOf(getNumberOfPersonnel()));
                airportInfoPanel.costsLBL.setText(getCost() + " $");
                airportInfoPanel.setVisible(true);
                return null ;
            }
        }.execute();
    }
}