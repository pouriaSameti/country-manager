/*
 * Created by JFormDesigner on Sat Jul 03 03:08:59 IRDT 2021
 */

package com.company.graphics.Travel;

import com.company.Person.person;
import com.company.Vehicle.vehicle;
import com.company.city;
import com.company.country.travel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class AddAutomaticallyPassengers extends JFrame {
    public AddAutomaticallyPassengers()
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

    private void addBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                int passengersNumber = (int) numberSPN.getValue() ;
                int index = 0 ;
                int counter = 0 ;
                while(counter < passengersNumber)
                {
                    person passenger = city.originCity.getAllPeople().get(index) ;
                    if (! passenger.getEmploymentStatus())
                    {
                        travel.carryPassengers.add(passenger) ;
                        TravelPanel4.numberOfPassengersLBL.setText(String.valueOf(travel.carryPassengers.size()));
                        ++index ;
                        ++counter ;
                    }

                    if (passenger.getEmploymentStatus())
                    {
                        ++index ;
                    }
                }
                String message = "Passengers were Added" ;
                String title = "Add Passenger" ;
                ImageIcon icon = new ImageIcon("src\\icons\\passenger.png") ;
                JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,icon);
                dispose();
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
        addBTN = new JButton();
        numberSPN = new JSpinner();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Add Manually Passengers Menu");
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
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
            );
        }

        //======== selectCityPanel ========
        {
            selectCityPanel.setBackground(new Color(51, 0, 0));

            //---- label3 ----
            label3.setText("Set Number");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);

            //---- addBTN ----
            addBTN.setText("Add");
            addBTN.setForeground(Color.white);
            addBTN.setBackground(new Color(0, 56, 0));
            addBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            addBTN.setIcon(new ImageIcon(getClass().getResource("/icons/yellow plus.png")));
            addBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            addBTN.addActionListener(e -> addBTNActionPerformed(e));

            //---- numberSPN ----
            numberSPN.setModel(new SpinnerNumberModel(1, 1, null, 1));

            GroupLayout selectCityPanelLayout = new GroupLayout(selectCityPanel);
            selectCityPanel.setLayout(selectCityPanelLayout);
            selectCityPanelLayout.setHorizontalGroup(
                selectCityPanelLayout.createParallelGroup()
                    .addGroup(selectCityPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(selectCityPanelLayout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(numberSPN, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                            .addComponent(addBTN, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(207, Short.MAX_VALUE))
            );
            selectCityPanelLayout.setVerticalGroup(
                selectCityPanelLayout.createParallelGroup()
                    .addGroup(selectCityPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberSPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                        .addComponent(addBTN)
                        .addGap(23, 23, 23))
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
    private JButton addBTN;
    private JSpinner numberSPN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
