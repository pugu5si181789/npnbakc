package com.bayside.npa.projectform.model;

import java.math.BigDecimal;
import java.util.Date;

public class Projectform {
    private String id;

    private String projectname;

    private String projectmanager;

    private String filenumber;

    private String projectgrade;

    private String borrower;

    private String cityoforigin;

    private String subocounty;

    private BigDecimal borbalance;//借款金额

    private Date borrowingdate;//借款日期

    private String connumber;

    private String guaranteemode;

    private String bail;//保证人

    private BigDecimal amountguaranteed;

    private String litsituation;

    private String courtname;

    private String caseno;

    private String judge;

    private String borsituation;

    private String guastatus;

    private String morsituation;

    private String invandclues;

    private String treideas;

    private String prodebriefing;

    private String keytips;

    private String transfertrip;

    private Date rolloutdate;

    private BigDecimal pritransfer;

    private BigDecimal outinterest;

    private String aging;

    private Date collectiondate;

    private String collectionmethod;

    private Date datereceivable;
    
    /*
     * 一下属性为展示用
     */
    private String firmname;
    private int firmsid;
    
    

    public String getFirmname() {
		return firmname;
	}

	public void setFirmname(String firmname) {
		this.firmname = firmname;
	}

	public int getFirmsid() {
		return firmsid;
	}

	public void setFirmsid(int firmsid) {
		this.firmsid = firmsid;
	}
	/*
	 * 展示属性结束
	 */

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public String getProjectmanager() {
        return projectmanager;
    }

    public void setProjectmanager(String projectmanager) {
        this.projectmanager = projectmanager == null ? null : projectmanager.trim();
    }

    public String getFilenumber() {
        return filenumber;
    }

    public void setFilenumber(String filenumber) {
        this.filenumber = filenumber == null ? null : filenumber.trim();
    }

    public String getProjectgrade() {
        return projectgrade;
    }

    public void setProjectgrade(String projectgrade) {
        this.projectgrade = projectgrade == null ? null : projectgrade.trim();
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower == null ? null : borrower.trim();
    }

    public String getCityoforigin() {
        return cityoforigin;
    }

    public void setCityoforigin(String cityoforigin) {
        this.cityoforigin = cityoforigin == null ? null : cityoforigin.trim();
    }

    public String getSubocounty() {
        return subocounty;
    }

    public void setSubocounty(String subocounty) {
        this.subocounty = subocounty == null ? null : subocounty.trim();
    }

    public BigDecimal getBorbalance() {
        return borbalance;
    }

    public void setBorbalance(BigDecimal borbalance) {
        this.borbalance = borbalance;
    }

    public Date getBorrowingdate() {
        return borrowingdate;
    }

    public void setBorrowingdate(Date borrowingdate) {
        this.borrowingdate = borrowingdate;
    }

    public String getConnumber() {
        return connumber;
    }

    public void setConnumber(String connumber) {
        this.connumber = connumber == null ? null : connumber.trim();
    }

    public String getGuaranteemode() {
        return guaranteemode;
    }

    public void setGuaranteemode(String guaranteemode) {
        this.guaranteemode = guaranteemode == null ? null : guaranteemode.trim();
    }

    public String getBail() {
        return bail;
    }

    public void setBail(String bail) {
        this.bail = bail == null ? null : bail.trim();
    }

    public BigDecimal getAmountguaranteed() {
        return amountguaranteed;
    }

    public void setAmountguaranteed(BigDecimal amountguaranteed) {
        this.amountguaranteed = amountguaranteed;
    }

    public String getLitsituation() {
        return litsituation;
    }

    public void setLitsituation(String litsituation) {
        this.litsituation = litsituation == null ? null : litsituation.trim();
    }

    public String getCourtname() {
        return courtname;
    }

    public void setCourtname(String courtname) {
        this.courtname = courtname == null ? null : courtname.trim();
    }

    public String getCaseno() {
        return caseno;
    }

    public void setCaseno(String caseno) {
        this.caseno = caseno == null ? null : caseno.trim();
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge == null ? null : judge.trim();
    }

    public String getBorsituation() {
        return borsituation;
    }

    public void setBorsituation(String borsituation) {
        this.borsituation = borsituation == null ? null : borsituation.trim();
    }

    public String getGuastatus() {
        return guastatus;
    }

    public void setGuastatus(String guastatus) {
        this.guastatus = guastatus == null ? null : guastatus.trim();
    }

    public String getMorsituation() {
        return morsituation;
    }

    public void setMorsituation(String morsituation) {
        this.morsituation = morsituation == null ? null : morsituation.trim();
    }

    public String getInvandclues() {
        return invandclues;
    }

    public void setInvandclues(String invandclues) {
        this.invandclues = invandclues == null ? null : invandclues.trim();
    }

    public String getTreideas() {
        return treideas;
    }

    public void setTreideas(String treideas) {
        this.treideas = treideas == null ? null : treideas.trim();
    }

    public String getProdebriefing() {
        return prodebriefing;
    }

    public void setProdebriefing(String prodebriefing) {
        this.prodebriefing = prodebriefing == null ? null : prodebriefing.trim();
    }

    public String getKeytips() {
        return keytips;
    }

    public void setKeytips(String keytips) {
        this.keytips = keytips == null ? null : keytips.trim();
    }

    public String getTransfertrip() {
        return transfertrip;
    }

    public void setTransfertrip(String transfertrip) {
        this.transfertrip = transfertrip == null ? null : transfertrip.trim();
    }

    public Date getRolloutdate() {
        return rolloutdate;
    }

    public void setRolloutdate(Date rolloutdate) {
        this.rolloutdate = rolloutdate;
    }

    public BigDecimal getPritransfer() {
        return pritransfer;
    }

    public void setPritransfer(BigDecimal pritransfer) {
        this.pritransfer = pritransfer;
    }

    public BigDecimal getOutinterest() {
        return outinterest;
    }

    public void setOutinterest(BigDecimal outinterest) {
        this.outinterest = outinterest;
    }

    public String getAging() {
        return aging;
    }

    public void setAging(String aging) {
        this.aging = aging == null ? null : aging.trim();
    }

    public Date getCollectiondate() {
        return collectiondate;
    }

    public void setCollectiondate(Date collectiondate) {
        this.collectiondate = collectiondate;
    }

    public String getCollectionmethod() {
        return collectionmethod;
    }

    public void setCollectionmethod(String collectionmethod) {
        this.collectionmethod = collectionmethod == null ? null : collectionmethod.trim();
    }

    public Date getDatereceivable() {
        return datereceivable;
    }

    public void setDatereceivable(Date datereceivable) {
        this.datereceivable = datereceivable;
    }
}