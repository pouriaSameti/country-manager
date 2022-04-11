/*
 * Created by JFormDesigner on Fri Jul 02 00:59:09 IRDT 2021
 */

package com.company.graphics.Travel;
import com.company.country.Country;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.GroupLayout;
import com.company.city ;
import com.company.Exceptions.* ;

/**
 * @author pouria
 */
public class TravelPanel extends JFrame {
    public TravelPanel()
    {
        initComponents();
        for (city c : Country.getCountry().getCities())
            startCityCMB.addItem(c);

        for (city c : Country.getCountry().getCities())
                destinationCityCMB.addItem(c);


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

    private void startCityInfoBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                city City = (city) startCityCMB.getSelectedItem() ;
                Objects.requireNonNull(City).getCityInfoPanel();
                return null ;
            }
        }.execute();
    }

    private void destinationCityInfoBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                city City = (city) destinationCityCMB.getSelectedItem() ;
                Objects.requireNonNull(City).getCityInfoPanel();
                return null ;
            }
        }.execute();
    }

    private void nextBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                city.originCity = (city) startCityCMB.getSelectedItem() ;
                city.destinationCity = (city) destinationCityCMB.getSelectedItem() ;
                if (city.originCity.getAllTerminal().size() == 0)
                {
                    try {
                        throw new lackOfTerminal("THERE IS NO TERMINAL AT " + city.originCity.getCityName()) ;
                    }
                    catch (lackOfTerminal lt){
                        JOptionPane.showMessageDialog(null,lt.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

                else if (city.destinationCity.getAllTerminal().size() == 0)
                {
                    try {
                        throw new lackOfTerminal("THERE IS NO TERMINAL AT " + city.destinationCity.getCityName()) ;
                    }
                    catch (lackOfTerminal lt){
                        JOptionPane.showMessageDialog(null,lt.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

                else if (city.originCity.equals(city.destinationCity))
                {
                    try {
                        throw new isSameDestination("DESTINATION CITY AND ORIGIN CITY IS SAME") ;
                    }
                    catch (isSameDestination sm) {
                        JOptionPane.showMessageDialog(null,sm.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

                else
                {
                    TravelPanel2 travelPanel2 = new TravelPanel2() ;
                    travelPanel2.setVisible(true);
                    dispose();
                }
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
        startCityCMB = new JComboBox();
        startCityInfoBTN = new JButton();
        label5 = new JLabel();
        destinationCityCMB = new JComboBox();
        destinationCityInfoBTN = new JButton();
        nextBTN = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Travel Menu");
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
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
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

        //======== selectCityPanel ========
        {
            selectCityPanel.setBackground(new Color(51, 0, 0));

            //---- label3 ----
            label3.setText("Origin City");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);

            //---- startCityCMB ----
            startCityCMB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- startCityInfoBTN ----
            startCityInfoBTN.setText("Info");
            startCityInfoBTN.setForeground(Color.white);
            startCityInfoBTN.setBackground(new Color(0, 0, 102));
            startCityInfoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            startCityInfoBTN.addActionListener(e -> startCityInfoBTNActionPerformed(e));

            //---- label5 ----
            label5.setText("Destination city");
            label5.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label5.setForeground(Color.white);

            //---- destinationCityCMB ----
            destinationCityCMB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //---- destinationCityInfoBTN ----
            destinationCityInfoBTN.setText("Info");
            destinationCityInfoBTN.setForeground(Color.white);
            destinationCityInfoBTN.setBackground(new Color(0, 0, 102));
            destinationCityInfoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            destinationCityInfoBTN.addActionListener(e -> destinationCityInfoBTNActionPerformed(e));

            //---- nextBTN ----
            nextBTN.setText("Next");
            nextBTN.setForeground(Color.white);
            nextBTN.setBackground(new Color(153, 38, 0));
            nextBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            nextBTN.setIcon(new ImageIcon(getClass().getResource("/icons/enter.png")));
            nextBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            nextBTN.addActionListener(e -> nextBTNActionPerformed(e));

            GroupLayout selectCityPanelLayout = new GroupLayout(selectCityPanel);
            selectCityPanel.setLayout(selectCityPanelLayout);
            selectCityPanelLayout.setHorizontalGroup(
                selectCityPanelLayout.createParallelGroup()
                    .addGroup(selectCityPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(startCityInfoBTN, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                            .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(selectCityPanelLayout.createSequentialGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(startCityCMB))
                                .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(destinationCityInfoBTN, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(selectCityPanelLayout.createSequentialGroup()
                                        .addComponent(label5)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(destinationCityCMB, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nextBTN, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(335, Short.MAX_VALUE))
            );
            selectCityPanelLayout.setVerticalGroup(
                selectCityPanelLayout.createParallelGroup()
                    .addGroup(selectCityPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addComponent(startCityCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startCityInfoBTN)
                        .addGap(34, 34, 34)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addComponent(destinationCityCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destinationCityInfoBTN)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
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
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                    .addComponent(selectCityPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        setSize(650, 410);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel selectCityPanel;
    private JLabel label3;
    private JComboBox startCityCMB;
    private JButton startCityInfoBTN;
    private JLabel label5;
    private JComboBox destinationCityCMB;
    private JButton destinationCityInfoBTN;
    private JButton nextBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
