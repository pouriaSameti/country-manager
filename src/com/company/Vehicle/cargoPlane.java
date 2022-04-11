package com.company.Vehicle;
import com.company.Buildings.airPort;
import com.company.graphics.AirPortFolder.CargoPlanePanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class cargoPlane extends airVehicle
{
    private int loadWeight;
    private int maxVolume ;
    transient JButton vehicleBTN ;
    transient JButton removeBTN ;
    private transient CargoPlanePanel cargoPlanePanel ;

    public cargoPlane(String name,int loadWeight,int maxVolume)
    {
        super(name,(loadWeight * 20 + maxVolume),maxVolume,"Wright brothers",10000,3000);
        this.loadWeight = loadWeight;
        this.maxVolume = maxVolume ;
        this.setId();
    }

    public int getLoadWeight() { return this.loadWeight ; }
    public int getMaxVolume() { return this.maxVolume ;}

    //graphical method

    public void createCargoPlanePanel()
    {
        cargoPlanePanel = new CargoPlanePanel() ;
        cargoPlanePanel.nameLBL.setText(getName());
        cargoPlanePanel.idLBL.setText(String.valueOf(getId()));
        cargoPlanePanel.weightLoadLBL.setText(String.valueOf(getLoadWeight()));
        cargoPlanePanel.maxLoadLBL.setText(String.valueOf(getVolume()));
        cargoPlanePanel.companyLBL.setText(getCompanyMaker());
        cargoPlanePanel.minBandLBL.setText(String.valueOf(getBandLength()));
        cargoPlanePanel.maxAltitudeLBL.setText(String.valueOf(getAltitude()));
        cargoPlanePanel.priceLBL.setText(String.valueOf(getPrice()));
    }

    @Override
    public void createVehicleBTN(JPanel vehiclePanel, JFrame vehicleFrame) {

        ActionListener al = event ->
        {
            new SwingWorker<>(){
                @Override
                public Object doInBackground() {
                    createCargoPlanePanel();
                    cargoPlanePanel.setVisible(true);
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
                vehicleBTN.setIcon(new ImageIcon("src\\icons\\cargo plane.png"));
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
                removeBTN.setIcon(new ImageIcon("src\\icons\\cargo plane.png"));
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
                createCargoPlanePanel();
                cargoPlanePanel.setVisible(true);
                return null ;
            }
        }.execute();
    }
}
