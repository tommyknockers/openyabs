/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GroupDialog.java
 *
 * Created on 08.03.2009, 22:03:40
 */
package mpv5.ui.dialogs.subcomponents;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;
import mpv5.db.common.Context;
import mpv5.db.common.DatabaseObject;
import mpv5.db.common.NodataFoundException;
import mpv5.globals.Messages;
import mpv5.db.objects.Group;
import mpv5.logging.Log;
import mpv5.ui.panels.DataPanel;
import mpv5.utils.arrays.ArrayUtilities;
import mpv5.utils.trees.TreeFormat;

/**
 *
 *  anti
 */
public class GroupDialog extends javax.swing.JPanel {
    private DataPanel view;

    /** Creates new form GroupDialog */
    public GroupDialog(DataPanel view) {
        initComponents();
        try {
            refresh();
        } catch (NodataFoundException ex) {
            Logger.getLogger(GroupDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.view = view;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();

        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        java.util.ResourceBundle bundle = mpv5.i18n.LanguageManager.getBundle(); // NOI18N
        tree.setToolTipText(bundle.getString("ControlPanel_Groups.tree.toolTipText")); // NOI18N
        tree.setName("tree"); // NOI18N
        tree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void refresh() throws NodataFoundException {
        ArrayList<Group> data = null;
        try {
            data = DatabaseObject.getObjects(Context.getGroup());
        } catch (NodataFoundException ex) {
            Log.Debug(this, ex.getMessage());
        }

        Group g = new Group();
        g.setCName(Messages.GROUPNAMES.toString());
        g.setIDS(-1);

        tree.setModel(ArrayUtilities.toTreeModel(data, g));

        TreeFormat.expandTree(tree);
    }

    private void treeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeMouseClicked
        evt.consume();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

        if (node != null) {
            Group g = (Group) node.getUserObject();
            view.getDataOwner().setGroupsids(g.__getIDS());
            view.setDataOwner(view.getDataOwner());
        }
}//GEN-LAST:event_treeMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables
}
