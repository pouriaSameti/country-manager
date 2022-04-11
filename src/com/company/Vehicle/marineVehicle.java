package com.company.Vehicle;


public abstract class marineVehicle extends vehicle
{

    private fuelType fuelType;
    private int depth;
    public marineVehicle(String name, int price,int volume,String CM,fuelType fuel,int depth)
    {
            super.setName(name);
            super.setPrice(price) ;
            super.setVolume(volume) ;
            super.setCompanyMaker(CM) ;
            this.fuelType = fuel;
            this.depth = depth;
    }

    public String getName() { return super.getName() ; }

    public int getDepth() { return depth; }

    public fuelType getFuelType() { return fuelType; }

    public enum fuelType
    {
        gas(30),gasoline(25),coal(20) ;
        int price ;
        fuelType(int price)
        {
            this.price = price ;
        }
    }
}