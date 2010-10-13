/*
 *  This file is part of YaBS.
 *
 *      YaBS is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *
 *      YaBS is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with YaBS.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * TimeframeChooser.java
 *
 * Created on 25.05.2009, 14:20:08
 */
package mpv5.ui.beans;

import java.util.Date;
import mpv5.utils.date.DateConverter;
import mpv5.utils.date.vTimeframe;

/**
 *
 *  
 */
public class TimeframeChooser extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    /** Creates new form TimeframeChooser */
    public TimeframeChooser() {
        initComponents();
        setTime(new vTimeframe(new Date(), new Date()))
               ;
    }
    private vTimeframe time;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new mpv5.ui.beans.DateChooser();
        dateChooser2 = new mpv5.ui.beans.DateChooser();
        jLabel1 = new javax.swing.JLabel();

        setFont(getFont());
        setName("Form"); // NOI18N

        dateChooser1.setName("dateChooser1"); // NOI18N

        dateChooser2.setName("dateChooser2"); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/2rightarrow.png"))); // NOI18N
        java.util.ResourceBundle bundle = mpv5.i18n.LanguageManager.getBundle(); // NOI18N
        jLabel1.setText(bundle.getString("TimeframeChooser.jLabel1.text")); // NOI18N
        jLabel1.setIconTextGap(0);
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(dateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dateChooser1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dateChooser2, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mpv5.ui.beans.DateChooser dateChooser1;
    private mpv5.ui.beans.DateChooser dateChooser2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the time
     */
    public vTimeframe getTime() {
        if (dateChooser1.hasDate() && dateChooser2.hasDate()) {
            time = new vTimeframe(dateChooser1.getDate(), DateConverter.getEndOfDay(dateChooser2.getDate()));
        }
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(vTimeframe time) {
        this.time = time;
        dateChooser1.setDate(time.getStart());
        dateChooser2.setDate(DateConverter.getEndOfDay(time.getEnd()));
    }
}
