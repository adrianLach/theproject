package de.tp.glaeubiger.comp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JComboBox;

import de.tp.framework.sql.Buffer_glaeubiger;
import de.tp.framework.sql.Filter;
import de.tp.framework.sql.SQL;
import de.tp.glaeubiger.GlaeubigerItem;

public class GlaeubigerComboBox extends JComboBox<GlaeubigerItem> {
    
    private static final long serialVersionUID = 5984555661849176250L;
    
    @Override
    public void validate() {
        updateData();
        super.validate();
    }
    
    private void updateData() {
        
        LinkedList<GlaeubigerItem> cboData = new LinkedList<>();
        
        Buffer_glaeubiger bf = new Buffer_glaeubiger(SQL.getDefaultConnection());
        bf.reload(Filter.getFilter().select("*").from("glaeubiger"));
        ResultSet rs = bf.getResultSet();
        
        try {
            cboData.clear();
            while (rs.next()) {
                cboData.add(new GlaeubigerItem(rs.getString(2), rs.getInt(1)));
            }
            removeAllItems();
            for (GlaeubigerItem gi : cboData) {
                addItem(gi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
