package mpv5.ui.panels;

import java.awt.Component;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.table.TableCellRenderer;
import mpv5.db.common.Context;
import mpv5.db.common.DatabaseObject;
import mpv5.db.common.NodataFoundException;
import mpv5.db.common.QueryCriteria2;
import mpv5.db.common.QueryHandler;
import mpv5.db.common.QueryParameter;
import mpv5.db.objects.Product;
import mpv5.globals.Messages;
import mpv5.logging.Log;
import mpv5.utils.date.vTimeframe;
import mpv5.utils.models.MPTableModel;
import mpv5.utils.tables.*;

/**
 *
 * 
 */
public class ProductList extends javax.swing.JPanel implements ListPanel {

    private static final long serialVersionUID = 1L;
    private Context context = Context.getProduct();
    private java.util.ResourceBundle bundle = mpv5.i18n.LanguageManager.getBundle();

    /** Creates new form ListPanel */
    public ProductList() {
        initComponents();
        setName("productlist");
        labeledCombobox1.setContext(Context.getSupplier());
        labeledCombobox1.setSearchEnabled(true);
        labeledCombobox2.setContext(Context.getManufacturer());
        labeledCombobox2.setSearchEnabled(true);
        labeledCombobox1.setEditable(true);
        labeledCombobox2.setEditable(true);
        prinitingComboBox1.init(listTable);
        context.addReference(Context.getContact().getDbIdentity(), "ids", "suppliersids");
        context.addReference(Context.getGroup());

    }

    private void fill() {

        QueryCriteria2 qc = new QueryCriteria2();

        if (labeledCombobox1.getValue() != null && labeledCombobox1.getComboBox().getSelectedIndex() != -1) {
            qc.and(new QueryParameter(context, "suppliersids", Integer.valueOf(labeledCombobox1.getSelectedItem().getId()), QueryParameter.EQUALS));
        }
        if (labeledCombobox2.getValue() != null && labeledCombobox2.getComboBox().getSelectedIndex() != -1) {
            qc.and(new QueryParameter(context, "manufacturersids", Integer.valueOf(labeledCombobox2.getSelectedItem().getId()), QueryParameter.EQUALS));
        }
        if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
            qc.or(new QueryParameter[]{new QueryParameter(context, "inttype", Product.TYPE_PRODUCT, QueryParameter.EQUALS),
                        new QueryParameter(context, "inttype", Product.TYPE_SERVICE, QueryParameter.EQUALS)});
        } else {
            if (!jCheckBox2.isSelected()) {
                qc.and(new QueryParameter(context, "inttype", Product.TYPE_PRODUCT, QueryParameter.EQUALS));
            } else {
                qc.and(new QueryParameter(context, "inttype", Product.TYPE_SERVICE, QueryParameter.EQUALS));
            }
        }

        try {
            QueryHandler c = QueryHandler.instanceOf().clone(context);
            listTable.setModel(new MPTableModel(c.select(Context.DETAILS_PRODUCTS, qc, new vTimeframe(new Date(0), new Date())).getData()));
        } catch (NodataFoundException ex) {
            listTable.setModel(new MPTableModel());
        }
        TableFormat.hideHeader(listTable);
        validate();
    }

    /** This me4thod is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTable = new  mpv5.ui.misc.MPTable(this) {
            public Component prepareRenderer(TableCellRenderer renderer,
                int rowIndex, int vColIndex) {
                Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
                if (c instanceof JComponent) {
                    JComponent jc = (JComponent)c;
                    jc.setToolTipText(String.valueOf(getValueAt(rowIndex, vColIndex)));
                }
                return c;
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        labeledCombobox1 = new mpv5.ui.beans.LabeledCombobox();
        labeledCombobox2 = new mpv5.ui.beans.LabeledCombobox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        prinitingComboBox1 = new mpv5.ui.beans.PrinitingComboBox();
        jButton1 = new javax.swing.JButton();

        setName("Form"); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("mpv5/resources/languages/Panels"); // NOI18N
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("ProductList.jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        listTable.setAutoCreateRowSorter(true);
        listTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        listTable.setDragEnabled(true);
        listTable.setFillsViewportHeight(true);
        listTable.setName("listTable"); // NOI18N
        listTable.setShowVerticalLines(false);
        listTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listTable);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("ProductList.jPanel2.border.title"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel1.setText(bundle.getString("ProductList.jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jCheckBox1.setSelected(true);
        jCheckBox1.setText(bundle.getString("ProductList.jCheckBox1.text")); // NOI18N
        jCheckBox1.setName("jCheckBox1"); // NOI18N
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ItemStateChanged(evt);
            }
        });

        jCheckBox2.setText(bundle.getString("ProductList.jCheckBox2.text")); // NOI18N
        jCheckBox2.setName("jCheckBox2"); // NOI18N
        jCheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ItemStateChanged(evt);
            }
        });

        labeledCombobox1.set_Label(bundle.getString("ProductList.labeledCombobox1._Label")); // NOI18N
        labeledCombobox1.setName("labeledCombobox1"); // NOI18N

        labeledCombobox2.set_Label(bundle.getString("ProductList.labeledCombobox2._Label")); // NOI18N
        labeledCombobox2.setName("labeledCombobox2"); // NOI18N

        jButton2.setText(bundle.getString("ProductList.jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/16/remove.png"))); // NOI18N
        jButton3.setText(bundle.getString("ProductList.jButton3.text")); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/16/remove.png"))); // NOI18N
        jButton4.setText(bundle.getString("ProductList.jButton4.text")); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labeledCombobox2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(labeledCombobox1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, 0, 0, Short.MAX_VALUE)
                    .addComponent(labeledCombobox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labeledCombobox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        prinitingComboBox1.setName("prinitingComboBox1"); // NOI18N

        jButton1.setText(bundle.getString("ProductList.jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addComponent(prinitingComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prinitingComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ItemStateChanged

        fill();
}//GEN-LAST:event_ItemStateChanged

    private void listTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTableMouseClicked

        if (evt.getClickCount() > 1) {
            Selection sel = new Selection(listTable);
            if (sel.checkID()) {
                try {
                    mpv5.YabsViewProxy.instance().getIdentifierView().addTab(DatabaseObject.getObject(Context.getProduct(), sel.getId()));
                } catch (NodataFoundException ex) {
                    Log.Debug(ex);
                }
            }
        }
    }//GEN-LAST:event_listTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DatabaseObject d = DatabaseObject.getObject(Context.getProduct());
        mpv5.YabsViewProxy.instance().getIdentifierView().addTab(d, Messages.NEW_PRODUCT);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fill();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        labeledCombobox1.setSelectedIndex(-1);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        labeledCombobox2.setSelectedIndex(-1);
    }//GEN-LAST:event_jButton4ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private mpv5.ui.beans.LabeledCombobox labeledCombobox1;
    private mpv5.ui.beans.LabeledCombobox labeledCombobox2;
    private javax.swing.JTable listTable;
    private mpv5.ui.beans.PrinitingComboBox prinitingComboBox1;
    // End of variables declaration//GEN-END:variables

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

    public void refresh() {
    }

    public void flush() {
        listTable.setModel(null);
    }
}
