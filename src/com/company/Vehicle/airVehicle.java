package com.company.Vehicle;

public abstract class airVehicle extends vehicle
{

    private int altitude;
    private int bandLength;
    public airVehicle(String name,int price,int volume,String CM,int altitude,int bandLength)
    {
            super.setName(name);
            super.setPrice(price) ;
            super.setVolume(volume) ;
            super.setCompanyMaker(CM);
            this.altitude = altitude;
            this.bandLength = bandLength;
    }

    @Override
    public int getCost()
    {
        return this.getPrice() ;
    }
    public String getName()
    {
        return super.getName();
    }
    public int getAltitude() { return altitude; }
    public int getBandLength() { return bandLength; }
}
