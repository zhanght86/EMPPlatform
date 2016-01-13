package com.report.table;

/**
 * 此处插入类型描述。
 * 创建日期：(2002-1-17 11:04:03)
 * @author：Lubo
 */

import javax.swing.*;
import javax.swing.table.*;
import java.util.ResourceBundle;

public class RowNumberHeader extends javax.swing.JTable {

    static ResourceBundle res = ResourceBundle.getBundle("com.report.table.Language");
  protected JTable myTable;
    class RowNumberTableModel extends AbstractTableModel {
        public int getRowCount() {
            return myTable.getModel().getRowCount();
        }
        public int getColumnCount() {
            return 1;
        }
        public Object getValueAt(int row, int column) {
            return new Integer(row + 1);
        }
    }

    /**
     * RowNumberHeader 构造子注解。
     */
    public RowNumberHeader(JTable table) {
        super();
        myTable = table;
        setModel(new RowNumberTableModel());
        setPreferredScrollableViewportSize(getMinimumSize());
        setRowSelectionAllowed(false);
        JComponent renderer = (JComponent) getDefaultRenderer(Object.class);
        LookAndFeel.installColorsAndFont(
            renderer,
            "TableHeader.background",
            "TableHeader.foreground",
            "TableHeader.font");
        LookAndFeel.installBorder(this, "TableHeader.cellBorder");
    }
}
