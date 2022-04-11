package com.company;
import com.company.Buildings.* ;
import com.company.Vehicle.* ;
import com.company.Person.* ;
import com.company.Person.person.* ;
import com.company.country.* ;
import com.company.graphics.CityFolder.CityInfoPanel;
import com.company.graphics.CityFolder.CityPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.* ;

public class city implements Serializable
{
    private String name ;
    private Country country ;
    private int numberOfVehicle ;
    private int numberOfBuilding ;
    private int volumeOfPeople ;
    private int numberOfPeople = 0 ;
    private static int personCounter ;
    private int budgetOfCity ;
    private  ArrayList <person> allPeople = new ArrayList<>() ;
    private  ArrayList <vehicle> allVehicle = new ArrayList<>() ;
    private  ArrayList <terminal> allTerminal = new ArrayList<>() ;
    private  ArrayList<hotel> allHotel = new ArrayList<>() ;
    private  ArrayList<Bank> allBank = new ArrayList<>() ;
    private String pathCityFolder ;
    private transient JButton cityBTN ;
    private transient CityPanel cityPanel ;
    public static city currentCity ;
    private transient CityInfoPanel cityInfoPanel ;
    //fields for Travel
    public static city originCity ;
    public static city destinationCity ;

    public city(String name, Country country ,int volumeOfPeople, boolean isCreate)
    {
        this.name = name ;
        this.volumeOfPeople = volumeOfPeople ;
        this.country = country ;
        this.budgetOfCity = 10000 ;
        this.setPathCityFolder("country\\" + this.getCityName() + ".txt");
        if (isCreate)
        {
            File cityFile = new File(this.getPathCityFolder()) ;
            try {
                cityFile.createNewFile() ;
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
            this.writeCity();
        }
    }


    public void addPeople(person newPerson) throws Exception
    {
        if (this.getNumberOfPeople() <= this.getVolumeOfPeople())
        {
            newPerson.sethCountry(this.getCountry().getName());
            this.getAllPeople().add(newPerson) ;
            this.setNumberOfPeople(this.getAllPeople().size());
            this.writeCity();
        }

        else
            throw new Exception(this.getCityName() + " IS FULL") ;
    }

    public void removePeople(person newPerson)
    {
        newPerson.sethCountry("");
        this.getAllPeople().remove(newPerson) ;
        this.setNumberOfPeople(this.getAllPeople().size());
        this.writeCity();
    }

    public void generatePerson(int numberOfPerson, job Job) throws Exception
    {
        String[] firstname_Boy = {"Liam","Noah", "Oliver","Elijah","William","James","Benjamin","Lucas","Henry",
                "Alexander","Mason","Michael", "Ethan","Daniel","Jacob","Logan","Jackson","Levi","Sebastian","Mateo",
                "Jack","Owen","Theodore","Aiden","Samuel","Joseph", "John","David","Wyatt","Matthew","Luke","Asher",
                "Julian","Leo","Lincoln","Dylan","Thomas","Charles","Christopher","Jaxon", "Andrew","Elias","Joshua",
                "Ryan","Adrian","Nolan","Christian","Luca","Hunter","Jonathan","Santiago","Axel","Angel","Roman",
                "Jordan","Ian","Jaxson","Leonardo","Nicholas","Dominic","Austin"
        };

        String [] firstname_Girl = {"Olivia","Emma","Ava","Charlotte","Sophia","Amelia","Isabella","Mia","Harper",
                "Camila","Abigail","Luna","Ella", "Elizabeth","Sofia","Emily","Scarlett","Eleanor","Madison","Layla",
                "Penelope","Aria","Grace","Ellie","Nora", "Hazel","Zoey","Riley","Victoria","Lily","Aurora","Violet",
                "Emilia","Stella","Lucy","Paisley","Natalie", "Elena","Ivy","Kinsley","Audrey","Maya","Skylar","Bella",
                "Madelyn","Anna","Delilah","Caroline", "Valentina", "Ruby","Sophie","Alice","Gabriella","Ariana",
                "Allison","Hailey","Nevaeh","Natalia", "Josephine","Sarah","Cora", "Samantha","Eva","Lydia","Jade",
                "Peyton","Adeline"
        };

        String [] lastnames = {"Smith","Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez",
                "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson",
                "Martin", "Lee", "Perez", "Thompson", "White", "Harris", "Sanchez", "Clark", "Ramirez", "Lewis", "Robinson",
                "Walker", "Young", "Allen", "King", "Wright", "Scott", "Torres", "Nguyen", "Hill", "Flores", "Green", "Adams",
                "Nelson", "Baker", "Hall", "Rivera", "Campbell", "Mitchell", "Carter", "Roberts", "Wang", "Ivanova", "Sato",
                "Da silva", "Gonzalez", "Yilmaz", "Murphy", "Nowak", "Borg", "Rusu", "Hansen", "Lopez", "Rodriguez", "Kumar",
                "Liu", "Yang", "Xu", "Kim", "Hugo", "dickens", "zuckerberg", "larson", "moore", "underwood", "slade", "grant",
                "howland", "starling", "Doubtfire", "Ardern", "twain"
        };


        if (numberOfPerson <= this.volumeOfPeople)
        {
            int boyFirstnameCounter = 0 ;
            int girlFirstnameCounter = 0 ;
            int lastNameCounter = 0 ;
            for (int i = 0 ; i < numberOfPerson ; ++i)
            {
                int birthYear = personCounter + 1300;
                String Country = this.getCountry().getName();
                String City = this.getCityName();
                person newPerson;

                if (i % 2 == 0)
                {
                    newPerson = new person(firstname_Boy[boyFirstnameCounter], lastnames[lastNameCounter], birthYear, Country, City, Job, gender.male);
                    ++ boyFirstnameCounter;
                    ++ lastNameCounter ;
                }


                else
                {
                    newPerson = new person(firstname_Girl[girlFirstnameCounter], lastnames[lastNameCounter], birthYear, Country, City, Job, gender.female);
                    ++ girlFirstnameCounter ;
                    ++ lastNameCounter ;
                }

                if (boyFirstnameCounter == firstname_Boy.length)
                    boyFirstnameCounter = 0 ;

                if (girlFirstnameCounter == firstname_Girl.length)
                    girlFirstnameCounter = 0 ;

                if (lastNameCounter == lastnames.length)
                    lastNameCounter = 0 ;


                this.addPeople(newPerson);
                ++personCounter;
            }
        }

        else
            throw new Exception("CITY IS FULL") ;
    }


    public void addBuilding(Object building)
    {
        int numberOfBuildings = this.getAllTerminal().size() + this.getAllHotel().size() + this.getAllBank().size() ;
        if (building instanceof terminal)
        {
            terminal t = (terminal) building ;
            this.getAllTerminal().add(t) ;
            this.setNumberOfBuilding(numberOfBuildings);
            this.writeCity();
        }

        if (building instanceof hotel)
        {
            hotel h = (hotel) building ;
            this.getAllHotel().add(h) ;
            this.setNumberOfBuilding(numberOfBuildings);
            this.writeCity();
        }

        if (building instanceof Bank)
        {
            Bank b = (Bank) building;
            this.getAllBank().add(b) ;
            this.setNumberOfBuilding(numberOfBuildings);
            this.writeCity();
        }
    }

    public void removeBuilding(Object building)
    {
        int numberOfBuildings = this.getAllTerminal().size() + this.getAllHotel().size() + this.getAllBank().size() ;
        if (building instanceof  terminal)
        {
            terminal t = (terminal) building ;
            t.getVehicleLeader().forEach(person -> person.setEmploymentStatus(false));
            t.getVehicleLeader().forEach(person -> person.setWorkHouse(""));
            t.getEmployee().forEach(person -> person.setEmploymentStatus(false));
            t.getEmployee().forEach(person -> person.setWorkHouse(""));
            this.getAllTerminal().remove(t) ;
            this.setNumberOfBuilding(numberOfBuildings - 1);
            this.writeCity();
        }

        if (building instanceof hotel)
        {
            hotel h = (hotel) building ;
            h.getHotelPersonnel().forEach(person -> person.setEmploymentStatus(false));
            h.getHotelPersonnel().forEach(person -> person.setWorkHouse(""));
            this.getAllHotel().remove(h) ;
            this.setNumberOfBuilding(numberOfBuildings - 1);
            this.writeCity();
        }

        if (building instanceof Bank)
        {
            Bank b = (Bank) building;
            b.getAllPersonnel().forEach(person -> person.setEmploymentStatus(false));
            b.getAllPersonnel().forEach(person -> person.setWorkHouse(""));
            this.getAllBank().remove(b) ;
            this.setNumberOfBuilding(numberOfBuildings - 1);
            this.writeCity();
        }
    }


    public void addVehicle(vehicle newVehicle)
    {
       this.getAllVehicle().add(newVehicle) ;
       this.setNumberOfVehicle(this.getAllVehicle().size());
       this.writeCity();
    }

    public void removeVehicle(vehicle v)
    {
        this.getAllVehicle().remove(v) ;
        this.setNumberOfVehicle(this.getAllVehicle().size());
        this.writeCity();
    }

    public void addBudget(int value)
    {
        this.setBudgetOfCity(this.budgetOfCity + value );
        this.writeCity();
    }

    public void withdrawBudget(int value)
    {
        this.setBudgetOfCity(this.budgetOfCity - value );
        this.writeCity();
    }

    @Override
    public String toString()
    {
        return getCityName() ;
    }

    //part of set properties of city
    public void writeCity()
    {
        try {
            FileOutputStream fos = new FileOutputStream(this.getPathCityFolder()) ;
            ObjectOutputStream oos = new ObjectOutputStream(fos) ;
            oos.writeObject(this);
            oos.close();
            fos.close();
        }
        catch (IOException ie){
            ie.getStackTrace();
        }
    }

    public void setFinallyBudget()
    {
        int sum = 0 ;
        int bankBalances = 0 ;
        for (terminal t : this.allTerminal)
            sum = sum + t.getCost() ;
        for (hotel h : this.allHotel)
            sum = sum + h.getCost() ;
        for (Bank b : this.allBank)
            bankBalances = bankBalances + b.getBalanceOfBank() ;
        this.setBudgetOfCity(10000 - sum + bankBalances);
    }


    public String getCityName() { return name; }
    public  ArrayList<person> getAllPeople() { return allPeople ; }
    public  ArrayList<vehicle> getAllVehicle() { return allVehicle ; }
    public  ArrayList<terminal> getAllTerminal() { return this.allTerminal ; }
    public  ArrayList<hotel> getAllHotel() { return this.allHotel ; }

    public int getVolumeOfPeople() { return volumeOfPeople; }

    public int getBudgetOfCity() { return budgetOfCity; }
    public void setBudgetOfCity(int budgetOfCity) { this.budgetOfCity = budgetOfCity ; }

    public int getNumberOfPeople() { return numberOfPeople; }
    public void setNumberOfPeople(int numberOfPeople) { this.numberOfPeople = numberOfPeople; }

    public Country getCountry() { return country; }

    public int getNumberOfBuilding() { return allBank.size() + allHotel.size() + allTerminal.size() ; }
    public void setNumberOfBuilding(int numberOfBuilding) { this.numberOfBuilding = numberOfBuilding; }

    public int getNumberOfVehicle() { return numberOfVehicle; }
    public void setNumberOfVehicle(int numberOfVehicle) { this.numberOfVehicle = numberOfVehicle; }

    public void setPathCityFolder(String pathCityFolder) { this.pathCityFolder = pathCityFolder;}
    public String getPathCityFolder() { return pathCityFolder; }

    public ArrayList<Bank> getAllBank() { return allBank; }

    //graphical methods

    public void updateCityPanel()
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                cityPanel.cityNameLBL.setText("City Name : " + getCityName());
                cityPanel.populationLBL.setText("Population : " + getNumberOfPeople());
                cityPanel.vehiclesLBL.setText("Vehicles : " + getNumberOfVehicle());
                cityPanel.buildingsLBL.setText("Buildings : " + getNumberOfBuilding());
                cityPanel.budjetLBL.setText("Budget : " + getBudgetOfCity() + "$");
                Country.getCountry().updateCountryInfo();
                return null ;
            }

        }.execute();
    }

    public void updateCityBudgetOnPanel()
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                city.currentCity.setFinallyBudget();
                city.currentCity.updateCityPanel();
                Country.getCountry().updateCountryInfo();
                return null ;
            }
        }.execute();
    }

    public  void createCityPanel()
    {
        cityPanel = new CityPanel() ;
        updateCityPanel();
        cityPanel.setVisible(true);
        currentCity = this ;
    }


    public void getCityInfoPanel()
    {
        cityInfoPanel = new CityInfoPanel() ;
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                cityInfoPanel.cityNameLBL.setText("City Name : " + getCityName());
                cityInfoPanel.populationLBL.setText("Population : " + getNumberOfPeople());
                cityInfoPanel.vehiclesLBL.setText("Vehicles : " + getNumberOfVehicle());
                cityInfoPanel.buildingsLBL.setText("Buildings : " + getNumberOfBuilding());
                cityInfoPanel.budjetLBL.setText("Budget : " + getBudgetOfCity() + "$");
                cityInfoPanel.setVisible(true);
                return null ;
            }
        }.execute();
    }
}