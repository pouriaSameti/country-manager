/*
 * Created by JFormDesigner on Thu Jul 01 22:47:58 IRDT 2021
 */

package com.company.graphics.AirPortFolder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import com.company.Buildings.airPort;
import com.company.Person.person ;

/**
 * @author pouria
 */
public class RemoveAPPersonnel extends JFrame {
    public RemoveAPPersonnel()
    {
        initComponents();
        for (person p : airPort.currentAirport.getVehicleLeader())
            personnelCMB.addItem(p);
        for (person p : airPort.currentAirport.getEmployee())
            personnelCMB.addItem(p);

        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            if (info.getName().equals("Nimbus"))
            {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.invokeLater(() -> SwingUtilities.updateComponentTreeUI(getRootPane()));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
    }

    private void label2MouseClicked(MouseEvent e) {
        // TODO add your code here
        dispose();
    }

    private void DeleteBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                    person p = (person) personnelCMB.getSelectedItem();
                    airPort.currentAirport.removePersonnel(p);
                    String message = "Person was removed";
                    String title = "Remove Personnel";
                    ImageIcon icon = new ImageIcon("src\\icons\\remove-friend.png");
                    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
                    airPort.currentAirport.updateAirportPanel();
                    dispose();
                    return null;
                }
        }.execute();
    }

    private void infoBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        {
            new SwingWorker<>(){
                @Override
                public Object doInBackground() {
                    person p = (person) personnelCMB.getSelectedItem();
                    p.showPersonPanel();
                    return null;
                }
            }.execute();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        citiesContainer = new JPanel();
        DeleteBTN = new JButton();
        personnelCMB = new JComboBox();
        label14 = new JLabel();
        infoBTN = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Delete Personnel Menu");
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

            //---- DeleteBTN ----
            DeleteBTN.setText("Delete");
            DeleteBTN.setBackground(new Color(102, 0, 0));
            DeleteBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            DeleteBTN.setForeground(Color.white);
            DeleteBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            DeleteBTN.setIcon(new ImageIcon(getClass().getResource("/icons/delete.png")));
            DeleteBTN.addActionListener(e -> DeleteBTNActionPerformed(e));

            //---- personnelCMB ----
            personnelCMB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- label14 ----
            label14.setText("Personnels");
            label14.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label14.setForeground(Color.white);
            label14.setIcon(new ImageIcon(getClass().getResource("/icons/pilot.png")));

            //---- infoBTN ----
            infoBTN.setText("Info");
            infoBTN.setBackground(new Color(0, 0, 102));
            infoBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 14));
            infoBTN.setForeground(Color.white);
            infoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            infoBTN.addActionListener(e -> infoBTNActionPerformed(e));

            GroupLayout citiesContainerLayout = new GroupLayout(citiesContainer);
            citiesContainer.setLayout(citiesContainerLayout);
            citiesContainerLayout.setHorizontalGroup(
                citiesContainerLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, citiesContainerLayout.createSequentialGroup()
                        .addContainerGap(121, Short.MAX_VALUE)
                        .addComponent(label14, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(citiesContainerLayout.createParallelGroup()
                            .addComponent(DeleteBTN, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                            .addComponent(infoBTN, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                            .addComponent(personnelCMB, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE))
                        .addGap(213, 213, 213))
            );
            citiesContainerLayout.setVerticalGroup(
                citiesContainerLayout.createParallelGroup()
                    .addGroup(citiesContainerLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(citiesContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(personnelCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoBTN, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                        .addComponent(DeleteBTN)
                        .addGap(34, 34, 34))
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
    private JButton DeleteBTN;
    private JComboBox personnelCMB;
    private JLabel label14;
    private JButton infoBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
