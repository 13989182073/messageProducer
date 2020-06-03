package com.luck.demo.entity;

import javax.persistence.*;

public class T_JBXX_XJXX {
    @Id
    @Column(name = "XH")
    private String xh;

    @Column(name = "KSH")
    private String ksh;

    @Column(name = "KSLB")
    private String kslb;

    @Column(name = "XM")
    private String xm;

    @Column(name = "XB")
    private String xb;

    @Column(name = "CSRQ")
    private String csrq;

    @Column(name = "SFZH")
    private String sfzh;

    @Column(name = "MZ")
    private String mz;

    @Column(name = "JG")
    private String jg;

    @Column(name = "ZZMM")
    private String zzmm;

    @Column(name = "XYDM")
    private String xydm;

    @Column(name = "XYMC")
    private String xymc;

    @Column(name = "ZYDM")
    private String zydm;

    @Column(name = "ZYMC")
    private String zymc;

    @Column(name = "BJDM")
    private String bjdm;

    @Column(name = "BJMC")
    private String bjmc;

    @Column(name = "NJ")
    private String nj;

    @Column(name = "PYCC")
    private String pycc;

    @Column(name = "XXXS")
    private String xxxs;

    @Column(name = "XXNX")
    private String xxnx;

    @Column(name = "XZ")
    private String xz;

    @Column(name = "RXRQ")
    private String rxrq;

    @Column(name = "YJBYRQ")
    private String yjbyrq;

    @Column(name = "ZXZT")
    private String zxzt;

    @Column(name = "XJZT")
    private String xjzt;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "IMAGEURL")
    private String imageurl;

    /**
     * @return XH
     */
    public String getXh() {
        return xh;
    }

    /**
     * @param xh
     */
    public void setXh(String xh) {
        this.xh = xh == null ? null : xh.trim();
    }

    /**
     * @return KSH
     */
    public String getKsh() {
        return ksh;
    }

    /**
     * @param ksh
     */
    public void setKsh(String ksh) {
        this.ksh = ksh == null ? null : ksh.trim();
    }

    /**
     * @return KSLB
     */
    public String getKslb() {
        return kslb;
    }

    /**
     * @param kslb
     */
    public void setKslb(String kslb) {
        this.kslb = kslb == null ? null : kslb.trim();
    }

    /**
     * @return XM
     */
    public String getXm() {
        return xm;
    }

    /**
     * @param xm
     */
    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    /**
     * @return XB
     */
    public String getXb() {
        return xb;
    }

    /**
     * @param xb
     */
    public void setXb(String xb) {
        this.xb = xb == null ? null : xb.trim();
    }

    /**
     * @return CSRQ
     */
    public String getCsrq() {
        return csrq;
    }

    /**
     * @param csrq
     */
    public void setCsrq(String csrq) {
        this.csrq = csrq == null ? null : csrq.trim();
    }

    /**
     * @return SFZH
     */
    public String getSfzh() {
        return sfzh;
    }

    /**
     * @param sfzh
     */
    public void setSfzh(String sfzh) {
        this.sfzh = sfzh == null ? null : sfzh.trim();
    }

    /**
     * @return MZ
     */
    public String getMz() {
        return mz;
    }

    /**
     * @param mz
     */
    public void setMz(String mz) {
        this.mz = mz == null ? null : mz.trim();
    }

    /**
     * @return JG
     */
    public String getJg() {
        return jg;
    }

    /**
     * @param jg
     */
    public void setJg(String jg) {
        this.jg = jg == null ? null : jg.trim();
    }

    /**
     * @return ZZMM
     */
    public String getZzmm() {
        return zzmm;
    }

    /**
     * @param zzmm
     */
    public void setZzmm(String zzmm) {
        this.zzmm = zzmm == null ? null : zzmm.trim();
    }

    /**
     * @return XYDM
     */
    public String getXydm() {
        return xydm;
    }

    /**
     * @param xydm
     */
    public void setXydm(String xydm) {
        this.xydm = xydm == null ? null : xydm.trim();
    }

    /**
     * @return XYMC
     */
    public String getXymc() {
        return xymc;
    }

    /**
     * @param xymc
     */
    public void setXymc(String xymc) {
        this.xymc = xymc == null ? null : xymc.trim();
    }

    /**
     * @return ZYDM
     */
    public String getZydm() {
        return zydm;
    }

    /**
     * @param zydm
     */
    public void setZydm(String zydm) {
        this.zydm = zydm == null ? null : zydm.trim();
    }

    /**
     * @return ZYMC
     */
    public String getZymc() {
        return zymc;
    }

    /**
     * @param zymc
     */
    public void setZymc(String zymc) {
        this.zymc = zymc == null ? null : zymc.trim();
    }

    /**
     * @return BJDM
     */
    public String getBjdm() {
        return bjdm;
    }

    /**
     * @param bjdm
     */
    public void setBjdm(String bjdm) {
        this.bjdm = bjdm == null ? null : bjdm.trim();
    }

    /**
     * @return BJMC
     */
    public String getBjmc() {
        return bjmc;
    }

    /**
     * @param bjmc
     */
    public void setBjmc(String bjmc) {
        this.bjmc = bjmc == null ? null : bjmc.trim();
    }

    /**
     * @return NJ
     */
    public String getNj() {
        return nj;
    }

    /**
     * @param nj
     */
    public void setNj(String nj) {
        this.nj = nj == null ? null : nj.trim();
    }

    /**
     * @return PYCC
     */
    public String getPycc() {
        return pycc;
    }

    /**
     * @param pycc
     */
    public void setPycc(String pycc) {
        this.pycc = pycc == null ? null : pycc.trim();
    }

    /**
     * @return XXXS
     */
    public String getXxxs() {
        return xxxs;
    }

    /**
     * @param xxxs
     */
    public void setXxxs(String xxxs) {
        this.xxxs = xxxs == null ? null : xxxs.trim();
    }

    /**
     * @return XXNX
     */
    public String getXxnx() {
        return xxnx;
    }

    /**
     * @param xxnx
     */
    public void setXxnx(String xxnx) {
        this.xxnx = xxnx == null ? null : xxnx.trim();
    }

    /**
     * @return XZ
     */
    public String getXz() {
        return xz;
    }

    /**
     * @param xz
     */
    public void setXz(String xz) {
        this.xz = xz == null ? null : xz.trim();
    }

    /**
     * @return RXRQ
     */
    public String getRxrq() {
        return rxrq;
    }

    /**
     * @param rxrq
     */
    public void setRxrq(String rxrq) {
        this.rxrq = rxrq == null ? null : rxrq.trim();
    }

    /**
     * @return YJBYRQ
     */
    public String getYjbyrq() {
        return yjbyrq;
    }

    /**
     * @param yjbyrq
     */
    public void setYjbyrq(String yjbyrq) {
        this.yjbyrq = yjbyrq == null ? null : yjbyrq.trim();
    }

    /**
     * @return ZXZT
     */
    public String getZxzt() {
        return zxzt;
    }

    /**
     * @param zxzt
     */
    public void setZxzt(String zxzt) {
        this.zxzt = zxzt == null ? null : zxzt.trim();
    }

    /**
     * @return XJZT
     */
    public String getXjzt() {
        return xjzt;
    }

    /**
     * @param xjzt
     */
    public void setXjzt(String xjzt) {
        this.xjzt = xjzt == null ? null : xjzt.trim();
    }

    /**
     * @return STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return IMAGEURL
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * @param imageurl
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }
}