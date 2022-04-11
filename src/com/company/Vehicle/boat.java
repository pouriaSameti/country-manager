package com.company.Vehicle;
import com.company.Buildings.seaPort;
import com.company.graphics.AirPortFolder.AirplaneInformationPanel;
import com.company.graphics.SeaportFolder.BoatPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class boat extends marineVehicle
{
    transient JButton vehicleBTN ;
    transient JButton removeBTN ;
    transient BoatPanel boatPanel ;

    public boat(String name, int volume)
    {
        super(name,(20 + volume * 10), volume,"government",null,2);
        this.setId();
    }

    @Override
    public int getCost() { return super.getPrice() ; }

    //graphical method

    public void createBoatPanel() {
        boatPanel = new BoatPanel() ;
        boatPanel.nameLBL.setText(getName());
        boatPanel.idLBL.setText(String.valueOf(getId()));
        boatPanel.seatsLBL.setText(String.valueOf(getVolume()));
        boatPanel.depthLBL.setText(String.valueOf(getDepth()));
        boatPanel.companyLBL.setText(getCompanyMaker());
        boatPanel.priceLBL.setText(String.valueOf(getPrice()));
    }

    @Override
    public void createVehicleBTN(JPanel vehiclePanel, JFrame vehicleFrame) {

        ActionListener al = event ->
        {
            new SwingWorker<>(){
                @Override
                public Object doInBackground() {
                    createBoatPanel();
                    boatPanel.setVisible(true);
                    vehicleFrame.dispose();
                    return null ;
                }
            }.execute();
        };


        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                vehicleBTN = new JButton(getName());
                vehicleBTN.setPreferredSize(new Dimension(150, 60));
                vehicleBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
                vehicleBTN.setForeground(Color.white);
                vehicleBTN.setIcon(new ImageIcon("src\\icons\\boat.png"));
                vehicleBTN.setBackground(new Color(0, 0, 102));
                vehicleBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                vehicleBTN.addActionListener(al);
                vehiclePanel.add(vehicleBTN);
                return null ;
            }
        }.execute();

    }

    @Override
    public void createRemoveBTN(JPanel vehiclePanel, JFrame vehicleFrame) {

        ActionListener al = event ->
        {
            seaPort.currentSeaport.removeVehicle(this);
            new SwingWorker<>() {
                @Override
                public Object doInBackground() {
                    seaPort.currentSeaport.updateSeaportPanel();
                    seaPort.currentSeaport.getCity().updateCityPanel();
                    String message = getName() + " was removed";
                    String title = "Remove Vehicle";
                    ImageIcon icon = new ImageIcon("src\\icons\\delete.png");
                    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
                    vehicleFrame.dispose();
                    return null;
                }
            }.execute();
        };

        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                removeBTN = new JButton(getName());
                removeBTN.setPreferredSize(new Dimension(150, 60));
                removeBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
                removeBTN.setForeground(Color.white);
                removeBTN.setIcon(new ImageIcon("src\\icons\\boat.png"));
                removeBTN.setBackground(new Color(0, 0, 102));
                removeBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                removeBTN.addActionListener(al);
                vehiclePanel.add(removeBTN);
                return null ;
            }
        }.execute();
    }

    @Override
    public void showVehiclePanel()
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                createBoatPanel();
                boatPanel.setVisible(true);
                return null ;
            }
        }.execute();
    }
}