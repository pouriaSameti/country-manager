/*
 * Created by JFormDesigner on Wed Jun 30 02:51:48 IRDT 2021
 */

package com.company.graphics.TrainStationFolder;
import com.company.Buildings.trainStation;
import com.company.Vehicle.train;
import com.company.Vehicle.train.service ;
import com.company.country.Country;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class CreateTrainMenu extends JFrame {
    public CreateTrainMenu()
    {

        initComponents();
        String [] colors = {"Blue", "Green", "Red", "Black", "White", "Orange"} ;
        for (String color : colors)
            setColorCMB.addItem(color);
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

    private void saveBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                if (nameTXT.getText().isEmpty())
                {
                    String message = "Name is Empty" ;
                    JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
                }

                else
                {
                    try {
                        String name = nameTXT.getText() ;
                        String color = (String) setColorCMB.getSelectedItem() ;
                        int wagons = (int) setWagonSPN.getValue() ;
                        int star = (int) setStarSPN.getValue() ;
                        train t = new train(name,wagons,color,star) ;
                        if (restaurantCHB.isSelected())
                            t.addService(service.restaurant);
                        if (wcCHB.isSelected())
                            t.addService(service.WC);
                        if (airConditionerCHB.isSelected())
                            t.addService(service.AirConditioner);
                        if (sleepServiceCHB.isSelected())
                            t.addService(service.sleepService);
                        trainStation.currentTrainStation.addVehicle(t);
                        String message = t.getName() + " was created" ;
                        String title = "Create Train" ;
                        ImageIcon icon = new ImageIcon("src\\icons\\train.png") ;
                        JOptionPane.showMessageDialog(null,message,title,JOptionPane.ERROR_MESSAGE,icon);
                        trainStation.currentTrainStation.updateTrainStationPanel();
                        trainStation.currentTrainStation.getCity().setFinallyBudget();
                        trainStation.currentTrainStation.getCity().updateCityPanel();
                        Country.getCountry().updateCountryInfo();
                        dispose();
                    }
                    catch (Exception e){
                        JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        dispose();
                    }
                }
                return null ;
            }
        }.execute();
    }

    private void cancelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        nameTXT.setText("");
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        saveBTN = new JButton();
        cancelBTN = new JButton();
        label3 = new JLabel();
        nameTXT = new JTextField();
        setWagonSPN = new JSpinner();
        label6 = new JLabel();
        label7 = new JLabel();
        setColorCMB = new JComboBox();
        label8 = new JLabel();
        setStarSPN = new JSpinner();
        restaurantCHB = new JCheckBox();
        label9 = new JLabel();
        wcCHB = new JCheckBox();
        airConditionerCHB = new JCheckBox();
        sleepServiceCHB = new JCheckBox();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();

        //======== this ========
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Create Train Menu");
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
                        .addGap(28, 28, 28))
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

            //---- saveBTN ----
            saveBTN.setText("Save");
            saveBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            saveBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            saveBTN.setForeground(Color.white);
            saveBTN.setBackground(new Color(0, 0, 51));
            saveBTN.addActionListener(e -> saveBTNActionPerformed(e));

            //---- cancelBTN ----
            cancelBTN.setText("Cancel");
            cancelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            cancelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            cancelBTN.setForeground(Color.white);
            cancelBTN.setBackground(new Color(102, 0, 0));
            cancelBTN.addActionListener(e -> cancelBTNActionPerformed(e));

            //---- label3 ----
            label3.setText("Name");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);

            //---- setWagonSPN ----
            setWagonSPN.setModel(new SpinnerNumberModel(1, 1, 9, 1));
            setWagonSPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- label6 ----
            label6.setText("Wagons");
            label6.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label6.setForeground(Color.white);

            //---- label7 ----
            label7.setText("Color");
            label7.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label7.setForeground(Color.white);

            //---- label8 ----
            label8.setText("Star");
            label8.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label8.setForeground(Color.white);

            //---- setStarSPN ----
            setStarSPN.setModel(new SpinnerNumberModel(1, 1, 5, 1));
            setStarSPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- restaurantCHB ----
            restaurantCHB.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            restaurantCHB.setForeground(Color.white);
            restaurantCHB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            restaurantCHB.setContentAreaFilled(false);

            //---- label9 ----
            label9.setText("Services");
            label9.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label9.setForeground(Color.white);

            //---- wcCHB ----
            wcCHB.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            wcCHB.setForeground(Color.white);

            //---- airConditionerCHB ----
            airConditionerCHB.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            airConditionerCHB.setForeground(Color.white);

            //---- sleepServiceCHB ----
            sleepServiceCHB.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            sleepServiceCHB.setForeground(Color.white);

            //---- label10 ----
            label10.setText("Restaurant");
            label10.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label10.setForeground(Color.white);
            label10.setIcon(new ImageIcon(getClass().getResource("/icons/restaurant.png")));

            //---- label11 ----
            label11.setText("WC");
            label11.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label11.setForeground(Color.white);
            label11.setIcon(new ImageIcon(getClass().getResource("/icons/WC.png")));

            //---- label12 ----
            label12.setText("Air Conditioner");
            label12.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label12.setForeground(Color.white);
            label12.setIcon(new ImageIcon(getClass().getResource("/icons/air conditioner.png")));

            //---- label13 ----
            label13.setText("Sleep Service");
            label13.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label13.setForeground(Color.white);
            label13.setIcon(new ImageIcon(getClass().getResource("/icons/sleep.png")));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nameTXT)
                                        .addGap(123, 123, 123))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(setWagonSPN))
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(setColorCMB, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
                                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel2Layout.createParallelGroup()
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addComponent(restaurantCHB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                .addGap(78, 78, 78)
                                                .addComponent(wcCHB)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label11, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                .addGap(76, 76, 76)
                                                .addComponent(airConditionerCHB)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addComponent(sleepServiceCHB)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label13)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(setStarSPN, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
                                        .addComponent(saveBTN, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cancelBTN, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)))
                                .addGap(110, 110, 110))))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTXT, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addComponent(setColorCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addComponent(setWagonSPN, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addComponent(setStarSPN, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label9, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label10, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label11, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(wcCHB))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(airConditionerCHB))
                                    .addComponent(label12, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(restaurantCHB)))
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(sleepServiceCHB))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(label13, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(saveBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
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
    private JButton saveBTN;
    private JButton cancelBTN;
    private JLabel label3;
    private JTextField nameTXT;
    private JSpinner setWagonSPN;
    private JLabel label6;
    private JLabel label7;
    private JComboBox setColorCMB;
    private JLabel label8;
    private JSpinner setStarSPN;
    private JCheckBox restaurantCHB;
    private JLabel label9;
    private JCheckBox wcCHB;
    private JCheckBox airConditionerCHB;
    private JCheckBox sleepServiceCHB;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
