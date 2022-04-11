/*
 * Created by JFormDesigner on Fri Jul 02 15:50:01 IRDT 2021
 */

package com.company.graphics.AirPortFolder;

import com.company.Buildings.airPort;
import com.company.Person.person ;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class GetPersonnelPanel extends JFrame {
    public GetPersonnelPanel()
    {
        initComponents();
        for (person p : airPort.currentAirport.getVehicleLeader())
            personnelCMB.addItem(p);
        for (person p : airPort.currentAirport.getEmployee())
            personnelCMB.addItem(p);
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
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

    private void label2MouseClicked(MouseEvent e) {
        // TODO add your code here
        dispose();
    }

    private void selectBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                person p = (person) personnelCMB.getSelectedItem() ;
                p.showPersonPanel();
                return null ;
            }
        }.execute();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        citiesContainer = new JPanel();
        label12 = new JLabel();
        selectBTN = new JButton();
        personnelCMB = new JComboBox();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Get Personnel Menu");
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
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 683, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
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

        //======== citiesContainer ========
        {
            citiesContainer.setBackground(new Color(51, 0, 0));

            //---- label12 ----
            label12.setText("Personnel");
            label12.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label12.setForeground(Color.white);
            label12.setIcon(new ImageIcon(getClass().getResource("/icons/employee.png")));

            //---- selectBTN ----
            selectBTN.setText("Select");
            selectBTN.setBackground(new Color(0, 0, 51));
            selectBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            selectBTN.setForeground(Color.white);
            selectBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            selectBTN.setIcon(new ImageIcon(getClass().getResource("/icons/check 2.png")));
            selectBTN.addActionListener(e -> selectBTNActionPerformed(e));

            //---- personnelCMB ----
            personnelCMB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            GroupLayout citiesContainerLayout = new GroupLayout(citiesContainer);
            citiesContainer.setLayout(citiesContainerLayout);
            citiesContainerLayout.setHorizontalGroup(
                citiesContainerLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, citiesContainerLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(label12, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(personnelCMB, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                        .addGap(235, 235, 235))
                    .addGroup(citiesContainerLayout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(selectBTN, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(300, Short.MAX_VALUE))
            );
            citiesContainerLayout.setVerticalGroup(
                citiesContainerLayout.createParallelGroup()
                    .addGroup(citiesContainerLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(citiesContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(personnelCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                        .addComponent(selectBTN)
                        .addGap(33, 33, 33))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(citiesContainer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(citiesContainer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setSize(940, 600);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel citiesContainer;
    private JLabel label12;
    private JButton selectBTN;
    private JComboBox personnelCMB;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
