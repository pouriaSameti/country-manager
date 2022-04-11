/*
 * Created by JFormDesigner on Sat Jul 03 22:47:58 IRDT 2021
 */

package com.company.graphics.BankFolder;

import com.company.Buildings.Bank;
import com.company.bankery.Account;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class WithdrawalAccount extends JFrame {
    public WithdrawalAccount()
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

    private void closeBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void withdrawalBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        int amount = (int) amountSPN.getValue() ;
        Account.currentAccount.withdrawalFromAccount(amount);
        Account.currentAccount.updateAccountPanel();
        Bank.currentBank.updateBankPanel();
        String message = "Money was Withdrawn" ;
        String title = "withdrawal Money" ;
        ImageIcon icon = new ImageIcon("src\\icons\\money Icon.png") ;
        JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,icon);
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel3 = new JPanel();
        label8 = new JLabel();
        label11 = new JLabel();
        panel4 = new JPanel();
        label13 = new JLabel();
        amountSPN = new JSpinner();
        withdrawalBTN = new JButton();
        closeBTN = new JButton();
        label14 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel3 ========
        {
            panel3.setBackground(new Color(0, 51, 51));

            //---- label8 ----
            label8.setText("Withdrawal Money Menu");
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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 500, Short.MAX_VALUE)
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

            //---- label13 ----
            label13.setText("Amount");
            label13.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label13.setForeground(Color.white);
            label13.setIcon(new ImageIcon(getClass().getResource("/icons/dollar.png")));

            //---- amountSPN ----
            amountSPN.setModel(new SpinnerNumberModel(0, 0, null, 1));
            amountSPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- withdrawalBTN ----
            withdrawalBTN.setText("withdrawal");
            withdrawalBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            withdrawalBTN.setForeground(Color.white);
            withdrawalBTN.setBackground(new Color(0, 0, 102));
            withdrawalBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            withdrawalBTN.addActionListener(e -> withdrawalBTNActionPerformed(e));

            //---- closeBTN ----
            closeBTN.setText("Close");
            closeBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            closeBTN.setForeground(Color.white);
            closeBTN.setBackground(new Color(102, 0, 0));
            closeBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            closeBTN.addActionListener(e -> closeBTNActionPerformed(e));

            //---- label14 ----
            label14.setText("$");
            label14.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label14.setForeground(Color.white);

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addComponent(label13, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(amountSPN, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label14))
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addComponent(withdrawalBTN, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(closeBTN, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(233, Short.MAX_VALUE))
            );
            panel4Layout.setVerticalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(amountSPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(withdrawalBTN)
                            .addComponent(closeBTN))
                        .addGap(26, 26, 26))
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
        setSize(875, 350);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel3;
    private JLabel label8;
    private JLabel label11;
    private JPanel panel4;
    private JLabel label13;
    private JSpinner amountSPN;
    private JButton withdrawalBTN;
    private JButton closeBTN;
    private JLabel label14;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
