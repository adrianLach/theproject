package de.tp.framework.details;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

public class BufferDataTable extends JPanel {
    public JScrollPane scrollPane;
    public JTable table;
    
    /**
     * Create the panel.
     */
    public BufferDataTable(TableModel tm) {
        setLayout(new BorderLayout(0, 0));
        {
            this.scrollPane = new JScrollPane();
            add(this.scrollPane, BorderLayout.CENTER);
            {
                this.table = new JTable(tm);
                this.table.setAutoCreateRowSorter(true);
                this.table.setBackground(Color.LIGHT_GRAY);
                this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                this.table.setFillsViewportHeight(true);
                this.scrollPane.setViewportView(this.table);
            }
        }
        
    }
    
}
