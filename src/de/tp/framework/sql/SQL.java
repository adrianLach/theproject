package de.tp.framework.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {
    
    private static Connection connection;
    
    public static final Connection getDefaultConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://" + "localhost" + "/" + "finance" + "?serverTimezone=UTC", "default", "useruser");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    
}
