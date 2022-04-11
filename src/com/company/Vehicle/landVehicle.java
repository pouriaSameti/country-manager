package com.company.Vehicle;

public abstract class landVehicle extends vehicle
{

        private String color;
        public landVehicle(String name, int price, int volume, String CM, String color)
        {
            super.setName(name);
            super.setPrice(price) ;
            super.setVolume(volume) ;
            super.setCompanyMaker(CM) ;
            this.color = color;
        }

    public String getName() { return super.getName() ; }

    public String getColor() { return color; }
}
