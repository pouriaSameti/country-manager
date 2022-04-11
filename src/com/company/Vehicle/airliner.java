package com.company.Vehicle;
import com.company.Buildings.airPort;
import com.company.graphics.AirPortFolder.AirplaneInformationPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class airliner extends airVehicle {

    private int crew;
    transient JButton vehicleBTN ;
    transient JButton removeBTN ;
    private transient AirplaneInformationPanel airplanePanel ;

    public airliner(String name,int numberOfCrew,int volume)
    {
        super(name,( (volume * 2) + (numberOfCrew * 3) ), volume, "Wright Brothers", 12000, 3500);
        this.crew = numberOfCrew;
        this.setId();
        this.setPrice((volume * 2) + (this.crew * 3));
    }

    @Override
    public int getCost()
    {
        return super.getPrice() ;
    }

    public int getCrew() { return this.crew ; }

    //graphical method

    public void createAirplaneInformationPanel()
    {
        airplanePanel = new AirplaneInformationPanel() ;
        airplanePanel.nameLBL.setText(getName());
        airplanePanel.idLBL.setText(String.valueOf(getId()));
        airplanePanel.seatsLBL.setText(String.valueOf(getVolume()));
        airplanePanel.altitudeLBL.setText(String.valueOf(getAltitude()));
        airplanePanel.companyLBL.setText(getCompanyMaker());
        airplanePanel.minBandLBL.setText(String.valueOf(getBandLength()));
        airplanePanel.crewLBL.setText(String.valueOf(getCrew()));
        airplanePanel.priceLBL.setText(String.valueOf(getPrice()));
    }


    @Override
    public void createVehicleBTN(JPanel vehiclePanel, JFrame vehicleFrame) {

        ActionListener al = event ->
        {
            new SwingWorker<>(){
                @Override
                public Object doInBackground()
                {
                    createAirplaneInformationPanel();
                    airplanePanel.setVisible(true);
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
                vehicleBTN.setIcon(new ImageIcon("src\\icons\\airplane.png"));
                vehicleBTN.setBackground(new Color(0, 0, 102));
                vehicleBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                vehicleBTN.addActionListener(al);
                vehiclePanel.add(vehicleBTN);
                return null ;
            }
        }.execute();
    }

    @Override
    public void createRemoveBTN(JPanel vehiclePanel,JFrame vehicleFrame) {

        ActionListener al = event ->
        {
            airPort.currentAirport.removeVehicle(this);
            new SwingWorker<>() {
                @Override
                public Object doInBackground() {
                    airPort.currentAirport.updateAirportPanel();
                    airPort.currentAirport.getCity().updateCityPanel();
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
                removeBTN.setIcon(new ImageIcon("src\\icons\\airplane.png"));
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
                createAirplaneInformationPanel();
                airplanePanel.setVisible(true);
                return null ;
            }
        }.execute();
    }
}
