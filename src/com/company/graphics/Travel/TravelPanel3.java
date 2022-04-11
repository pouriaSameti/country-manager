/*
 * Created by JFormDesigner on Sat Jul 03 01:23:48 IRDT 2021
 */

package com.company.graphics.Travel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import com.company.Buildings.terminal;
import com.company.Person.person ;
import com.company.Vehicle.* ;

/**
 * @author pouria
 */
public class TravelPanel3 extends JFrame {
    public TravelPanel3()
    {
        initComponents();
        for (vehicle v : terminal.originTerminal.getVehicleList())
            vehicleCMB.addItem(v);
        for (person p : terminal.originTerminal.getVehicleLeader())
            driversCMB.addItem(p);
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


    private void backBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                TravelPanel2 tp = new TravelPanel2() ;
                dispose();
                tp.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void vehicleBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                vehicle v = (vehicle) vehicleCMB.getSelectedItem() ;
                v.showVehiclePanel();
                return null ;
            }
        }.execute();
    }

    private void driverBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                person p = (person) driversCMB.getSelectedItem() ;
                p.showPersonPanel();
                return null ;
            }
        }.execute();
    }

    private void nextBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                vehicle.travelVehicle = (vehicle) vehicleCMB.getSelectedItem() ;
                person.vehicleDriver = (person) driversCMB.getSelectedItem() ;
                TravelPanel4 tp = new TravelPanel4() ;
                dispose();
                tp.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        selectCityPanel = new JPanel();
        label3 = new JLabel();
        vehicleCMB = new JComboBox();
        vehicleBTN = new JButton();
        label5 = new JLabel();
        driversCMB = new JComboBox();
        driverBTN = new JButton();
        nextBTN = new JButton();
        backBTN = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Travel Menu");
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
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
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

        //======== selectCityPanel ========
        {
            selectCityPanel.setBackground(new Color(51, 0, 0));

            //---- label3 ----
            label3.setText("Vehicle ");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);

            //---- vehicleCMB ----
            vehicleCMB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- vehicleBTN ----
            vehicleBTN.setText("Info");
            vehicleBTN.setForeground(Color.white);
            vehicleBTN.setBackground(new Color(0, 0, 102));
            vehicleBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            vehicleBTN.addActionListener(e -> vehicleBTNActionPerformed(e));

            //---- label5 ----
            label5.setText("Drivers");
            label5.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label5.setForeground(Color.white);

            //---- driversCMB ----
            driversCMB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- driverBTN ----
            driverBTN.setText("Info");
            driverBTN.setForeground(Color.white);
            driverBTN.setBackground(new Color(0, 0, 102));
            driverBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            driverBTN.addActionListener(e -> driverBTNActionPerformed(e));

            //---- nextBTN ----
            nextBTN.setText("Next");
            nextBTN.setForeground(Color.white);
            nextBTN.setBackground(new Color(153, 38, 0));
            nextBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            nextBTN.setIcon(new ImageIcon(getClass().getResource("/icons/enter.png")));
            nextBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            nextBTN.addActionListener(e -> nextBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("Back");
            backBTN.setForeground(Color.white);
            backBTN.setBackground(new Color(0, 102, 0));
            backBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            backBTN.setIcon(new ImageIcon(getClass().getResource("/icons/sign-out.png")));
            backBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            GroupLayout selectCityPanelLayout = new GroupLayout(selectCityPanel);
            selectCityPanel.setLayout(selectCityPanelLayout);
            selectCityPanelLayout.setHorizontalGroup(
                selectCityPanelLayout.createParallelGroup()
                    .addGroup(selectCityPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(selectCityPanelLayout.createParallelGroup()
                            .addGroup(selectCityPanelLayout.createSequentialGroup()
                                .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                                .addComponent(nextBTN, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
                            .addGroup(selectCityPanelLayout.createSequentialGroup()
                                .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(driverBTN, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(selectCityPanelLayout.createSequentialGroup()
                                            .addComponent(label5)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(driversCMB, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(vehicleBTN, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(selectCityPanelLayout.createSequentialGroup()
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(vehicleCMB, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(270, Short.MAX_VALUE))))
            );
            selectCityPanelLayout.setVerticalGroup(
                selectCityPanelLayout.createParallelGroup()
                    .addGroup(selectCityPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addComponent(vehicleCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicleBTN)
                        .addGap(34, 34, 34)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addComponent(driversCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(driverBTN)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(backBTN)
                            .addComponent(nextBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectCityPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                    .addComponent(selectCityPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        setSize(650, 410);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel selectCityPanel;
    private JLabel label3;
    private JComboBox vehicleCMB;
    private JButton vehicleBTN;
    private JLabel label5;
    private JComboBox driversCMB;
    private JButton driverBTN;
    private JButton nextBTN;
    private JButton backBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
