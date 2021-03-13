package de.tp.framework.sql.filter;

import de.tp.framework.sql.Filter;

public class FilterCondition extends Filter {
    
    public static final String EQUAL_TO = " = ";
    public static final String GREATER_THAN = " > ";
    public static final String LESS_THAN = " < ";
    public static final String GREATER_THAN_EQUAL_TO = " >= ";
    public static final String LESS_THAN_EQUAL_TO = " <= ";
    public static final String NOT_EQUAL_TO = " <> ";
    
    public FilterCondition(String query) {
        super(query);
    }
    
    public FilterCondition and(String str) {
        return new FilterCondition(query + "AND " + str + " ");
    }
    
    public FilterCondition or(String str) {
        return new FilterCondition(query + "OR " + str + " ");
    }
    
    public FilterCondition and(String fieldName, String comparision, String value) {
        return and(fieldName + comparision + value);
    }
    
    public FilterCondition or(String fieldName, String comparision, String value) {
        return or(fieldName + comparision + value);
    }
    
}
