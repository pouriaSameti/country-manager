/*
 * Created by JFormDesigner on Fri Jul 02 12:34:36 IRDT 2021
 */

package com.company.graphics.HotelFolder;

import com.company.Buildings.hotel;
import com.company.Person.person ;
import com.company.city;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class RemovePersonnelPanel extends JFrame {
    public RemovePersonnelPanel()
    {
        initComponents();
        for (person p : hotel.currentHotel.getHotelPersonnel())
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

    private void personInfoBTNActionPerformed(ActionEvent e) {
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

    private void deletePersonnelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                person p = (person) personnelCMB.getSelectedItem() ;
                hotel.currentHotel.removePersonnel(p);
                hotel.currentHotel.updateHotelPanel();
                String message = "Person was Removed" ;
                String title = "Remove Person" ;
                ImageIcon icon = new ImageIcon("src\\icons\\remove-friend.png") ;
                JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE,icon);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        selectCityPanel = new JPanel();
        label3 = new JLabel();
        personnelCMB = new JComboBox();
        personInfoBTN = new JButton();
        deletePersonnelBTN = new JButton();

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
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
            );
        }

        //======== selectCityPanel ========
        {
            selectCityPanel.setBackground(new Color(51, 0, 0));

            //---- label3 ----
            label3.setText("Personnel");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);
            label3.setIcon(new ImageIcon(getClass().getResource("/icons/crew.png")));

            //---- personnelCMB ----
            personnelCMB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- personInfoBTN ----
            personInfoBTN.setText("Info");
            personInfoBTN.setForeground(Color.white);
            personInfoBTN.setBackground(new Color(0, 0, 102));
            personInfoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            personInfoBTN.addActionListener(e -> personInfoBTNActionPerformed(e));

            //---- deletePersonnelBTN ----
            deletePersonnelBTN.setText("Delete");
            deletePersonnelBTN.setForeground(Color.white);
            deletePersonnelBTN.setBackground(new Color(102, 0, 0));
            deletePersonnelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            deletePersonnelBTN.setIcon(new ImageIcon(getClass().getResource("/icons/delete.png")));
            deletePersonnelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            deletePersonnelBTN.addActionListener(e -> deletePersonnelBTNActionPerformed(e));

            GroupLayout selectCityPanelLayout = new GroupLayout(selectCityPanel);
            selectCityPanel.setLayout(selectCityPanelLayout);
            selectCityPanelLayout.setHorizontalGroup(
                selectCityPanelLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, selectCityPanelLayout.createSequentialGroup()
                        .addContainerGap(110, Short.MAX_VALUE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(selectCityPanelLayout.createParallelGroup()
                            .addComponent(deletePersonnelBTN, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
                            .addComponent(personInfoBTN, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                            .addComponent(personnelCMB, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE))
                        .addGap(203, 203, 203))
            );
            selectCityPanelLayout.setVerticalGroup(
                selectCityPanelLayout.createParallelGroup()
                    .addGroup(selectCityPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addComponent(personnelCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(personInfoBTN)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
                        .addComponent(deletePersonnelBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectCityPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(selectCityPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setSize(940, 615);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel selectCityPanel;
    private JLabel label3;
    private JComboBox personnelCMB;
    private JButton personInfoBTN;
    private JButton deletePersonnelBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
