/*
 * Created by JFormDesigner on Sat Jul 03 11:45:24 IRDT 2021
 */

package com.company.graphics.Travel;

import com.company.country.travel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class TravelInfoPanel extends JFrame {
    public TravelInfoPanel()
    {
        initComponents();
        travelNameLBL.setText(travel.currentTravel.toString());
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
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

    private void label2MouseClicked(MouseEvent e) {
        // TODO add your code here
        dispose();
    }

    private void okBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void originBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                travel.currentTravel.getStartTravel().getTerminalPanel();
                return null ;
            }
        }.execute();
    }

    private void destinationBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                travel.currentTravel.getEndTravel().getTerminalPanel();
                return null ;
            }
        }.execute();
    }

    private void driverBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                travel.currentTravel.getDriver().showPersonPanel();
                return null ;
            }
        }.execute();
    }

    private void dateAndCostBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                String message = "Date : " + travel.currentTravel.getTravelDate().toString() + "\n" +
                                  "Cost : " + travel.currentTravel.getCostOfTravel() + " $";
                String title = "Travel Info" ;
                ImageIcon icon = new ImageIcon("src\\icons\\calendar.png") ;
                JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,icon);
                return null ;
            }
        }.execute();
    }

    private void passengersBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                GetPassengersPanel gpp = new GetPassengersPanel() ;
                gpp.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void vehicleBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                travel.currentTravel.getTravelVehicle().showVehiclePanel();
                return null ;
            }
        }.execute();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        passengersBTN = new JButton();
        originBTN = new JButton();
        driverBTN = new JButton();
        destinationBTN = new JButton();
        dateAndCostBTN = new JButton();
        okBTN = new JButton();
        vehicleBTN = new JButton();
        travelNameLBL = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Travel Information Menu");
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
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== panel2 ========
        {
            panel2.setBackground(new Color(51, 0, 0));

            //---- passengersBTN ----
            passengersBTN.setText("Passengrs");
            passengersBTN.setBackground(new Color(0, 0, 51));
            passengersBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            passengersBTN.setForeground(Color.white);
            passengersBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            passengersBTN.setIcon(new ImageIcon(getClass().getResource("/icons/passenger.png")));
            passengersBTN.addActionListener(e -> passengersBTNActionPerformed(e));

            //---- originBTN ----
            originBTN.setText("Origin");
            originBTN.setBackground(new Color(0, 0, 51));
            originBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            originBTN.setForeground(Color.white);
            originBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            originBTN.setIcon(new ImageIcon(getClass().getResource("/icons/point.png")));
            originBTN.addActionListener(e -> originBTNActionPerformed(e));

            //---- driverBTN ----
            driverBTN.setText("Driver");
            driverBTN.setBackground(new Color(0, 0, 51));
            driverBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            driverBTN.setForeground(Color.white);
            driverBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            driverBTN.setIcon(new ImageIcon(getClass().getResource("/icons/driver.png")));
            driverBTN.addActionListener(e -> driverBTNActionPerformed(e));

            //---- destinationBTN ----
            destinationBTN.setText("Destination");
            destinationBTN.setBackground(new Color(0, 0, 51));
            destinationBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            destinationBTN.setForeground(Color.white);
            destinationBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            destinationBTN.setIcon(new ImageIcon(getClass().getResource("/icons/point.png")));
            destinationBTN.addActionListener(e -> destinationBTNActionPerformed(e));

            //---- dateAndCostBTN ----
            dateAndCostBTN.setText("Date & Cost");
            dateAndCostBTN.setBackground(new Color(0, 0, 51));
            dateAndCostBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            dateAndCostBTN.setForeground(Color.white);
            dateAndCostBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            dateAndCostBTN.setIcon(new ImageIcon(getClass().getResource("/icons/calendar.png")));
            dateAndCostBTN.addActionListener(e -> dateAndCostBTNActionPerformed(e));

            //---- okBTN ----
            okBTN.setText("Ok");
            okBTN.setForeground(Color.white);
            okBTN.setBackground(new Color(0, 40, 0));
            okBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            okBTN.setIcon(new ImageIcon(getClass().getResource("/icons/red checked.png")));
            okBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            okBTN.addActionListener(e -> okBTNActionPerformed(e));

            //---- vehicleBTN ----
            vehicleBTN.setText("Vehicle");
            vehicleBTN.setBackground(new Color(0, 0, 51));
            vehicleBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            vehicleBTN.setForeground(Color.white);
            vehicleBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            vehicleBTN.setIcon(new ImageIcon(getClass().getResource("/icons/vehicle.png")));
            vehicleBTN.addActionListener(e -> vehicleBTNActionPerformed(e));

            //---- travelNameLBL ----
            travelNameLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            travelNameLBL.setForeground(Color.white);

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(travelNameLBL, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(originBTN, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(destinationBTN, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(driverBTN, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vehicleBTN, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passengersBTN, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateAndCostBTN, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(338, 338, 338)
                                .addComponent(okBTN, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(340, Short.MAX_VALUE))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(travelNameLBL, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(originBTN, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(destinationBTN, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(driverBTN, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vehicleBTN, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(passengersBTN, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dateAndCostBTN, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(okBTN)
                        .addContainerGap(26, Short.MAX_VALUE))
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
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel2;
    private JButton passengersBTN;
    private JButton originBTN;
    private JButton driverBTN;
    private JButton destinationBTN;
    private JButton dateAndCostBTN;
    private JButton okBTN;
    private JButton vehicleBTN;
    private JLabel travelNameLBL;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
