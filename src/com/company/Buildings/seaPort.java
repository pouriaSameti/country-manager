package com.company.Buildings;
import com.company.Person.person;
import com.company.Person.person.job ;
import com.company.Vehicle.*;
import com.company.Vehicle.marineVehicle.fuelType ;
import com.company.city;
import com.company.country.* ;
import com.company.graphics.SeaportFolder.SeaportInfoPanel;
import com.company.graphics.SeaportFolder.SeaportPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class seaPort extends terminal {

    private int wharf;
    private int createSeaPort ;
    private int indexOfMArinVehicle = 0 ;
    private transient SeaportPanel seaportPanel ;
    public static seaPort currentSeaport ;
    private transient SeaportInfoPanel seaportInfoPanel ;

    public seaPort(String name,city City,Country country, String address, int wharf)
    {
        this.setTerminalName(name);
        super.setCity(City) ;
        super.setCountry(country);
        this.setAddress(address);
        this.wharf = wharf;
        this.setSpace(4000);
        this.createSeaPort = 600 ;
        this.getCity().addBuilding(this);
    }

    @Override
    public String getTerminalType() { return "Seaport" ; }

    @Override
    public String getName()
    {
        return "Seaport " + this.getTerminalName() ;
    }

    @Override
    public void checkPersonJob() throws Exception
    {
        boolean isThere = false ;
        for (person p : getCity().getAllPeople())
            if (! p.getEmploymentStatus())
                if (p.getJob().equals(job.Sailor) || p.getJob().equals(job.SeaportEmployee) )
                    isThere = true ;

        if (!isThere)
            throw new Exception("There is no person who can work at Seaport") ;
    }

    @Override
    public void hireJob() throws Exception
    {
        if (getVehicleLeader().size() >= getVehicleList().size())
            throw new Exception("number of drivers is sufficient");
        else
        {
            ArrayList<person> tempSailor = new ArrayList<>() ;
            ArrayList<person> tempEmployee = new ArrayList<>() ;
            for (person p : getCity().getAllPeople())
                if (!p.getEmploymentStatus())
                {
                    if (p.getJob().equals(job.Sailor))
                        tempSailor.add(p) ;
                    if (p.getJob().equals(job.SeaportEmployee))
                        tempEmployee.add(p) ;
                }

            int numberOfNewSailor = this.getVehicleList().size() ;
            int numberOFNewEmployee = 8 ;

            if (tempSailor.size() <= this.getVehicleList().size())
                numberOfNewSailor = tempSailor.size() ;

            if (tempEmployee.size() <= 8)
                numberOFNewEmployee = tempEmployee.size() ;

            for (int i = 0 ; i < numberOfNewSailor ; ++i)
                this.addPersonnel(tempSailor.get(i));
            for (int i = 0 ; i < numberOFNewEmployee ; ++i)
                this.addPersonnel(tempEmployee.get(i));
        }
    }

    @Override
    public void addPersonnel(person p)
    {
        if (p.getJob().equals(job.Sailor))
        {
            p.setSalary(40) ;
            p.setEmploymentStatus(true);
            p.setWorkHouse(this.getName());
            this.getVehicleLeader().add(p) ;
            this.setNumberOfPersonnel(this.getVehicleLeader().size() + this.getEmployee().size());
            //write part
            this.getCity().writeCity();
        }

        if (p.getJob().equals(job.SeaportEmployee))
        {
            p.setSalary(4) ;
            p.setEmploymentStatus(true);
            p.setWorkHouse(this.getName());
            this.getEmployee().add(p) ;
            this.setNumberOfPersonnel(this.getVehicleLeader().size() + this.getEmployee().size());
            //write part
            this.getCity().writeCity();
        }
    }

    @Override
    public void removePersonnel(person p)
    {
        if (p.getJob().equals(job.Sailor))
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

        if (p.getJob().equals(job.SeaportEmployee))
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


    public void addShip(String name,fuelType fuel,int volume)
    {
        String Name = this.indexOfMArinVehicle + " " + name ;
        ship Ship = new ship(Name,fuel,volume) ;
        Ship.setVehicleTerminal(this);
        this.getVehicleList().add(Ship) ;
        this.getCity().addVehicle(Ship);
        this.setNumberOfVehicle(getVehicleList().size());
        //write part
        this.getCity().writeCity();
        ++indexOfMArinVehicle ;
    }

    public void addBoat(String name, int volume)
    {
        String Name = indexOfMArinVehicle + " " + name ;
        boat Boat = new boat(Name,volume) ;
        Boat.setVehicleTerminal(this);
        this.getVehicleList().add(Boat) ;
        this.getCity().addVehicle(Boat);
        this.setNumberOfVehicle(getVehicleList().size());
        //write part
        this.getCity().writeCity();
        ++indexOfMArinVehicle ;
    }

    @Override
    public void addVehicle(vehicle Vehicle)
    {
        if (Vehicle instanceof ship)
        {
            ship s = (ship) Vehicle ;
            this.addShip(s.getName(),s.getFuelType(),s.getVolume());
        }

        if (Vehicle instanceof boat)
        {
            this.addBoat(Vehicle.getName(),Vehicle.getVolume());
        }
    }

    @Override
    public void removeVehicle(vehicle Vehicle)
    {
        this.getVehicleList().remove(Vehicle) ;
        this.getCity().getAllVehicle().remove(Vehicle) ;
        this.setNumberOfVehicle(getVehicleList().size());
        //write part
        this.getCity().writeCity();
    }

    @Override
    public int getCost()
    {
        int createSeaPort = this.createSeaPort ;
        int costOfCreateWharf = this.wharf * 100 ;

        int marianVehicleCost = 0;
        for (vehicle v : getVehicleList())
            marianVehicleCost = marianVehicleCost + v.getCost() ;

        int salaryOfSailors = 0;
        for (person p : getVehicleLeader())
            salaryOfSailors = salaryOfSailors + p.getSalary() ;

        int salaryOfEmployee = 0;
        for (person p : getEmployee())
            salaryOfEmployee = salaryOfEmployee + p.getSalary() ;

        int sum = salaryOfSailors + salaryOfEmployee + marianVehicleCost + createSeaPort + costOfCreateWharf;
        this.setCost(sum);
        return sum;
    }

    //graphical method
    public void createSeaportPanel()
    {
        seaportPanel = new SeaportPanel() ;
        seaportPanel.setVisible(true);
    }

    public void updateSeaportPanel()
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                seaportPanel.nameLBL.setText(getTerminalName());
                seaportPanel.addressLBL.setText(getAddress());
                seaportPanel.spaceLBL.setText(String.valueOf(getSpace()));
                seaportPanel.vehicleLBL.setText(String.valueOf(getNumberOfVehicle()));
                seaportPanel.wharfLBL.setText(String.valueOf(wharf));
                seaportPanel.personnelsLBL.setText(String.valueOf(getNumberOfPersonnel()));
                seaportPanel.costsLBL.setText(getCost() + " $");
                return null ;
            }
        }.execute();
    }

    @Override
    public void createTerminalPanel()
    {
        currentSeaport = this ;
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                createSeaportPanel();
                updateSeaportPanel();
                return null ;
            }
        }.execute();
    }

    @Override
    public void getTerminalPanel() {

        seaportInfoPanel = new SeaportInfoPanel() ;
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                seaportInfoPanel.nameLBL.setText(getTerminalName());
                seaportInfoPanel.addressLBL.setText(getAddress());
                seaportInfoPanel.spaceLBL.setText(String.valueOf(getSpace()));
                seaportInfoPanel.vehicleLBL.setText(String.valueOf(getNumberOfVehicle()));
                seaportInfoPanel.wharfLBL.setText(String.valueOf(wharf));
                seaportInfoPanel.personnelsLBL.setText(String.valueOf(getNumberOfPersonnel()));
                seaportInfoPanel.costsLBL.setText(getCost() + " $");
                seaportInfoPanel.setVisible(true);
                return null ;
            }
        }.execute();
    }
}