/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LabeledTextField.java
 *
 * Created on 20.11.2008, 19:26:39
 */
package mpv5.ui.beans;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import mpv5.globals.LocalSettings;

/**
 *
 *  
 */
public class LabeledSpinner extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    private String _text;
    private String _label;
    private Class clazz;

    /** Creates new form LabeledTextField */
    public LabeledSpinner() {
        initComponents();

    }

    public JSpinner getSpinner() {
        return jSpinner1;
    }




//    public void setLabelFont(Font font) {
//        setFont(font);
//
//    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();

        setOpaque(false);

        jLabel1.setFont(jLabel1.getFont());
        jLabel1.setText("text");

        jSpinner1.setFont(jSpinner1.getFont());
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel());
        jSpinner1.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner1, ""));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSpinner1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the _text
     */
    public Object get_Value() {
        return jSpinner1.getValue();
    }

    /**
     * @param text the _text to set
     */
    public void set_Value(Object text) {
        this._text = String.valueOf(text);
        jSpinner1.setValue(text);

    }

    /**
     * @return the _label
     */
    public String get_Label() {
        return jLabel1.getText();
    }

    /**
     * @param label the _label to set
     */
    public void set_Label(String label) {
        this._label = label;
        jLabel1.setText(_label);
        this.setToolTipText(_text);
        jLabel1.setToolTipText(_text);
    }

    public void set_LabelFont(Font font) {
//        if (font != null) {
//            jLabel1.setFont(font);
//        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        jLabel1.setEnabled(enabled);
        jSpinner1.setEnabled(enabled);
    }

    /**
     *
     * @param i
     */
    public void setValue(int i) {
        set_Value(i);
    }


}
