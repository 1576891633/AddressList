package com.lensyn.addresslist.domain;

import java.util.List;

/**
 * 
 * Created by lizhongfu on 14:06 2017/12/26
 */
public class Accounts {
    private page page;
    private List<UserDto> rows;

    public com.lensyn.addresslist.domain.page getPage() {
        return page;
    }

    public void setPage(com.lensyn.addresslist.domain.page page) {
        this.page = page;
    }

    public List<UserDto> getRows() {
        return rows;
    }

    public void setRows(List<UserDto> rows) {
        this.rows = rows;
    }
}
