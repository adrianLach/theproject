package de.tp.framework.sql.filter;

import de.tp.framework.sql.Filter;

public class FilterTable extends Filter {
    
    public FilterTable(String query) {
        super(query);
    }
    
    public FilterFields from(String str) {
        return new FilterFields(query + "FROM " + str + " ");
    }
    
}
