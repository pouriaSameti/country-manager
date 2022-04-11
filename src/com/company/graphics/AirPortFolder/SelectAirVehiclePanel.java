/*
 * Created by JFormDesigner on Tue Jun 29 23:52:46 IRDT 2021
 */

package com.company.graphics.AirPortFolder;

import com.company.graphics.AirPortFolder.CreateAirplanePanel;
import com.company.graphics.AirPortFolder.CreateCargoPlanePanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class SelectAirVehiclePanel extends JFrame {
    public SelectAirVehiclePanel()
    {
        initComponents();
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            if (info.getName().equals("Nimbus")) {
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

    private void airplaneCreateBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                CreateAirplanePanel cap = new CreateAirplanePanel() ;
                cap.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void cargoplaneBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                CreateCargoPlanePanel ccp = new CreateCargoPlanePanel() ;
                ccp.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void closeBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        airplaneCreateBTN = new JButton();
        cargoplaneBTN = new JButton();
        closeBTN = new JButton();

        //======== this ========
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Air Vehicle Selection  Menu");
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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 565, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label1)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
            );
        }

        //======== panel2 ========
        {
            panel2.setBackground(new Color(51, 0, 0));

            //---- airplaneCreateBTN ----
            airplaneCreateBTN.setText("Airplane");
            airplaneCreateBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            airplaneCreateBTN.setForeground(Color.white);
            airplaneCreateBTN.setIcon(new ImageIcon(getClass().getResource("/icons/airplane.png")));
            airplaneCreateBTN.setBackground(new Color(51, 0, 102));
            airplaneCreateBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            airplaneCreateBTN.addActionListener(e -> airplaneCreateBTNActionPerformed(e));

            //---- cargoplaneBTN ----
            cargoplaneBTN.setText("Cargo plane");
            cargoplaneBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            cargoplaneBTN.setForeground(Color.white);
            cargoplaneBTN.setIcon(new ImageIcon(getClass().getResource("/icons/cargo plane.png")));
            cargoplaneBTN.setBackground(new Color(51, 51, 0));
            cargoplaneBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            cargoplaneBTN.addActionListener(e -> cargoplaneBTNActionPerformed(e));

            //---- closeBTN ----
            closeBTN.setText("Close");
            closeBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            closeBTN.setForeground(Color.white);
            closeBTN.setIcon(new ImageIcon(getClass().getResource("/icons/close.png")));
            closeBTN.setBackground(new Color(0, 30, 30));
            closeBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            closeBTN.addActionListener(e -> closeBTNActionPerformed(e));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap(371, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(airplaneCreateBTN, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cargoplaneBTN, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                            .addComponent(closeBTN, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGap(367, 367, 367))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(airplaneCreateBTN, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(cargoplaneBTN, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(closeBTN, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(86, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JButton airplaneCreateBTN;
    private JButton cargoplaneBTN;
    private JButton closeBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
