/*
 * Created by JFormDesigner on Sat Jul 03 16:07:48 IRDT 2021
 */

package com.company.graphics.Travel;
import com.company.city ;
import com.company.Buildings.terminal ;
import com.company.country.Country;
import com.company.country.travel ;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class GetOutputTravel extends JFrame {
    public GetOutputTravel()
    {
        initComponents();
        for (city c : Country.getCountry().getCities())
            cityCMB.addItem(c);
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
        dispose() ;
    }

    private void cityCMBItemStateChanged(ItemEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                terminalCMB.removeAllItems();
                city City = (city) cityCMB.getSelectedItem() ;
                for (terminal t : City.getAllTerminal())
                    terminalCMB.addItem(t);
                return null ;
            }
        }.execute();
    }

    private void cityInfoBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                city C = (city) cityCMB.getSelectedItem() ;
                C.getCityInfoPanel();
                return null ;
            }
        }.execute();

    }

    private void terminalInfoBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                terminal t = (terminal) terminalCMB.getSelectedItem() ;
                t.getTerminalPanel();
                return null ;
            }
        }.execute();
    }

    private void finishBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                travel.currentTravel = (travel) travelCMB.getSelectedItem() ;
                TravelInfoPanel tip = new TravelInfoPanel() ;
                dispose();
                tip.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void backBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                setOperationPanel sop = new setOperationPanel() ;
                dispose();
                sop.setVisible(true);
                return null ;
            }
        }.execute();
    }

    private void terminalCMBItemStateChanged(ItemEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                travelCMB.removeAllItems();
                terminal Terminal = (terminal) terminalCMB.getSelectedItem() ;
                for (travel t : Terminal.getOutputTravelList())
                    travelCMB.addItem(t);
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
        cityCMB = new JComboBox();
        cityInfoBTN = new JButton();
        label5 = new JLabel();
        terminalCMB = new JComboBox();
        terminalInfoBTN = new JButton();
        finishBTN = new JButton();
        backBTN = new JButton();
        label6 = new JLabel();
        travelCMB = new JComboBox();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Get Travel Information Menu");
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
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 586, Short.MAX_VALUE)
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
            label3.setText("City");
            label3.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label3.setForeground(Color.white);

            //---- cityCMB ----
            cityCMB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            cityCMB.addItemListener(e -> cityCMBItemStateChanged(e));

            //---- cityInfoBTN ----
            cityInfoBTN.setText("Info");
            cityInfoBTN.setForeground(Color.white);
            cityInfoBTN.setBackground(new Color(0, 0, 102));
            cityInfoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            cityInfoBTN.addActionListener(e -> cityInfoBTNActionPerformed(e));

            //---- label5 ----
            label5.setText("Terminals");
            label5.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label5.setForeground(Color.white);

            //---- terminalCMB ----
            terminalCMB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            terminalCMB.addItemListener(e -> terminalCMBItemStateChanged(e));

            //---- terminalInfoBTN ----
            terminalInfoBTN.setText("Info");
            terminalInfoBTN.setForeground(Color.white);
            terminalInfoBTN.setBackground(new Color(0, 0, 102));
            terminalInfoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            terminalInfoBTN.addActionListener(e -> terminalInfoBTNActionPerformed(e));

            //---- finishBTN ----
            finishBTN.setText("Finish");
            finishBTN.setForeground(Color.white);
            finishBTN.setBackground(new Color(0, 0, 51));
            finishBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            finishBTN.setIcon(new ImageIcon(getClass().getResource("/icons/check 2.png")));
            finishBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            finishBTN.addActionListener(e -> finishBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("Back");
            backBTN.setForeground(Color.white);
            backBTN.setBackground(new Color(0, 102, 0));
            backBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            backBTN.setIcon(new ImageIcon(getClass().getResource("/icons/sign-out.png")));
            backBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            //---- label6 ----
            label6.setText("Teravel");
            label6.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label6.setForeground(Color.white);

            //---- travelCMB ----
            travelCMB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            GroupLayout selectCityPanelLayout = new GroupLayout(selectCityPanel);
            selectCityPanel.setLayout(selectCityPanelLayout);
            selectCityPanelLayout.setHorizontalGroup(
                selectCityPanelLayout.createParallelGroup()
                    .addGroup(selectCityPanelLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addGroup(selectCityPanelLayout.createParallelGroup()
                            .addComponent(label5)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6)
                            .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                        .addGroup(selectCityPanelLayout.createParallelGroup()
                            .addGroup(selectCityPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(cityCMB, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
                            .addGroup(selectCityPanelLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(selectCityPanelLayout.createParallelGroup()
                                    .addComponent(terminalCMB, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(travelCMB, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(GroupLayout.Alignment.TRAILING, selectCityPanelLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(selectCityPanelLayout.createParallelGroup()
                                    .addComponent(cityInfoBTN, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(terminalInfoBTN, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(finishBTN, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(305, Short.MAX_VALUE))
            );
            selectCityPanelLayout.setVerticalGroup(
                selectCityPanelLayout.createParallelGroup()
                    .addGroup(selectCityPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(selectCityPanelLayout.createParallelGroup()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addGroup(selectCityPanelLayout.createSequentialGroup()
                                .addComponent(cityCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cityInfoBTN)))
                        .addGap(50, 50, 50)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addComponent(terminalCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(terminalInfoBTN)
                        .addGap(41, 41, 41)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(travelCMB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(selectCityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(finishBTN, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(backBTN))
                        .addGap(22, 22, 22))
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
        setSize(930, 480);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel selectCityPanel;
    private JLabel label3;
    private JComboBox cityCMB;
    private JButton cityInfoBTN;
    private JLabel label5;
    private JComboBox terminalCMB;
    private JButton terminalInfoBTN;
    private JButton finishBTN;
    private JButton backBTN;
    private JLabel label6;
    private JComboBox travelCMB;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
