/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adima.seo;

import com.adima.seo.util.AnalyUrl;
import com.adima.seo.util.HttpClientUtil;
import static com.adima.seo.util.HttpClientUtil.getHtml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.httpclient.HttpClient;

/**
 *
 * @author yctse
 */
public class SeoFrame extends javax.swing.JFrame {

    /**
     * Creates new form SeoFrame
     */
    public SeoFrame() {
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

        jLabel1 = new javax.swing.JLabel();
        inputKey = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputUrl = new javax.swing.JTextField();
        checkPeriod = new javax.swing.JCheckBox();
        delayClick = new javax.swing.JTextField();
        checkWait = new javax.swing.JCheckBox();
        delayWait = new javax.swing.JTextField();
        btnStart = new javax.swing.JButton();
        jSearchEngine = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("KeyWord : ");

        inputKey.setText("adima");

        jLabel2.setText("KeyUrl    : ");

        inputUrl.setText("www.shopadima.com");

        checkPeriod.setText("ClickPeriod");

        delayClick.setText("5");

        checkWait.setText("WaitPeriod");

        delayWait.setText("5");

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jSearchEngine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "https://www.google.com.tw/search?q=", "https://tw.search.yahoo.com/search?p=", "https://www.bing.com/search?q=" }));

        jLabel3.setText("Search Engine   :  ");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(10);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputKey))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
                    .addComponent(jSearchEngine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkPeriod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delayClick, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkWait)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delayWait, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSearchEngine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkPeriod)
                    .addComponent(delayClick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkWait)
                    .addComponent(delayWait, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        isStart = !isStart;
        if (isStart) {
            timer = new Timer();
            jTextArea1.append("Start\n");
            btnStart.setText("Stop");
            textKey = inputKey.getText().trim();
            textUrl = inputUrl.getText().trim();
            searchEngine = jSearchEngine.getSelectedItem().toString();
            chkClick = checkPeriod.isEnabled();
            chkWait = checkWait.isEnabled();
            numDelayClick = Integer.parseInt(delayClick.getText());
            numDelayWait = Integer.parseInt(delayWait.getText());
            jTextArea1.append("Count down in...\n");
            temp.append(jTextArea1.getText());
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    jTextArea1.setText(temp.toString());
                    jTextArea1.append(numDelayClick-- + " sec\n");
                    if (numDelayClick < 0) {
                        timer.cancel();
                        connect = true;
//                        startConnect();
                        startConnect2();
                    }
                }
            }, 0, 1000);

        } else {
            timer.cancel();
            btnStart.setText("Start");
            jTextArea1.append("Stop\n");
            connect = false;
        }


    }//GEN-LAST:event_btnStartActionPerformed

    private String textKey, textUrl, searchEngine;
    private Boolean isStart = false, chkClick = false, chkWait = false, connect = false;
    private int numDelayClick = 2, numDelayWait = 2;
    private StringBuilder temp = new StringBuilder();

    private static Timer timer;

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
            java.util.logging.Logger.getLogger(SeoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeoFrame().setVisible(true);
            }
        });
    }

    void startConnect2() {
        temp.setLength(0);
        Thread thread = null;
        if (connect) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

//                        if (isStart) {
                            String resultUrl = new AnalyUrl().analyUrl(getHtml(searchEngine + textKey), textUrl);
                            jTextArea1.append("Search finish.\n");
                            jTextArea1.append("Start click in " + numDelayWait + " sec\n");

                            Thread.sleep(1000 * numDelayWait);
                            
                            getHtml(resultUrl);
                            jTextArea1.append("Open URL finish\n");
                            if (chkWait) {
                                jTextArea1.append("Wait " + numDelayWait + " sec to restart\n");
                            } else {
                                jTextArea1.append("Finish click\n");
                                connect = false;
                                isStart = false;
                                btnStart.setText("Start");
                            }
                            
//                        } else {
//
//                        }

                    } catch (InterruptedException ex) {
//                    Logger.getLogger(SeoFrame.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Click target InterruptedException: " + ex.getMessage());
                        jTextArea1.append("Get html Stop\n");
                    } catch (IOException ex) {
                        Logger.getLogger(SeoFrame.class.getName()).log(Level.SEVERE, null, ex);

                        System.out.println("Click target IOException: " + ex.getMessage());
                        jTextArea1.append("Get html has IOException\n");
                    }
                }

            });
        } else {
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    void startConnect() {
        if (connect) {
            temp.setLength(0);
//                System.out.println("textUrl: " + textUrl + " textKey: " + textKey);
            timer = new Timer();
            try {
                String resultUrl = new AnalyUrl().analyUrl(getHtml(searchEngine + textKey), textUrl);
                jTextArea1.append("Search finish.\n");
                jTextArea1.append("Start click in " + numDelayWait + " sec\n");

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            getHtml(resultUrl);
                            jTextArea1.append("Open URL finish\n");
//                            timer.cancel();
                            if (chkWait) {
                                jTextArea1.append("Restart in " + numDelayWait + " sec\n");
                                restartConnect();
                            } else {
                                timer.cancel();
                                connect = false;
                                isStart = false;
                                btnStart.setText("Start");
                            }
                        } catch (IOException ex) {
                            System.out.println("Click target IOException: " + ex.getMessage());
                            jTextArea1.append("Get html has IOException\n");
                        }
                        connect = false;
                    }
                }, 1000 * numDelayWait, 1000 * numDelayWait);

            } catch (IOException ex) {
//                Logger.getLogger(SeoFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Click search IOException: " + ex.getMessage());
            }
        }
    }

    void restartConnect() {
        if (connect) {
            temp.setLength(0);
            timer = new Timer();
            try {
                String resultUrl = new AnalyUrl().analyUrl(getHtml(searchEngine + textKey), textUrl);
                jTextArea1.append("Search finish.\n");
                jTextArea1.append("Start click in " + numDelayWait + " sec\n");

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            getHtml(resultUrl);
                            jTextArea1.append("Open URL finish\n");
                            timer.cancel();
                            if (chkWait) {
                                jTextArea1.append("Restart in " + numDelayWait + " sec\n");
                                startConnect();
                            } else {
                                connect = false;
                                isStart = false;
                                btnStart.setText("Start");
                            }
                        } catch (IOException ex) {
                            System.out.println("Click target IOException: " + ex.getMessage());
                            jTextArea1.append("Get html has IOException\n");
                        }
                        connect = false;
                    }
                }, 1000 * numDelayWait, 1000 * numDelayWait);

            } catch (IOException ex) {
//                Logger.getLogger(SeoFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Click search IOException: " + ex.getMessage());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JCheckBox checkPeriod;
    private javax.swing.JCheckBox checkWait;
    private javax.swing.JTextField delayClick;
    private javax.swing.JTextField delayWait;
    private javax.swing.JTextField inputKey;
    private javax.swing.JTextField inputUrl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jSearchEngine;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
