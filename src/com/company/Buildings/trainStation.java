package com.company.Buildings;
import com.company.Vehicle.* ;
import com.company.Person.* ;
import com.company.Person.person.job ;
import com.company.city;
import com.company.country.* ;
import com.company.graphics.TrainStationFolder.TrainStationInfoPanel;
import com.company.graphics.TrainStationFolder.TrainStationPanel;

import java.awt.event.* ;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class trainStation extends terminal
{
    private int inputRail;
    private int outputRail;
    private int createTrainStation;
    private int indexOfTrain = 0 ;
    private transient TrainStationPanel trainStationPanel ;
    public static trainStation currentTrainStation ;
    public transient TrainStationInfoPanel trainStationInfoPanel ;

    public trainStation(String name, city City, Country country , String address,int inputRail, int outputRail)
    {
        this.setTerminalName(name);
        super.setCity(City) ;
        super.setCountry(country);
        this.setAddress(address);
        this.setSpace(2000);
        this.inputRail = inputRail ;
        this.outputRail = outputRail ;
        this.createTrainStation = 400 + this.inputRail * 50 + this.outputRail * 50  ;
        this.getCity().addBuilding(this);
    }


    @Override
    public String getTerminalType() { return "Train Station" ; }

    @Override
    public String getName()
    {
        return  "Train Station " + this.getTerminalName() ;
    }

    @Override
    public void checkPersonJob() throws Exception
    {
        boolean isThere = false ;
        for (person p : getCity().getAllPeople())
            if (! p.getEmploymentStatus())
                if (p.getJob().equals(job.TrainEngineer) || p.getJob().equals(job.TrainEmployee) )
                    isThere = true ;

        if (!isThere)
            throw new Exception("There is no person who can work at Train Station") ;
    }

    @Override
    public void hireJob() throws Exception
    {
        if (getVehicleLeader().size() >= getVehicleList().size())
            throw new Exception("number of drivers is sufficient");
        else
        {
            ArrayList<person> tempTrainEngineer = new ArrayList<>() ;
            ArrayList<person> tempEmployee = new ArrayList<>() ;
            for (person p : getCity().getAllPeople())
                if (!p.getEmploymentStatus())
                {
                    if (p.getJob().equals(job.TrainEngineer))
                        tempTrainEngineer.add(p) ;
                    if (p.getJob().equals(job.TrainEmployee))
                        tempEmployee.add(p) ;
                }

            int numberOfNewTrainEngineer = this.getVehicleList().size() ;
            int numberOfNewTrainEmployee = 6 ;
            if (tempTrainEngineer.size() <= this.getVehicleList().size())
                numberOfNewTrainEngineer = tempTrainEngineer.size() ;
            if (tempEmployee.size() <= 6 )
                numberOfNewTrainEmployee = tempEmployee.size() ;


            for (int i = 0 ; i < numberOfNewTrainEngineer ; ++i)
                this.addPersonnel(tempTrainEngineer.get(i));
            for (int i = 0 ; i < numberOfNewTrainEmployee ; ++i)
                this.addPersonnel(tempEmployee.get(i));
        }
    }


    public void addTrain(String name, int wagon, String color,int star) throws Exception
    {
        if(indexOfTrain <= this.outputRail)
        {
            String Name = indexOfTrain + name ;
            train Train = new train(Name,wagon,color,star);
            Train.setVehicleTerminal(this);
            this.getVehicleList().add(Train) ;
            this.getCity().addVehicle(Train);
            this.setNumberOfVehicle(getVehicleList().size());
            //write part
            this.getCity().writeCity();
            ++indexOfTrain;
        }

        else
            throw new Exception("all of rails is filled of trains -- station hasn't any space") ;
    }

    @Override
    public void addVehicle(vehicle Vehicle) throws Exception
    {
        if (Vehicle instanceof train)
        {
            train t = (train) Vehicle ;
            this.addTrain(t.getName(),t.getWagon(), t.getColor(), t.getStar());
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
        if (p.getJob().equals(job.TrainEngineer))
        {
            p.setSalary(20) ;
            p.setEmploymentStatus(true);
            p.setWorkHouse(this.getName());
            this.getVehicleLeader().add(p) ;
            this.setNumberOfPersonnel(this.getVehicleLeader().size() + this.getEmployee().size());
            //write part
            this.getCity().writeCity();
        }

        if (p.getJob().equals(job.TrainEmployee))
        {
            p.setSalary(2) ;
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
        if (p.getJob().equals(job.TrainEngineer))
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

        if (p.getJob().equals(job.TrainEmployee))
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
        int createStation = this.createTrainStation ;
        int trainCost = 0 ;
        for (vehicle v : getVehicleList())
            trainCost = trainCost + v.getCost() ;

        int salaryOfTrainEngineer = 0 ;
        for (person p : getVehicleLeader())
            salaryOfTrainEngineer = salaryOfTrainEngineer + p.getSalary() ;

        int salaryOfEmployee = 0 ;
        for (person p : getEmployee())
            salaryOfEmployee = salaryOfEmployee + p.getSalary() ;

        int sum = createStation + trainCost + salaryOfTrainEngineer + salaryOfEmployee ;
        this.setCost(sum);
        return sum;
    }

    //graphical method

    public void createTrainStationPanel()
    {
        trainStationPanel = new TrainStationPanel() ;
        trainStationPanel.setVisible(true);
    }

    public void updateTrainStationPanel()
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                trainStationPanel.nameLBL.setText(getTerminalName());
                trainStationPanel.addressLBL.setText(getAddress());
                trainStationPanel.spaceLBL.setText(String.valueOf(getSpace()));
                trainStationPanel.vehicleLBL.setText(String.valueOf(getNumberOfVehicle()));
                trainStationPanel.inputRailLBL.setText(String.valueOf(inputRail));
                trainStationPanel.outputRailLBL.setText(String.valueOf(outputRail));
                trainStationPanel.personnelsLBL.setText(String.valueOf(getNumberOfPersonnel()));
                trainStationPanel.costsLBL.setText(getCost() + " $");
                return null ;
            }
        }.execute();
    }

    @Override
    public void createTerminalPanel()
    {
        currentTrainStation = this ;
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                createTrainStationPanel();
                updateTrainStationPanel();
                return null ;
            }
        }.execute();
    }

    @Override
    public void getTerminalPanel() {
        trainStationInfoPanel = new TrainStationInfoPanel() ;
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {

                trainStationInfoPanel.nameLBL.setText(getTerminalName());
                trainStationInfoPanel.addressLBL.setText(getAddress());
                trainStationInfoPanel.spaceLBL.setText(String.valueOf(getSpace()));
                trainStationInfoPanel.vehicleLBL.setText(String.valueOf(getNumberOfVehicle()));
                trainStationInfoPanel.inputRailLBL.setText(String.valueOf(inputRail));
                trainStationInfoPanel.outputRailLBL.setText(String.valueOf(outputRail));
                trainStationInfoPanel.personnelsLBL.setText(String.valueOf(getNumberOfPersonnel()));
                trainStationInfoPanel.costsLBL.setText(getCost() + " $");
                trainStationInfoPanel.setVisible(true);
                return null ;
            }
        }.execute();
    }
}