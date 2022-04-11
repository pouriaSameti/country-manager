/*
 * Created by JFormDesigner on Sat Jul 03 16:35:15 IRDT 2021
 */

package com.company.graphics.Travel;
import com.company.Person.* ;
import com.company.Buildings.terminal ;
import com.company.country.travel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class GetPassengersPanel extends JFrame {
    public GetPassengersPanel()
    {
        initComponents();
        for (person p : travel.currentTravel.getPassengersList())
            passengersCMB.addItem(p);
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

    private void selectBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                person p = (person) passengersCMB.getSelectedItem() ;
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
        passengersCMB = new JComboBox();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Get Passengers Menu");
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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            label12.setText("Passengers");
            label12.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label12.setForeground(Color.white);
            label12.setIcon(new ImageIcon(getClass().getResource("/icons/passenger.png")));

            //---- selectBTN ----
            selectBTN.setText("Select");
            selectBTN.setBackground(new Color(0, 0, 51));
            selectBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            selectBTN.setForeground(Color.white);
            selectBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            selectBTN.setIcon(new ImageIcon(getClass().getResource("/icons/check 2.png")));
            selectBTN.addActionListener(e -> selectBTNActionPerformed(e));

            GroupLayout citiesContainerLayout = new GroupLayout(citiesContainer);
            citiesContainer.setLayout(citiesContainerLayout);
            citiesContainerLayout.setHorizontalGroup(
                citiesContainerLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, citiesContainerLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(label12, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(citiesContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectBTN, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(passengersCMB, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                        .addGap(235, 235, 235))
            );
            citiesContainerLayout.setVerticalGroup(
                citiesContainerLayout.createParallelGroup()
                    .addGroup(citiesContainerLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(citiesContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passengersCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addComponent(selectBTN)
                        .addGap(35, 35, 35))
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
        setSize(705, 415);
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
    private JComboBox passengersCMB;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
