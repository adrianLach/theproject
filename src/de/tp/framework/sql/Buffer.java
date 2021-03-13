package de.tp.framework.sql;

import java.sql.Connection;
import java.sql.ResultSet;

public abstract class Buffer {
    
    private ResultSet resultSet;
    private Connection connection;
    
    public Buffer(Connection connection) {
        super();
        this.connection = connection;
    }
    
    public ResultSet getResultSet() {
        return resultSet;
    }
    
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public abstract void reload(String query);
    
    public void reload(Filter filter) {
        reload(filter.getQuery());
    }
    
}
