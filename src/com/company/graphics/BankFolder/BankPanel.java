/*
 * Created by JFormDesigner on Sat Jul 03 17:57:44 IRDT 2021
 */

package com.company.graphics.BankFolder;

import com.company.Buildings.Bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class BankPanel extends JFrame {
    public BankPanel()
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
    }

    private void label2MouseClicked(MouseEvent e) {
        // TODO add your code here
        dispose();
    }

    private void addAccountBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                AddAccount aa = new AddAccount() ;
                aa.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void addPersonnelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                Bank.currentBank.hireJob();
                Bank.currentBank.updateBankPanel();
                Bank.currentBank.getCity().setFinallyBudget();
                Bank.currentBank.getCity().updateCityBudgetOnPanel();
                Bank.currentBank.getCity().updateCityPanel();
                String message = "Personnel were Added" ;
                String title = "Add Personnel" ;
                ImageIcon icon = new ImageIcon("src\\icons\\hired.png") ;
                JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,icon);
                return null ;
            }
        }.execute();
    }

    private void getPersonnelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                GetPersonnel gp = new GetPersonnel() ;
                gp.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void removePersonnelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                RemovePersonnelPanel rpp = new RemovePersonnelPanel() ;
                rpp.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void getAccountBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                GetAccount ga = new GetAccount() ;
                ga.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void backBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        addAccountBTN = new JButton();
        addPersonnelBTN = new JButton();
        removePersonnelBTN = new JButton();
        getAccountBTN = new JButton();
        getPersonnelBTN = new JButton();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        nameLBL = new JLabel();
        addressLBL = new JLabel();
        accountsLBL = new JLabel();
        personnelsLBL = new JLabel();
        balanceLBL = new JLabel();
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
            label1.setText("Bank  Menu");
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
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== panel2 ========
        {
            panel2.setBackground(new Color(51, 0, 0));

            //---- addAccountBTN ----
            addAccountBTN.setText("Add Account");
            addAccountBTN.setBackground(new Color(0, 0, 51));
            addAccountBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            addAccountBTN.setForeground(Color.white);
            addAccountBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            addAccountBTN.setIcon(new ImageIcon(getClass().getResource("/icons/add-user.png")));
            addAccountBTN.addActionListener(e -> addAccountBTNActionPerformed(e));

            //---- addPersonnelBTN ----
            addPersonnelBTN.setText("Add Personnel");
            addPersonnelBTN.setBackground(new Color(0, 25, 25));
            addPersonnelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            addPersonnelBTN.setForeground(Color.white);
            addPersonnelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            addPersonnelBTN.setIcon(new ImageIcon(getClass().getResource("/icons/add employee.jpg")));
            addPersonnelBTN.addActionListener(e -> addPersonnelBTNActionPerformed(e));

            //---- removePersonnelBTN ----
            removePersonnelBTN.setText("Remove Personnel");
            removePersonnelBTN.setBackground(new Color(102, 0, 0));
            removePersonnelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            removePersonnelBTN.setForeground(Color.white);
            removePersonnelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            removePersonnelBTN.setIcon(new ImageIcon(getClass().getResource("/icons/remove emplyee.png")));
            removePersonnelBTN.addActionListener(e -> removePersonnelBTNActionPerformed(e));

            //---- getAccountBTN ----
            getAccountBTN.setText("Get Accounts");
            getAccountBTN.setBackground(new Color(0, 51, 0));
            getAccountBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            getAccountBTN.setForeground(Color.white);
            getAccountBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            getAccountBTN.setIcon(new ImageIcon(getClass().getResource("/icons/user.png")));
            getAccountBTN.addActionListener(e -> getAccountBTNActionPerformed(e));

            //---- getPersonnelBTN ----
            getPersonnelBTN.setText("Get Personnel");
            getPersonnelBTN.setBackground(new Color(20, 0, 20));
            getPersonnelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            getPersonnelBTN.setForeground(Color.white);
            getPersonnelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            getPersonnelBTN.setIcon(new ImageIcon(getClass().getResource("/icons/contact-list.png")));
            getPersonnelBTN.addActionListener(e -> getPersonnelBTNActionPerformed(e));

            //---- label3 ----
            label3.setText("Name");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);
            label3.setIcon(new ImageIcon(getClass().getResource("/icons/banking.png")));

            //---- label4 ----
            label4.setText("Address");
            label4.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label4.setForeground(Color.white);
            label4.setIcon(new ImageIcon(getClass().getResource("/icons/address.png")));

            //---- label5 ----
            label5.setText("Accounts");
            label5.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label5.setForeground(Color.white);
            label5.setIcon(new ImageIcon(getClass().getResource("/icons/user.png")));

            //---- label8 ----
            label8.setText("Personnels");
            label8.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label8.setForeground(Color.white);
            label8.setIcon(new ImageIcon(getClass().getResource("/icons/personnel.png")));

            //---- label9 ----
            label9.setText("Balance");
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

            //---- accountsLBL ----
            accountsLBL.setText("text");
            accountsLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            accountsLBL.setForeground(Color.white);

            //---- personnelsLBL ----
            personnelsLBL.setText("text");
            personnelsLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            personnelsLBL.setForeground(Color.white);

            //---- balanceLBL ----
            balanceLBL.setText("text");
            balanceLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            balanceLBL.setForeground(Color.white);

            //---- backBTN ----
            backBTN.setText("Back");
            backBTN.setBackground(new Color(153, 51, 0));
            backBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            backBTN.setForeground(Color.white);
            backBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            backBTN.setIcon(new ImageIcon(getClass().getResource("/icons/back icon.png")));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(addAccountBTN, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(getAccountBTN, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 62, Short.MAX_VALUE)
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(removePersonnelBTN, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addPersonnelBTN, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label9, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(personnelsLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(balanceLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(accountsLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 33, Short.MAX_VALUE)))
                        .addGap(68, 68, 68)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(getPersonnelBTN, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(accountsLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(personnelsLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(balanceLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(getPersonnelBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(addPersonnelBTN)
                            .addComponent(addAccountBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(removePersonnelBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(getAccountBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(backBTN))
                        .addContainerGap(56, Short.MAX_VALUE))
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
    private JButton addAccountBTN;
    private JButton addPersonnelBTN;
    private JButton removePersonnelBTN;
    private JButton getAccountBTN;
    private JButton getPersonnelBTN;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label8;
    private JLabel label9;
    public JLabel nameLBL;
    public JLabel addressLBL;
    public JLabel accountsLBL;
    public JLabel personnelsLBL;
    public JLabel balanceLBL;
    private JButton backBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
