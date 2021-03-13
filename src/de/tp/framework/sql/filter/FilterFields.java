package de.tp.framework.sql.filter;

import de.tp.framework.sql.Filter;

public class FilterFields extends Filter {
    
    public FilterFields(String query) {
        super(query);
    }
    
    public FilterCondition where(String str) {
        return new FilterCondition(query + "WHERE " + str + " ");
    }
    
    public FilterCondition where(String fieldName, String comparision, String value) {
        return where(fieldName + comparision + value);
    }
    
}
