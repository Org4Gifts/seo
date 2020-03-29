/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adima.seo;

import com.adima.seo.util.AnalyUrl;
import static com.adima.seo.util.HttpClientUtil.getHtml;
import com.adima.seo.util.ForFile;
import java.io.IOException;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultCaret;

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
        jChkClickPeriod = new javax.swing.JCheckBox();
        jNumDelayClick = new javax.swing.JTextField();
        jChkWaitPeriod = new javax.swing.JCheckBox();
        jNumDelayWait = new javax.swing.JTextField();
        btnStart = new javax.swing.JButton();
        jSearchEngine = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("關鍵字     : ");

        inputKey.setText("adima");

        jLabel2.setText("目標網址 : ");

        inputUrl.setText("www.shopadima.com");

        jChkClickPeriod.setText("點擊倒數");

        jNumDelayClick.setText("5");

        jChkWaitPeriod.setText("重啟倒數");

        jNumDelayWait.setText("5");

        btnStart.setText("開始");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jSearchEngine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "https://www.google.com.tw/search?q=", "https://tw.search.yahoo.com/search?p=", "https://www.bing.com/search?q=" }));
        jSearchEngine.setEnabled(false);

        jLabel3.setText("搜尋引擎   :  ");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(10);
        jScrollPane2.setViewportView(jTextArea1);
        DefaultCaret caret = (DefaultCaret)jTextArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputKey))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputUrl))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSearchEngine, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jChkClickPeriod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNumDelayClick, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jChkWaitPeriod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNumDelayWait, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
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
                    .addComponent(jChkClickPeriod)
                    .addComponent(jNumDelayClick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChkWaitPeriod)
                    .addComponent(jNumDelayWait, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            jTextArea1.append("準備開始搜尋作業\n");
            btnStart.setText("停止");
            keyText = inputKey.getText().trim();
            keyUrl = inputUrl.getText().trim();
            searchEngine = jSearchEngine.getSelectedItem().toString();
            chkClickPeriod = jChkClickPeriod.isSelected();
            chkWaitPeriod = jChkWaitPeriod.isSelected();
            if (chkClickPeriod) {
                try {
                    numDelayClick = Integer.parseInt(jNumDelayClick.getText());
                    map.put("numDelayClick", numDelayClick + "");
                } catch (NumberFormatException e) {
                    jTextArea1.append("點擊倒數數字轉換錯誤.\n");
                    numError = true;
                }
            } else {
                numDelayClick = numDelayClick < 1 ? 1 : numDelayClick;
            }

            if (chkWaitPeriod) {
                try {
                    numDelayWait = Integer.parseInt(jNumDelayWait.getText());
                    map.put("numDelayWait", numDelayWait + "");
                } catch (NumberFormatException e) {
                    jTextArea1.append("迴圈倒數數字轉換錯誤.\n");
                    numError = true;
                }
            }

            map.put("keyText", keyText);
            map.put("keyUrl", keyUrl);
            map.put("searchEngine", jSearchEngine.getSelectedIndex() + "");
            map.put("chkClickPeriod", chkClickPeriod.toString());
            map.put("chkClickWait", chkWaitPeriod.toString());

            if (!numError) {
                jTextArea1.append("即將於...\n");
                temp.append(jTextArea1.getText());
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        jTextArea1.setText(temp.toString());
                        jTextArea1.append(numDelayClick-- + " 秒後開始...\n");
                        if (numDelayClick < 0) {
                            timer.cancel();
                            connect = true;
                            startConnect();
                        }
                    }
                }, 0, 1000);
            } else {
                numError = false;
                btnStart.setText("開始");
            }

            writeConfig();

        } else {
            timer.cancel();
            btnStart.setEnabled(false);
            jTextArea1.append("停止中...\n");
            connect = false;
        }

    }//GEN-LAST:event_btnStartActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        inputKey.setText(map.get("keyText"));
        inputUrl.setText(map.get("keyUrl"));
        jSearchEngine.setSelectedIndex(Integer.parseInt(map.get("searchEngine")));
        jChkClickPeriod.setSelected(Boolean.parseBoolean(map.get("chkClickPeriod")));
        jNumDelayClick.setText(map.get("numDelayClick"));
        jChkWaitPeriod.setSelected(Boolean.parseBoolean(map.get("chkClickWait")));
        jNumDelayWait.setText(map.get("numDelayWait"));
    }//GEN-LAST:event_formWindowOpened

    private String keyText, keyUrl, searchEngine;
    private Boolean isStart = false, chkClickPeriod = false, chkWaitPeriod = false, numError = false, connect = false;
    private int numDelayClick = 1, numDelayWait = 1;
    private StringBuilder temp = new StringBuilder();
    private static Map<String, String> map;

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

        /* Read config */
        ForFile.createFile("", "");
        map = ForFile.readFile("");


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeoFrame().setVisible(true);
            }
        });
    }

    void writeConfig() {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            sb.append(str)
                    .append(":")
                    .append(map.get(str))
                    .append("\n");
        }

        try {
            ForFile.writeFileContent("", sb.toString());
        } catch (IOException ex) {
//            Logger.getLogger(SeoFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
        }
    }

    void startConnect() {
        temp.setLength(0);
        Thread thread = null;
        if (connect) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (isStart) {
                            String resultUrl = getHtml(searchEngine + keyText);
//                            System.out.println("resultUrl: "+resultUrl);
                            String matchUrl = new AnalyUrl().analyUrl(resultUrl, keyUrl, keyText);
                            jTextArea1.append("搜尋結束.\n");
                            if (matchUrl.contains(keyUrl)) {
                                jTextArea1.append("搜尋到目標網址...\n");
                                jTextArea1.append("搜尋點擊將於2秒後開始...\n");
                                Thread.sleep(2000);
                                getHtml(matchUrl);
                                jTextArea1.append("開啟網頁結束.\n");
                            } else {
                                jTextArea1.append("沒有搜尋到目標網址...\n");
                            }

                            if (chkWaitPeriod) {
                                jTextArea1.append("等待" + numDelayWait + "秒後重啟搜尋...\n");
                                Thread.sleep(1000 * numDelayWait);
                            } else {
                                jTextArea1.append("完成.\n");
                                connect = false;
                                isStart = false;
                                btnStart.setText("開始");

                                if (chkClickPeriod) {
                                    numDelayClick = Integer.parseInt(jNumDelayClick.getText());
                                } else {
                                    numDelayClick = 1;
                                }
                            }
                        }

                        jTextArea1.append("終止搜尋.\n");
                        btnStart.setText("開始");
                        btnStart.setEnabled(true);

                    } catch (InterruptedException ex) {
//                    Logger.getLogger(SeoFrame.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Click target InterruptedException: " + ex.getMessage());
                        jTextArea1.append("取得網頁終止\n");
                    } catch (IOException ex) {
                        Logger.getLogger(SeoFrame.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Click target IOException: " + ex.getMessage());
                        jTextArea1.append("取得網頁出現錯誤\n");
                    }
                }

            });

            thread.start();

        } else {
            if (thread != null) {
                jTextArea1.append("終止連線.\n");
                btnStart.setText("開始");
                thread.interrupt();
                btnStart.setEnabled(true);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JTextField inputKey;
    private javax.swing.JTextField inputUrl;
    private javax.swing.JCheckBox jChkClickPeriod;
    private javax.swing.JCheckBox jChkWaitPeriod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jNumDelayClick;
    private javax.swing.JTextField jNumDelayWait;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jSearchEngine;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
