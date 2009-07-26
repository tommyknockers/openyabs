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
import javax.swing.JTextField;
import mpv5.globals.LocalSettings;

/**
 *
 *  
 */
public class LabeledTextField extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    private String _text;
    private String _label;
    private Class clazz;

    /** Creates new form LabeledTextField */
    public LabeledTextField() {
        initComponents();

    }

    public JTextField getTextField() {
        return jTextField1;
    }

    /**
     * Determines if the field has some text
     * @return
     */
    public boolean hasText() {
        if (jTextField1.getText() != null && jTextField1.getText().length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setText(String text) {
        set_Text(text);
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
        jTextField1 = new javax.swing.JTextField();

        setOpaque(false);

        jLabel1.setText("text");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the _text
     */
    public String get_Text() {
        return getText();
    }

    /**
     * @param text the _text to set
     */
    public void set_Text(Object text) {
        this._text = String.valueOf(text);
        jTextField1.setText(_text);

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
        jTextField1.setEnabled(enabled);
    }

    /**
     * Set the class of possible entries. Currently supported:
     * <li>Integer - invalid values will be replaced with 0
     *<li>Double - invalid values will be replaced with 0.0
     * @param clazz
     */
    public void set_ValueClass(Class clazz) {
        this.clazz = clazz;
    }

    public String getText() {
        if (clazz == Integer.class) {
            try {
                Integer.valueOf(jTextField1.getText());
                jTextField1.setBackground(Color.WHITE);
            } catch (NumberFormatException numberFormatException) {
                jTextField1.setBackground(Color.RED);
                jTextField1.setText("0");
            }
        } else if (clazz == Double.class) {
            try {
                Double.valueOf(jTextField1.getText());
                jTextField1.setBackground(Color.WHITE);
            } catch (NumberFormatException numberFormatException) {
                jTextField1.setBackground(Color.RED);
                jTextField1.setText("0.0");
            }
        }
        return jTextField1.getText();
    }
}
