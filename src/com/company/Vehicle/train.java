package com.company.Vehicle;
import com.company.Buildings.trainStation;
import com.company.graphics.TrainStationFolder.TrainPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.* ;
import java.awt.* ;

public class train extends landVehicle {

    private int wagon;
    private int star;
    transient JButton vehicleBTN ;
    transient JButton removeBTN ;
    transient TrainPanel trainPanel ;

    public train(String name,int wagon,String color,int star)
    {
        super(name,(200 + (wagon * 60) + (star * 20) ) ,wagon * 25,"train industry", color);
        this.wagon = wagon ;
        this.star = star ;
        this.setId();
    }


    private ArrayList <service> saveService = new ArrayList<>();
    public enum service
    {
        restaurant(10),WC(3),
        AirConditioner( 1),sleepService(5) ;
        public int cost ;
        service(int cost) { this.cost = cost; }
    }

    public void addService(service trainService)
    {
        saveService.add(trainService) ;
    }

    public int getServiceCost()
    {
        int sum = 0;
        for(service s : saveService)
            sum = sum + s.cost ;
        return sum;
    }

    @Override
    public int getCost()
    {
        int trainCost = super.getPrice() ;
        return trainCost + this.getServiceCost();
    }

    public int getWagon() { return this.wagon ; }
    public int getStar() { return star ; }

    //graphical method

    public void createTrainPanel()
    {
        trainPanel = new TrainPanel() ;
        trainPanel.nameLBL.setText(getName());
        trainPanel.idLBL.setText(String.valueOf(getId()));
        trainPanel.starLBL.setText(String.valueOf(getStar()));
        trainPanel.wagonsLBL.setText(String.valueOf(getWagon()));
        trainPanel.companyLBL.setText(getCompanyMaker());
        trainPanel.colorLBL.setText(getColor());
        trainPanel.priceLBL.setText(String.valueOf(getPrice()));
    }


    @Override
    public void createVehicleBTN(JPanel vehiclePanel, JFrame vehicleFrame) {

        ActionListener al = event ->
        {
            new SwingWorker<>(){
                @Override
                public Object doInBackground() {
                    createTrainPanel();
                    trainPanel.setVisible(true);
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
                vehicleBTN.setIcon(new ImageIcon("src\\icons\\train station.png"));
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
            trainStation.currentTrainStation.removeVehicle(this);
            new SwingWorker<>() {
                @Override
                public Object doInBackground() {
                    trainStation.currentTrainStation.updateTrainStationPanel();
                    trainStation.currentTrainStation.getCity().updateCityPanel();
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
                removeBTN.setIcon(new ImageIcon("src\\icons\\train station.png"));
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
                createTrainPanel();
                trainPanel.setVisible(true);
                return null ;
            }
        }.execute();
    }
}