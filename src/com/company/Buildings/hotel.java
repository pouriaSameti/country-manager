package com.company.Buildings;
import com.company.Person.*;
import com.company.Person.person.job ;
import com.company.city;
import com.company.country.* ;
import com.company.graphics.HotelFolder.HotelInfo;
import com.company.graphics.HotelFolder.HotelPanel;

import java.awt.event.* ;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class hotel implements Serializable
{
    private String name ;
    private city city ;
    private Country country ;
    private int createHotel ;
    private String address ;
    private int star ;
    private int numberOfRoom;
    private static int roomCounter ;
    private ArrayList<room> roomList = new ArrayList<>() ;
    private ArrayList<person> hotelPersonnel = new ArrayList<>() ;
    private ArrayList<hotelService> hotelServicesList = new ArrayList<>();
    public static hotel currentHotel ;
    public transient JButton hotelBTN ;
    public transient JButton hotelRemoveBTN ;
    private transient HotelPanel hotelPanel ;
    private transient HotelInfo hotelInfo ;

    public hotel(String name, city city, Country country, String address, int star, int numberOfRoom)
    {
        this.name = name;
        this.city = city ;
        this.country = country ;
        this.address = address ;
        this.numberOfRoom = numberOfRoom;
        this.star = star ;
        this.createHotel = 1000 ;
        this.getCity().addBuilding(this);
    }


    public enum hotelService implements Serializable
    {
        restaurant( 15),laundry(8),pool(10),
        gym(12),nightParty(50);

        int cost;
        hotelService(int cost) { this.cost = cost; }
    }

    public String getName() { return "Hotel " + this.name ; }

    public void getHotelInfo()
    {
        String information = "|" ;
        information =  information + "NAME:" + this.getName() + " , " ;
        information =  information + "ADDRESS:" + this.getCity().getCityName() + "  " + this.address + " , " ;
        information =  information + "STAR:" + this.star + " , " ;
        information =  information + "NUMBER OF ROOMS:" + this.numberOfRoom + " , " ;
        information =  information + "NUMBER OF PERSONNEL:" + this.hotelPersonnel.size() + " , ";
        information =  information + "COST: "+ this.getCost() + " $" ;
        information =  information + "|" ;
        System.out.println(information);
    }


    public void checkPersonJob() throws Exception
    {
        System.out.println("THESE PERSONS HAVE A JOB THAT RELATED TO HOTEL");
        boolean isThere = false ;
        for (person p : getCity().getAllPeople())
            if (! p.getEmploymentStatus())
            if (p.getJob().equals(job.Waiter) ||
                    p.getJob().equals(job.ReceptionOfficer) ||
                    p.getJob().equals(job.HotelCook) ||
                    p.getJob().equals(job.HotelDriver) ||
                    p.getJob().equals(job.HotelEmployee))
                isThere = true ;
            if (!isThere)
                throw new Exception("There is no person who can work at Hotel") ;

    }

    public void hireJob()
    {
        ArrayList<person> tempWaiter = new ArrayList<>() ;
        ArrayList<person> tempReceptionOfficer = new ArrayList<>() ;
        ArrayList<person> tempHotelCook = new ArrayList<>() ;
        ArrayList<person> tempHotelEmployee = new ArrayList<>() ;
        ArrayList<person> tempHotelDriver = new ArrayList<>() ;

        for (person p : getCity().getAllPeople())
            if (!p.getEmploymentStatus())
            {
                if (p.getJob().equals(job.Waiter))
                    tempWaiter.add(p) ;

                if (p.getJob().equals(job.ReceptionOfficer))
                    tempReceptionOfficer.add(p) ;

                if (p.getJob().equals(job.HotelCook))
                    tempHotelCook.add(p) ;

                if (p.getJob().equals(job.HotelEmployee))
                    tempHotelEmployee.add(p) ;

                if (p.getJob().equals(job.HotelDriver))
                    tempHotelDriver.add(p) ;
            }

        int numberOfNewWaiter = 5 ;
        int numberOfNewReceptionOfficer = 2 ;
        int numberOfNewHotelCook = 3 ;
        int numberOfNewHotelEmployee = 4 ;
        int numberOfNewHotelDriver = 2 ;

        if (tempWaiter.size() <= 5)
            numberOfNewWaiter = tempWaiter.size() ;
        if (tempReceptionOfficer.size() <= 2)
            numberOfNewReceptionOfficer = tempReceptionOfficer.size() ;
        if (tempHotelCook.size() <= 3)
            numberOfNewHotelCook = tempHotelCook.size() ;
        if (tempHotelEmployee.size() <= 4)
            numberOfNewHotelEmployee = tempHotelEmployee.size() ;
        if (tempHotelDriver.size() <= 2)
            numberOfNewHotelDriver = tempHotelDriver.size() ;


        for (int i = 0 ; i < numberOfNewWaiter ; ++i)
            this.addPersonnel(tempWaiter.get(i));
        for (int i = 0 ; i < numberOfNewReceptionOfficer ; ++i)
            this.addPersonnel(tempReceptionOfficer.get(i));
        for (int i = 0 ; i <  numberOfNewHotelCook ; ++i)
            this.addPersonnel(tempHotelCook.get(i));
        for (int i = 0 ; i < numberOfNewHotelEmployee ; ++i)
            this.addPersonnel(tempHotelEmployee.get(i));
        for (int i = 0 ; i < numberOfNewHotelDriver ; ++i)
            this.addPersonnel(tempHotelDriver.get(i));

    }


    public void addPersonnel(person p)
    {
        if (p.getJob().equals(job.Waiter))
        {
            p.setSalary(4);
            p.setWorkHouse(this.getName());
            p.setEmploymentStatus(true);
            this.hotelPersonnel.add(p);
            //write part
            this.getCity().writeCity();
        }

        if (p.getJob().equals(job.ReceptionOfficer))
        {
            p.setSalary(6);
            p.setWorkHouse(this.getName());
            p.setEmploymentStatus(true);
            this.hotelPersonnel.add(p);
            //write part
            this.getCity().writeCity();
        }

        if (p.getJob().equals(job.HotelDriver))
        {
            p.setSalary(4);
            p.setWorkHouse(this.getName());
            p.setEmploymentStatus(true);
            this.hotelPersonnel.add(p);
            //write part
            this.getCity().writeCity();
        }

        if (p.getJob().equals(job.HotelCook))
        {
            p.setSalary(5);
            p.setWorkHouse(this.getName());
            p.setEmploymentStatus(true);
            this.hotelPersonnel.add(p);
            //write part
            this.getCity().writeCity();
        }

        if (p.getJob().equals(job.HotelEmployee))
        {
            p.setSalary(4);
            p.setWorkHouse(this.getName());
            p.setEmploymentStatus(true);
            this.hotelPersonnel.add(p);
            //write part
            this.getCity().writeCity();
        }
    }

    public void removePersonnel(person p)
    {
        p.setSalary(0);
        p.setWorkHouse("");
        p.setEmploymentStatus(false);
        this.hotelPersonnel.remove(p);
        //write part
        this.getCity().writeCity();
    }

    public void addRoom(int numberOfRoom,int numberOfBed, int space) throws Exception
    {
        if(this.numberOfRoom > numberOfRoom ) {
            for (int i = 0 ; i < numberOfRoom; ++i) {
                this.roomList.add(new room(roomCounter + 1, numberOfBed, space));
                ++roomCounter ;
            }
            this.setNumberOfRoom(getRoomList().size());
            //write part
            this.getCity().writeCity();
        }

        else
            throw new Exception("HOTEL IS FULL") ;
    }

    public void removeRoom(room deletedRoom)
    {
        getRoomList().remove(deletedRoom) ;
        //write part
        this.getCity().writeCity();
        this.setNumberOfRoom(getRoomList().size());
    }

    public void addHotelService(hotelService service)
    {
        hotelServicesList.add(service) ;
        //write part
        this.getCity().writeCity();
    }

    public int getHotelServiceCost()
    {
        int sum = 0 ;
        for (hotel.hotelService hotelService : hotelServicesList) {
            sum = sum + hotelService.cost;
        }
        return sum;
    }

    public int getCost()
    {
        int create = this.createHotel;
        int sumHotelServices = this.getHotelServiceCost();

        int salaryOfWaiters = 0 ;
        int salaryOfReceptionOfficer = 0 ;
        int salaryOfDriver = 0 ;
        int salaryOfCooks = 0 ;
        int salaryOfEmployees = 0 ;
        for (person person : hotelPersonnel)
        {
            if (job.Waiter.equals(person.getJob()))
                salaryOfWaiters = salaryOfWaiters + person.getSalary();

            if (job.ReceptionOfficer.equals(person.getJob()))
                salaryOfReceptionOfficer = salaryOfReceptionOfficer + person.getSalary();

            if (job.HotelDriver.equals(person.getJob()))
                salaryOfDriver = salaryOfDriver + person.getSalary();

            if (job.HotelCook.equals(person.getJob()))
                salaryOfCooks = salaryOfCooks + person.getSalary();

            if (job.HotelEmployee.equals(person.getJob()))
                salaryOfEmployees = salaryOfEmployees + person.getSalary();
        }

        int totalRoomsIncome = 0 ;
        for (room Room : this.roomList) {
            totalRoomsIncome = totalRoomsIncome + Room.getRoomPrice();
        }

        return  create + sumHotelServices + salaryOfWaiters +
                salaryOfReceptionOfficer + salaryOfDriver +
                salaryOfCooks + salaryOfEmployees +
                totalRoomsIncome ;
    }

    public void setNumberOfRoom(int numberOfRoom) { this.numberOfRoom = numberOfRoom; }
    public ArrayList<room> getRoomList() { return roomList; }


    public ArrayList<person> getHotelPersonnel() { return this.hotelPersonnel ; }
    public city getCity() { return city; }

    @Override
    public String toString(){
        return getName() ;
    }


    //graphical method

    public void createHotelPanel()
    {
        hotelPanel = new HotelPanel() ;
        hotelPanel.setVisible(true);
    }

    public void updateHotelPanel()
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                hotelPanel.nameLBL.setText(getName());
                hotelPanel.addressLBL.setText(address);
                hotelPanel.starLBL.setText(String.valueOf(star));
                hotelPanel.roomLBL.setText(String.valueOf(roomList.size()));
                hotelPanel.personnelsLBL.setText(String.valueOf(hotelPersonnel.size()));
                hotelPanel.costsLBL.setText(getCost() + " $");
                return null ;
            }
        }.execute();
    }


    public void createHotelMainPanel()
    {
        currentHotel = this ;
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                createHotelPanel();
                updateHotelPanel();
                return null ;
            }
        }.execute();
    }


    public void showHotelInfo()
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                hotelInfo = new HotelInfo() ;
                hotelInfo.nameLBL.setText(getName());
                hotelInfo.addressLBL.setText(address);
                hotelInfo.starLBL.setText(String.valueOf(star));
                hotelInfo.roomLBL.setText(String.valueOf(roomList.size()));
                hotelInfo.personnelsLBL.setText(String.valueOf(hotelPersonnel.size()));
                hotelInfo.costsLBL.setText(getCost() + " $");
                hotelInfo.setVisible(true);
                return null ;
            }
        }.execute();
    }

}