/*
 * Created by JFormDesigner on Sat Jul 03 02:54:16 IRDT 2021
 */

package com.company.graphics.Travel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

import com.company.Buildings.terminal;
import com.company.Exceptions.fullVolumeDestination;
import com.company.Person.person;
import com.company.Vehicle.vehicle;
import com.company.city;
import com.company.country.travel;
import com.company.date ;

/**
 * @author pouria
 */
public class TravelPanel5 extends JFrame {
    public TravelPanel5()
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

    private void backBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                TravelPanel4 tp = new TravelPanel4() ;
                dispose();
                tp.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void finishBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                String day = String.valueOf((int) daySPN.getValue()) ;
                String month = String.valueOf((int) monthSPN.getValue()) ;
                String year = String.valueOf((int) yearSPN.getValue()) ;
                ArrayList<person> passengers = new ArrayList<>(travel.carryPassengers) ;

                if (passengers.size() + city.destinationCity.getNumberOfPeople() > city.destinationCity.getVolumeOfPeople())
                {
                    try {
                        throw new fullVolumeDestination("NUMBER OF PASSENGERS IS MORE THAN REMAIN OF DESTINATION CAPACITY");
                    }
                    catch (fullVolumeDestination fd){
                        JOptionPane.showMessageDialog(null,fd.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                else
                {
                    travel.carryPassengers.clear();
                    date Date = new date(day + "/" + month + "/" + year) ;
                    int cost = terminal.originTerminal.calculateCost(passengers,vehicle.travelVehicle,person.vehicleDriver) ;
                    terminal.originTerminal.newTravel(
                            terminal.originTerminal,terminal.destinationTerminal,
                            vehicle.travelVehicle,passengers ,
                            person.vehicleDriver,Date,cost);
                    String message = "New Travel was created" ;
                    String title = "New Travel" ;
                    city.originCity.updateCityBudgetOnPanel();
                    city.originCity.updateCityPanel();
                    city.destinationCity.updateCityBudgetOnPanel();
                    city.destinationCity.updateCityPanel();
                    ImageIcon icon = new ImageIcon("src\\icons\\new-document.png") ;
                    JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,icon);
                    dispose();
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
        finishBTN = new JButton();
        backBTN = new JButton();
        daySPN = new JSpinner();
        label4 = new JLabel();
        label5 = new JLabel();
        monthSPN = new JSpinner();
        label6 = new JLabel();
        yearSPN = new JSpinner();

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
            label3.setText("Set Date");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);

            //---- finishBTN ----
            finishBTN.setText("Finish");
            finishBTN.setForeground(Color.white);
            finishBTN.setBackground(new Color(0, 0, 102));
            finishBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            finishBTN.setIcon(new ImageIcon(getClass().getResource("/icons/check 2.png")));
            finishBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            finishBTN.addActionListener(e -> finishBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("Back");
            backBTN.setForeground(Color.white);
            backBTN.setBackground(new Color(0, 102, 0));
            backBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            backBTN.setIcon(new ImageIcon(getClass().getResource("/icons/sign-out.png")));
            backBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            //---- daySPN ----
            daySPN.setModel(new SpinnerNumberModel(1, 1, 30, 1));

            //---- label4 ----
            label4.setText("Day");
            label4.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label4.setForeground(Color.white);

            //---- label5 ----
            label5.setText("Month");
            label5.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label5.setForeground(Color.white);

            //---- monthSPN ----
            monthSPN.setModel(new SpinnerNumberModel(1, 1, 12, 1));

            //---- label6 ----
            label6.setText("Year");
            label6.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label6.setForeground(Color.white);

            //---- yearSPN ----
            yearSPN.setModel(new SpinnerNumberModel(1400, 1400, null, 1));

            GroupLayout selectCityPanelLayout = new GroupLayout(selectCityPanel);
            selectCityPanel.setLayout(selectCityPanelLayout);
            selectCityPanelLayout.setHorizontalGroup(
                selectCityPanelLayout.createParallelGroup()
                    .addGroup(selectCityPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(selectCityPanelLayout.createParallelGroup()
                            .addGroup(selectCityPanelLayout.createSequentialGroup()
                                .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(selectCityPanelLayout.createParallelGroup()
                                    .addComponent(daySPN, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(monthSPN, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yearSPN, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(392, Short.MAX_VALUE))
                            .addGroup(selectCityPanelLayout.createSequentialGroup()
                                .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                                .addComponent(finishBTN, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))))
            );
            selectCityPanelLayout.setVerticalGroup(
                selectCityPanelLayout.createParallelGroup()
                    .addGroup(selectCityPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addComponent(daySPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthSPN, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearSPN, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(backBTN)
                            .addComponent(finishBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
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
    private JButton finishBTN;
    private JButton backBTN;
    private JSpinner daySPN;
    private JLabel label4;
    private JLabel label5;
    private JSpinner monthSPN;
    private JLabel label6;
    private JSpinner yearSPN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
