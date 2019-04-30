package com.drebander.excel.domain;

import java.util.Date;

public class SjtyExcelDto implements Cloneable{
    public String name;
    public String age;
    public String addr;
    public String sky;
    public Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {

        return date;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAddr() {
        return addr;
    }

    public String getSky() {
        return sky;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }
}
