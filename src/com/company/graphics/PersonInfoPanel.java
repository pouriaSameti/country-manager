/*
 * Created by JFormDesigner on Thu Jul 01 17:20:07 IRDT 2021
 */

package com.company.graphics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author pouria
 */
public class PersonInfoPanel extends JFrame {
    public PersonInfoPanel() {

        initComponents();
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            if (info.getName().equals("Nimbus"))
            {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.invokeLater(()-> SwingUtilities.updateComponentTreeUI(getRootPane()));
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

    private void okBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel3 = new JPanel();
        label8 = new JLabel();
        label11 = new JLabel();
        panel4 = new JPanel();
        okBTN2 = new JButton();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        nameLBL = new JLabel();
        idLBL = new JLabel();
        genderLBL = new JLabel();
        birthYearLBL = new JLabel();
        jobLBL = new JLabel();
        birthPlaceLBL = new JLabel();
        label18 = new JLabel();
        workHouseLBL = new JLabel();
        wirkHouseLBL = new JLabel();
        label20 = new JLabel();
        salaryLBL = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/main picture.jpg")).getImage());
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panel3 ========
        {
            panel3.setBackground(new Color(0, 51, 51));

            //---- label8 ----
            label8.setText("Person Information");
            label8.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label8.setForeground(Color.white);

            //---- label11 ----
            label11.setIcon(new ImageIcon(getClass().getResource("/icons/close.png")));
            label11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label11.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label2MouseClicked(e);
                }
            });

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 565, Short.MAX_VALUE)
                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel3Layout.createParallelGroup()
                            .addComponent(label11, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== panel4 ========
        {
            panel4.setBackground(new Color(51, 0, 0));

            //---- okBTN2 ----
            okBTN2.setText("Ok");
            okBTN2.setBackground(new Color(1, 18, 1));
            okBTN2.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            okBTN2.setForeground(Color.white);
            okBTN2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            okBTN2.setIcon(new ImageIcon(getClass().getResource("/icons/red checked.png")));
            okBTN2.addActionListener(e -> okBTNActionPerformed(e));

            //---- label12 ----
            label12.setText("Name");
            label12.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label12.setForeground(Color.white);
            label12.setIcon(new ImageIcon(getClass().getResource("/icons/user.png")));

            //---- label13 ----
            label13.setText("ID");
            label13.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label13.setForeground(Color.white);
            label13.setIcon(new ImageIcon(getClass().getResource("/icons/qr.png")));

            //---- label14 ----
            label14.setText("Gender");
            label14.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label14.setForeground(Color.white);
            label14.setIcon(new ImageIcon(getClass().getResource("/icons/lavatory.png")));

            //---- label15 ----
            label15.setText("Birth Year");
            label15.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label15.setForeground(Color.white);
            label15.setIcon(new ImageIcon(getClass().getResource("/icons/birth Date.png")));

            //---- label16 ----
            label16.setText("Job");
            label16.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label16.setForeground(Color.white);
            label16.setIcon(new ImageIcon(getClass().getResource("/icons/suitcase.png")));

            //---- nameLBL ----
            nameLBL.setText("text");
            nameLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            nameLBL.setForeground(Color.white);

            //---- idLBL ----
            idLBL.setText("text");
            idLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            idLBL.setForeground(Color.white);

            //---- genderLBL ----
            genderLBL.setText("text");
            genderLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            genderLBL.setForeground(Color.white);

            //---- birthYearLBL ----
            birthYearLBL.setText("text");
            birthYearLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            birthYearLBL.setForeground(Color.white);

            //---- jobLBL ----
            jobLBL.setText("text");
            jobLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            jobLBL.setForeground(Color.white);

            //---- birthPlaceLBL ----
            birthPlaceLBL.setText("text");
            birthPlaceLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            birthPlaceLBL.setForeground(Color.white);

            //---- label18 ----
            label18.setText("Birth Palace");
            label18.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label18.setForeground(Color.white);
            label18.setIcon(new ImageIcon(getClass().getResource("/icons/map.png")));

            //---- workHouseLBL ----
            workHouseLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            workHouseLBL.setForeground(Color.white);

            //---- wirkHouseLBL ----
            wirkHouseLBL.setText("Work House");
            wirkHouseLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            wirkHouseLBL.setForeground(Color.white);
            wirkHouseLBL.setIcon(new ImageIcon(getClass().getResource("/icons/building.png")));

            //---- label20 ----
            label20.setText("Salary");
            label20.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            label20.setForeground(Color.white);
            label20.setIcon(new ImageIcon(getClass().getResource("/icons/salary.png")));

            //---- salaryLBL ----
            salaryLBL.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
            salaryLBL.setForeground(Color.white);

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createParallelGroup()
                                .addGroup(panel4Layout.createSequentialGroup()
                                    .addGroup(panel4Layout.createParallelGroup()
                                        .addComponent(label18, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                        .addGroup(panel4Layout.createSequentialGroup()
                                            .addGroup(panel4Layout.createParallelGroup()
                                                .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(label12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(label13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(label14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(label15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(label16, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addGap(34, 34, 34))
                                .addGroup(panel4Layout.createSequentialGroup()
                                    .addComponent(wirkHouseLBL, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                    .addGap(23, 23, 23)))
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addComponent(label20, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addGroup(panel4Layout.createParallelGroup()
                            .addComponent(nameLBL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(okBTN2, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel4Layout.createParallelGroup()
                                        .addComponent(salaryLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(workHouseLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(idLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(genderLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(birthYearLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(birthPlaceLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jobLBL, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 351, Short.MAX_VALUE)))
                        .addContainerGap())
            );
            panel4Layout.setVerticalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLBL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label15, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthYearLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label18, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthPlaceLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jobLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label16, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(wirkHouseLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(workHouseLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel4Layout.createParallelGroup()
                            .addComponent(label20, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(salaryLBL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okBTN2)
                        .addGap(15, 15, 15))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setSize(940, 545);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel3;
    private JLabel label8;
    private JLabel label11;
    private JPanel panel4;
    private JButton okBTN2;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    public JLabel nameLBL;
    public JLabel idLBL;
    public JLabel genderLBL;
    public JLabel birthYearLBL;
    public JLabel jobLBL;
    public JLabel birthPlaceLBL;
    private JLabel label18;
    public JLabel workHouseLBL;
    private JLabel wirkHouseLBL;
    private JLabel label20;
    public JLabel salaryLBL;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
