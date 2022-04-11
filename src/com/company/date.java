package com.company;

import java.io.Serializable;

public class date implements Comparable, Serializable
{

    private int day ;
    private int month ;
    private int year ;
    public date(String date)
    {
        String[] saveDate = date.split("/") ;
        this.day = Integer.parseInt(saveDate[0]) ;
        this.month = Integer.parseInt(saveDate[1]) ;
        this.year = Integer.parseInt(saveDate[2]) ;
    }

    @Override
    public int compareTo(Object o)
    {
        date d = (date) o ;
        if (d.year > this.year)
            return 1 ;
        if (d.year < this.year)
            return -1 ;
        if (d.month > this.month)
            return 1 ;
        if (d.month < this.month)
            return -1;
        if (d.day > this.day)
            return 1 ;
        if (d.day < this.day)
            return -1 ;
        else
            return 0 ;
    }

    @Override
    public String toString()
    {
        return this.day + " / " + this.month + " / " + this.year ;
    }
}
