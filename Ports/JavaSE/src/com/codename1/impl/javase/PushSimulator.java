/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.impl.javase;

import com.codename1.io.Preferences;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.UUID;
import javax.swing.JFrame;

/**
 *
 * @author shai
 */
public class PushSimulator extends javax.swing.JFrame {

    /**
     * Creates new form PushSimulator
     */
    public PushSimulator() {
        initComponents();
        setLocationByPlatform(true);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                java.util.prefs.Preferences pref = java.util.prefs.Preferences.userNodeForPackage(JavaSEPort.class);
                pref.putBoolean("PushSimulator", false);
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        pack();
    }

    /**
     * This method is called from within the
     * constructor to initialize the form. WARNING: Do
     * NOT modify this code. The content of this method
     * is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        registerForPush = new javax.swing.JButton();
        pushError = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pushBody = new javax.swing.JTextArea();
        sendPush = new javax.swing.JButton();
        pushType = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Push Simulation");

        jLabel1.setText("Push Events");

        registerForPush.setText("Registered Successfully");
        registerForPush.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerForPushActionPerformed(evt);
            }
        });

        pushError.setText("Registration Error");
        pushError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pushErrorActionPerformed(evt);
            }
        });

        jLabel2.setText("Send Message");

        pushBody.setColumns(20);
        pushBody.setRows(5);
        jScrollPane1.setViewportView(pushBody);

        sendPush.setText("Send");
        sendPush.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendPushActionPerformed(evt);
            }
        });

        pushType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "99", "100", "101", "102" }));

        jLabel3.setText("Push Type");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pushError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerForPush, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sendPush)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pushType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerForPush)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pushError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pushType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendPush))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerForPushActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerForPushActionPerformed
        String k = Preferences.get("push_key", null);
        if(k == null || !k.startsWith("cn1")) {
            k = "cn1-simulator-" + UUID.randomUUID().toString();
            Preferences.set("push_key", k);
        }
        Executor.registerForPush(k);
    }//GEN-LAST:event_registerForPushActionPerformed

    private void pushErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pushErrorActionPerformed
        Executor.pushRegistrationError("Error During Push", -1);
    }//GEN-LAST:event_pushErrorActionPerformed

    private void sendPushActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendPushActionPerformed
        Executor.push(pushBody.getText(), Integer.parseInt((String)pushType.getSelectedItem()));
    }//GEN-LAST:event_sendPushActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea pushBody;
    private javax.swing.JButton pushError;
    private javax.swing.JComboBox pushType;
    private javax.swing.JButton registerForPush;
    private javax.swing.JButton sendPush;
    // End of variables declaration//GEN-END:variables
}
