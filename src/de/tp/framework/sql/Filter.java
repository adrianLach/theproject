package de.tp.framework.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.tp.framework.sql.filter.FilterAccess;
import de.tp.framework.sql.filter.FilterCondition;

public abstract class Filter {
    
    protected String query = "";
    
    public Filter(String query) {
        this.query = query;
    }
    
    public String getQuery() {
        System.out.println(query);
        return query;
    }
    
    public static FilterAccess getFilter() {
        return new FilterAccess("");
    }
    
    public String substitute(String... strings) {
        for (int i = 0; i < strings.length; i++) {
            query = query.replaceAll("&" + (i + 1), strings[i]);
        }
        return getQuery();
    }
    
    public static void main(String[] args) throws SQLException {
        
        Buffer_user bf = new Buffer_user(SQL.getDefaultConnection());
        
        Filter loginnameFIlter = Filter.getFilter().select("*").from("user").where("loginname",
                FilterCondition.EQUAL_TO, "'&1'");
        
        bf.reload(loginnameFIlter.substitute("adrian"));
        
        ResultSet rs = bf.getResultSet();
        
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }
    
}
