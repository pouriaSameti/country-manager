package com.company.Buildings;
import java.io.Serializable;
import javax.swing.* ;
import com.company.graphics.HotelFolder.* ;

public class room implements Serializable {

    private int roomNumber ;
    private int numberOfBed;
    private int space ;
    private int cost ;
    private transient RoomInfoPanel roomInfoPanel ;

    public room(int roomNumber, int numberOfBed , int space )
    {
        this.roomNumber = roomNumber;
        this.numberOfBed = numberOfBed ;
        this.space = space ;
        setCost(getRoomPrice());
    }


    public int getRoomPrice()
    {
        int bedCost = this.numberOfBed * 2 ;
        int spaceCost = this.space * 3 ;
        return bedCost + spaceCost;
    }

    public int getRoomNumber() { return roomNumber; }
    public void setCost(int cost) { this.cost = cost; }

    @Override
    public String toString(){
        return String.valueOf(roomNumber) ;
    }

    //graphical method
    public void showRoomPanel()
    {
        roomInfoPanel = new RoomInfoPanel() ;
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                roomInfoPanel.roomNumberLBL.setText(String.valueOf(getRoomNumber()));
                roomInfoPanel.sapeceLBL.setText(String.valueOf(space));
                roomInfoPanel.bedLBL.setText(String.valueOf(numberOfBed));
                roomInfoPanel.priceLBL.setText(getRoomPrice() + "$");
                roomInfoPanel.setVisible(true);
                return null ;
            }
        }.execute();
    }
}