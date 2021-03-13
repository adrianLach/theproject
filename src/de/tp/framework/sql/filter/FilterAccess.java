package de.tp.framework.sql.filter;

import de.tp.framework.sql.Filter;

public class FilterAccess extends Filter {
    
    public FilterAccess(String query) {
        super(query);
    }
    
    public FilterTable select(String str) {
        return new FilterTable("SELECT " + str + " ");
    }
    
    public FilterTable insert(String str) {
        return new FilterTable("INSERT " + str + " ");
    }
    
    public FilterTable update(String str) {
        return new FilterTable("UPDATE " + str + " ");
    }
    
    public FilterTable delete(String str) {
        return new FilterTable("DELETE " + str + " ");
    }
    
}
