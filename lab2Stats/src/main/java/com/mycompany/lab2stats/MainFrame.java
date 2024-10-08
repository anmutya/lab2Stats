package com.mycompany.lab2stats;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author annamutovkina
 */
public class MainFrame extends javax.swing.JFrame {
    private Manager manager = new Manager();

    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanelInputNameToSheet = new javax.swing.JPanel();
        jLabelInputIndex = new javax.swing.JLabel();
        jTextIndexSheet = new javax.swing.JTextField();
        buttonInputNameSheet = new javax.swing.JRadioButton();
        buttonInputIndexSheet = new javax.swing.JRadioButton();
        jTextNameOfSheet = new javax.swing.JTextField();
        buttonChoose = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButtonLoadfile = new javax.swing.JButton();
        jButtonCalcul = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();

        jFrame1.setVisible(false);
        jFrame1.setMinimumSize(new java.awt.Dimension(413, 300));

        jPanelInputNameToSheet.setVisible(false);

        jLabelInputIndex.setText("Введите название листа или его номер");

        jTextIndexSheet.setVisible(false);
        jTextIndexSheet.setMinimumSize(new java.awt.Dimension(80, 30));
        jTextIndexSheet.setPreferredSize(new java.awt.Dimension(80, 30));
        jTextIndexSheet.setSize(new java.awt.Dimension(80, 30));
        jTextIndexSheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIndexSheetActionPerformed(evt);
            }
        });

        buttonInputNameSheet.setText("Ввести название листа");
        buttonInputNameSheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInputNameSheetActionPerformed(evt);
            }
        });

        buttonInputIndexSheet.setText("Ввести номер листа");
        buttonInputIndexSheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInputIndexSheetActionPerformed(evt);
            }
        });

        jTextNameOfSheet.setVisible(false);
        jTextNameOfSheet.setMinimumSize(new java.awt.Dimension(100, 30));
        jTextNameOfSheet.setPreferredSize(new java.awt.Dimension(100, 30));
        jTextNameOfSheet.setSize(new java.awt.Dimension(100, 30));
        jTextNameOfSheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNameOfSheetActionPerformed(evt);
            }
        });

        buttonChoose.setText("Выбрать");
        buttonChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChooseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInputNameToSheetLayout = new javax.swing.GroupLayout(jPanelInputNameToSheet);
        jPanelInputNameToSheet.setLayout(jPanelInputNameToSheetLayout);
        jPanelInputNameToSheetLayout.setHorizontalGroup(
            jPanelInputNameToSheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputNameToSheetLayout.createSequentialGroup()
                .addGroup(jPanelInputNameToSheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInputNameToSheetLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabelInputIndex))
                    .addGroup(jPanelInputNameToSheetLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanelInputNameToSheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonInputNameSheet)
                            .addComponent(buttonInputIndexSheet))
                        .addGap(49, 49, 49)
                        .addGroup(jPanelInputNameToSheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextIndexSheet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNameOfSheet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInputNameToSheetLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonChoose)
                .addGap(146, 146, 146))
        );

        jPanelInputNameToSheetLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextIndexSheet, jTextNameOfSheet});

        jPanelInputNameToSheetLayout.setVerticalGroup(
            jPanelInputNameToSheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputNameToSheetLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelInputIndex)
                .addGap(24, 24, 24)
                .addGroup(jPanelInputNameToSheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInputNameSheet)
                    .addComponent(jTextNameOfSheet, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelInputNameToSheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInputIndexSheet)
                    .addComponent(jTextIndexSheet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonChoose)
                .addGap(35, 35, 35))
        );

        jPanelInputNameToSheetLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextIndexSheet, jTextNameOfSheet});

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
            .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jFrame1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelInputNameToSheet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jFrame1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelInputNameToSheet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonLoadfile.setText("Import file");
        jButtonLoadfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadfileActionPerformed(evt);
            }
        });

        jButtonCalcul.setText("Export statistics");
        jButtonCalcul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculActionPerformed(evt);
            }
        });

        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButtonLoadfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jButtonCalcul)
                .addGap(53, 53, 53))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jButtonExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCalcul)
                    .addComponent(jButtonLoadfile))
                .addGap(73, 73, 73)
                .addComponent(jButtonExit)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoadfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadfileActionPerformed
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Microsoft Excel Files", "xlsx");
            jFileChooser.setFileFilter(filter);
            
            int resonse = jFileChooser.showOpenDialog(null);
            if(resonse == 0){
                manager.setFile(new File(jFileChooser.getSelectedFile().getAbsolutePath())); 
                jFrame1.setVisible(true);
                jPanelInputNameToSheet.setVisible(true);
                }       
    }//GEN-LAST:event_jButtonLoadfileActionPerformed

    private void jButtonCalculActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculActionPerformed
        try {
            manager.exportFile();
            System.out.println("Successful export");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Импортируйте что-нибудь!\nУ меня ничего нет для экспорта...", "Алло!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCalculActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jTextIndexSheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIndexSheetActionPerformed
        SwingUtilities.updateComponentTreeUI(jFrame1);

    }//GEN-LAST:event_jTextIndexSheetActionPerformed

    private void jTextNameOfSheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNameOfSheetActionPerformed
        // TODO add your handling code here:
        SwingUtilities.updateComponentTreeUI(jFrame1);

    }//GEN-LAST:event_jTextNameOfSheetActionPerformed

    private void buttonInputNameSheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInputNameSheetActionPerformed
        jTextNameOfSheet.setVisible(true);

        if(buttonInputIndexSheet.isSelected()){
            jTextIndexSheet.setText("");
            buttonInputIndexSheet.setSelected(false);
        }
        SwingUtilities.updateComponentTreeUI(jFrame1);

    }//GEN-LAST:event_buttonInputNameSheetActionPerformed

    private void buttonInputIndexSheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInputIndexSheetActionPerformed
        jTextIndexSheet.setVisible(true);
        if(buttonInputNameSheet.isSelected()){
            jTextNameOfSheet.setText("");
            buttonInputNameSheet.setSelected(false);
        }
        SwingUtilities.updateComponentTreeUI(jFrame1);

    }//GEN-LAST:event_buttonInputIndexSheetActionPerformed

    private void buttonChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChooseActionPerformed
        if(buttonInputNameSheet.isSelected()){
            try {
                manager.importExcel(manager.getFile().getAbsolutePath(), jTextNameOfSheet.getText());
                jFrame1.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(buttonInputIndexSheet.isSelected()){
            try {
                manager.importExcel(manager.getFile().getAbsolutePath(), Integer.parseInt(jTextIndexSheet.getText()));
                jFrame1.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Выберите лист!!!", "Алло!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buttonChooseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChoose;
    private javax.swing.JRadioButton buttonInputIndexSheet;
    private javax.swing.JRadioButton buttonInputNameSheet;
    private javax.swing.JButton jButtonCalcul;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonLoadfile;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabelInputIndex;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelInputNameToSheet;
    private javax.swing.JTextField jTextIndexSheet;
    private javax.swing.JTextField jTextNameOfSheet;
    // End of variables declaration//GEN-END:variables
}
