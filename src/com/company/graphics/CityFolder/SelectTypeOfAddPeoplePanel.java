/*
 * Created by JFormDesigner on Wed Jun 30 22:28:01 IRDT 2021
 */

package com.company.graphics.CityFolder;

import com.company.graphics.CityFolder.AddManyPeoplePanel;
import com.company.graphics.CityFolder.AddPersonMenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class SelectTypeOfAddPeoplePanel extends JFrame {
    public SelectTypeOfAddPeoplePanel()
    {
        initComponents();
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
        dispose() ;
    }

    private void addManyPeopleBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                AddManyPeoplePanel amp = new AddManyPeoplePanel() ;
                amp.setVisible(true);
                dispose();
                return null ;
            }

        }.execute();
    }

    private void addOnePeopleBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                AddPersonMenu apm = new AddPersonMenu() ;
                apm.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void closeBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        addManyPeopleBTN = new JButton();
        addOnePeopleBTN = new JButton();
        closeBTN = new JButton();

        //======== this ========
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Selection Type Of Add People");
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

            //---- addManyPeopleBTN ----
            addManyPeopleBTN.setText("Auto Add People");
            addManyPeopleBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            addManyPeopleBTN.setForeground(Color.white);
            addManyPeopleBTN.setIcon(new ImageIcon(getClass().getResource("/icons/automatic-flash.png")));
            addManyPeopleBTN.setBackground(new Color(0, 0, 51));
            addManyPeopleBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            addManyPeopleBTN.addActionListener(e -> addManyPeopleBTNActionPerformed(e));

            //---- addOnePeopleBTN ----
            addOnePeopleBTN.setText("Add Manually Person");
            addOnePeopleBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            addOnePeopleBTN.setForeground(Color.white);
            addOnePeopleBTN.setIcon(new ImageIcon(getClass().getResource("/icons/hammer.png")));
            addOnePeopleBTN.setBackground(new Color(102, 0, 0));
            addOnePeopleBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            addOnePeopleBTN.addActionListener(e -> addOnePeopleBTNActionPerformed(e));

            //---- closeBTN ----
            closeBTN.setText("Close");
            closeBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            closeBTN.setForeground(Color.white);
            closeBTN.setIcon(new ImageIcon(getClass().getResource("/icons/close.png")));
            closeBTN.setBackground(new Color(0, 30, 30));
            closeBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            closeBTN.addActionListener(e -> closeBTNActionPerformed(e));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap(345, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(addManyPeopleBTN, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(closeBTN, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(addOnePeopleBTN, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                        .addGap(321, 321, 321))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(addManyPeopleBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(addOnePeopleBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(closeBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
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
    private JButton addManyPeopleBTN;
    private JButton addOnePeopleBTN;
    private JButton closeBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
