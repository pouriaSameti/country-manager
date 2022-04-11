/*
 * Created by JFormDesigner on Fri Jul 02 02:20:34 IRDT 2021
 */

package com.company.graphics.CityFolder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class CityInfoPanel extends JFrame {
    public CityInfoPanel()
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

    private void okBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        cityNameLBL = new JLabel();
        populationLBL = new JLabel();
        vehiclesLBL = new JLabel();
        buildingsLBL = new JLabel();
        budjetLBL = new JLabel();
        okBTN = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("City Information");
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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 721, Short.MAX_VALUE)
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

            //---- okBTN ----
            okBTN.setText("Ok");
            okBTN.setBackground(new Color(1, 18, 1));
            okBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            okBTN.setForeground(Color.white);
            okBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            okBTN.setIcon(new ImageIcon(getClass().getResource("/icons/red checked.png")));
            okBTN.addActionListener(e -> okBTNActionPerformed(e));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addComponent(cityNameLBL, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(budjetLBL, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buildingsLBL, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vehiclesLBL, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(populationLBL, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(352, 352, 352)
                                .addComponent(okBTN, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 356, Short.MAX_VALUE))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap(17, Short.MAX_VALUE)
                        .addComponent(cityNameLBL, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(populationLBL, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vehiclesLBL, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buildingsLBL, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(budjetLBL, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(okBTN)
                        .addGap(31, 31, 31))
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
    public JLabel cityNameLBL;
    public JLabel populationLBL;
    public JLabel vehiclesLBL;
    public JLabel buildingsLBL;
    public JLabel budjetLBL;
    private JButton okBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
