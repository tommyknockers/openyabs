/*
 * Charts.java
 *
 * Created on 25. Februar 2008, 23:52
 */
package mp3.classes.visual.main;

import mp3.classes.utils.LineGraph;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Date;
import mp3.database.util.Query;
import mp3.classes.interfaces.Constants;
import mp3.classes.interfaces.ProtectedStrings;
import mp3.classes.interfaces.Strings;
import mp3.classes.interfaces.Structure;
import mp3.classes.objects.Bill;
import mp3.classes.objects.Data;
import mp3.classes.utils.BarChart;
import mp3.classes.utils.CompCenter;
import mp3.classes.utils.Formater;
import mp3.classes.utils.Log;

/**
 *
 * @author  anti43
 */
public class EinnahmenChart extends javax.swing.JFrame implements Strings, ProtectedStrings, Constants, Structure {

    private String[] months;

    /** Creates new form Charts */
    public EinnahmenChart() {
        initComponents();
        months = Constants.MONTHS;


        Integer maxval = 0;
        Integer minval = 0;

        Data d = new Data(mp3.classes.layer.QueryClass.instanceOf());


        for (int i = 1; i <= months.length; i++) {

            double str = d.fetchGewinnInMonth(months[i - 1], Formater.formatYear(new Date()));

            int temval = (int) str;

            if (temval > maxval) {
                maxval = temval;
            }else  if (temval < minval) {
                minval = temval;
            }

            
        }

        LineGraph bar = new LineGraph("Gewinn/Verlust " + Formater.formatYear(new Date()),minval-10, maxval + 10);
        

        for (int i = 1; i <= months.length; i++) {

            double str = d.fetchGewinnInMonth(months[i - 1], Formater.formatYear(new Date()));

            String string = months[i - 1];

            if ((int) str > 0) {
                
                bar.addItem(string + " (" + str + "�)", (int) str, Color.GREEN);
            } else if ((int) str < 0) {
                bar.addItem(string + " (" + str + "�)", (int) str, Color.red);
            } else {
                bar.addItem(string + " (" + str + "�)", (int) str, Color.BLACK);
            }
        }



        jPanel1.add(bar, BorderLayout.CENTER);
        jTextField1.setText(Formater.formatYear(new Date()));

        new CompCenter(this);

        this.setVisible(rootPaneCheckingEnabled);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MP Diagramm");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Diagramm"));
        jPanel1.setLayout(new java.awt.BorderLayout());
        jScrollPane1.setViewportView(jPanel1);

        jButton1.setText("Schlie�en");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setText("Zeitraum");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     

        if (Formater.check(jTextField1.getText(), Formater.YEAR)) {


            
        Integer maxval = 0;
        Integer minval = 0;

        Data d = new Data(mp3.classes.layer.QueryClass.instanceOf());


        for (int i = 1; i <= months.length; i++) {

            double str = d.fetchGewinnInMonth(months[i - 1], jTextField1.getText());

            int temval = (int) str;

            if (temval > maxval) {
                maxval = temval;
            }else  if (temval < minval) {
                minval = temval;
            }

            
        }

        LineGraph bar = new LineGraph("Gewinn/Verlust " +  jTextField1.getText(),minval-10, maxval + 10);
        

        for (int i = 1; i <= months.length; i++) {

            double str = d.fetchGewinnInMonth(months[i - 1],  jTextField1.getText());

            String string = months[i - 1];

            if ((int) str > 0) {
                
                bar.addItem(string + " (" + str + "�)", (int) str, Color.GREEN);
            } else if ((int) str < 0) {
                bar.addItem(string + " (" + str + "�)", (int) str, Color.red);
            } else {
                bar.addItem(string + " (" + str + "�)", (int) str, Color.BLACK);
            }
        }

            


            jPanel1.removeAll();


            jPanel1.add(bar, BorderLayout.CENTER);
            jPanel1.validate();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

        jButton2ActionPerformed(evt);
    }//GEN-LAST:event_jTextField1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
