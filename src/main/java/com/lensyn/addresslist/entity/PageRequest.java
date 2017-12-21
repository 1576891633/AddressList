package com.lensyn.addresslist.entity;

import java.util.Map;

/**
 * Created by lizhongfu on 15:50 2017/12/21
 */
public class PageRequest {
    private String range;
    private Long begin;
    private Long end;
    private Long size;
    private String[] fields;
    private String[] sort;
    private Map<String, String[]> conditions;
    private Integer page;
    private Integer rows;

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Long getBegin() {
        return begin;
    }

    public void setBegin(Long begin) {
        this.begin = begin;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    public String[] getSort() {
        return sort;
    }

    public void setSort(String[] sort) {
        this.sort = sort;
    }

    public Map<String, String[]> getConditions() {
        return conditions;
    }

    public void setConditions(Map<String, String[]> conditions) {
        this.conditions = conditions;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
