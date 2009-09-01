/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SplashScreen.java
 *
 * Created on 30.03.2009, 21:55:52
 */
package mpv5.ui.dialogs;

import java.util.ArrayList;
import java.util.Date;

import mpv5.db.common.Context;
import mpv5.db.common.DatabaseObject;
import mpv5.db.common.NodataFoundException;
import mpv5.db.objects.Item;
import mpv5.db.objects.Schedule;
import mpv5.globals.Headers;
import mpv5.globals.Messages;
import mpv5.logging.Log;
import mpv5.ui.frames.MPView;
import mpv5.ui.misc.Position;
import mpv5.ui.panels.calendar.*;
import mpv5.utils.date.DateConverter;
import mpv5.utils.models.MPTableModel;
import mpv5.utils.tables.TableFormat;

/**
 *
 *  
 */
public class ScheduleDayEvent extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private static ScheduleDayEvent icke;
    private Schedule dataOwner;

    public static ScheduleDayEvent instanceOf() {
        if (icke == null) {
            icke = new ScheduleDayEvent();
        }
        return icke;
    }
    private String text = "";

    private ScheduleDayEvent() {
        initComponents();
        text = jLabel3.getText();
        refresh(new Date());
        labeledCombobox1.setSearchOnEnterEnabled(true);
        labeledCombobox1.setContext(Context.getBill());
        setAlwaysOnTop(true);
        new Position(this);
    }

    @Override
    public void dispose() {
        setVisible(false);
    }

    public void setDate(Date tday) {
        labeledDateChooser1.setDate(tday);
        labeledDateChooser2.setDate(DateConverter.addYear(tday));
        refresh(tday);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        labeledCombobox1 = new mpv5.ui.beans.LabeledCombobox();
        labeledSpinner1 = new mpv5.ui.beans.LabeledSpinner();
        jLabel1 = new javax.swing.JLabel();
        labeledDateChooser1 = new mpv5.ui.beans.LabeledDateChooser();
        labeledDateChooser2 = new mpv5.ui.beans.LabeledDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("mpv5/resources/languages/Panels"); // NOI18N
        setTitle(bundle.getString("ScheduleDayEvent.title")); // NOI18N
        setAlwaysOnTop(true);
        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("ScheduleDayEvent.jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText(bundle.getString("ScheduleDayEvent.jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        labeledCombobox1.set_Label(bundle.getString("ScheduleDayEvent.labeledCombobox1._Label")); // NOI18N
        labeledCombobox1.setName("labeledCombobox1"); // NOI18N

        labeledSpinner1.set_Label(bundle.getString("ScheduleDayEvent.labeledSpinner1._Label")); // NOI18N
        labeledSpinner1.setName("labeledSpinner1"); // NOI18N

        jLabel1.setText(bundle.getString("ScheduleDayEvent.jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        labeledDateChooser1.setToolTipText(bundle.getString("ScheduleDayEvent.labeledDateChooser1.toolTipText")); // NOI18N
        labeledDateChooser1.set_Label(bundle.getString("ScheduleDayEvent.labeledDateChooser1._Label")); // NOI18N
        labeledDateChooser1.setName("labeledDateChooser1"); // NOI18N

        labeledDateChooser2.set_Label(bundle.getString("ScheduleDayEvent.labeledDateChooser2._Label")); // NOI18N
        labeledDateChooser2.setName("labeledDateChooser2"); // NOI18N

        jPanel2.setName("jPanel2"); // NOI18N

        jButton2.setText(bundle.getString("ScheduleDayEvent.jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jPanel2.add(jSeparator1);

        jSeparator3.setName("jSeparator3"); // NOI18N
        jPanel2.add(jSeparator3);

        jButton3.setText(bundle.getString("ScheduleDayEvent.jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jSeparator2.setName("jSeparator2"); // NOI18N
        jPanel2.add(jSeparator2);

        jButton1.setText(bundle.getString("ScheduleDayEvent.jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton4.setText(bundle.getString("ScheduleDayEvent.jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        jButton5.setText(bundle.getString("ScheduleDayEvent.jButton5.text")); // NOI18N
        jButton5.setName("jButton5"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labeledSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labeledDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labeledDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labeledCombobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labeledCombobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(labeledSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labeledDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labeledDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     
            Schedule d = (Schedule) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            if (d != null) {
                try {
                    labeledCombobox1.setModel(d.getItem());
                } catch (NodataFoundException ex) {
                    Log.Debug(ex);
                }

                labeledDateChooser1.setDate(d.__getStartdate());
                labeledDateChooser2.setDate(d.__getStopdate());
                labeledSpinner1.setValue(d.__getIntervalmonth());
                dataOwner = d;
            }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        save(new Schedule());
        refresh(new Date());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        save(dataOwner);
        refresh(new Date());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (dataOwner != null && dataOwner.isExisting()) {
            dataOwner.delete();
            refresh(new Date());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            MPView.identifierView.addTab(DatabaseObject.getObject(Context.getItems(), Integer.valueOf(labeledCombobox1.getSelectedItem().getId())));
        } catch (Exception ex) {
            Log.Debug(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private mpv5.ui.beans.LabeledCombobox labeledCombobox1;
    private mpv5.ui.beans.LabeledDateChooser labeledDateChooser1;
    private mpv5.ui.beans.LabeledDateChooser labeledDateChooser2;
    private mpv5.ui.beans.LabeledSpinner labeledSpinner1;
    // End of variables declaration//GEN-END:variables

    private void refresh(Date da) {
        labeledSpinner1.setValue(1);
        jLabel3.setText(text + " " + DateConverter.getDefDateString(da));
        ArrayList<Schedule> data = Schedule.getEvents(da);
        Object[][] d = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            Schedule schedule = data.get(i);
            d[i] = schedule.toArray();
        }
        jTable1.setModel(new MPTableModel(d, Headers.SCHEDULE_LIST));
        TableFormat.resizeCols(jTable1, new Integer[]{150}, true);
    }

    private void save(Schedule s) {
        if (s != null) {
            try {
                Item i = (Item) DatabaseObject.getObject(Context.getItems(), Integer.valueOf(labeledCombobox1.getSelectedItem().getId()));
                s.setCName("(" + Messages.SCHEDULE + ") " + i.toString());
                s.setItemsids(i.__getIDS());
                s.setGroupsids(i.__getGroupsids());
                s.setIntervalmonth(Integer.valueOf(labeledSpinner1.getSpinner().getValue().toString()));
                s.setStartdate(labeledDateChooser1.getDate());
                s.setStopdate(labeledDateChooser2.getDate());
                s.setUsersids(MPView.getUser().__getIDS());
                s.setNextdate(labeledDateChooser1.getDate());
                s.save();
                dataOwner = s;
                Popup.notice(Messages.SCHEDULE_NEXT +
                        DateConverter.getDefDateString(DateConverter.addMonths(labeledDateChooser1.getDate(),
                        s.__getIntervalmonth())));
                JDayChooser.instanceOf().reload();
            } catch (Exception ex) {
                Log.Debug(this, ex.getMessage());
            }
        }
    }

    /**
     *
     * @param dataOwner
     */
    public void setItem(Item dataOwner) {
        labeledCombobox1.setModel(dataOwner);
        setDate(new Date());
        setVisible(true);
    }
}
