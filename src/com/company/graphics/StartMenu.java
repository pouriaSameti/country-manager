/*
 * Created by JFormDesigner on Sun Jun 27 22:33:34 IRDT 2021
 */

package com.company.graphics;
import com.company.Buildings.Bank;
import com.company.Main;
import com.company.Person.person;
import com.company.bankery.Account;
import com.company.city;
import com.company.country.Country;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.UIManager ;

/**
 * @author pouria
 */
public class StartMenu extends JFrame implements Serializable
{
    public StartMenu()
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

    private void startBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>()
        {
            @Override
            public Object doInBackground()
            {
                Main.readFile(Country.getCountry());
                person.setCurrentId();
                for (city c : Country.getCountry().getCities())
                    for (Bank bank : c.getAllBank()) {
                        ArrayList<Account> accounts = new ArrayList<>(bank.getAllAccounts().values()) ;
                        for (Account account :  accounts)
                            account.start();
                        bank.start();
                    }
                Country.getCountry().showCountryMenu();
                dispose();
                return null ;
            }
        }.execute();

    }

    private void exitBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void resetBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {

                for (city c : Country.getCountry().getCities())
                {
                    File city = new File(c.getPathCityFolder()) ;
                    city.delete();
                }
                String message = "All cities were Removed \n Program Should Restart" ;
                String title = "Delete City" ;
                ImageIcon icon = new ImageIcon("src\\icons\\remove building.png") ;
                JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,icon);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void infoBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                InfoPanel ip = new InfoPanel() ;
                ip.setVisible(true);
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
        startBTN = new JButton();
        exitBTN = new JButton();
        resetBTN = new JButton();
        infoBTN = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Start Menu");
            label1.setForeground(Color.white);
            label1.setFont(new Font("Myanmar Text", Font.PLAIN, 20));

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
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 480, Short.MAX_VALUE)
                        .addComponent(closeLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
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

            //---- startBTN ----
            startBTN.setText("Start");
            startBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            startBTN.setForeground(Color.white);
            startBTN.setBackground(new Color(0, 0, 52));
            startBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            startBTN.setIcon(new ImageIcon(getClass().getResource("/icons/play-button.png")));
            startBTN.addActionListener(e -> startBTNActionPerformed(e));

            //---- exitBTN ----
            exitBTN.setText("Exit");
            exitBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            exitBTN.setForeground(Color.white);
            exitBTN.setBackground(new Color(102, 0, 0));
            exitBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            exitBTN.setIcon(new ImageIcon(getClass().getResource("/icons/stand-by.png")));
            exitBTN.addActionListener(e -> exitBTNActionPerformed(e));

            //---- resetBTN ----
            resetBTN.setText("Reset");
            resetBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            resetBTN.setForeground(Color.white);
            resetBTN.setBackground(new Color(153, 51, 0));
            resetBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            resetBTN.setIcon(new ImageIcon(getClass().getResource("/icons/reset.png")));
            resetBTN.addActionListener(e -> resetBTNActionPerformed(e));

            //---- infoBTN ----
            infoBTN.setText("Info");
            infoBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            infoBTN.setForeground(Color.white);
            infoBTN.setBackground(new Color(0, 51, 0));
            infoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            infoBTN.setIcon(new ImageIcon(getClass().getResource("/icons/info.png")));
            infoBTN.addActionListener(e -> infoBTNActionPerformed(e));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(resetBTN, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                            .addComponent(startBTN, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                            .addComponent(infoBTN, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                            .addComponent(exitBTN, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(349, Short.MAX_VALUE))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(startBTN, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetBTN, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(infoBTN, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exitBTN, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))
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
    private JLabel closeLBL;
    private JPanel panel2;
    private JButton startBTN;
    private JButton exitBTN;
    private JButton resetBTN;
    private JButton infoBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
