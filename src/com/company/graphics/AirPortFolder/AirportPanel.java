/*
 * Created by JFormDesigner on Tue Jun 29 16:47:47 IRDT 2021
 */

package com.company.graphics.AirPortFolder;

import com.company.Buildings.airPort;
import com.company.city;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class AirportPanel extends JFrame {
    public AirportPanel()
    {
        initComponents();
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

    private void addVehicleBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                SelectAirVehiclePanel sav = new SelectAirVehiclePanel() ;
                sav.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void removeVehicleBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                RemoveAirVehiclePanel rav = new RemoveAirVehiclePanel() ;
                rav.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void getVehicleBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                getAirVehiclePanel gav = new getAirVehiclePanel() ;
                gav.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void addPersonnelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>() {
            @Override
            public Object doInBackground() {
                try {
                    airPort.currentAirport.checkPersonJob();
                    airPort.currentAirport.hireJob();
                    airPort.currentAirport.updateAirportPanel();
                    city.currentCity.updateCityBudgetOnPanel();
                    city.currentCity.updateCityPanel();
                    String message = "Employees & Drivers were added" ;
                    String title = "Hire Job" ;
                    ImageIcon icon = new ImageIcon("src\\icons\\hired.png");
                    JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,icon);
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                return null ;
            }
        }.execute();
    }

    private void removePersonnelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                RemoveAPPersonnel rap = new RemoveAPPersonnel() ;
                rap.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void getPersonnelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                GetPersonnelPanel gpp = new GetPersonnelPanel() ;
                gpp.setVisible(true);
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
        addVehicleBTN = new JButton();
        removeVehicleBTN = new JButton();
        addPersonnelBTN = new JButton();
        removePersonnelBTN = new JButton();
        getPersonnelBTN = new JButton();
        getVehicleBTN = new JButton();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        nameLBL = new JLabel();
        addressLBL = new JLabel();
        spaceLBL = new JLabel();
        vehicleLBL = new JLabel();
        bandsLBL = new JLabel();
        personnelsLBL = new JLabel();
        costsLBL = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Airport Menu");
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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

            //---- addVehicleBTN ----
            addVehicleBTN.setText("Add Vehicle");
            addVehicleBTN.setBackground(new Color(0, 0, 51));
            addVehicleBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            addVehicleBTN.setForeground(Color.white);
            addVehicleBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            addVehicleBTN.setIcon(new ImageIcon(getClass().getResource("/icons/plus.png")));
            addVehicleBTN.addActionListener(e -> addVehicleBTNActionPerformed(e));

            //---- removeVehicleBTN ----
            removeVehicleBTN.setText("Remove Vehicle");
            removeVehicleBTN.setBackground(new Color(0, 0, 51));
            removeVehicleBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            removeVehicleBTN.setForeground(Color.white);
            removeVehicleBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            removeVehicleBTN.setIcon(new ImageIcon(getClass().getResource("/icons/delete.png")));
            removeVehicleBTN.addActionListener(e -> removeVehicleBTNActionPerformed(e));

            //---- addPersonnelBTN ----
            addPersonnelBTN.setText("Add Personnel");
            addPersonnelBTN.setBackground(new Color(0, 0, 51));
            addPersonnelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            addPersonnelBTN.setForeground(Color.white);
            addPersonnelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            addPersonnelBTN.setIcon(new ImageIcon(getClass().getResource("/icons/add employee.jpg")));
            addPersonnelBTN.addActionListener(e -> addPersonnelBTNActionPerformed(e));

            //---- removePersonnelBTN ----
            removePersonnelBTN.setText("Remove Personnel");
            removePersonnelBTN.setBackground(new Color(0, 0, 51));
            removePersonnelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            removePersonnelBTN.setForeground(Color.white);
            removePersonnelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            removePersonnelBTN.setIcon(new ImageIcon(getClass().getResource("/icons/remove emplyee.png")));
            removePersonnelBTN.addActionListener(e -> removePersonnelBTNActionPerformed(e));

            //---- getPersonnelBTN ----
            getPersonnelBTN.setText("Get Personnels");
            getPersonnelBTN.setBackground(new Color(0, 0, 51));
            getPersonnelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            getPersonnelBTN.setForeground(Color.white);
            getPersonnelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            getPersonnelBTN.setIcon(new ImageIcon(getClass().getResource("/icons/contact-list.png")));
            getPersonnelBTN.addActionListener(e -> getPersonnelBTNActionPerformed(e));

            //---- getVehicleBTN ----
            getVehicleBTN.setText("Get Vehicles");
            getVehicleBTN.setBackground(new Color(0, 0, 51));
            getVehicleBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            getVehicleBTN.setForeground(Color.white);
            getVehicleBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            getVehicleBTN.setIcon(new ImageIcon(getClass().getResource("/icons/airplane.png")));
            getVehicleBTN.addActionListener(e -> getVehicleBTNActionPerformed(e));

            //---- label3 ----
            label3.setText("Name");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);
            label3.setIcon(new ImageIcon(getClass().getResource("/icons/airport.png")));

            //---- label4 ----
            label4.setText("Address");
            label4.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label4.setForeground(Color.white);
            label4.setIcon(new ImageIcon(getClass().getResource("/icons/address.png")));

            //---- label5 ----
            label5.setText("Space");
            label5.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label5.setForeground(Color.white);
            label5.setIcon(new ImageIcon(getClass().getResource("/icons/volume.png")));

            //---- label6 ----
            label6.setText("Vehicles");
            label6.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label6.setForeground(Color.white);
            label6.setIcon(new ImageIcon(getClass().getResource("/icons/airplane.png")));

            //---- label7 ----
            label7.setText("Bands");
            label7.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label7.setForeground(Color.white);
            label7.setIcon(new ImageIcon(getClass().getResource("/icons/road.png")));

            //---- label8 ----
            label8.setText("Personnels");
            label8.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label8.setForeground(Color.white);
            label8.setIcon(new ImageIcon(getClass().getResource("/icons/personnel.png")));

            //---- label9 ----
            label9.setText("Costs");
            label9.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label9.setForeground(Color.white);
            label9.setIcon(new ImageIcon(getClass().getResource("/icons/budget (1).png")));

            //---- nameLBL ----
            nameLBL.setText("text");
            nameLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            nameLBL.setForeground(Color.white);

            //---- addressLBL ----
            addressLBL.setText("text");
            addressLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            addressLBL.setForeground(Color.white);

            //---- spaceLBL ----
            spaceLBL.setText("text");
            spaceLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            spaceLBL.setForeground(Color.white);

            //---- vehicleLBL ----
            vehicleLBL.setText("text");
            vehicleLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            vehicleLBL.setForeground(Color.white);

            //---- bandsLBL ----
            bandsLBL.setText("text");
            bandsLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            bandsLBL.setForeground(Color.white);

            //---- personnelsLBL ----
            personnelsLBL.setText("text");
            personnelsLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            personnelsLBL.setForeground(Color.white);

            //---- costsLBL ----
            costsLBL.setText("text");
            costsLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            costsLBL.setForeground(Color.white);

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label3, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(label4, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(label5, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(label6, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(label7, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(label8, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(label9, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(nameLBL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGroup(panel2Layout.createParallelGroup()
                                            .addComponent(addressLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spaceLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(vehicleLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bandsLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(personnelsLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(costsLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(addVehicleBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(removeVehicleBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                                .addGap(81, 81, 81)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(removePersonnelBTN)
                                    .addComponent(addPersonnelBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(91, 91, 91)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(getVehicleBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                            .addComponent(getPersonnelBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLBL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(spaceLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(vehicleLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(bandsLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(personnelsLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(costsLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(addVehicleBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(getVehicleBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(addPersonnelBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(removeVehicleBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(getPersonnelBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(removePersonnelBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
    private JButton addVehicleBTN;
    private JButton removeVehicleBTN;
    private JButton addPersonnelBTN;
    private JButton removePersonnelBTN;
    private JButton getPersonnelBTN;
    private JButton getVehicleBTN;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    public JLabel nameLBL;
    public JLabel addressLBL;
    public JLabel spaceLBL;
    public JLabel vehicleLBL;
    public JLabel bandsLBL;
    public JLabel personnelsLBL;
    public JLabel costsLBL;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
