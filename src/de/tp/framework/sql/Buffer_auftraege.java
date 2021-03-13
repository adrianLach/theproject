package de.tp.framework.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Buffer_auftraege extends Buffer {
    
    public Buffer_auftraege(Connection connection) {
        super(connection);
    }
    
    @Override
    public void reload(String query) {
        
        try {
            
            Statement stmt = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            
            setResultSet(stmt.executeQuery(query));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
