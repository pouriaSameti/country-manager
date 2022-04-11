package com.company.Buildings;
import com.company.Person.*;
import com.company.Person.person.job ;
import com.company.Vehicle.*;
import com.company.city;
import com.company.country.Country;
import com.company.graphics.AirPortFolder.AirportInfoPanel;
import com.company.graphics.BusTerminalFolder.BusTerminalInfoPanel;
import com.company.graphics.BusTerminalFolder.BusTerminalPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class busTerminal extends terminal
{
    private int createBusTerminal ;
    private int indexOfBus = 0 ;
    private transient BusTerminalPanel busTerminalPanel ;
    public static busTerminal currentBusTerminal ;
    private transient BusTerminalInfoPanel busTerminalInfoPanel ;

    public busTerminal(String name,city City,Country country, String address)
    {
        this.setTerminalName(name);
        super.setCity(City) ;
        super.setCountry(country);
        this.setAddress(address);
        this.setSpace(800);
        this.createBusTerminal = 400 ;
        this.getCity().addBuilding(this);
    }


    @Override
    public String getTerminalType() { return "Bus Terminal" ; }


    @Override
    public String getName() { return  "Bus Terminal " + this.getTerminalName() ; }

    @Override
    public void checkPersonJob() throws Exception
    {
        boolean isThere = false ;
        for (person p : getCity().getAllPeople())
            if (! p.getEmploymentStatus())
                if (p.getJob().equals(job.BusDriver) || p.getJob().equals(job.BusTerminalEmployee) )
                    isThere = true ;

        if (!isThere)
            throw new Exception("There is no person who can work at Bus Terminal") ;
    }

    @Override
    public void hireJob() throws Exception
    {
        if (getVehicleLeader().size() >= getVehicleList().size())
            throw new Exception("number of drivers is sufficient");

        else
        {
            ArrayList<person> tempDriver = new ArrayList<>() ;
            ArrayList<person> tempEmployee = new ArrayList<>() ;

            for (person p : getCity().getAllPeople())
            if (!p.getEmploymentStatus())
            {
                if (p.getJob().equals(job.BusDriver))
                    tempDriver.add(p) ;

                if (p.getJob().equals(job.BusTerminalEmployee))
                    tempEmployee.add(p) ;
            }

            int numberOfNewBusDriver = this.getVehicleList().size() ;
            int numberOfNewBusTerminalEmployee = 5 ;

            if (tempDriver.size() <= this.getVehicleList().size())
                numberOfNewBusDriver = tempDriver.size() ;

            if (tempEmployee.size() <= 5)
                numberOfNewBusTerminalEmployee = tempEmployee.size() ;

            for (int i = 0 ; i < numberOfNewBusDriver ; ++i)
                this.addPersonnel(tempDriver.get(i));
            for (int i = 0 ; i < numberOfNewBusTerminalEmployee ; ++i)
                this.addPersonnel(tempEmployee.get(i));
        }
    }


    public void addBus(String name ,int volume, String color)
    {
        String Name = indexOfBus + name ;
        bus Bus = new bus(Name,volume,color);
        Bus.setVehicleTerminal(this);
        this.getVehicleList().add(Bus);
        this.getCity().addVehicle(Bus);
        this.setNumberOfVehicle(getVehicleList().size());
        //write part
        this.getCity().writeCity();
        ++indexOfBus ;
    }

    @Override
    public void addVehicle(vehicle Vehicle)
    {
        if (Vehicle instanceof bus)
        {
            bus b = (bus) Vehicle ;
            this.addBus(b.getName(),b.getVolume(), b.getColor());
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
    public void addPersonnel(person p)
    {
        if (p.getJob().equals(job.BusDriver))
        {
            p.setSalary(8) ;
            p.setEmploymentStatus(true);
            p.setWorkHouse(this.getName());
            this.getVehicleLeader().add(p) ;
            this.setNumberOfPersonnel(this.getVehicleLeader().size() + this.getEmployee().size());
            //write part
            this.getCity().writeCity();
        }

        if (p.getJob().equals(job.BusTerminalEmployee))
        {
            p.setSalary(1) ;
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
        if (p.getJob().equals(job.BusDriver))
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

        if (p.getJob().equals(job.BusTerminalEmployee))
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
        int createTerminal = this.createBusTerminal;

        int busCost = 0  ;
        for (vehicle v : getVehicleList())
            busCost = busCost + v.getCost() ;

        int salaryOfDriver = 0 ;
        for (person p : getVehicleLeader())
            salaryOfDriver = salaryOfDriver + p.getSalary() ;

        int salaryOfEmployee = 0 ;
        for (person p : getEmployee())
            salaryOfEmployee = salaryOfEmployee + p.getSalary() ;

        int sum = createTerminal + busCost + salaryOfDriver + salaryOfEmployee;
        this.setCost(sum);
        return sum;
    }

    //graphical method

    public void createBusTerminalPanel()
    {
        busTerminalPanel = new BusTerminalPanel() ;
        busTerminalPanel.setVisible(true);
    }

    public void updateBusTerminalPanel()
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                busTerminalPanel.nameLBL.setText(getTerminalName());
                busTerminalPanel.addressLBL.setText(getAddress());
                busTerminalPanel.spaceLBL.setText(String.valueOf(getSpace()));
                busTerminalPanel.vehicleLBL.setText(String.valueOf(getNumberOfVehicle()));
                busTerminalPanel.personnelsLBL.setText(String.valueOf(getNumberOfPersonnel()));
                busTerminalPanel.costsLBL.setText(getCost() + " $");
                return null ;
            }
        }.execute();
    }

    @Override
    public void createTerminalPanel()
    {
        currentBusTerminal = this ;
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                createBusTerminalPanel();
                updateBusTerminalPanel();
                return null ;
            }
        }.execute();
    }


    @Override
    public void getTerminalPanel() {

        busTerminalInfoPanel = new BusTerminalInfoPanel() ;
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {

                busTerminalInfoPanel.nameLBL.setText(getTerminalName());
                busTerminalInfoPanel.addressLBL.setText(getAddress());
                busTerminalInfoPanel.spaceLBL.setText(String.valueOf(getSpace()));
                busTerminalInfoPanel.vehicleLBL.setText(String.valueOf(getNumberOfVehicle()));
                busTerminalInfoPanel.personnelsLBL.setText(String.valueOf(getNumberOfPersonnel()));
                busTerminalInfoPanel.costsLBL.setText(getCost() + " $");
                busTerminalInfoPanel.setVisible(true);
                return null ;
            }
        }.execute();
    }
}