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
import java.math.BigDecimal;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mpv5.db.common.Context;
import mpv5.db.common.DatabaseObject;
import mpv5.db.common.NodataFoundException;
import mpv5.globals.Messages;
import mpv5.logging.Log;
import mpv5.ui.panels.DataPanel;
import mpv5.utils.numberformat.FormatNumber;
import mpv5.utils.ui.TextFieldUtils;

/**
 *
 *  
 */
public class LabeledTextField extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    private String _text;
    private String _label;
    private Class clazz;
    private DataPanel parent;
    private Context context;
    private String searchField;
    private boolean searchOnEnterEnabled;
    private Object displayingObject;

    /** Creates new form LabeledTextField */
    public LabeledTextField() {
        initComponents();

    }

    /**
     *
     * @return
     */
    public JTextField getTextField() {
        return jTextField1;
    }

    /**
     *
     * @return
     */
    public JLabel getLabelField() {
        return jLabel1;
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
        setText((Object) text);
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

        jLabel1.setFont(jLabel1.getFont());
        jLabel1.setText("text");

        jTextField1.setFont(jTextField1.getFont());
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 51, 51));
        jTextField1.setMinimumSize(new java.awt.Dimension(5, 20));
        jTextField1.setPreferredSize(new java.awt.Dimension(5, 20));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        DatabaseObject data;
        if (searchOnEnterEnabled) {
            try {
                if (searchField != null) {
                    data = DatabaseObject.getObject(context, searchField, jTextField1.getText());
                } else {
                    data = DatabaseObject.getObject(context, jTextField1.getText());
                }
                parent.setDataOwner(data, true);
                Log.Debug(this, "Data found: " + data);
                Log.PrintArray(data.getValues3().toArray(new Object[][]{}));
            } catch (NodataFoundException ex) {
                Log.Debug(this, "Data NOT found: " + jTextField1.getText());
                TextFieldUtils.blinkerRed(jTextField1);
            }
        }
    }//GEN-LAST:event_jTextField1ActionPerformed
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
    public void setText(Object text) {
        if (text == null) {
            text = "";
        }
        if (clazz != null && (clazz == Double.class || clazz == BigDecimal.class)) {
            try {
                this._text = FormatNumber.formatDezimal((Number) text);
            } catch (Exception e) {
                try {
                    this._text = FormatNumber.formatDezimal(new BigDecimal(String.valueOf(text)));
                } catch (Exception ex) {
                    this._text = String.valueOf(text);
                }
            }
        } else {
            this._text = String.valueOf(text);
        }
        jTextField1.setText(_text);
    }

    /**
     * @param text the _text to set
     */
    public void set_Text(String text) {
        setText(text);
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

        /**
     * @param label the _label to set
     */
    public void setLabel(String label) {
        set_Label(label);
    }


    public void set_LabelFont(Font font) {
//        if (font != null) {
//            jLabel1.setFont(font);
//        }
    }

    @Override
    public void setEnabled(boolean enabled) {
//        jLabel1.setEnabled(enabled);
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
                Log.Debug(numberFormatException);
                TextFieldUtils.blinker(jTextField1, Color.gray);
                jTextField1.setText("0");
            }
        } else if (clazz == Double.class) {
            try {
                FormatNumber.parseDezimal(jTextField1.getText());
                jTextField1.setBackground(Color.WHITE);
            } catch (NumberFormatException numberFormatException) {
                Log.Debug(numberFormatException);
                TextFieldUtils.blinker(jTextField1, Color.gray);
                jTextField1.setText("0.0");
            }
        } else if (clazz == BigDecimal.class) {
            try {
                FormatNumber.parseDezimal(jTextField1.getText());
                jTextField1.setBackground(Color.WHITE);
            } catch (NumberFormatException numberFormatException) {
                Log.Debug(this, jTextField1.getText());
                Log.Debug(numberFormatException);

                TextFieldUtils.blinker(jTextField1, Color.gray);
                jTextField1.setText("0.0");
            }
        }
        String txt = jTextField1.getText();
        if (txt == null) {
            txt = "";
        }
        return txt;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(DataPanel parent) {
        this.parent = parent;
    }

    /**
     * @return the context
     */
    public Context getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * @return the searchOnEnterEnabled
     */
    public boolean isSearchOnEnterEnabled() {
        return searchOnEnterEnabled;
    }

    /**
     * @param searchOnEnterEnabled the searchOnEnterEnabled to set
     */
    public void setSearchOnEnterEnabled(boolean searchOnEnterEnabled) {
        if (searchOnEnterEnabled) {
            jTextField1.setToolTipText(Messages.SEARCHABLE.toString());
        }
        this.searchOnEnterEnabled = searchOnEnterEnabled;
    }

    /**
     *
     * @param string
     */
    public void setSearchField(String string) {
        searchField = string;
    }

    /**
     * Set the object displayed by this text field for later use
     * @param selectedItem
     */
    public void setDisplayingObject(Object selectedItem) {
        this.displayingObject = selectedItem;
        setText(selectedItem);
    }

    /**
     * @return the displayingObject
     */
    public Object getDisplayingObject() {
        return displayingObject;
    }

    @SuppressWarnings("unchecked")
    public <T extends Object> T getValue(T classtemplate) {
        if (clazz != classtemplate.getClass()) {
            throw new IllegalArgumentException("Classtemplate must match value class!");
        }
        if (clazz == Integer.class) {
            try {
                Integer.valueOf(jTextField1.getText());
                jTextField1.setBackground(Color.WHITE);
                return (T) Integer.valueOf(jTextField1.getText());
            } catch (NumberFormatException numberFormatException) {
                Log.Debug(numberFormatException);
                TextFieldUtils.blinker(jTextField1, Color.gray);
                jTextField1.setText("0");
            }
        } else if (clazz == Double.class) {
            try {
                FormatNumber.parseDezimal(jTextField1.getText());
                jTextField1.setBackground(Color.WHITE);
                return (T) new Double(FormatNumber.parseDezimal(jTextField1.getText()).doubleValue());
            } catch (NumberFormatException numberFormatException) {
                Log.Debug(numberFormatException);
                TextFieldUtils.blinker(jTextField1, Color.gray);
                jTextField1.setText("0.0");
            }
        } else if (clazz == BigDecimal.class) {
            try {
                FormatNumber.parseDezimal(jTextField1.getText());
                jTextField1.setBackground(Color.WHITE);
                return (T) FormatNumber.parseDezimal(jTextField1.getText());
            } catch (NumberFormatException numberFormatException) {
                Log.Debug(this, jTextField1.getText());
                Log.Debug(numberFormatException);

                TextFieldUtils.blinker(jTextField1, Color.gray);
                jTextField1.setText("0.0");
            }
        }
        return null;
    }
}
