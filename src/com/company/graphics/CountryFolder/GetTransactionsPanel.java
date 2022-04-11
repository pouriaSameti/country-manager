/*
 * Created by JFormDesigner on Sun Jul 04 01:16:11 IRDT 2021
 */

package com.company.graphics.CountryFolder;

import com.company.Buildings.Bank;
import com.company.bankery.Account;
import com.company.city;
import com.company.country.Country;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class GetTransactionsPanel extends JFrame {
    public GetTransactionsPanel()
    {
        initComponents();
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            if (info.getName().equals("Nimbus"))
            {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.invokeLater(() -> SwingUtilities.updateComponentTreeUI(getRootPane()));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }

        for (city c : Country.getCountry().getCities())
            for (Bank B : c.getAllBank())
            {
                B.setShow(true);
                ArrayList<Account> accounts = new ArrayList<>(B.getAllAccounts().values()) ;
                accounts.forEach(account -> account.setShow(true));
            }
    }

    private void label2MouseClicked(MouseEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {

                for (city c : Country.getCountry().getCities())
                    for (Bank B : c.getAllBank())
                    {
                        B.setShow(false);
                        ArrayList<Account> accounts = new ArrayList<>(B.getAllAccounts().values()) ;
                        accounts.forEach(account -> account.setShow(false));
                    }
                dispose();
                return null ;
            }
        }.execute();
    }

    private void closeBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                for (city c : Country.getCountry().getCities())
                    for (Bank B : c.getAllBank())
                    {
                        B.setShow(false);
                        ArrayList<Account> accounts = new ArrayList<>(B.getAllAccounts().values()) ;
                        accounts.forEach(account -> account.setShow(false));
                    }
                dispose();
                return null ;
            }
        }.execute();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel3 = new JPanel();
        label8 = new JLabel();
        label11 = new JLabel();
        panel4 = new JPanel();
        closeBTN = new JButton();
        scrollPane1 = new JScrollPane();
        transactionTXA = new JTextArea();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel3 ========
        {
            panel3.setBackground(new Color(0, 51, 51));

            //---- label8 ----
            label8.setText("Get Transactions");
            label8.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label8.setForeground(Color.white);

            //---- label11 ----
            label11.setIcon(new ImageIcon(getClass().getResource("/icons/close.png")));
            label11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label11.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label2MouseClicked(e);
                }
            });

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 550, Short.MAX_VALUE)
                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel3Layout.createParallelGroup()
                            .addComponent(label11, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== panel4 ========
        {
            panel4.setBackground(new Color(51, 0, 0));

            //---- closeBTN ----
            closeBTN.setText("Close");
            closeBTN.setBackground(new Color(0, 30, 30));
            closeBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            closeBTN.setForeground(Color.white);
            closeBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            closeBTN.setIcon(new ImageIcon(getClass().getResource("/icons/close.png")));
            closeBTN.addActionListener(e -> closeBTNActionPerformed(e));

            //======== scrollPane1 ========
            {

                //---- transactionTXA ----
                transactionTXA.setBackground(new Color(0, 0, 51));
                transactionTXA.setForeground(Color.white);
                transactionTXA.setFont(new Font("Myanmar Text", Font.PLAIN, 18));
                scrollPane1.setViewportView(transactionTXA);
            }

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                        .addContainerGap(348, Short.MAX_VALUE)
                        .addComponent(closeBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                        .addGap(345, 345, 345))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 810, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(56, Short.MAX_VALUE))
            );
            panel4Layout.setVerticalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeBTN)
                        .addGap(15, 15, 15))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setSize(925, 500);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel3;
    private JLabel label8;
    private JLabel label11;
    private JPanel panel4;
    private JButton closeBTN;
    private JScrollPane scrollPane1;
    public static JTextArea transactionTXA;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
