/*
 * Created by JFormDesigner on Sun Jun 27 22:52:38 IRDT 2021
 */

package com.company.graphics.CountryFolder;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

import com.company.Buildings.Bank;
import com.company.bankery.Account;
import com.company.city;
import com.company.country.Country;
import com.company.graphics.CityFolder.AddCity;
import com.company.graphics.CityFolder.GetCitiesPanel;
import com.company.graphics.CityFolder.RemoveCityMenu;
import com.company.graphics.StartMenu;
import com.company.graphics.Travel.*;

/**
 * @author pouria
 */
public class CountryMenu extends JFrame implements Serializable
{
    public CountryMenu()
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
                catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    private void closeLBLMouseClicked(MouseEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void backBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
        new SwingWorker<>()
        {
            @Override
            public Object doInBackground()
            {
                StartMenu sm = new StartMenu() ;
                sm.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void createCityBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        AddCity ac = new AddCity() ;
        ac.setVisible(true);
    }

    private void getCityBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>()
        {
            @Override
            public Object doInBackground()
            {
                GetCitiesPanel gcp = new GetCitiesPanel() ;
                gcp.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void removeCityBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>()
        {
            @Override
            public Object doInBackground()
            {
                RemoveCityMenu rcm = new RemoveCityMenu();
                rcm.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void travelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                setOperationPanel sop = new setOperationPanel() ;
                sop.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void getTransactionsBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                GetTransactionsPanel gtp = new GetTransactionsPanel() ;
                gtp.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        closeLBL = new JLabel();
        panel2 = new JPanel();
        createCityBTN = new JButton();
        getCityBTN = new JButton();
        backBTN = new JButton();
        removeCityBTN = new JButton();
        getTransactionsBTN = new JButton();
        label2 = new JLabel();
        populationLBL = new JLabel();
        cityLBL = new JLabel();
        budgetLBL = new JLabel();
        travelBTN = new JButton();

        //======== this ========
        setUndecorated(true);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Country Menu");
            label1.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label1.setForeground(Color.white);

            //---- closeLBL ----
            closeLBL.setIcon(new ImageIcon(getClass().getResource("/icons/close.png")));
            closeLBL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            closeLBL.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    closeLBLMouseClicked(e);
                }
            });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 661, Short.MAX_VALUE)
                        .addComponent(closeLBL, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(closeLBL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
            );
        }

        //======== panel2 ========
        {
            panel2.setBackground(new Color(51, 0, 0));

            //---- createCityBTN ----
            createCityBTN.setText("Add City");
            createCityBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            createCityBTN.setForeground(Color.white);
            createCityBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            createCityBTN.setBackground(new Color(0, 0, 51));
            createCityBTN.setIcon(new ImageIcon(getClass().getResource("/icons/plus.png")));
            createCityBTN.addActionListener(e -> createCityBTNActionPerformed(e));

            //---- getCityBTN ----
            getCityBTN.setText("Get City");
            getCityBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            getCityBTN.setForeground(Color.white);
            getCityBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            getCityBTN.setBackground(new Color(0, 51, 0));
            getCityBTN.setIcon(new ImageIcon(getClass().getResource("/icons/City icon.png")));
            getCityBTN.addActionListener(e -> getCityBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("Back");
            backBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            backBTN.setForeground(Color.white);
            backBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            backBTN.setBackground(new Color(204, 51, 0));
            backBTN.setIcon(new ImageIcon(getClass().getResource("/icons/back icon.png")));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            //---- removeCityBTN ----
            removeCityBTN.setText("Remove City");
            removeCityBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            removeCityBTN.setForeground(Color.white);
            removeCityBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            removeCityBTN.setIcon(new ImageIcon(getClass().getResource("/icons/minus.png")));
            removeCityBTN.setBackground(new Color(29, 1, 29));
            removeCityBTN.addActionListener(e -> removeCityBTNActionPerformed(e));

            //---- getTransactionsBTN ----
            getTransactionsBTN.setText("Get Transactions");
            getTransactionsBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            getTransactionsBTN.setForeground(Color.white);
            getTransactionsBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            getTransactionsBTN.setBackground(new Color(0, 51, 102));
            getTransactionsBTN.setIcon(new ImageIcon(getClass().getResource("/icons/money-transfer.png")));
            getTransactionsBTN.addActionListener(e -> getTransactionsBTNActionPerformed(e));

            //---- label2 ----
            label2.setText("IRAN");
            label2.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label2.setForeground(Color.white);
            label2.setIcon(new ImageIcon(getClass().getResource("/icons/Iran flag.png")));

            //---- populationLBL ----
            populationLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            populationLBL.setForeground(Color.white);
            populationLBL.setIcon(new ImageIcon(getClass().getResource("/icons/people icon.png")));

            //---- cityLBL ----
            cityLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            cityLBL.setForeground(Color.white);
            cityLBL.setIcon(new ImageIcon(getClass().getResource("/icons/City icon.png")));

            //---- budgetLBL ----
            budgetLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            budgetLBL.setForeground(Color.white);
            budgetLBL.setIcon(new ImageIcon(getClass().getResource("/icons/money Icon.png")));

            //---- travelBTN ----
            travelBTN.setText("Travel");
            travelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            travelBTN.setForeground(Color.white);
            travelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            travelBTN.setBackground(new Color(153, 0, 0));
            travelBTN.setIcon(new ImageIcon(getClass().getResource("/icons/travel.png")));
            travelBTN.addActionListener(e -> travelBTNActionPerformed(e));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(636, Short.MAX_VALUE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(createCityBTN, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                        .addGap(91, 91, 91))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(removeCityBTN, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)))
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(travelBTN, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                        .addGap(118, 118, 118)
                                        .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(getCityBTN, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                        .addGap(115, 115, 115)
                                        .addComponent(getTransactionsBTN, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(populationLBL, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cityLBL, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(budgetLBL, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 636, Short.MAX_VALUE))))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(populationLBL, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cityLBL, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(budgetLBL, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(createCityBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(getCityBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(getTransactionsBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(removeCityBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(travelBTN))
                        .addGap(23, 23, 23))
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
                    .addGap(12, 12, 12)
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setSize(930, 480);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel closeLBL;
    private JPanel panel2;
    public JButton createCityBTN;
    public JButton getCityBTN;
    public JButton backBTN;
    public JButton removeCityBTN;
    public JButton getTransactionsBTN;
    private JLabel label2;
    public JLabel populationLBL;
    public JLabel cityLBL;
    public JLabel budgetLBL;
    public JButton travelBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
