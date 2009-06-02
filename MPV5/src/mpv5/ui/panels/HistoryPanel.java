/*
 *  This file is part of MP.
 *
 *      MP is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *
 *      MP is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with MP.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * HistoryPanel.java
 *
 * Created on 30.03.2009, 12:05:51
 */
package mpv5.ui.panels;

import java.awt.Component;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import mpv5.db.common.Context;
import mpv5.db.common.QueryCriteria;
import mpv5.db.common.DatabaseObject;
import mpv5.db.common.NodataFoundException;
import mpv5.db.common.QueryHandler;
import mpv5.globals.Headers;
import mpv5.db.objects.Group;
import mpv5.logging.Log;
import mpv5.db.objects.User;
import mpv5.utils.arrays.ArrayUtilities;
import mpv5.utils.date.DateConverter;
import mpv5.utils.date.vTimeframe;
import mpv5.utils.models.MPTableModel;
import mpv5.utils.tables.TableFormat;

/**
 *
 *  anti
 */
public class HistoryPanel extends javax.swing.JPanel implements ListPanel {

    private static HistoryPanel t;
    private static final long serialVersionUID = 1L;

    public static Component instanceOf() {
        if (t == null) {
            t = new HistoryPanel();
        }
        return t;
    }

    /** Creates new form HistoryPanel */
    public HistoryPanel() {
        initComponents();
        timeframeChooser1.setTime(new vTimeframe(DateConverter.getDate(DateConverter.getYear()), new Date()));
        prinitingComboBox1.init(jTable1);
        Object[] dat;
        Object[] dat2;
        try {
            dat = DatabaseObject.getObjects(Context.getUser()).toArray();
            dat = ArrayUtilities.merge(new Object[]{User.DEFAULT}, dat);
            users.setModel(new DefaultComboBoxModel(dat));
        } catch (NodataFoundException ex) {
            Log.Debug(ex);
            users.setModel(new DefaultComboBoxModel());
        }

        try {
            dat2 = DatabaseObject.getObjects(Context.getGroup()).toArray();
            dat2 = ArrayUtilities.merge(new Object[]{new Group("")}, dat2);
            groups.setModel(new DefaultComboBoxModel(dat2));
        } catch (NodataFoundException ex) {
            Log.Debug(ex);
            groups.setModel(new DefaultComboBoxModel());
        }

        refresh(null, null);
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
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        users = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        groups = new javax.swing.JComboBox();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        prinitingComboBox1 = new mpv5.ui.beans.PrinitingComboBox();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        timeframeChooser1 = new mpv5.ui.beans.TimeframeChooser();

        setName("Form"); // NOI18N

        java.util.ResourceBundle bundle = mpv5.i18n.LanguageManager.getBundle(); // NOI18N
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("HistoryPanel.jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        jLabel1.setText(bundle.getString("HistoryPanel.jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jToolBar1.add(jLabel1);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jToolBar1.add(jSeparator1);

        users.setMaximumSize(new java.awt.Dimension(224, 20));
        users.setName("users"); // NOI18N
        users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersActionPerformed(evt);
            }
        });
        jToolBar1.add(users);

        jSeparator2.setName("jSeparator2"); // NOI18N
        jToolBar1.add(jSeparator2);

        jLabel2.setText(bundle.getString("HistoryPanel.jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jToolBar1.add(jLabel2);

        jSeparator5.setName("jSeparator5"); // NOI18N
        jToolBar1.add(jSeparator5);

        groups.setMaximumSize(new java.awt.Dimension(224, 20));
        groups.setName("groups"); // NOI18N
        groups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupsActionPerformed(evt);
            }
        });
        jToolBar1.add(groups);

        jSeparator6.setName("jSeparator6"); // NOI18N
        jToolBar1.add(jSeparator6);

        jButton1.setText(bundle.getString("HistoryPanel.jButton1.text")); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jSeparator4.setName("jSeparator4"); // NOI18N
        jToolBar1.add(jSeparator4);

        prinitingComboBox1.setName("prinitingComboBox1"); // NOI18N
        jToolBar1.add(prinitingComboBox1);

        jSeparator3.setName("jSeparator3"); // NOI18N
        jToolBar1.add(jSeparator3);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setAutoCreateRowSorter(true);
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
        jScrollPane1.setViewportView(jTable1);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setName("jToolBar2"); // NOI18N

        timeframeChooser1.setName("timeframeChooser1"); // NOI18N
        jToolBar2.add(timeframeChooser1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (users.getSelectedIndex() > 0 && groups.getSelectedIndex() > 0) {
                refresh((User) users.getSelectedItem(), (Group) groups.getSelectedItem());
            } else if (groups.getSelectedIndex() > 0) {
                refresh(null, (Group) groups.getSelectedItem());
            } else if (users.getSelectedIndex() > 0) {
                refresh((User) users.getSelectedItem(), null);
            } else {
                refresh(null, null);
            }
        } catch (Exception ignore) {
            refresh(null, null);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void groupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupsActionPerformed
    }//GEN-LAST:event_groupsActionPerformed

    private void usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersActionPerformed
    }//GEN-LAST:event_usersActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox groups;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private mpv5.ui.beans.PrinitingComboBox prinitingComboBox1;
    private mpv5.ui.beans.TimeframeChooser timeframeChooser1;
    private javax.swing.JComboBox users;
    // End of variables declaration//GEN-END:variables

    private void refresh(User forUser, Group forGroup) {
        QueryCriteria dh = new QueryCriteria();
        Object[][] d = new Object[0][0];

        if (forUser != null && !forUser.equals(User.DEFAULT)) {
            try {
 
                dh.add(forUser.getType() + "name", forUser.getName());

                if (forGroup != null && !forGroup.__getCName().equals("")) {
                    dh.add( forGroup.getDbIdentity() + "ids", forGroup.__getIDS());
                }
                Context c = Context.getHistory();
                c.addReference(Context.getGroup());
                d = QueryHandler.instanceOf().clone(c).select(Context.DETAILS_HISTORY, dh, timeframeChooser1.getTime());

            } catch (NodataFoundException ex) {
                Log.Debug(this, ex.getMessage());
            }
        } else if (forGroup != null && !forGroup.__getCName().equals("")) {
            try {
              
                dh.add( forGroup.getDbIdentity() + "ids", forGroup.__getIDS());

                Context c = Context.getHistory();
                c.addReference(Context.getGroup());
                d = QueryHandler.instanceOf().clone(c).select(Context.DETAILS_HISTORY, dh, timeframeChooser1.getTime());

            } catch (NodataFoundException ex) {
                Log.Debug(this, ex.getMessage());
            }
        } else {
            try {
                Context c = Context.getHistory();
                dh = new QueryCriteria();
                c.addReference(Context.getGroup());
                d = QueryHandler.instanceOf().clone(c).select(Context.DETAILS_HISTORY, dh, timeframeChooser1.getTime());
            } catch (NodataFoundException ex) {
                Log.Debug(this, ex.getMessage());
            }

        }

        jTable1.setModel(new MPTableModel(ArrayUtilities.changeToClassValue(d, 4, Date.class), Headers.HISTORY.getValue(), new Class[]{String.class, String.class, String.class, String.class, Date.class}));
        TableFormat.stripColumn(jTable1, 0);
//        TableFormat.stripColumn(jTable1, 3);
//        TableFormat.stripColumn(jTable1, 4);
    }

        public void refresh() {
      refresh(null,null);
    }

    public void flush() {
      jTable1.setModel(new DefaultTableModel());
    }
}
