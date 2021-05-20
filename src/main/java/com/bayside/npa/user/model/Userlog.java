package com.bayside.npa.user.model;

import java.util.Date;

public class Userlog {
    private String id;

    private String logname;

    private String address;

    private Date logintime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname == null ? null : logname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date address2) {
        this.logintime = address2;
    }
}