/*
 * Created by JFormDesigner on Sat Jul 03 21:55:04 IRDT 2021
 */

package com.company.graphics.BankFolder;

import com.company.Buildings.Bank;
import com.company.Person.person;
import com.company.bankery.Account;
import com.company.city;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class AccountPanel extends JFrame {
    public AccountPanel()
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

    private void depositBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                DepositPanel dp = new DepositPanel() ;
                dp.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void withdrawalBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                WithdrawalAccount wa = new WithdrawalAccount() ;
                wa.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void ownerInfoBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {

                person p = Account.currentAccount.getOwner() ;
                p.showPersonPanel();
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

    private void removeAccountBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                Bank.currentBank.removeAccount(Account.currentAccount);
                String message = "Account was Removed" ;
                String title = "Remove Account" ;
                ImageIcon icon = new ImageIcon("src\\icons\\remove-friend.png") ;
                JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,icon);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void backBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                Bank.currentBank.createBankPanel();
                Bank.currentBank.updateBankPanel();
                return null ;
            }
        }.execute();
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel3 = new JPanel();
        label8 = new JLabel();
        label11 = new JLabel();
        panel4 = new JPanel();
        depositBTN = new JButton();
        label12 = new JLabel();
        label13 = new JLabel();
        ownerLBL = new JLabel();
        BalanceLBL = new JLabel();
        withdrawalBTN = new JButton();
        ownerInfoBTN = new JButton();
        getTransactionsBTN = new JButton();
        removeAccountBTN = new JButton();
        backBTN = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel3 ========
        {
            panel3.setBackground(new Color(0, 51, 51));

            //---- label8 ----
            label8.setText("Account Menu");
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

            //---- depositBTN ----
            depositBTN.setText("Deposit");
            depositBTN.setBackground(new Color(0, 0, 51));
            depositBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            depositBTN.setForeground(Color.white);
            depositBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            depositBTN.setIcon(new ImageIcon(getClass().getResource("/icons/green plus.png")));
            depositBTN.addActionListener(e -> depositBTNActionPerformed(e));

            //---- label12 ----
            label12.setText("Owner");
            label12.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label12.setForeground(Color.white);
            label12.setIcon(new ImageIcon(getClass().getResource("/icons/user.png")));

            //---- label13 ----
            label13.setText("Balance");
            label13.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label13.setForeground(Color.white);
            label13.setIcon(new ImageIcon(getClass().getResource("/icons/dollar.png")));

            //---- ownerLBL ----
            ownerLBL.setText("text");
            ownerLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            ownerLBL.setForeground(Color.white);

            //---- BalanceLBL ----
            BalanceLBL.setText("text");
            BalanceLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            BalanceLBL.setForeground(Color.white);

            //---- withdrawalBTN ----
            withdrawalBTN.setText("Withdrawal");
            withdrawalBTN.setBackground(new Color(75, 0, 0));
            withdrawalBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            withdrawalBTN.setForeground(Color.white);
            withdrawalBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            withdrawalBTN.setIcon(new ImageIcon(getClass().getResource("/icons/minus 2.png")));
            withdrawalBTN.addActionListener(e -> withdrawalBTNActionPerformed(e));

            //---- ownerInfoBTN ----
            ownerInfoBTN.setText("Owner  Info");
            ownerInfoBTN.setBackground(new Color(0, 51, 0));
            ownerInfoBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            ownerInfoBTN.setForeground(Color.white);
            ownerInfoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            ownerInfoBTN.setIcon(new ImageIcon(getClass().getResource("/icons/info.png")));
            ownerInfoBTN.addActionListener(e -> ownerInfoBTNActionPerformed(e));

            //---- getTransactionsBTN ----
            getTransactionsBTN.setText("Get Transactions");
            getTransactionsBTN.setBackground(new Color(25, 0, 25));
            getTransactionsBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            getTransactionsBTN.setForeground(Color.white);
            getTransactionsBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            getTransactionsBTN.setIcon(new ImageIcon(getClass().getResource("/icons/money-transfer.png")));
            getTransactionsBTN.addActionListener(e -> getTransactionsBTNActionPerformed(e));

            //---- removeAccountBTN ----
            removeAccountBTN.setText("Remove Account");
            removeAccountBTN.setBackground(new Color(0, 51, 51));
            removeAccountBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            removeAccountBTN.setForeground(Color.white);
            removeAccountBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            removeAccountBTN.setIcon(new ImageIcon(getClass().getResource("/icons/remove-friend.png")));
            removeAccountBTN.addActionListener(e -> removeAccountBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("Back");
            backBTN.setBackground(new Color(153, 51, 0));
            backBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            backBTN.setForeground(Color.white);
            backBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            backBTN.setIcon(new ImageIcon(getClass().getResource("/icons/back icon.png")));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addComponent(depositBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 367, Short.MAX_VALUE)
                                .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label12, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addComponent(label13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(removeAccountBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BalanceLBL, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                                            .addComponent(ownerLBL, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
                                        .addGap(291, 291, 291))
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addGroup(panel4Layout.createParallelGroup()
                                            .addComponent(withdrawalBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(getTransactionsBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                                        .addGap(74, 74, 74)
                                        .addComponent(ownerInfoBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(46, Short.MAX_VALUE))))))
            );
            panel4Layout.setVerticalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ownerLBL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(BalanceLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(160, 160, 160)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(depositBTN)
                            .addComponent(getTransactionsBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ownerInfoBTN))
                        .addGap(30, 30, 30)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(removeAccountBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(withdrawalBTN)
                            .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
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
        setSize(925, 515);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel3;
    private JLabel label8;
    private JLabel label11;
    private JPanel panel4;
    private JButton depositBTN;
    private JLabel label12;
    private JLabel label13;
    public JLabel ownerLBL;
    public JLabel BalanceLBL;
    private JButton withdrawalBTN;
    private JButton ownerInfoBTN;
    private JButton getTransactionsBTN;
    private JButton removeAccountBTN;
    private JButton backBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
