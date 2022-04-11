package com.company.Vehicle;
import com.company.Buildings.* ;
import javax.swing.*;
import java.io.Serializable;

public abstract class vehicle implements Serializable
{
    private int id;
    private String name ;
    private int price;
    private int volume;
    private String companyMaker;
    private static int indexId = 0 ;
    private terminal vehicleTerminal ;
    //field for travel
    public static vehicle travelVehicle ;

    public void setId() { this.id = indexId ++; }
    public int getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setPrice(int price) { this.price = price; }
    public int getPrice() { return price; }

    public void setCompanyMaker(String companyMaker) { this.companyMaker = companyMaker; }
    public String getCompanyMaker() { return companyMaker; }

    public int getVolume() { return volume; }
    public void setVolume(int volume) { this.volume = volume; }

    public terminal getVehicleTerminal() { return vehicleTerminal; }
    public void setVehicleTerminal(terminal vehicleTerminal) { this.vehicleTerminal = vehicleTerminal; }

    public abstract int getCost() ;

    @Override
    public String toString(){
        return getName() ;
    }

    //graphical abstract method
    public abstract void showVehiclePanel() ;
    public abstract void createVehicleBTN(JPanel vehiclePanel, JFrame vehicleFrame);
    public abstract void createRemoveBTN(JPanel vehiclePanel, JFrame vehicleFrame) ;
}