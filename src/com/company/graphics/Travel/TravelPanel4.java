/*
 * Created by JFormDesigner on Sat Jul 03 01:51:54 IRDT 2021
 */

package com.company.graphics.Travel;

import com.company.Exceptions.volumePassenger;
import com.company.Vehicle.vehicle;
import com.company.city;
import com.company.country.travel;
import com.company.Person.person ;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class TravelPanel4 extends JFrame {
    public TravelPanel4()
    {
        initComponents();
        numberOfPassengersLBL.setText(String.valueOf(travel.carryPassengers.size()));
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
        travel.carryPassengers.clear();
        dispose();
    }

    private void backBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                TravelPanel3 tp = new TravelPanel3() ;
                dispose();
                tp.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void manuallyBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                AddManuallyPassengers amp = new AddManuallyPassengers() ;
                amp.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void automaticallyBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                AddAutomaticallyPassengers aap = new AddAutomaticallyPassengers() ;
                aap.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void nextBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {

                if (travel.carryPassengers.size() < vehicle.travelVehicle.getVolume() / 2)
                {
                    try{
                        throw new volumePassenger("NUMBER OF PASSENGERS IS LESS THAN HALF OF VOLUME OF VEHICLE") ;
                    }
                    catch (volumePassenger vp){
                        JOptionPane.showMessageDialog(null,vp.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

                else if (travel.carryPassengers.size() > vehicle.travelVehicle.getVolume())
                {
                    try {
                        throw new volumePassenger("NUMBER OF PASSENGERS IS MORE THAN VOLUME OF VEHICLE") ;
                    }
                    catch (volumePassenger vp){
                        JOptionPane.showMessageDialog(null,vp.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

                else {
                    TravelPanel5 tp = new TravelPanel5() ;
                    dispose();
                    tp.setVisible(true);
                }
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
        nextBTN = new JButton();
        backBTN = new JButton();
        manuallyBTN = new JButton();
        automaticallyBTN = new JButton();
        label4 = new JLabel();
        numberOfPassengersLBL = new JLabel();

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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 425, Short.MAX_VALUE)
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
            label3.setText("Set Passengers");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);

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

            //---- manuallyBTN ----
            manuallyBTN.setText("Add Manually");
            manuallyBTN.setForeground(Color.white);
            manuallyBTN.setBackground(new Color(0, 0, 102));
            manuallyBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            manuallyBTN.setIcon(new ImageIcon(getClass().getResource("/icons/hammer.png")));
            manuallyBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            manuallyBTN.addActionListener(e -> manuallyBTNActionPerformed(e));

            //---- automaticallyBTN ----
            automaticallyBTN.setText("Add Automatically");
            automaticallyBTN.setForeground(Color.white);
            automaticallyBTN.setBackground(new Color(102, 0, 0));
            automaticallyBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            automaticallyBTN.setIcon(new ImageIcon(getClass().getResource("/icons/automatic-flash.png")));
            automaticallyBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            automaticallyBTN.addActionListener(e -> automaticallyBTNActionPerformed(e));

            //---- label4 ----
            label4.setText("Number Of Passengs");
            label4.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label4.setForeground(Color.white);

            //---- numberOfPassengersLBL ----
            numberOfPassengersLBL.setText("0");
            numberOfPassengersLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            numberOfPassengersLBL.setForeground(Color.white);

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
                                .addComponent(nextBTN, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGroup(selectCityPanelLayout.createSequentialGroup()
                                .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(automaticallyBTN, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                    .addComponent(label3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(manuallyBTN, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addGroup(selectCityPanelLayout.createParallelGroup()
                                    .addComponent(label4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(GroupLayout.Alignment.TRAILING, selectCityPanelLayout.createSequentialGroup()
                                        .addComponent(numberOfPassengersLBL, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)))))
                        .addGap(51, 51, 51))
            );
            selectCityPanelLayout.setVerticalGroup(
                selectCityPanelLayout.createParallelGroup()
                    .addGroup(selectCityPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(selectCityPanelLayout.createParallelGroup()
                            .addGroup(selectCityPanelLayout.createSequentialGroup()
                                .addComponent(manuallyBTN)
                                .addGap(25, 25, 25)
                                .addComponent(automaticallyBTN)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(backBTN)
                                    .addComponent(nextBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))
                            .addGroup(selectCityPanelLayout.createSequentialGroup()
                                .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numberOfPassengersLBL)
                                .addContainerGap(174, Short.MAX_VALUE))))
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
                    .addGap(18, 18, 18)
                    .addComponent(selectCityPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private JButton nextBTN;
    private JButton backBTN;
    private JButton manuallyBTN;
    private JButton automaticallyBTN;
    private JLabel label4;
    public static JLabel numberOfPassengersLBL;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
