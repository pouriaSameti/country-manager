package com.company.Person;
import com.company.city;
import com.company.country.Country;
import com.company.graphics.PersonInfoPanel;
import java.io.Serializable;
import javax.swing.*;

public class person implements Serializable
{
    private String name;
    private String lastName;
    private int id ;
    private int birthYear;
    private String birthCountry ;
    private String birthCity ;
    private job Job;
    private gender Gender;
    private int salary;
    private boolean employmentStatus = false ;
    private String workHouse ;
    private static int setID = 0 ;
    public transient PersonInfoPanel personInfoPanel ;
    //field for travel
    public static person vehicleDriver ;

    public person(String name , String lastName,int birthYear,String Country, String City,job Job,gender Gender)
    {
        this.name = name;
        this.lastName = lastName;
        this.id = setID ++ ;
        this.birthYear = birthYear;
        this.birthCountry = Country ;
        this.birthCity = City ;
        setCity(City);
        this.Job = Job;
        this.Gender = Gender;
        this.salary = this.getSalary();
    }

    public enum job
    {
        Pilot, AirportEmployee, BusDriver, BusTerminalEmployee, Waiter, ReceptionOfficer,
        HotelCook, HotelEmployee, HotelDriver ,Sailor, SeaportEmployee, TrainEngineer, TrainEmployee, banker, bankEmployee
    }

    public enum gender
    {
        female, male
    }

    public static void setCurrentId()
    {
        int counter = 0 ;
        for (city City : Country.getCountry().getCities())
            counter = counter +  City.getAllPeople().size() ;
        setID = counter ;
    }

    @Override
    public String toString()
    {
        return getName() + " " + getLastName() ;
    }

    public String getName() { return name; }
    public String getLastName(){return lastName; }

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public int getBirthYear() { return birthYear; }

    public job getJob() { return this.Job ; }
    public gender getGender() { return Gender ; }


    public void sethCountry(String Country) { this.birthCountry = Country; }
    public String getBirthCountry() { return birthCountry; }

    public void setCity(String city) { this.birthCity = city; }
    public String getBirthCity() { return birthCity; }

    public void setSalary(int salary) { this.salary = salary; }
    public int getSalary() { return this.salary; }

    public void setEmploymentStatus(boolean set) { this.employmentStatus = set; }
    public boolean getEmploymentStatus() { return this.employmentStatus; }

    public void setWorkHouse(String workHouse) { this.workHouse = workHouse; }
    public String getWorkHouse() { return workHouse ; }

    //graphical method

    public void createPersonInfoPanel()
    {
        personInfoPanel = new PersonInfoPanel() ;
        personInfoPanel.setVisible(true);
    }

    public void showPersonPanel()
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                createPersonInfoPanel();
                personInfoPanel.nameLBL.setText(getName() + " " + getLastName());
                personInfoPanel.idLBL.setText(String.valueOf(getId()));
                personInfoPanel.genderLBL.setText(getGender().name());
                personInfoPanel.birthYearLBL.setText(String.valueOf(getBirthYear()));
                personInfoPanel.birthPlaceLBL.setText(getBirthCountry() + " " + getBirthCity());
                personInfoPanel.jobLBL.setText(getJob().name());
                if (getEmploymentStatus())
                {
                    personInfoPanel.salaryLBL.setText(String.valueOf(getSalary()));
                    personInfoPanel.workHouseLBL.setText(getWorkHouse());
                }
                return null ;
            }
        }.execute();
    }
}