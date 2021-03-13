package de.tp.glaeubiger.ui;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import de.tp.framework.details.BufferDataTable;
import de.tp.framework.details.BufferDataTableControl;

public class GlaeubigerTableControl extends BufferDataTableControl {
    
    public GlaeubigerTableControl() {
        
        DefaultTableModel tm = new DefaultTableModel() {
            
            private static final long serialVersionUID = -8258599512043064265L;
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column) && false;
            }
        };
        
        tm.addColumn("Gläubiger");
        tm.addColumn("Name");
        
        gui = new BufferDataTable(tm);
        
    }
    
    @Override
    public void fillData() {
        
        DefaultTableModel dtm = (DefaultTableModel) gui.table.getModel();
        dtm.setRowCount(0);
        gui.table.revalidate();
        
        try {
            ResultSet resultSet = buffer.getResultSet();
            int currRow = resultSet.getRow();
            resultSet.beforeFirst();
            while (resultSet.next()) {
                Object[] data = new Object[2];
                data[0] = resultSet.getString(1);
                data[1] = resultSet.getString(2);
                dtm.addRow(data);
            }
            resultSet.absolute(currRow);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        gui.table.setModel(dtm);
        dtm.fireTableDataChanged();
    }
    
}
