/*
 * DateField.java
 *
 * Created on September 17, 2008, 2:01 PM
 */
package mp4.visualbeans;

import mp4.utils.ui.inputfields.*;
import java.util.Date;
import mp4.items.Popup;
import mp4.items.visual.DatePick;
import mp4.utils.datum.DateConverter;
import mp4.utils.datum.vDate;

/**
 *
 * @author  anti43
 */
public class DateField extends javax.swing.JPanel {

    private Date date;

    /** Creates new form DateField */
    public DateField() {
        initComponents();
        jTextField1.setText(DateConverter.getTodayDefDate());
        jTextField1.setInputVerifier(InputVerifiers.getDateInputVerfier(jTextField1));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setOpaque(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilder/small/cal.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    new DatePick(jTextField1);
}//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    public Date getDate() {

        date  = DateConverter.getDate(jTextField1.getText());
        if (date != null) {
            return date;
        } else {
            Popup.error("Fehler bei der Dateneingabe: Datum (" + jTextField1.getText() +")", "Es ist ein Fehler aufgetreten");
            return new Date();
        }
    }

    public void setDate(Date date) {
        this.date = date;
        jTextField1.setText(DateConverter.getDefDateString(date));
    }
}
