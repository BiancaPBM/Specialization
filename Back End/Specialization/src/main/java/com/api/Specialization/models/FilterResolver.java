package com.api.Specialization.models;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class FilterResolver {
    private List<FilterEntry> filterEntryList;
    private Query query;

    public FilterResolver(List<FilterEntry> filterEntryList) {
        this.filterEntryList = filterEntryList;
        this.query = new Query();
    }

    public Query toQuery() {
        //query = new Query();
        for (FilterEntry filterEntry : filterEntryList) {
            if (filterEntry.getOperator().equals("=")) {
                query.addCriteria(Criteria.where(filterEntry.getField()).is(filterEntry.getValue()));
            }
            if(filterEntry.getOperator().equals("<")) {
                query.addCriteria(Criteria.where(filterEntry.getField()).lt(filterEntry.getValue()));
            }
            if(filterEntry.getOperator().equals(">")){
                query.addCriteria(Criteria.where(filterEntry.getField()).gt(filterEntry.getValue()));
            }
        }
        return query;
    }
}
