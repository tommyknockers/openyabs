/*
 * productImporter.java
 *
 * Created on 27. Januar 2008, 21:56
 */
package mp4.items.visual;

import com.Ostermiller.util.CSVParser;
import java.awt.Cursor;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import mp4.globals.Strings;

import mp4.interfaces.panelInterface;
import mp4.items.People;

import mp4.items.visual.Help;
import mp4.logs.*;
import mp4.items.Popup;
import mp4.datenbank.verbindung.ConnectionHandler;
import mp4.items.visual.SupplierPicker;

import mp4.items.ProductImporteur;
import mp4.items.HistoryItem;
import mp4.items.Product;
import mp4.items.ProductGroupCategory;
import mp4.items.ProductGroupFamily;
import mp4.items.ProductGroupGroup;
import mp4.items.handler.ProductGroupHandler;
import mp4.items.Lieferant;
import mp4.utils.tabellen.models.DefaultHelpModel;
import mp4.utils.ui.Position;
import org.supercsv.cellprocessor.constraint.StrMinMax;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCSVException;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

/**
 *
 * @author  anti43
 */
public class csvProductImporter extends javax.swing.JFrame implements panelInterface {

    private static csvProductImporter frame;

    public static void instanceOf() {

        if (frame == null) {
            frame = new csvProductImporter();
        }

        frame.setVisible(true);
    }
    private CSVParser p;
    private ArrayList liste;
    private String[][] datstr;
    private String[] header;
    public ProductImporteur[] data;
    public Lieferant supplier = null;
    private Task task;

    /** Creates new form productImporter */
    public csvProductImporter() {
        initComponents();
        new Position(this);

    }

    public csvProductImporter(File file) {
         initComponents();
        new Position(this);
        this.jTextField1.setText(file.getPath());
        this.setVisible(rootPaneCheckingEnabled);
          boolean succ = true;
        ProductImporteur user = new ProductImporteur();
        liste = new ArrayList();
        header = new String[]{"produktnummer", "name", "text", "vk",
                    "ek", "tax", "hersteller", "warengruppenkategorie", "warengruppenfamilie",
                    "warengruppe", "url", "ean", "lieferantenid"
                };

        try {

            final CellProcessor[] processors = new CellProcessor[]{
                new StrMinMax(0, 49),
                new StrMinMax(0, 49),
                new StrMinMax(0, 499),
                new StrMinMax(0, 99),
                new StrMinMax(0, 99),
                new StrMinMax(0, 99),
                new StrMinMax(0, 99),
                new StrMinMax(0, 99),
                new StrMinMax(0, 99),
                new StrMinMax(0, 99),
                new StrMinMax(0, 135),
                new StrMinMax(0, 19),
                new StrMinMax(0, 19)
            };


            CsvPreference pref = CsvPreference.STANDARD_PREFERENCE;
            if (jCheckBox2.isSelected()) {
                pref = CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE;
            }

            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));

            ICsvBeanReader inFile = new CsvBeanReader(new FileReader(jTextField1.getText()), pref);
            try {
//                final String[] header = inFile.getCSVHeader(true);


                while ((user = inFile.read(ProductImporteur.class, header, processors)) != null) {
                    liste.add(user);
                }


            } catch (SuperCSVException ex) {
                succ = false;
                new Popup(ex.getMessage(), Popup.ERROR);
                ex.printStackTrace();
            } catch (IOException ex) {
                succ = false;
                new Popup(ex.getMessage(), Popup.ERROR);

                ex.printStackTrace();
            } finally {
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                inFile.close();

            }

        } catch (Exception ex) {
            succ = false;
            new Popup(ex.getMessage(), Popup.ERROR);
            ex.printStackTrace();
        }

        try {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            user = new ProductImporteur();
            data = ProductImporteur.listToImporteurArray(liste, this.supplier);
            datstr = user.getData(data);
            
            Thread.sleep(5000);//Wait for the data..
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            
            jTable1.setModel(new DefaultTableModel(datstr, header));


        } catch (Exception ex) {
            succ = false;
            new Popup(ex.getMessage(), Popup.ERROR);
            ex.printStackTrace();
        }


        if (succ) {
            getJButton4().setEnabled(true);
        }
    }

    public void setSupplier(Lieferant supplier) {
        this.jTextField2.setText(supplier.getFirma());
        this.supplier = supplier;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MP CSV Import");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Import: Daten aus einer CSV -Datei"));

        jButton1.setText("Start");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Abbruch");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jTextField1.setText("Datei w�hlen!");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setText("...");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jLabel2.setText("Trennzeichen:");

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Produknummer", "Produktname", "Langtext", "VK", "EK", "Mehrwertsteuer", "Herstellername", "Warengruppenkategorie", "Warengruppenfamilie", "Warengruppe", "Produktbild-URL", "EAN"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setText("Komma");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Semikolon");

        jButton4.setText("Daten �bernehmen");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Produktimport: W�hlen Sie eine CSV-Datei.");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jProgressBar1.setStringPainted(true);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
        jLabel3.setText("Lieferant: ");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton5.setText("W�hlen");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Hilfe");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jLabel3)
                    .addComponent(jButton5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    @SuppressWarnings({"unchecked", "unchecked"})
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        boolean succ = true;
        ProductImporteur importeur = new ProductImporteur();
        liste = new ArrayList();
        header = new String[]{"produktnummer", "name", "text", "vk",
                    "ek", "tax", "hersteller", "warengruppenkategorie", "warengruppenfamilie",
                    "warengruppe", "url", "ean", "lieferantenid"
                };

        try {

            final CellProcessor[] processors = new CellProcessor[]{
                new StrMinMax(0, 49),
                new StrMinMax(0, 49),
                new StrMinMax(0, 499),
                new StrMinMax(0, 99),
                new StrMinMax(0, 99),
                new StrMinMax(0, 99),
                new StrMinMax(0, 99),
                new StrMinMax(0, 99),
                new StrMinMax(0, 99),
                new StrMinMax(0, 99),
                new StrMinMax(0, 135),
                new StrMinMax(0, 19),
                new StrMinMax(0, 19)
            };


            CsvPreference pref = CsvPreference.STANDARD_PREFERENCE;
            if (jCheckBox2.isSelected()) {
                pref = CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE;
            }

            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));

            ICsvBeanReader inFile = new CsvBeanReader(new FileReader(jTextField1.getText()), pref);
            try {
//                final String[] header = inFile.getCSVHeader(true);


                while ((importeur = inFile.read(ProductImporteur.class, header, processors)) != null) {
                    liste.add(importeur);
                }


            } catch (SuperCSVException ex) {
                succ = false;
                new Popup(ex.getMessage(), Popup.ERROR);
                ex.printStackTrace();
            } catch (IOException ex) {
                succ = false;
                new Popup(ex.getMessage(), Popup.ERROR);

                ex.printStackTrace();
            } finally {
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                inFile.close();

            }

        } catch (Exception ex) {
            succ = false;
            new Popup(ex.getMessage(), Popup.ERROR);
            ex.printStackTrace();
        }

        try {
            importeur = new ProductImporteur();
            data = ProductImporteur.listToImporteurArray(liste, this.supplier);
            datstr = importeur.getData(data);


            jTable1.setModel(new DefaultTableModel(datstr, header));


        } catch (Exception ex) {
            succ = false;
            new Popup(ex.getMessage(), Popup.ERROR);
            ex.printStackTrace();
        }


        if (succ) {
            getJButton4().setEnabled(true);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            jTextField1.setText(fc.getSelectedFile().toString());
        }

    }//GEN-LAST:event_jButton3MouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jButton4.isEnabled()) {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            task = new Task(this);
            task.execute();
           
            jButton2.setText("Beenden");
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        new SupplierPicker(this);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        new Help(new DefaultHelpModel("CSV Import",
                "<P><FONT FACE='DejaVu Sans, sans-serif'><FONT SIZE=3>Die zu " +
                "importierenden Daten m&uuml;ssen in dieser Form vorliegen:</FONT></FONT></P>" +
                "<P><FONT FACE='DejaVu Sans, sans-serif'><FONT SIZE=3><B>&lt;produktnummer&gt;;" +
                "&lt;name&gt;;&lt;text&gt;;&lt;vk&gt;;&lt;ek&gt;;&lt;tax&gt;" +
                ";&lt;hersteller&gt;;&lt;warengruppenkategorie&gt;;&lt;warengruppenfamilie&gt;;&lt;warengruppe&gt;;&lt;url&gt;;&lt;ean&gt;</B></FONT></FONT></P>" +
                "<P><FONT FACE='DejaVu Sans, sans-serif'><FONT SIZE=3>Zum Beispiel:</FONT></FONT></P>" +
                "<P><FONT FACE='DejaVu Sans, sans-serif'><FONT SIZE=3>1000143;&quot;NPPSU023&quot;;&quot;INTEL&nbsp;NPPSU023&nbsp;POWERSUPPLY&nbsp;UK&quot;;;07.01.08;19;&quot;INTEL&quot;;;;;&quot;http://www.google.de/logo.gif&quot;;675900307711" +
                "<BR>1000144;&quot;NPPSU023&quot;;&quot;INTEL&nbsp;NPPSU023&nbsp;POWERSUPPLY&nbsp;UK&quot;;;07.01.08;19;&quot;INTEL&quot;;;;;&quot;http://www.google.de/logo.gif&quot;;675900307711" +
                "<BR>1000145;&quot;NPPSU023&quot;;&quot;INTEL&nbsp;NPPSU023&nbsp;POWERSUPPLY&nbsp;UK&quot;;;07.01.08;19;&quot;INTEL&quot;;;;;&quot;http://www.google.de/logo.gif&quot;;675900307711</FONT></FONT></P>" +
                "<P><FONT FACE='DejaVu Sans, sans-serif'><FONT SIZE=3>Kontrollieren " +
                "Sie die Korrektheit ihrer Daten in der Vorschautabelle.<BR></FONT></FONT><BR><BR>" +
                "</P>" +
                "<P><FONT FACE='DejaVu Sans, sans-serif'><FONT SIZE=3>Das Importieren " +
                "kann abh&auml;ngig von der Dtenstruktur und der verwendeten Hardware " +
                "sehr lange dauern (</FONT></FONT><FONT FACE='DejaVu Sans, sans-serif'><FONT SIZE=3><B>~1.5" +
                "h f&uuml;r 32000</B></FONT></FONT><FONT FACE='DejaVu Sans, sans-serif'><FONT SIZE=3>" +
                "</FONT></FONT><FONT FACE='DejaVu Sans, sans-serif'><FONT SIZE=3><B>Produkte" +
                "</B></FONT></FONT><FONT FACE='DejaVu Sans, sans-serif'><FONT SIZE=3>(Dual-Core" +
                "2 Ghz mit Sata2-Festplatte)).</FONT></FONT></P>"));
    }//GEN-LAST:event_jButton6ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    public javax.swing.JButton getJButton4() {
        return jButton4;
    }

    class Task extends SwingWorker<Void, Void> {

        private csvProductImporter thisa;
        private ProductGroupCategory newcat;
        private ProductGroupFamily newfam;
        private ProductGroupGroup newgrp;
        private String fam;
        private String grp;
        /*
         * Main task. Executed in background thread.
         */

        public Task(csvProductImporter thisa) {

            this.thisa = thisa;
        }

        public Void doInBackground() {
            int h = 0;
            SimpleDateFormat df = new SimpleDateFormat();
            Date datum = new Date();
            String cat;
            boolean news = false;




            if ((JOptionPane.showConfirmDialog(thisa, "Wirklich alle Daten �bernehmen? Dies wird m�glicherweise einige Zeit dauern!", "Sicher?", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {

                if (thisa.data != null) {
                    Date d = new Date();
//                Log.setLogLevel(Log.LOGLEVEL_HIGH);
                    Log.Debug("Einlesen gestartet: " + d, true);
                    thisa.setCursor(new Cursor(Cursor.WAIT_CURSOR));

                    thisa.jProgressBar1.setMaximum(thisa.data.length);
                    thisa.jProgressBar1.setMinimum(0);

                    for (int i = 0; i < thisa.data.length; i++) {

                        Product pg = new Product(ConnectionHandler.instanceOf());
                        ProductGroupHandler handler = ProductGroupHandler.instanceOf();

                        pg.setNummer(thisa.data[i].getProduktnummer());
                        pg.setName(thisa.data[i].getName());
                        pg.setDatum(datum);
                        pg.setEK(Double.valueOf(thisa.data[i].getEk()));
                        pg.setVK(Double.valueOf(thisa.data[i].getVk()));
                        pg.setEan(thisa.data[i].getEan());
                        pg.setHerstellernr(thisa.data[i].getHersteller());
//                        pg.setTAX(Double.valueOf(thisa.data[i].getTax()));
                        pg.setText(thisa.data[i].getText());
                        pg.setUrl(thisa.data[i].getUrl());
                        pg.setLieferantenId(Integer.valueOf(thisa.data[i].getLieferantenid()));


                        if (thisa.supplier != null && thisa.supplier.isValid()) {
                            pg.setLieferantenId(thisa.supplier.getId());
                        } 
//                        else {
//                            pg.setLieferantenId(Integer.valueOf(thisa.data[i].getLieferantenid()));
//                        }

                        cat = thisa.data[i].getWarengruppenkategorie();
                        fam = thisa.data[i].getWarengruppenfamilie();
                        grp = thisa.data[i].getWarengruppe();

                       Log.Debug( pg.getName()+":Produkt \n" +cat,true);
                       Log.Debug(fam,true);
                       Log.Debug(grp,true);
                       
                       Log.Debug("---------------------------",true);


                        if (!cat.equals("null") && !fam.equals("null") && !grp.equals("null")) {

                            int z = handler.exists(cat, handler.CATEGORY);
                            if (z == 0) {

                                newcat = new ProductGroupCategory(ConnectionHandler.instanceOf());

                                newcat.setName(cat);
                                newcat.save();
                                z = newcat.getID();
                                news = true;
                            } else {//                            newcat = handler.getCategory(z);
                            }

                            int f = handler.existFam(fam);
                            if (f == 0) {
                            Log.Debug("creating fam: "+fam + " " + f,true);
                                newfam = new ProductGroupFamily(ConnectionHandler.instanceOf());
                                newfam.setName(fam);
                                newfam.setKategorieid(z);
                                newfam.save();
                                f = newfam.getID();
                                news = true;
                            } else {
//                          Log.Debug("existing fam: "+fam + " " + f,true);
//                            newfam = handler.getFamily(f);
                            }



                            int l = handler.exists(grp, handler.GROUP);
                            if (l == 0) {

                                newgrp = new ProductGroupGroup(ConnectionHandler.instanceOf());
                                newgrp.setName(grp);
                                newgrp.setFamilienid(f);
                                newgrp.save();
                                news = true;
                            } else {
                                newgrp = handler.getGroup(l);
                            }


                            pg.setWarengruppenId(newgrp.getID());


                            if (news) {
                                handler.getCats(true); //speed?
                            } //speed?

                            news = false;


                        } else {

                            pg.setWarengruppenId(1);

                        }



                        pg.save();
                        h++;
                        thisa.jProgressBar1.setValue(i);

                        thisa.jLabel1.setText(h + " Produkte angelegt");
                        pg = null;
                    }
                    d = new Date();
                    Log.Debug("Einlesen beendet: " + d + " Produkte: " + h, true);
                    Popup.notice("Einlesen beendet: " + d + " Produkte: " + h);
                    new HistoryItem(ConnectionHandler.instanceOf(), Strings.PRODUCT, h + " Produkte importiert.");


                    thisa.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    thisa.getJButton4().setEnabled(false);
                    thisa.jProgressBar1.setValue(0);
                    
                }

            }


            return null;
        }

        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
//        Toolkit.getDefaultToolkit().beep();
            thisa.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            

        }
    }

    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setContact(People contact) {
        this.supplier = (Lieferant) contact;
    }
}
