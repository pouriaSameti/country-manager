/*
 * Created by JFormDesigner on Mon Jun 28 16:39:27 IRDT 2021
 */

package com.company.graphics.CityFolder;

import com.company.graphics.AirPortFolder.CreateAirportPanel;
import com.company.graphics.BusTerminalFolder.CreateBusTerminalPanel;
import com.company.graphics.BankFolder.CreateBankPanel;
import com.company.graphics.HotelFolder.CreateHotelPanel;
import com.company.graphics.SeaportFolder.CreateSeaportPanel;
import com.company.graphics.TrainStationFolder.CreateTrainStationPanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class CreateBuildingMenu extends JFrame {
    public CreateBuildingMenu()
    {
        initComponents();
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
        {
            if (info.getName().equals("Nimbus"))
            {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.invokeLater(()-> SwingUtilities.updateComponentTreeUI(getRootPane()));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    private void label2MouseClicked(MouseEvent e) {
        // TODO add your code here
        dispose();
    }

    private void airportBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                CreateAirportPanel cap = new CreateAirportPanel() ;
                cap.setVisible(true);
                dispose();
                return null ;
            }

        }.execute();
    }

    private void busTerminalBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                CreateBusTerminalPanel cbt = new CreateBusTerminalPanel();
                cbt.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void seaportBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                CreateSeaportPanel csp = new CreateSeaportPanel() ;
                csp.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();

    }

    private void trainStationBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                CreateTrainStationPanel cts = new CreateTrainStationPanel() ;
                cts.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void hotelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                CreateHotelPanel chp = new CreateHotelPanel() ;
                chp.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void bankBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                CreateBankPanel cbp = new CreateBankPanel()  ;
                cbp.setVisible(true);
                dispose();
                return null;
            }
        }.execute();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        airportBTN = new JButton();
        busTerminalBTN = new JButton();
        seaportBTN = new JButton();
        trainStationBTN = new JButton();
        hotelBTN = new JButton();
        bankBTN = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Create Building Menu");
            label1.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label1.setForeground(Color.white);

            //---- label2 ----
            label2.setIcon(new ImageIcon(getClass().getResource("/icons/close.png")));
            label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label2MouseClicked(e);
                }
            });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 555, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
            );
        }

        //======== panel2 ========
        {
            panel2.setBackground(new Color(51, 0, 0));

            //---- airportBTN ----
            airportBTN.setText("Airport");
            airportBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            airportBTN.setForeground(Color.white);
            airportBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            airportBTN.setIcon(new ImageIcon(getClass().getResource("/icons/airport.png")));
            airportBTN.setBackground(new Color(51, 0, 51));
            airportBTN.addActionListener(e -> airportBTNActionPerformed(e));

            //---- busTerminalBTN ----
            busTerminalBTN.setText("Bus Terminal");
            busTerminalBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            busTerminalBTN.setForeground(Color.white);
            busTerminalBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            busTerminalBTN.setIcon(new ImageIcon(getClass().getResource("/icons/bus terminal icon.png")));
            busTerminalBTN.setBackground(new Color(0, 102, 102));
            busTerminalBTN.addActionListener(e -> busTerminalBTNActionPerformed(e));

            //---- seaportBTN ----
            seaportBTN.setText("Seaport");
            seaportBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            seaportBTN.setForeground(Color.white);
            seaportBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            seaportBTN.setIcon(new ImageIcon(getClass().getResource("/icons/seaport.png")));
            seaportBTN.setBackground(new Color(0, 102, 51));
            seaportBTN.addActionListener(e -> seaportBTNActionPerformed(e));

            //---- trainStationBTN ----
            trainStationBTN.setText("Train Station");
            trainStationBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            trainStationBTN.setForeground(Color.white);
            trainStationBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            trainStationBTN.setIcon(new ImageIcon(getClass().getResource("/icons/train station.png")));
            trainStationBTN.setBackground(new Color(204, 0, 0));
            trainStationBTN.addActionListener(e -> trainStationBTNActionPerformed(e));

            //---- hotelBTN ----
            hotelBTN.setText("Hotel");
            hotelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            hotelBTN.setForeground(Color.white);
            hotelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            hotelBTN.setIcon(new ImageIcon(getClass().getResource("/icons/hotel.png")));
            hotelBTN.setBackground(new Color(204, 51, 0));
            hotelBTN.addActionListener(e -> hotelBTNActionPerformed(e));

            //---- bankBTN ----
            bankBTN.setText("Bank");
            bankBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            bankBTN.setForeground(Color.white);
            bankBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            bankBTN.setBackground(new Color(0, 0, 102));
            bankBTN.setIcon(new ImageIcon(getClass().getResource("/icons/banking.png")));
            bankBTN.addActionListener(e -> bankBTNActionPerformed(e));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(trainStationBTN, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                            .addComponent(airportBTN, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                        .addGap(142, 142, 142)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(busTerminalBTN, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                            .addComponent(hotelBTN, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(seaportBTN, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(bankBTN, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                        .addGap(25, 25, 25))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(seaportBTN)
                            .addComponent(busTerminalBTN)
                            .addComponent(airportBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(hotelBTN)
                            .addComponent(trainStationBTN)
                            .addComponent(bankBTN))
                        .addGap(85, 85, 85))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setSize(930, 500);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel2;
    private JButton airportBTN;
    private JButton busTerminalBTN;
    private JButton seaportBTN;
    private JButton trainStationBTN;
    private JButton hotelBTN;
    private JButton bankBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
