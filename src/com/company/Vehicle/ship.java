package com.company.Vehicle;
import com.company.Buildings.seaPort;
import com.company.graphics.SeaportFolder.ShipPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ship extends marineVehicle
{
    transient JButton vehicleBTN ;
    transient JButton removeBTN ;
    transient ShipPanel shipPanel ;

    public ship(String name,fuelType fuel,int volume)
    {
        super(name,(200 + volume * 2 + fuel.price),volume,"Sameti & brothers industry",fuel,10);
        this.setId();
    }


    @Override
    public int getCost()
    {
        return super.getPrice() ;
    }

    //graphical method

    public void createShipPanel() {
        shipPanel = new ShipPanel();
        shipPanel.nameLBL.setText(getName());
        shipPanel.idLBL.setText(String.valueOf(getId()));
        shipPanel.seatsLBL.setText(String.valueOf(getVolume()));
        shipPanel.depthLBL.setText(String.valueOf(getDepth()));
        shipPanel.companyLBL.setText(getCompanyMaker());
        shipPanel.fuelLBL.setText(getFuelType().name());
        shipPanel.priceLBL.setText(String.valueOf(getPrice()));
    }
    @Override
    public void createVehicleBTN(JPanel vehiclePanel, JFrame vehicleFrame) {

        ActionListener al = event ->
        {
            new SwingWorker<>(){
                @Override
                public Object doInBackground() {
                    createShipPanel();
                    shipPanel.setVisible(true);
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
                vehicleBTN.setIcon(new ImageIcon("src\\icons\\cruise.png"));
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
                removeBTN.setIcon(new ImageIcon("src\\icons\\cruise.png"));
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
                createShipPanel();
                shipPanel.setVisible(true);
                return null ;
            }
        }.execute();
    }
}
