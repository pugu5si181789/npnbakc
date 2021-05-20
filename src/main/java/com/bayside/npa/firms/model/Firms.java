package com.bayside.npa.firms.model;

public class Firms {
    private Integer firmsid;

    private String firmname;

    public Integer getFirmsid() {
        return firmsid;
    }

    public void setFirmsid(Integer firmsid) {
        this.firmsid = firmsid;
    }

    public String getFirmname() {
        return firmname;
    }

    public void setFirmname(String firmname) {
        this.firmname = firmname == null ? null : firmname.trim();
    }
}