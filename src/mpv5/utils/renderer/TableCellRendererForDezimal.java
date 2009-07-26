/*
 * 
This file is part of MP.

MP is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

MP is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with MP.  If not, see <http://www.gnu.org/licenses/>.

 * 
 */
package mpv5.utils.renderer;

import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import mpv5.utils.numberformat.FormatNumber;


public class TableCellRendererForDezimal extends DefaultTableCellRenderer {

    public static NumberFormat DECIMALFORMAT = FormatNumber.getDefaultDecimalFormat();
    private final JTable t;

    /**
     * Set this renderer to the given column + editor
     * @param column
     */
    public void setRendererTo(int column) {
        TableColumn col = t.getColumnModel().getColumn(column);
        col.setCellEditor(new TableCellEditorForDezimal(new JFormattedTextField()));
        col.setCellRenderer(this);
    }

    /**
     * 
     * @param t
     */
    public TableCellRendererForDezimal(JTable t) {
        super();
        this.t = t;
    }

    @Override
    protected void setValue(Object value) {
        if (value instanceof Number) {
            value = DECIMALFORMAT.format(value);
        }
        super.setValue(value);
    }
}
