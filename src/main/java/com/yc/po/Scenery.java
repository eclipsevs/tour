package com.yc.po;


import java.io.Serializable;

/**
 * @author Administrator
 */
public class Scenery implements Serializable {
    private static final long serialVersionUID = 1067934262576927584L;
    private Integer sid;

    private String sname;

    private String sdesc;

    private Double sprice;

    private String stel;

    private String saddr;

    private String sstars;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    public Double getSprice() {
        return sprice;
    }

    public void setSprice(double sprice) {
        this.sprice = sprice;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public String getSaddr() {
        return saddr;
    }

    public void setSaddr(String saddr) {
        this.saddr = saddr;
    }

    public String getSstars() {
        return sstars;
    }

    public void setSstars(String sstars) {
        this.sstars = sstars;
    }

    @Override
    public String toString() {
        return "Scenery{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sdesc='" + sdesc + '\'' +
                ", sprice=" + sprice +
                ", stel='" + stel + '\'' +
                ", saddr='" + saddr + '\'' +
                ", sstars='" + sstars + '\'' +
                '}';
    }
}