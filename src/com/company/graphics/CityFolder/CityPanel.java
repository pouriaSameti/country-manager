/*
 * Created by JFormDesigner on Mon Jun 28 02:37:18 IRDT 2021
 */

package com.company.graphics.CityFolder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class CityPanel extends JFrame {
    public CityPanel()
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

    private void addBuildingBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                CreateBuildingMenu cbm = new CreateBuildingMenu() ;
                cbm.setVisible(true);
                return null ;
            }

        }.execute();
    }

    private void getCityBuildingBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                GetBuildingMenu gbm = new GetBuildingMenu() ;
                gbm.setVisible(true);
                return null ;
            }

        }.execute();

    }

    private void removeBuildingBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                BuildingRemoveMenu brm = new BuildingRemoveMenu() ;
                brm.setVisible(true);
                return null ;
            }

        }.execute();
    }

    private void addPeopleBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                SelectTypeOfAddPeoplePanel sto = new SelectTypeOfAddPeoplePanel() ;
                sto.setVisible(true);
                return null ;
            }

        }.execute();
    }

    private void removePeopleBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                GetDeletePeoplePanel gdp = new GetDeletePeoplePanel() ;
                gdp.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void getPeopleBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                GetPeoplePanel gpp = new GetPeoplePanel() ;
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
        addPeopleBTN = new JButton();
        addBuildingBTN = new JButton();
        getCityBuildingBTN = new JButton();
        removePeopleBTN = new JButton();
        removeBuildingBTN = new JButton();
        cityNameLBL = new JLabel();
        populationLBL = new JLabel();
        vehiclesLBL = new JLabel();
        buildingsLBL = new JLabel();
        budjetLBL = new JLabel();
        getPeopleBTN = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("City Menu");
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
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 711, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
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

            //---- addPeopleBTN ----
            addPeopleBTN.setText("Add People");
            addPeopleBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            addPeopleBTN.setForeground(Color.white);
            addPeopleBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            addPeopleBTN.setBackground(new Color(0, 0, 51));
            addPeopleBTN.setIcon(new ImageIcon(getClass().getResource("/icons/add-user.png")));
            addPeopleBTN.addActionListener(e -> addPeopleBTNActionPerformed(e));

            //---- addBuildingBTN ----
            addBuildingBTN.setText("Add Building");
            addBuildingBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            addBuildingBTN.setForeground(Color.white);
            addBuildingBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            addBuildingBTN.setIcon(new ImageIcon(getClass().getResource("/icons/add building.png")));
            addBuildingBTN.setBackground(new Color(0, 51, 0));
            addBuildingBTN.addActionListener(e -> addBuildingBTNActionPerformed(e));

            //---- getCityBuildingBTN ----
            getCityBuildingBTN.setText("Get Buildings");
            getCityBuildingBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            getCityBuildingBTN.setForeground(Color.white);
            getCityBuildingBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            getCityBuildingBTN.setBackground(new Color(23, 0, 23));
            getCityBuildingBTN.setIcon(new ImageIcon(getClass().getResource("/icons/building.png")));
            getCityBuildingBTN.addActionListener(e -> getCityBuildingBTNActionPerformed(e));

            //---- removePeopleBTN ----
            removePeopleBTN.setText("Remove People");
            removePeopleBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            removePeopleBTN.setForeground(Color.white);
            removePeopleBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            removePeopleBTN.setBackground(new Color(102, 0, 0));
            removePeopleBTN.setIcon(new ImageIcon(getClass().getResource("/icons/remove-friend.png")));
            removePeopleBTN.addActionListener(e -> removePeopleBTNActionPerformed(e));

            //---- removeBuildingBTN ----
            removeBuildingBTN.setText("Remove Building");
            removeBuildingBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            removeBuildingBTN.setForeground(Color.white);
            removeBuildingBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            removeBuildingBTN.setIcon(new ImageIcon(getClass().getResource("/icons/remove building.png")));
            removeBuildingBTN.setBackground(new Color(0, 51, 51));
            removeBuildingBTN.addActionListener(e -> removeBuildingBTNActionPerformed(e));

            //---- cityNameLBL ----
            cityNameLBL.setText("City Name : ");
            cityNameLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            cityNameLBL.setForeground(Color.white);
            cityNameLBL.setIcon(new ImageIcon(getClass().getResource("/icons/City icon.png")));

            //---- populationLBL ----
            populationLBL.setText("Population :");
            populationLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            populationLBL.setForeground(Color.white);
            populationLBL.setIcon(new ImageIcon(getClass().getResource("/icons/population.png")));

            //---- vehiclesLBL ----
            vehiclesLBL.setText("Vehicles :");
            vehiclesLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            vehiclesLBL.setForeground(Color.white);
            vehiclesLBL.setIcon(new ImageIcon(getClass().getResource("/icons/vehicle.png")));

            //---- buildingsLBL ----
            buildingsLBL.setText("Buildings :");
            buildingsLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            buildingsLBL.setForeground(Color.white);
            buildingsLBL.setIcon(new ImageIcon(getClass().getResource("/icons/architecture-and-city Icon.png")));

            //---- budjetLBL ----
            budjetLBL.setText("Budget :");
            budjetLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            budjetLBL.setForeground(Color.white);
            budjetLBL.setIcon(new ImageIcon(getClass().getResource("/icons/dollar.png")));

            //---- getPeopleBTN ----
            getPeopleBTN.setText("Get People");
            getPeopleBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            getPeopleBTN.setForeground(Color.white);
            getPeopleBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            getPeopleBTN.setBackground(new Color(20, 17, 10));
            getPeopleBTN.setIcon(new ImageIcon(getClass().getResource("/icons/contact-list.png")));
            getPeopleBTN.addActionListener(e -> getPeopleBTNActionPerformed(e));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(removePeopleBTN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(addPeopleBTN, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(82, 82, 82)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(removeBuildingBTN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(addBuildingBTN, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(getCityBuildingBTN, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(getPeopleBTN, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(38, Short.MAX_VALUE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(cityNameLBL, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(499, Short.MAX_VALUE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(populationLBL, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vehiclesLBL, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buildingsLBL, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(budjetLBL, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 499, Short.MAX_VALUE))))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cityNameLBL, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(populationLBL, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehiclesLBL, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buildingsLBL, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(budjetLBL, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(addPeopleBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBuildingBTN)
                            .addComponent(getCityBuildingBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(removePeopleBTN)
                            .addComponent(removeBuildingBTN)
                            .addComponent(getPeopleBTN))
                        .addGap(24, 24, 24))
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
    private JButton addPeopleBTN;
    private JButton addBuildingBTN;
    private JButton getCityBuildingBTN;
    private JButton removePeopleBTN;
    private JButton removeBuildingBTN;
    public JLabel cityNameLBL;
    public JLabel populationLBL;
    public JLabel vehiclesLBL;
    public JLabel buildingsLBL;
    public JLabel budjetLBL;
    private JButton getPeopleBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
