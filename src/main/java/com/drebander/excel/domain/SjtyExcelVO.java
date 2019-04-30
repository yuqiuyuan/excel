package com.drebander.excel.domain;

import java.util.Date;

public class SjtyExcelVO {
    private String name;
    private String old;
    private Date date;


    public String getName() {
        return name;
    }

    public String getOld() {
        return old;
    }

    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SjtyExcelVO{" +
                "name='" + name + '\'' +
                ", old='" + old + '\'' +
                ", date=" + date +
                '}';
    }
}
