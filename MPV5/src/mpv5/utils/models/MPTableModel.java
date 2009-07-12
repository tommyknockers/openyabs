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
package mpv5.utils.models;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import mpv5.db.common.Context;
import mpv5.db.common.DatabaseObject;
import mpv5.db.objects.Item;
import mpv5.globals.Headers;
import mpv5.logging.Log;
import mpv5.ui.frames.MPV5View;
import mpv5.utils.numberformat.FormatNumber;
import mpv5.utils.tables.TableCalculator;

/**
 *
 *  
 */
public class MPTableModel extends DefaultTableModel {

    private static final long serialVersionUID = 1L;
    private Class[] types;
    private boolean[] canEdits;
    private Context context;
    private Object[] predefinedRow;
    private Integer autoCountColumn;
    private TableCalculator calculator;
//    public static MPTableModel ITEM_TABLE_MODEL = new MPTableModel(Context.getItems());

    public MPTableModel() {
        super();
        setEditable(false);

        setTypes(new Class[]{Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class,
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class,
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class});
    }

    public MPTableModel(Object[][] data) {
        super();

        if (data.length > 0) {
            String[] header = new String[data[0].length];
            for (int i = 0; i < header.length; i++) {
                header[i] = String.valueOf(i);
            }
            setDataVector(data, header);
        }

        setEditable(false);

        setTypes(new Class[]{Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class,
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class,
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class});
    }

    public MPTableModel(ArrayList<DatabaseObject> list, String[] header) {
        super();
        Object[][] data = new Object[0][0];
        if (list.size() > 0 && list.get(0) != null) {
            data = new Object[list.size()][list.get(0).getValues().size()];
        }
        ArrayList<String[]> sdata;



        for (int i = 0; i < list.size(); i++) {
            DatabaseObject databaseObject = list.get(i);
            sdata = databaseObject.getValues();
            for (int j = 0; j < sdata.size(); j++) {
                String[] strings = sdata.get(j);
                data[i][j] = strings[1];
            }
        }

        setDataVector(data, header);

        setEditable(false);

        setTypes(new Class[]{Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class,
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class,
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class});

    }

    public MPTableModel(Object[][] datstr, String[] header) {
        super(datstr, header);
        setEditable(false);

        setTypes(new Class[]{Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class,
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class,
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class});

    }

    public MPTableModel(Object[][] data, Headers header) {
        super(data, header.getValue());
        setEditable(false);

        setTypes(new Class[]{Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class,
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class,
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class});

    }

    public MPTableModel(Object[][] datstr, String[] header, Class[] types) {
        super(datstr, header);
        setEditable(false);
        setTypes(types);
    }

    public MPTableModel(Class[] types, boolean[] canEdits, Object[][] data, Object[] columnNames) {
        super(data, columnNames);
        setTypes(types);
        setCanEdits(canEdits);
    }

    public MPTableModel(Class[] types, boolean[] canEdits, Object[] columnNames) {
        super(columnNames, 1);
        setTypes(types);
        setCanEdits(canEdits);
    }

    public MPTableModel(Class[] types, Object[][] data, Object[] columnNames) {
        super(data, columnNames);
        setTypes(types);
        setEditable(false);
    }

    /**
     *
     * @param context
     */
    public MPTableModel(Context context) {
        this();
        this.context = context;
        if (context.equals(Context.getSubItem())) {
            String defunit = null;
            if (MPV5View.getUser().getProperties().hasProperty("defunit")) {
                defunit = MPV5View.getUser().getProperties().getProperty("defunit");
            }
            Double deftax = 0d;
            if (MPV5View.getUser().getProperties().hasProperty("deftax")) {
                int taxid = MPV5View.getUser().getProperties().getProperty("deftax", 0);
                deftax = Item.getTaxValue(taxid);
            }
            Double defcount = 0d;
            if (MPV5View.getUser().getProperties().hasProperty("defcount")) {
                defcount = MPV5View.getUser().getProperties().getProperty("defcount", 0d);
            }

            setDataVector(new Object[][]{
                        {0, 1, defcount, defunit, null, 0.0, deftax, 0.0},
                        {0, 2, defcount, defunit, null, 0.0, deftax, 0.0},
                        {0, 3, defcount, defunit, null, 0.0, deftax, 0.0},
                        {0, 4, defcount, defunit, null, 0.0, deftax, 0.0},
                        {0, 5, defcount, defunit, null, 0.0, deftax, 0.0},
                        {0, 6, defcount, defunit, null, 0.0, deftax, 0.0},
                        {0, 7, defcount, defunit, null, 0.0, deftax, 0.0}}, Headers.SUBITEMS);
            setCanEdits(new boolean[]{false, false, true, true, true, true, true, false});
            defineRow(new Object[]{0, 0, defcount, defunit, null, 0.0, deftax, 0.0});
            autoCountColumn = 1;
        }
    }

    /**
     * Set the cell calculator for this model
     * @param cv
     */
    public void setCalculator(TableCalculator cv) {
        this.calculator = cv;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        getTypes()[columnIndex].toString();//Check for non-null
        return getTypes()[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        new Boolean(getCanEdits()[columnIndex]).toString();//Check for non-null
        return getCanEdits()[columnIndex];
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }

    public boolean[] getCanEdits() {
        return canEdits;
    }

    public void setCanEdits(boolean[] canEdits) {
        this.canEdits = canEdits;
    }

    public Vector getColumnIdentifiers() {
        return columnIdentifiers;
    }

    /**
     * Set the table editable
     * @param bool
     */
    public void setEditable(boolean bool) {
        setCanEdits(new boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool,
                    bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool,
                    bool, bool, bool, bool, bool, bool, bool, bool, bool});
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object getValueAt(int row, int column) {
        Object o = super.getValueAt(row, column);
        Class t = getColumnClass(column);
        if (!t.getName().equals("java.lang.Object")) {
            if (t.isAssignableFrom(Double.class) ||
                    t.isAssignableFrom(double.class) ||
                    t.isAssignableFrom(float.class) ||
                    t.isAssignableFrom(Float.class)) {
                return FormatNumber.formatDezimal(Double.valueOf(o.toString()));
            } else {
                return o;
            }
        } else {
            return o;
        }
    }

    private void setDataVector(Object[][] object, Headers head) {
        super.setDataVector(object, head.getValue());
    }

    @Override
    public void fireTableCellUpdated(int row, int column) {
        if (calculator != null && !calculator.isTargetCell(row, column)) {
            calculator.calculateOnce();
        }
        super.fireTableCellUpdated(row, column);
    }

    /**
     * Checks if the model has empty rows
     * @param columnsToCheck The columns to be checked for emptyness
     * @return TRUE if the last row of the model has a NULL value at the specified columns
     */
    public boolean hasEmptyRows(int[] columnsToCheck) {
        boolean empty = true;
        for (int i = 0; i < columnsToCheck.length; i++) {
            if (getValueAt(getRowCount() - 1, columnsToCheck[i]) != null) {
                empty = false;
            }
        }
        return empty;
    }

    /**
     * Adds rows to the end of the model. The new rows will contain null values.<br/>
     * If this.context is defined, Context specific values may be added.
     * @param count
     */
    public void addRow(int count) {
        for (int i = 0; i < count; i++) {
            if (predefinedRow == null) {
                addRow((Object[]) null);
            } else {
                if (autoCountColumn != null) {
                    predefinedRow[autoCountColumn] = getRowCount() + 1;
                }
                addRow(predefinedRow);
            }
        }
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

    private void defineRow(Object[] object) {
        predefinedRow = object;
    }
}
