/*
 * Created by JFormDesigner on Fri Jul 02 01:47:24 IRDT 2021
 */

package com.company.graphics.Travel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class setOperationPanel extends JFrame {
    public setOperationPanel()
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

    private void newTravelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {

                TravelPanel tp = new TravelPanel() ;
                tp.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void inputTravelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                GetInputTravel git = new GetInputTravel() ;
                git.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void outputTravelBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                GetOutputTravel got = new GetOutputTravel() ;
                got.setVisible(true);
                dispose();
                return null ;
            }
        }.execute();
    }

    private void backBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        inputTravelBTN = new JButton();
        outputTravelBTN = new JButton();
        newTravelBTN = new JButton();
        backBTN = new JButton();

        //======== this ========
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 51, 51));

            //---- label1 ----
            label1.setText("Travel  Menu");
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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 555, Short.MAX_VALUE)
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

            //---- inputTravelBTN ----
            inputTravelBTN.setText("Get Input Travel");
            inputTravelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            inputTravelBTN.setForeground(Color.white);
            inputTravelBTN.setIcon(new ImageIcon(getClass().getResource("/icons/enter.png")));
            inputTravelBTN.setBackground(new Color(51, 0, 102));
            inputTravelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            inputTravelBTN.addActionListener(e -> inputTravelBTNActionPerformed(e));

            //---- outputTravelBTN ----
            outputTravelBTN.setText("Get Output Travel");
            outputTravelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            outputTravelBTN.setForeground(Color.white);
            outputTravelBTN.setIcon(new ImageIcon(getClass().getResource("/icons/sign-out.png")));
            outputTravelBTN.setBackground(new Color(0, 45, 0));
            outputTravelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            outputTravelBTN.addActionListener(e -> outputTravelBTNActionPerformed(e));

            //---- newTravelBTN ----
            newTravelBTN.setText("New Travel");
            newTravelBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            newTravelBTN.setForeground(Color.white);
            newTravelBTN.setIcon(new ImageIcon(getClass().getResource("/icons/new-document.png")));
            newTravelBTN.setBackground(new Color(0, 0, 102));
            newTravelBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            newTravelBTN.addActionListener(e -> newTravelBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("Back");
            backBTN.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            backBTN.setForeground(Color.white);
            backBTN.setIcon(new ImageIcon(getClass().getResource("/icons/back icon.png")));
            backBTN.setBackground(new Color(153, 51, 0));
            backBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap(366, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                            .addComponent(newTravelBTN, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputTravelBTN, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputTravelBTN, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
                        .addGap(328, 328, 328))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(newTravelBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputTravelBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(outputTravelBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
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
    private JButton inputTravelBTN;
    private JButton outputTravelBTN;
    private JButton newTravelBTN;
    private JButton backBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
