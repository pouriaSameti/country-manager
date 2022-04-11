/*
 * Created by JFormDesigner on Wed Jun 30 02:12:06 IRDT 2021
 */

package com.company.graphics.SeaportFolder;

import com.company.Buildings.seaPort;
import com.company.Vehicle.boat;
import com.company.Vehicle.marineVehicle;
import com.company.Vehicle.ship;
import com.company.city;
import com.company.country.Country;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class CreateBoatPanel extends JFrame {
    public CreateBoatPanel()
    {
        initComponents();
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

    private void saveBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground()
            {
                if (nameTXT.getText().isEmpty())
                {
                    String message = "Name is Empty" ;
                    JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
                }

                else
                {
                    String name = nameTXT.getText();
                    int volume = (int) setVolumeSPN.getValue();
                    boat b = new boat(name,volume) ;
                    seaPort.currentSeaport.addVehicle(b);
                    String message = b.getName() + " was created" ;
                    String title = "Create Boat" ;
                    ImageIcon icon = new ImageIcon("src\\icons\\boat.png") ;
                    JOptionPane.showMessageDialog(null,message,title,JOptionPane.ERROR_MESSAGE,icon);
                    seaPort.currentSeaport.updateSeaportPanel();
                    seaPort.currentSeaport.getCity().updateCityPanel();
                    city.currentCity.setFinallyBudget();
                    city.currentCity.updateCityPanel();
                    Country.getCountry().updateCountryInfo();
                    dispose();
                }
                return null ;
            }

        }.execute();
    }

    private void cancelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        nameTXT.setText("");
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        saveBTN = new JButton();
        cancelBTN = new JButton();
        label3 = new JLabel();
        nameTXT = new JTextField();
        label5 = new JLabel();
        setVolumeSPN = new JSpinner();

        //======== this ========
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Create Ship Menu");
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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 540, Short.MAX_VALUE)
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

            //---- saveBTN ----
            saveBTN.setText("Save");
            saveBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            saveBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            saveBTN.setForeground(Color.white);
            saveBTN.setBackground(new Color(0, 0, 51));
            saveBTN.addActionListener(e -> saveBTNActionPerformed(e));

            //---- cancelBTN ----
            cancelBTN.setText("Cancel");
            cancelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            cancelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            cancelBTN.setForeground(Color.white);
            cancelBTN.setBackground(new Color(102, 0, 0));
            cancelBTN.addActionListener(e -> cancelBTNActionPerformed(e));

            //---- label3 ----
            label3.setText("Name");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);

            //---- label5 ----
            label5.setText("Volume");
            label5.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label5.setForeground(Color.white);

            //---- setVolumeSPN ----
            setVolumeSPN.setModel(new SpinnerNumberModel(1, 1, 250, 1));
            setVolumeSPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTXT, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(saveBTN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(setVolumeSPN, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
                                .addComponent(cancelBTN, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)))
                        .addGap(123, 123, 123))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTXT, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addComponent(setVolumeSPN, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(saveBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
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
    private JButton saveBTN;
    private JButton cancelBTN;
    private JLabel label3;
    private JTextField nameTXT;
    private JLabel label5;
    private JSpinner setVolumeSPN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
