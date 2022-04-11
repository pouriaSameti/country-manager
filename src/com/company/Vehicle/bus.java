package com.company.Vehicle;
import com.company.Buildings.busTerminal;
import com.company.graphics.BusTerminalFolder.BusPanel;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.* ;

public class bus extends landVehicle
{
    transient JButton vehicleBTN ;
    transient JButton removeBTN ;
    transient BusPanel busPanel ;

    public bus(String name, int volume, String color) {
        super(name, (50 + (volume * 2)), volume, "BUS industry", color);
        this.setId();
    }

    @Override
    public int getCost() {
        return super.getPrice();
    }

    //graphical method

    public void createBusPanel() {
        busPanel = new BusPanel();
        busPanel.nameLBL.setText(getName());
        busPanel.colorLBL.setText(getColor());
        busPanel.idLBL.setText(String.valueOf(getId()));
        busPanel.seatsLBL.setText(String.valueOf(getVolume()));
        busPanel.companyLBL.setText(getCompanyMaker());
        busPanel.priceLBL.setText(String.valueOf(getPrice()));
    }
    @Override
    public void createVehicleBTN(JPanel vehiclePanel, JFrame vehicleFrame) {

        ActionListener al = event ->
        {
            new SwingWorker<>(){
                @Override
                public Object doInBackground() {
                    createBusPanel();
                    busPanel.setVisible(true);
                    vehicleFrame.dispose();
                    return null ;
                }
            }.execute();
        };

        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                vehicleBTN = new JButton(getName());
                vehicleBTN.setPreferredSize(new Dimension(150, 60));
                vehicleBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
                vehicleBTN.setForeground(Color.white);
                vehicleBTN.setIcon(new ImageIcon("src\\icons\\bus.png"));
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
            busTerminal.currentBusTerminal.removeVehicle(this);
            new SwingWorker<>() {
                @Override
                public Object doInBackground() {
                    busTerminal.currentBusTerminal.updateBusTerminalPanel();
                    busTerminal.currentBusTerminal.getCity().updateCityPanel();
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
                removeBTN.setIcon(new ImageIcon("src\\icons\\bus.png"));
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
                createBusPanel();
                busPanel.setVisible(true);
                return null ;
            }
        }.execute();
    }
}