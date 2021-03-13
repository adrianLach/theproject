package de.tp.framework.details;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import de.tp.framework.sql.Buffer;

public class BufferDataTableControl {
    
    protected BufferDataTable gui;
    
    protected Buffer buffer;
    
    public BufferDataTableControl() {
        
        DefaultTableModel tm = new DefaultTableModel() {
            
            private static final long serialVersionUID = -8258599512043064265L;
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column) && false;
            }
        };
        
        tm.addColumn("Login Name");
        tm.addColumn("Password (HASH)");
        
        gui = new BufferDataTable(tm);
        
        gui.table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                }
            }
        });
    }
    
    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }
    
    public BufferDataTable getGui() {
        return gui;
    }
    
    public void showGUI() {
        gui.setVisible(true);
    }
    
    public void fillData() {
        
        System.out.println("BufferDataTableControl.fillData()");
        
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
