/*
 * Created by JFormDesigner on Thu Jul 01 11:22:18 IRDT 2021
 */

package com.company.graphics.CityFolder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import com.company.Person.person ;
import com.company.Person.person.* ;
import com.company.city;
import com.company.country.Country;

/**
 * @author pouria
 */
public class AddPersonMenu extends JFrame {
    public AddPersonMenu()
    {
        initComponents();
        for (job j : job.values())
            jobCMB.addItem(j);
        for (gender g : gender.values())
            genderCMB.addItem(g);
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            if (info.getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.invokeLater(() -> SwingUtilities.updateComponentTreeUI(getRootPane()));
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
    }

    private void label2MouseClicked(MouseEvent e) {
        // TODO add your code here
        dispose();
    }

    private void createBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                if (firstNameTXT.getText().isEmpty())
                {
                    String message = "name field is empty" ;
                    String title = "Error" ;
                    JOptionPane.showMessageDialog(null,message,title,JOptionPane.ERROR_MESSAGE);
                }

                if (lastNameTXT.getText().isEmpty())
                {
                    String message = "lastname field is empty" ;
                    String title = "Error" ;
                    JOptionPane.showMessageDialog(null,message,title,JOptionPane.ERROR_MESSAGE);
                }

                else
                {
                    try {
                        String firstname = firstNameTXT.getText() ;
                        String lastname = lastNameTXT.getText() ;
                        int birthYear = (int) birthYearSPN.getValue() ;
                        job Job = (job) jobCMB.getSelectedItem() ;
                        gender Gender = (gender) genderCMB.getSelectedItem() ;
                        String countryName = Country.getCountry().getName() ;
                        String cityName = city.currentCity.getCityName();
                        person p = new person(firstname,lastname,birthYear,countryName,cityName,Job,Gender) ;
                        city.currentCity.addPeople(p);
                        city.currentCity.updateCityPanel();
                        Country.getCountry().updateCountryInfo();
                        String message = "person was added" ;
                        String title = "Add Person" ;
                        ImageIcon icon = new ImageIcon("src\\icons\\user.png") ;
                        JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,icon);
                        dispose();
                    }
                    catch (Exception e){
                        JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                return null ;
            }

        }.execute();
    }

    private void cancelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        createBTN = new JButton();
        cancelBTN = new JButton();
        label3 = new JLabel();
        jobCMB = new JComboBox();
        firstNameTXT = new JTextField();
        label5 = new JLabel();
        lastNameTXT = new JTextField();
        label6 = new JLabel();
        birthYearSPN = new JSpinner();
        label7 = new JLabel();
        label8 = new JLabel();
        genderCMB = new JComboBox();

        //======== this ========
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Add Person Menu");
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
                        .addContainerGap())
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

            //---- createBTN ----
            createBTN.setText("Create");
            createBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            createBTN.setForeground(Color.white);
            createBTN.setBackground(new Color(0, 66, 0));
            createBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            createBTN.addActionListener(e -> createBTNActionPerformed(e));

            //---- cancelBTN ----
            cancelBTN.setText("Cancel");
            cancelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            cancelBTN.setForeground(Color.white);
            cancelBTN.setBackground(new Color(102, 0, 0));
            cancelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            cancelBTN.addActionListener(e -> cancelBTNActionPerformed(e));

            //---- label3 ----
            label3.setText("Name");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);

            //---- jobCMB ----
            jobCMB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- label5 ----
            label5.setText("Lastname");
            label5.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label5.setForeground(Color.white);

            //---- label6 ----
            label6.setText("birthYear");
            label6.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label6.setForeground(Color.white);

            //---- birthYearSPN ----
            birthYearSPN.setModel(new SpinnerNumberModel(1300, 1300, null, 1));

            //---- label7 ----
            label7.setText("Job");
            label7.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label7.setForeground(Color.white);

            //---- label8 ----
            label8.setText("Gender");
            label8.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label8.setForeground(Color.white);

            //---- genderCMB ----
            genderCMB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(genderCMB, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(birthYearSPN))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jobCMB, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 513, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lastNameTXT, GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(firstNameTXT, GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(createBTN, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
                                        .addComponent(cancelBTN, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                .addGap(70, 70, 70))))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(firstNameTXT, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(lastNameTXT, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(birthYearSPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label7)
                            .addComponent(jobCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label8)
                            .addComponent(genderCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelBTN)
                            .addComponent(createBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JButton createBTN;
    private JButton cancelBTN;
    private JLabel label3;
    private JComboBox jobCMB;
    private JTextField firstNameTXT;
    private JLabel label5;
    private JTextField lastNameTXT;
    private JLabel label6;
    private JSpinner birthYearSPN;
    private JLabel label7;
    private JLabel label8;
    private JComboBox genderCMB;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
